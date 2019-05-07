package com.qtpselenium.cucumber.connector;

import static org.assertj.core.api.Assertions.fail;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.qtpselenium.cucumber.reports.ExtentManager;
// Complete WebDriver code
public class WebConnector {

	WebDriver driver;
	Properties prop;
	ExtentReports rep ;
	ExtentTest scenario;
	
	public WebConnector() {
		System.out.println("WebConnector Initialized . Starting execution");
		try {
			 prop = new Properties();
			FileInputStream fs = new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//project.properties");
			prop.load(fs);
			String env = prop.getProperty("env");
			System.out.println(env);
			fs = new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//"+env+".properties");
			prop.load(fs);
			System.out.println(prop.getProperty("loginURL"));
			}catch(Exception e) {
				e.printStackTrace();
			}
	}
	
	public void openBrowser(String bName) {
		if(prop.getProperty("gridRun").equals("Y")) {
			// code to invoke grid -  Remotewebdriver
			
			
			
			
			
		}else {
		
		if(bName.equals("Mozilla"))
			driver = new FirefoxDriver();
		else if (bName.equals("Chrome"))
			driver = new ChromeDriver();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public void navigate(String urlKey) {
		driver.get(prop.getProperty(urlKey));
	}
	public void select(String objectKey,String data) {
		Select s= new Select(getObject(objectKey));
		s.selectByVisibleText(data);
	}
	
	public void type(String fieldKey,String data) {
		getObject(fieldKey).sendKeys(data);
	}
	public void click(String fieldKey) {
		getObject(fieldKey).click();
	}
	
	public String getTitle() {
		return driver.getTitle();
	}
	
	public WebElement getObject(String fieldKey) {
		WebElement e=null;
		try {
			
			if(fieldKey.endsWith("_xpath"))
				e= driver.findElement(By.xpath(prop.getProperty(fieldKey)));
			else if(fieldKey.endsWith("_id"))
				e= driver.findElement(By.id(prop.getProperty(fieldKey)));
			else if(fieldKey.endsWith("_css"))
				e= driver.findElement(By.cssSelector(prop.getProperty(fieldKey)));
		}catch(Exception ex) {
			reportFailure("Object Not Found "+ fieldKey);
		}
		return e;
	}
	
	/*****************Validation Functions********************/
	
	
	public boolean isElementPresent(String fieldKey) {
		List<WebElement> e=null;
		
		try {
			if(fieldKey.endsWith("_xpath"))
				e= driver.findElements(By.xpath(prop.getProperty(fieldKey)));
			else if(fieldKey.endsWith("_id"))
				e= driver.findElements(By.id(prop.getProperty(fieldKey)));
			else if(fieldKey.endsWith("_css"))
				e= driver.findElements(By.cssSelector(prop.getProperty(fieldKey)));
		}catch(Exception ex) {
			// report error
		}
		
		if(e.size()>0)
			return true;
		else
			return false;
	}
	
	public void clear(String objectKey) {
		getObject(objectKey).clear();
	}
	
	public void acceptAlertIfPresent() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 15);
			wait.until(ExpectedConditions.alertIsPresent());
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		}catch(Exception e) {
			// not present
		}
	}
	public String getProp(String key) {
		return prop.getProperty(key);
	}
	/**********************Reporting Function*************************/
	public void initReports(String scenarioName) {
		 rep = ExtentManager.getInstance(System.getProperty("user.dir")+"\\reports\\");
		 scenario = rep.createTest(scenarioName);
		infoLog("Started scenario "+ scenarioName);
	}
	public void infoLog(String message) {
		scenario.log(Status.INFO, message);
	}
	public void reportFailure(String failureMsg) {
		// fail in extent reports
		scenario.log(Status.FAIL, "Scenario Failed -> "+failureMsg);
		// attach screenshot in extent rep
		takeSceenShot();
		// fail in cucumber
		fail(failureMsg);
		
		
	}
	public void flushReports() {
		rep.flush();
	}
	
	public void takeSceenShot(){
		// fileName of the screenshot
		Date d=new Date();
		String screenshotFile=d.toString().replace(":", "_").replace(" ", "_")+".png";
		// take screenshot
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			// get the dynamic folder name
			FileUtils.copyFile(srcFile, new File(ExtentManager.screenshotFolderPath+screenshotFile));
			//put screenshot file in reports
			scenario.log(Status.FAIL,"Screenshot-> "+ scenario.addScreenCaptureFromPath(ExtentManager.screenshotFolderPath+screenshotFile));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public void login(String username, String password) {
		type("username_xpath", username);
		click("username_submit_id");
		type("password_css",password);
		click("password_submit_xpath");
		waitForPageToLoad();
	}
	public void waitForPageToLoad(){
		JavascriptExecutor js = (JavascriptExecutor)driver;
			int i=0;
			
			while(i!=10){
			String state = (String)js.executeScript("return document.readyState;");
			System.out.println(state);

			if(state.equals("complete"))
				break;
			else
				wait(2);

			i++;
			}
			// check for jquery status
			i=0;
			while(i!=10){
		
				Long d= (Long) js.executeScript("return jQuery.active;");
				System.out.println(d);
				if(d.longValue() == 0 )
				 	break;
				else
					 wait(2);
				 i++;
					
				}
			
	}
	
	public void wait(int time) {
		try {
			Thread.sleep(time*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void clickAndWait(String xpathExpTarget, String xpathExpWait, int maxTime){
		for(int i=0;i<maxTime;i++){
			// click
			getObject(xpathExpTarget).click();
			// check presence of other ele
			if(isElementPresent(xpathExpWait) && driver.findElement(By.id(prop.getProperty(xpathExpWait))).isDisplayed()){
				// if present - success.. return
				return;
			}else{
				// else wait for 1 sec
				wait(1);
			}
			
		}
		// 10 seconds over - for loop - comes here
		reportFailure("Target element coming after clicking on "+xpathExpTarget );
	}
	
	
	

	
	
	
}
