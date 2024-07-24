@Merchandise
Feature: Merchandise Business unit Setup page

  Background: 
    Given The user navigates to login page of Merx
    When The user login Merx application with email as and password
    And The user clicks on the Sign in button
    And User Can Select Company "DUNNS"
    And Click on merchandise Menu
    #Then The user should be redirected to the Merchandise Page

  @BusinessUnitFieldValidation
  Scenario: Generate Business Unit
    And click on Business unit
    And submit the page
    And The user get an error message if mandatory fields are empty
    When User enter business Names
		#And The user select Reporting category "REPOCAT0012" 
		#And The user select Alternative Hierarchy "Kids#Jeans#Spring Season#Christmas#Back To school#Bottoms#Cartoons"
    And verify that the Active status is selected by default from the Status dropdown
    And submit the page
    
    
  @BusinessUnitIDAutomatic
  Scenario: Verify that the Business Unit field is auto-populated
    And click on Business unit
    Then verify Business Unit ID is automatically generated

  @BusinessSetupMerx
  Scenario: Business unit setup in Merchandise
    #When The user on the Merchandise Page
    And click on Business unit
    When User enter business Names
    And The user select Reporting category "DUNNS" 
		And The user select Alternative Hierarchy "Kids#Jeans#Spring Season#Christmas#Back To school#Bottoms#Cartoons"
    And verify that the Active status is selected by default from the Status dropdown
    And submit the page
    
   @SmokeCheckForDevops
   Scenario: Business unit setup in Merchandise Hierarchy
    And click on Business unit
    When User enter business Names
    And verify that the Active status is selected by default from the Status dropdown
    And submit the page
    When I click on Logo Master
    Then I should be navigated to the Logo Master page 
     
       
  @MerchendiseSetupMerx
  Scenario: Merchandise setup from Business unit to subclass
    When click on Business unit
    When User enter business Names
    And verify that the Active status is selected by default from the Status dropdown
    And submit the page
    When Click on Divivion Add button
    When Enter Division Name   
    And verify that the Active status is selected by default from the Status dropdown in division
    And The user click on save and continue button
    When Click on Group Add button
    And Enter Group Name
    When User get the GroupIDNames
  	And verify that the Active status is selected by default from the Status dropdown
    And submit the page
    And Click on Department Add button
    And Enter department Name
    And User select item Type "TESTITEM101"
    Then verify that the Active status is selected by default from the Status dropdown
    And submit the page
    And Click on Class Add button
    And Enter Class Name
    And User get the classIdName
    And User select item Type "TESTITEM101"
    And verify that the Active status is selected by default from the Status dropdown
    And submit the page
    And Click on SubClass Add button
    And Enter SubClass Name
    And User select item Type "TESTITEM101"
    And verify that the Active status is selected by default from the Status dropdown
    And submit the page   
        