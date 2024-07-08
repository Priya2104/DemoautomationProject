@ItemManagement 
Feature: Merchandise Item Creation Process

  Background: 
    Given The user navigates to login page of Merx
    When The user login Merx application with email as and password
    And The user clicks on the Sign in button
    And User Can Select Company "PEP00003COMPANY"
    And Click on merchandise Menu
   # Then The user should be redirected to the Merchandise Page
  
  @PKHD-251 @PKHD-217 @PKHD-215 @RegressionTesting @SanityTesting @PKHD-496
  Scenario: Verify Item management setup
    When I Create Merchandise data with API request
    When Click on create Item menu
    When Select Business Unit from Item Management
    When Select Division from Item Management
    When select Group from Item Management
    And The user select Reporting category Item "Apparel"
    And submit Item Creation
    And select Department from Item Management
    And select class from Item management
    And select subclass from Item management
    And select subtype 
    And Create Family Item with name "familyDescval","Active","longDescriptionval","POS value2 Test1","POS value2 Test2","Clothing Color#Clothing Size#Clothing Pattern#Clothing Fabric"
    And Create ChildItem "Red#xxl#Skinny#Cotton" 
   Then Verify the child item was created successfully "familyDescval","xxl","Skinny","Cotton","Cotton"
   
   @PKHD-VMI
  Scenario: Verify Item management VMI setup
    When I Create Merchandise data with API request
    When Click on create Item menu
    When Select Business Unit from Item Management
    When Select Division from Item Management
    When select Group from Item Management
    And The user select Reporting category Item "Apparel"
    And submit Item Creation
    And select Department from Item Management
    And select class from Item management
    And select subclass from Item management
    And select subtype 
    And Create Family Item with name "familyDescval","Active","longDescriptionval","POS value2 Test1","POS value2 Test2","Clothing Color#Clothing Size#Clothing Pattern#Clothing Fabric"
    And Create ChildItem "Red#xxl#Skinny#Cotton" 
   Then Verify the child item was created successfully "familyDescval","xxl","Skinny","Cotton","Cotton"
   
   