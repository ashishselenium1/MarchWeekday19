package com.qtpselenium.cucumber.steps;

import com.qtpselenium.cucumber.connector.WebConnector;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class ValidationSteps {

	WebConnector con;
	
	public ValidationSteps(WebConnector con) {
		this.con=con;
	}
	
	@Then("^Login should be ([^\"]*)$")
	public void validateLogin(String expectedResult) {
		con.infoLog("Validating login");
	}
	
	@Then("^Title should be ([^\"]*)$")
	public void validateTitle(String expectedTitleKey) {
		con.infoLog("Validating title");
		String actualTitle = con.getTitle();
		String expectedTitle = con.getProp(expectedTitleKey);
		System.out.println(actualTitle+" --- "+expectedTitle);
		if(!actualTitle.equals(expectedTitle)) {
			// report a failure
			con.reportFailure("Title Validation Failed");
		}
	}
	
	@And("^([^\"]*) element should be present$")
	public void verifyElementPresent(String fieldKey) {
		if(!con.isElementPresent(fieldKey)) {
			// report failure
			con.reportFailure("Element not present "+fieldKey );
		}
	}
	
	
	
	
	
	
}
