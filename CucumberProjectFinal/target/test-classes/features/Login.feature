#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@Login
Feature: Title of your feature
  I want to use this template for my feature file

  @RediffLogin
  Scenario: Logging in Rediff.com
    Given Open Chrome
    When I go to the loginURL
    Then Title should be loginpage_title
    And username_xpath element should be present
    And Type username_xpath as ashishthakur1983
    And Click on username_submit_id
    And Type password_css as pass@1234
    And Click on password_submit_xpath
    Then Login should be success
