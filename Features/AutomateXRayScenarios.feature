@PKHD-3904
Feature: Default
 Background: 
    Given The user navigates to login page of Merx
    When The user login Merx application with email as and password
    And The user clicks on the Sign in button
    And User Can Select Company "PEP00002COMPANY12"
    And Click on merchandise Menu
	
		@PKHD-3035
	Scenario: Verify that the results are correctly displayed according to the search
		When click on Business unit
		When User enter business Names
		When user get the BUID
		And The user select Reporting category "Apparel" 
		And The user select Alternative Hierarchy "Kids#Jeans#Spring Season#Christmas#Back To school#Bottoms#Cartoons"
		And verify that the Active status is selected by default from the Status dropdown
		And submit the page
		Then The page has landing the division page
		When Click on BUUnitTab  
		When Enter a search with BUID
		Then The BUID is showing up in the view page
		When Enter a Search with BUName
		Then The BUName is showing up in the view page	

	
	@PKHD-3036
	Scenario Outline: Verify the filter functionality in business view page
		Then I apply filters "<Accountable>","<Responsible>","<Reporting Category>","<Alternate Hierarchy>","<Status>"
		And I Reset and check the filter results
		Examples:
		 Accountable   | Responsible | Reporting Category | Alternate Hierarchy | Status |
				  | Clark, Ronald |             | Footwear           | Kids,Avengers,Jeans | Active |	

	
	@PKHD-3037
	Scenario Outline: Verify the filter functionality in Division view page
		#When Click merchandiseMenu
		When The user on the Merchandise Pages
		And click on division tab
		Then I apply Division filters "<BusinessUnit>","<Accountable>","<Responsible>","<Reporting Category>","<Alternate Hierarchy>","<Status>"
		And I Reset and check the division filter results
		Examples:
		 | BusinessUnit | Accountable   | Responsible | Reporting Category | Alternate Hierarchy | Status |
		 | PEP00432     | Clark, Ronald |             | Footwear           | Kids,Avengers       | Active |	

	
	@PKHD-3038
	Scenario Outline: Verify the filter functionality in Group view page
		When The user on the Merchandise Pages
		And click on group tab
		Then I apply group filters "<BusinessUnit>","<DivisionUnit>","<Accountable>","<Responsible>","<Reporting Category>","<Alternate Hierarchy>","<Status>"
		And I Reset and check the group filter results
		Examples:
		| BusinessUnit | DivisionUnit | Accountable   | Responsible | Reporting Category | Alternate Hierarchy | Status |
		| SmartPhone   | SmartPhone   | Clark, Ronald |             | Footwear           | Kids,Avengers,Jeans | Active |	

	
	@PKHD-3039
	Scenario Outline: Verify the filter functionality in Department view page
		When The user on the Merchandise Pages
		And click on department tab
		Then I apply Department filters "<BusinessUnit>","<DivisionUnit>","<GroupUnit>","<Accountable>","<Responsible>","<Reporting Category>","<Alternate Hierarchy>","<Status>"
		And I Reset and check the Department filter results
		Examples:
		| BusinessUnit | DivisionUnit | GroupUnit  | Accountable   | Responsible | Reporting Category | Alternate Hierarchy | Status |
		| PEP00432     | SmartPhone   | SmartPhone | Clark, Ronald |             | Footwear           | Kids,Avengers,Jeans | Active |	

	
	@PKHD-3040
	Scenario Outline: Verify the filter functionality in class view page
		When The user on the Merchandise Pages
		And click on class tab
		Then I apply class filters "<BusinessUnit>","<DivisionUnit>","<GroupUnit>","<Department>","<Accountable>","<Responsible>","<Reporting Category>","<Alternate Hierarchy>","<Status>"
		And I Reset and check the class filter results
		
		Examples: 
		| BusinessUnit | DivisionUnit | GroupUnit  | Department | Accountable   | Responsible | Reporting Category | Alternate Hierarchy | Status |
		| PEP00432     | SmartPhone   | SmartPhone | SmartPhone | Clark, Ronald |             | Footwear           | Kids,Avengers,Jeans | Active |	

	
	@PKHD-3041
	Scenario Outline: Verify the filter functionality in subclass view page
		When The user on the Merchandise Pages
		And click on subclass tab
		Then I apply subclass filters "<BusinessUnit>","<DivisionUnit>","<GroupUnit>","<Department>","<ClassData>","<Accountable>","<Responsible>","<Reporting Category>","<Alternate Hierarchy>","<Status>"
		And I Reset and check the subclass filter results
		Examples:
		| BusinessUnit | DivisionUnit | GroupUnit  | Department | ClassData  | Accountable   | Responsible | Reporting Category | Alternate Hierarchy | Status |
		| SmartPhone   | SmartPhone   | SmartPhone | SmartPhone | SmartPhone | Clark, Ronald |             | Footwear           | Kids,Avengers,Jeans | Active |	

	
	@PKHD-3046
	Scenario Outline: Edit BusinessUnit and Verify page details
		When I Create Merchandise data with API request
		Then I will search with Business Unit ID and select Edit
		And I will update the fields "<Business Unit Name>","<Reporting Category>","<Alternate Hierarchy>","<Status>"
		And I will verify the updated fields.
		
		Examples: 
		| Business Unit Name | Reporting Category | Alternate Hierarchy | Status |
		|                    | Footwear           | Cartoons            | Active |	

	
	@PKHD-3047
	Scenario: Edit DivisionUnit and Verify page details
		Scenario Outline: Edit DivisionUnit and Verify page details
		Then I will search with Division Unit ID and select Edit
		And I will update the Division fields "<Division Name>","<Reporting Category>","<Alternate Hierarchy>","<Status>"
		And I will verify the updated Division fields.
		
		Examples: 
		| Division Name | Reporting Category | Alternate Hierarchy | Status |
		|               | Footwear           | Cartoons            | Active |	

	
	@PKHD-3048
	Scenario Outline: Edit Group and Verify page details
		Then I will search with Group Unit ID and select Edit
		And I will update the Group fields "<Group Name>","<Reporting Category>","<Alternate Hierarchy>","<Status>"
		And I will verify the updated Group fields.
		
		Examples: 
		| Group Name | Reporting Category | Alternate Hierarchy | Status |
		|            | Footwear           | Cartoons            | Active |	

	
	@PKHD-3049
	Scenario Outline: Edit Department and Verify page details
		Then I will search with Department Unit ID and select Edit
		And I will update the Department fields "<Department Name>","<Reporting Category>","<Item Type>","<Alternate Hierarchy>","<Status>"
		And I will verify the updated Department fields.
		
		Examples: 
		| Department Name | Reporting Category | Item Type  | Alternate Hierarchy | Status |
		|                 | Footwear           | Electronic | Cartoons            | Active |	

	
	@PKHD-3050
	Scenario Outline: Edit Class and Verify page details
		Then I will search with Class Unit ID and select Edit
		And I will update the Class fields "<Class Name>","<Reporting Category>","<Item Type>","<Alternate Hierarchy>","<Status>"
		And I will verify the updated Class fields.
		
		Examples: 
		| Class Name | Reporting Category | Item Type   | Alternate Hierarchy | Status |
		|            | Footwear           | CFH Regular | Cartoons            | Active |	

	
	@PKHD-3051
	Scenario Outline: Edit Subclass and Verify page details
		Then I will search with Subclass Unit ID and select Edit
		And I will update the Subclass fields "<Subclass Name>","<Reporting Category>","<Item Type>","<Alternate Hierarchy>","<Status>"
		And I will verify the updated Subclass fields.
		
		Examples: 
		| Subclass Name | Reporting Category | Item Type  | Alternate Hierarchy | Status |
		|               | Footwear           | Electronic | Cartoons            | Active |	

	
	@PKHD-3052
	Scenario: Verify the Successful Deletion from the Subclass view Page
		When I Create Merchandise data with API request
		Then I will search with Subclass unit ID
		And I will Delete the record
		And I will verify the deleted Subclass record should not exist in the system	

	
	@PKHD-3053
	Scenario: Verify the Successful Deletion from the Class view Page
		Then I will search with Class unit ID
		And I will Delete the record
		And I will verify the deleted Class record should not exist in the system	

	
	@PKHD-3054
	Scenario: Verify the Successful Deletion from the Department view Page
		Then I will search with Department unit ID
		And I will Delete the record
		And I will verify the deleted Department record should not exist in the system	

	
	@PKHD-3055
	Scenario: Verify the Successful Deletion from the Group view Page
		Then I will search with Group unit ID
		And I will Delete the record
		And I will verify the deleted Group record should not exist in the system	

	
	@PKHD-3056
	Scenario: Verify the Successful Deletion from the Division view Page
		Then I will search with Division unit ID
		And I will Delete the record
		And I will verify the deleted Division record should not exist in the system	

	
	@PKHD-3057
	Scenario: Verify the Successful Deletion from the Business view Page
		Then I will search with Business unit ID
		And I will Delete the record
		And I will verify the deleted BU record should not exist in the system