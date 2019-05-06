package com.qtpselenium.cucumber.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class ReportingExample {

	public static void main(String[] args) {
		ExtentReports rep = ExtentManager.getInstance("D:\\Whizdom-Trainings\\Online Training Workspace\\MarchWeekday2019\\CucumberProjectFinal\\reports\\");
		ExtentTest test = rep.createTest("SampleTest");
		
		test.log(Status.INFO, "Starting the test");
		test.log(Status.INFO, "Booking a ticket");
		test.log(Status.PASS, "Test has passed");
		
		rep.flush();
	}

}
