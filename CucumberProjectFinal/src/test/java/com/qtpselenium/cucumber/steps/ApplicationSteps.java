package com.qtpselenium.cucumber.steps;

import java.util.List;

import com.qtpselenium.cucumber.connector.WebConnector;

import cucumber.api.java.en.And;

public class ApplicationSteps {

	WebConnector con;
	
	public ApplicationSteps(WebConnector con) {
		this.con=con;
	}
	
	@And("^I Login inside application$")
	public void login(List<String> data) {
		con.infoLog("Logging inside application"+data.toString());
		con.login(data.get(0),data.get(1));
		
	}
	
	
}
