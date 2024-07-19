@Group
Feature: Merchandise Group Setup page

  Background:
    Given The user navigates to login page of Merx
    When The user login Merx application with email as and password
    And  The user clicks on the Sign in button
    And User Can Select Company "DUNNS"
    And Click on merchandise Menu
   # Then The user should be redirected to the Merchandise Page

  @GroupSetupHierarchy
  Scenario: Verify Group setup
    When click on group tab
    When I Create Merchandise data with API request
    When User select division name Unit in Group
    And Enter Group Name
   And The user select Reporting category "REPOCAT0012" 
   And The user select Alternative Hierarchy "ALT-130624#ALT-1206"
    And verify that the Active status is selected by default from the Status dropdown
    And submit the page
    
    
      @GropuErrorMessage
  Scenario: Verify error messages are displayed in group when mandatory fields are left blank
    When click on group tab 
    When click on save button in group
    Then Validate error message on the screen

  @GroupFilters
  Scenario Outline: Verify the filter functionality in Group view page
    #When The user on the Merchandise Pages
    And click on group tab
    Then I apply group filters "<BusinessUnit>","<DivisionUnit>","<Accountable>","<Responsible>","<Reporting Category>","<Alternate Hierarchy>","<Status>"
    #And I Reset and check the group filter results
    Examples:
      | BusinessUnit | DivisionUnit | Accountable   | Responsible | Reporting Category | Alternate Hierarchy | Status |
      | 1975   | 1173   |  |             | RC_SK1207           | ALTH_SK1207 | Active |
      #| PEP00432     | SmartPhone   |               |               |                    |                     |          |
      #| PEP00432     | SmartPhone   |               |               | Bath               | Avengers            | Active   |
      #| PEP00432     | SmartPhone   |               |               | Bath               | Jeans               | Inactive |