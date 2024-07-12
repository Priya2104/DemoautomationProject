@BusinessUnit  @PKHD-496
Feature: Merchandise Business unit view page

  Background:
    Given The user navigates to login page of Merx
    When The user login Merx application with email as and password
    And The user clicks on the Sign in button
    And User Can Select Company "DUNNS"
    And Click on merchandise Menu
    #Then The user should be redirected to the Merchandise Page
     
    @PKHD-249 @PKHD_5_Testcase
	Scenario: Verify that the results are correctly displayed according to the search
		When click on Business unit
		When User enter business Names
		When user get the BUID
		And The user select Reporting category "REPOCAT0012" 
		And The user select Alternative Hierarchy "ALTSK0807#SKAH05"
		And verify that the Active status is selected by default from the Status dropdown
		And submit the page
		Then The page has landing the division page
		When Click on BUUnitTab  
		When Enter a search with BUID
		Then The BUID is showing up in the view page
		When Enter a Search with BUName
		Then The BUName is showing up in the view page	

	#Verify that users can select one or more alternate hierarchy values for the BU level, and that the system groups and generates reports based on these values as expected.
	@PKHD-250 @PKHD_5_Testcase
	Scenario Outline: Verify the filter functionality in business view page
		Then I apply filters "<Accountable>","<Responsible>","<Reporting Category>","<Alternate Hierarchy>","<Status>"
		And I Reset and check the filter results
		Examples:
		  | Accountable   | Responsible | Reporting Category | Alternate Hierarchy | Status |
		  | Clark, Ronald |             | Footwear           | Kids,Avengers,Jeans | Active |
#
  @BusinesUnitSetUpPage
  Scenario: Verify BU Setup   
    When click on Business unit
    When User enter business Names
   	And The user select Reporting category "REPOCAT0012" 
		And The user select Alternative Hierarchy "ALT-130624#ALT-1206"
    And verify that the Active status is selected by default from the Status dropdown
    And submit the page
    
    @BUMandatoryFieldEmptyError
  Scenario: Verify error messages are displayed in BU when mandatory fields are left blank
    #When click on Business unit
    When click on save button in BU page
    Then Validate BU error message on the screen

  #@BusinessUnitFilters
  #Scenario Outline: Verify the filter functionality in busines view page
    #When Click merchandiseMenu
    #Then I apply filters "<Accountable>","<Responsible>","<Reporting Category>","<Alternate Hierarchy>","<Status>"
    #And I Reset and check the filter results
#
    #Examples:
      #| Accountable   | Responsible | Reporting Category | Alternate Hierarchy | Status |
      #| Clark, Ronald |             | Footwear           | Kids,Avengers,Jeans | Active |
#      |               |               |                    |                     |          |
#      |               |               | Bath               | Avengers            | Active   |
#      |               |               | Bath               | Jeans               | Inactive |

