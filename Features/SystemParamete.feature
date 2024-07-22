@BusinessUnit  @PKHD-496
Feature: System Parameter in Merx

  Background:
    Given The user navigates to login page of Merx
    When The user login Merx application with email as and password
    And The user clicks on the Sign in button
    And User Can Select Company "DUNNS"
    And Click on system paramter Menu
 @alternateHierarchy   
Scenario Outline:: Verify the alternate hierarchy in System Parameter Screen  
		When click on AlternateHierarhyTab
		And  Submit the Alternate Hierarhy details "<AlternateHierarhy>","<Description>"
		And Click on merchandise Menu
		When click on Business unit
		#And The user select Alternative Hierarchy "SKAH05#ALT-0112"
		Then Validate Alternate Hierarhy in the table grid
Examples: 
      | ALT | alternateDescription | 
		
		