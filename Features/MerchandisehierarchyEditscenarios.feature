@EditFlow
Feature: Editing records for the created Hierarchys.

  Background: 
    Given The user navigates to login page of Merx
    When The user login Merx application with email as and password
    And The user clicks on the Sign in button
    And User Can Select Company "PEP00002COMPANY12"
    And Click on merchandise Menu
    Then The user should be redirected to the Merchandise Page

  @RegularFlow
  Scenario: Verify Hierarchy setup
    When click on Business unit
    When User enter business Names
    When user get the BUID
    And The user select Reporting category "Apparel" 
		And The user select Alternative Hierarchy "Kids#Jeans#Spring Season#Christmas#Back To school#Bottoms#Cartoons"
    And verify that the Active status is selected by default from the Status dropdown
    And submit the page
    Then The page has landing the division page
    #Division setup
    #When click on divsion tab
    #When select business Unit in divsion page
    #When Enter DivsionName
    #When User get the divIDNames
    #When The user select Reporting category in Division
    #And The user select Alternative Hierarchy in Division
    #And verify that the Active status is selected by default from the Status dropdown in division
    #And The user click on save and continue button
    #Then The page has landing the Group page
    #Group Setup process
    #When click on group tab
    #When User select division name Unit in Group
    #And Enter Group Name
    #When User get the GroupIDNames
    #And The user select Reporting category
    #And The user select Alternative Hierarchy
    #And verify that the Active status is selected by default from the Status dropdown
    #And submit the page
    #Then The page has landing the department page
    # Department
    #When click on department tab
    #When User select group name in department
    #And Enter department Name
    #And User get the DeptIDNames
    #And The user select Reporting category
    #And User select item Type
    #And The user select Alternative Hierarchy
    #And verify that the Active status is selected by default from the Status dropdown
    #And submit the page
    #Then The page has landing the class page
    #Setup Class
    #When User select department name in class
    #And Enter Class Name
    #And User get the classIdName
    #And The user select Reporting category
    #And User select item Type
    #And The user select Alternative Hierarchy
    #And verify that the Active status is selected by default from the Status dropdown
    #And submit the page
    #Then The page has landing the Subclass page
    #Set up Sub Class
    #When User select class name in Subclass
    #And Enter SubClass Name
    #And User get the subclassIdName
    #And The user select Reporting category
    #And User select item Type
    #And The user select Alternative Hierarchy
    #And verify that the Active status is selected by default from the Status dropdown
    #And submit the page
    #Then The page has move to home page

  #//BU
  @sanity1
  Scenario: User navigates to the form page by selecting edit action for a given BU
    Given In the List page the user search for the Business unit ID to perform edit
    When the user selects edit action for a given Business unit
    Then the user is navigated to the form page

  @sanity @Regression
  Scenario: Verify the display functionality of the searched BU in the form page.
    Given In the List page the user search for the Business unit ID to perform edit
    When the user selects edit action for a given Business unit
    Then the user is navigated to the form page
    And the Existing Business Unit ID, Business Unit Name, Reporting category, Status should be displayed

  @sanity @Regression
  Scenario: Verify the updating functionality of the searched BU in the form page.
    Given In the List page the user search for the Business unit ID to perform edit
    When the user selects edit action for a given Business unit
    Then the user is navigated to the form page
    And the user can update the records for the fields Business Unit Name, Reporting category, Status.

  @Regression
  Scenario: Verify the display functionality of the updated BU record in the form page.
    Given In the List page the user search for the Business unit ID to perform edit
    When the user selects edit action for a given Business unit
    Then the user is navigated to the form page
    And the user can update the records for the fields Business Unit Name, Reporting category, Status.
    And the user validate the fields are updated in the view page.

  @Regression
  Scenario: Verify the save button without updating any details
    Given In the List page the user search for the Business unit ID to perform edit
    When the user selects edit action for a given Business unit
    Then the user is navigated to the form page
    And user clicks on save button and verify the success message

  @Regression
  Scenario: Verify the Cancel button without updating any details
    Given In the List page the user search for the Business unit ID to perform edit
    When the user selects edit action for a given Business unit
    Then the user is navigated to the form page
    And user clicks on cancel button and verify the alert message
    And User clicks on No option and stays on same page
    And user clicks on cancel button and verify the alert message
    And User clicks on Yes option and navigate to view Page
