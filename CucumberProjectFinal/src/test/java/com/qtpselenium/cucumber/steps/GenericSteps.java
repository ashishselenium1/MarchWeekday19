package com.qtpselenium.cucumber.steps;

import com.qtpselenium.cucumber.connector.WebConnector;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class GenericSteps {

	

	WebConnector con;
	
	public GenericSteps(WebConnector con) {
		this.con=con;
	}
	
	
	@Before
	public void init(Scenario s) {
		System.out.println("***Bef*** "+s.getName());
		con.initReports(s.getName());
		System.out.println("-----------Init--------------");
	}
	
	@After
	public void quit() {
		System.out.println("-----------Quit--------------");
		con.flushReports();
	}
	
	
	@Given("^Open ([^\"]*)$")
	public void openBrowser(String browserName) {
		con.infoLog("Opening the browser "+browserName );
		con.openBrowser(browserName);
		
	}
    @When("^I go to the ([^\"]*)$")
    public void navigate(String urlKey) {
    	con.infoLog("Navigating to the url "+ urlKey);
    	con.navigate(urlKey);
    }
    
    @And("^Type ([^\"]*) as ([^\"]*)$")
    public void type(String fieldKey,String data) {
    	con.infoLog("Typing in "+fieldKey+". Data "+data );
    	con.type(fieldKey, data);
    }
    
    @And("^Click on ([^\"]*)$")
    public void click(String fieldKey) {
    	con.infoLog("Clicking on "+fieldKey);
    	con.click(fieldKey);
    }
    
    @And("^I click (.*) and wait for (.*)$")
	public void clickAndWait(String src,String target) {
		con.infoLog("Clicking on "+ src);
		con.clickAndWait(src, target, 20);	
	}
    @And("^I clear (.*)$")
	public void clear(String locatorKey) {
		con.infoLog("Clearing in "+locatorKey);
		con.clear(locatorKey);
	}
    @And("^I wait for page to load$")
	public void waitForPageToLoad() {
		con.waitForPageToLoad();
	}
    @And("Select (.*) from (.*)")
	public void select(String data,String locatorKey) {
		con.infoLog("Selecting from "+ locatorKey);
		con.select(locatorKey,data);
	}
    @When("^I accept alert$")
	public void iAcceptAlert() {
		con.acceptAlertIfPresent();
	}

    
	
	
	
	
	
	
	
	
}
