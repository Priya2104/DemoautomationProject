@Division
Feature: Merchandise Division Setup page

  Background:
    Given The user navigates to login page of Merx
    When The user login Merx application with email as and password
    And  The user clicks on the Sign in button
    And User Can Select Company "AVENIDA"
    And Click on merchandise Menu    
    

  @DivisionSetup
  Scenario: Verify Division setup
    When I Create Merchandise data with API request
    And  click on division tab
    When select business Unit in division page
    When  Enter Division Name
    And The user select Reporting category "REPOCAT0012" 
    #And The user select Alternative Hierarchy "Kids#Jeans#Spring Season#Christmas#Back To school#Bottoms#Cartoons"
    And   verify that the Active status is selected by default from the Status dropdown in division
    And   The user click on save and continue button
    #Then  The user receive confirmation message on the division page

  @DivisionErrorMessage
  Scenario: Verify error messages are displayed in division when mandatory fields are left blank
    And  click on division tab  
    When click on save button
    Then Validate error message on the screen


  @DivisionFilters
  Scenario Outline: Verify the filter functionality in Division view page
    #When Click merchandiseMenu
    When The user on the Merchandise Pages
    And click on division tab
    Then I apply Division filters "<BusinessUnit>","<Accountable>","<Responsible>","<Reporting Category>","<Alternate Hierarchy>","<Status>"
    And I Reset and check the division filter results
    Examples:
      | BusinessUnit | Accountable   | Responsible | Reporting Category | Alternate Hierarchy | Status |
      | PEP00432     | Clark, Ronald |             | Footwear           | Kids,Avengers       | Active |
#      |              |               |               |                    |                     |          |
#      | PEP00432     |               |               | Bath               | Avengers            | Active   |
#      | PEP00432     |               |               | Bath               | Jeans               | Inactive |