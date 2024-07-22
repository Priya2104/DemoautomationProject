@BusinessUnit  @PKHD-496
Feature: System Parameter in Merx

  Background:
    Given The user navigates to login page of Merx
    When The user login Merx application with email as and password
    And The user clicks on the Sign in button
    And User Can Select Company "DUNNS"
    And Click on system paramter Menu
 @alternateHierarchy   
Scenario Outline: Verify the alternate hierarchy in System Parameter Screen  
		When click on AlternateHierarhyTab
		And  Submit the Alternate Hierarhy details "<AlternateHierarhy>","<Description>"
		And Click on merchandise Menu
		When click on Business unit
		#And The user select Alternative Hierarchy "SKAH05#ALT-0112"
		Then Validate Alternate Hierarhy in the BU Merchandise
Examples: 
      |	AlternateHierarhy| DiffType |
      | ALT | alternateDescription |

 @ItemTypeSettingTest 
 Scenario: Scenario: Merchandise setup from Business unit to subclass
		When click on ItemSettingTab
		And  Submit the itemSetting 
		And  Click on merchandise Menu
		When click on department tab
		Then Item type validity in the department merchandise 
@ReportingCategory
  Scenario Outline: : Verify the Reporting Category in System Parameter Screen
    When click on ReportingCategoryTab
    And Submit the Reporting Category Details "<Reporting category>","<Reference1>","<Reference2>","<status>"
    And Click on merchandise Menu
   # When click on Business unit
    #And The user select ReportingCategory "SKAH05#ALT-0112"
    Then Validate the Reporting Cetegory in the table grid

    Examples: 
      | Reporting category | Reference1 | Reference2 | status |
      | ANJReporting       | ANJrep1    | ANJrep2    | Active |