@BusinessUnit  @PKHD-496
Feature: Merchandise Business unit view page

  Background:
    Given The user navigates to login page of Merx
    When The user login Merx application with email as and password
    And The user clicks on the Sign in button
    And User Can Select Company "AVENIDA"
    And Click on merchandise Menu
    #Then The user should be redirected to the Merchandise Page
     
    @ChainSetup
	Scenario: Verify Organisation Chian setup
		#When click on Business unit
	 