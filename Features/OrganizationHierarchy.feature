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
  Scenario Outline: Verify Organisation Chian setup
    When user click on Organization Hierarchy menu
    And user clicks on Add Chain button
    And user provide chain details are "<Chain Name>","<Alternate Hierarchy>","<Default Currency>","<Status>"
    Then user validate the success message as "Record saved successfully, now continue to next step"
    And user search with "Chain Name"

    Examples: 
      | Chain Name | Alternate Hierarchy | Default Currency | Status |
      | chainname  | SK_ALH1307,SKAH05   | Indian Rupee     | Active |

  @RegionSetup
  Scenario Outline: Verify Organisation Region setup
    When user click on Organization Hierarchy menu
    And user clicks on Add Region button
    And user provide Range details are "<AreaName>","<Region Name>","<Alternate Hierarchy>","<Default Currency>","<Status>"
    Then user validate the success message as "Record saved successfully, now continue to next step"
    And user search with rangename "Range Name"

    Examples: 
      | AreaName | Region Name | Alternate Hierarchy | Default Currency | Status |
      | area0990 | Regionname | SK_ALH1307,SKAH05   | Indian Rupee     | Active |
      
  @AreaSetup
  Scenario Outline: Verify Organisation Region setup
    When user click on Organization Hierarchy menu
    And user clicks on Add Area button
    And user provide Area details are "<ChainName>","<Area Name>","<Alternate Hierarchy>","<Default Currency>","<Status>"
    Then user validate the success message as "Record saved successfully, now continue to next step"
    And user search with Areaname "Area Name"

    Examples: 
      | ChainName | Area Name | Alternate Hierarchy | Default Currency | Status |
      | chain0900 | Areaname | SK_ALH1307,SKAH05   | Indian Rupee     | Active |
     
@DistrictSetup
  Scenario Outline: Verify Organisation Region setup
    When user click on Organization Hierarchy menu
    And user clicks on Add District button
    And user provide District details are "<RegionName>","<District Name>","<Alternate Hierarchy>","<Default Currency>","<Status>"
    Then user validate the success message as "Record saved successfully, now continue to next step"
    And user search with Districtname "District Name"

    Examples: 
      | RegionName | District Name | Alternate Hierarchy | Default Currency | Status |
      | Regionwork | Districtname | SK_ALH1307,SKAH05   | Indian Rupee     | Active |
     