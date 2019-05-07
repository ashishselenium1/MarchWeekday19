$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/features/Login.feature");
formatter.feature({
  "name": "Title of your feature",
  "description": "  I want to use this template for my feature file",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@Login"
    }
  ]
});
formatter.scenario({
  "name": "Logging in Rediff.com",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Login"
    },
    {
      "name": "@RediffLogin"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "Open Chrome",
  "keyword": "Given "
});
formatter.match({
  "location": "GenericSteps.openBrowser(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I go to the loginURL",
  "keyword": "When "
});
formatter.match({
  "location": "GenericSteps.navigate(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Title should be loginpage_title",
  "keyword": "Then "
});
formatter.match({
  "location": "ValidationSteps.validateTitle(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "username_xpath element should be present",
  "keyword": "And "
});
formatter.match({
  "location": "ValidationSteps.verifyElementPresent(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Type username_xpath as ashishthakur1983",
  "keyword": "And "
});
formatter.match({
  "location": "GenericSteps.type(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Click on username_submit_id",
  "keyword": "And "
});
formatter.match({
  "location": "GenericSteps.click(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Type password_css as pass@1234",
  "keyword": "And "
});
formatter.match({
  "location": "GenericSteps.type(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Click on password_submit_xpath",
  "keyword": "And "
});
formatter.match({
  "location": "GenericSteps.click(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Login should be success",
  "keyword": "Then "
});
formatter.match({
  "location": "ValidationSteps.validateLogin(String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.uri("src/test/resources/features/Portfolio.feature");
formatter.feature({
  "name": "Title of your feature",
  "description": "  I want to use this template for my feature file",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@Portfolio"
    }
  ]
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "Open Chrome",
  "keyword": "Given "
});
formatter.match({
  "location": "GenericSteps.openBrowser(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I go to the loginURL",
  "keyword": "When "
});
formatter.match({
  "location": "GenericSteps.navigate(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Title should be loginpage_title",
  "keyword": "Then "
});
formatter.match({
  "location": "ValidationSteps.validateTitle(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I Login inside application",
  "rows": [
    {
      "cells": [
        "ashishthakur1983",
        "pass@1234"
      ]
    }
  ],
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.login(String\u003e)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Creating a Portfolio",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Portfolio"
    },
    {
      "name": "@CreatePortFolio"
    }
  ]
});
formatter.step({
  "name": "I click createPortFolio_id and wait for portfolioName_id",
  "keyword": "And "
});
formatter.match({
  "location": "GenericSteps.clickAndWait(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I clear portfolioName_id",
  "keyword": "And "
});
formatter.match({
  "location": "GenericSteps.clear(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Type portfolioName_id as Port12345",
  "keyword": "And "
});
formatter.match({
  "location": "GenericSteps.type(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Click on portFolioSubmit_id",
  "keyword": "And "
});
formatter.match({
  "location": "GenericSteps.click(String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "Open Chrome",
  "keyword": "Given "
});
formatter.match({
  "location": "GenericSteps.openBrowser(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I go to the loginURL",
  "keyword": "When "
});
formatter.match({
  "location": "GenericSteps.navigate(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Title should be loginpage_title",
  "keyword": "Then "
});
formatter.match({
  "location": "ValidationSteps.validateTitle(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I Login inside application",
  "rows": [
    {
      "cells": [
        "ashishthakur1983",
        "pass@1234"
      ]
    }
  ],
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.login(String\u003e)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Deleting a Portfolio",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Portfolio"
    },
    {
      "name": "@DeletePortFolio"
    }
  ]
});
formatter.step({
  "name": "I wait for page to load",
  "keyword": "And "
});
formatter.match({
  "location": "GenericSteps.waitForPageToLoad()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Select Port12345 from portfolioSelection_id",
  "keyword": "And "
});
formatter.match({
  "location": "GenericSteps.select(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I wait for page to load",
  "keyword": "And "
});
formatter.match({
  "location": "GenericSteps.waitForPageToLoad()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Click on deletePortfolio_id",
  "keyword": "And "
});
formatter.match({
  "location": "GenericSteps.click(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I accept alert",
  "keyword": "When "
});
formatter.match({
  "location": "GenericSteps.iAcceptAlert()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});