@Departments
Feature: Merchandise Department Setup page

  Background:
    Given The user navigates to login page of Merx
    When The user login Merx application with email as and password
    And  The user clicks on the Sign in button
    And User Can Select Company "DUNNS"
    And Click on merchandise Menu
    #Then The user should be redirected to the Merchandise Page


  @DepartmentSetupHierarchy
  Scenario: Verify Department setup
    When I Create Merchandise data with API request
    When click on department tab
    When User select group name in department
    And Enter department Name
    And The user select Reporting category "REPOCAT0012"
    And User select item Type "TESTITEM101"
    And The user select Alternative Hierarchy "ALT-130624#ALT-1206"
    And verify that the Active status is selected by default from the Status dropdown
    And submit the page
    #Then The page has landing the class page
@DepartmentErrorMessage
  Scenario: Verify error messages are displayed in department when mandatory fields are left blank
    When click on department tab 
    When click on save button in department
    Then Validate depClassSubclass error message on the screen
  @DepartmentFilters
  Scenario Outline: Verify the filter functionality in Department view page
    When The user on the Merchandise Pages
    And click on department tab
    Then I apply Department filters "<BusinessUnit>","<DivisionUnit>","<GroupUnit>","<Accountable>","<Responsible>","<Reporting Category>","<Alternate Hierarchy>","<Status>"
    And I Reset and check the Department filter results
    Examples:
      | BusinessUnit | DivisionUnit | GroupUnit  | Accountable   | Responsible | Reporting Category | Alternate Hierarchy | Status |
      | PEP00432     | SmartPhone   | SmartPhone | Clark, Ronald |             | Footwear           | Kids,Avengers,Jeans | Active |
#      | PEP00432     | SmartPhone   | SmartPhone |               |               |                    |                     |          |
#      | PEP00432     | SmartPhone   | SmartPhone |               |               | Bath               | Avengers            | Active   |
#      | PEP00432     | SmartPhone   | SmartPhone |               |               | Bath               | Jeans               | Inactive |