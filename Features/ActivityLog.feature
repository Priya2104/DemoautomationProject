@SubClass
Feature: Mechandise sub class Setup page

  Background:
    Given The user navigates to login page of Merx
    When The user login Merx application with email as and password
    And  The user clicks on the Sign in button
    And User Can Select Company "DUNNS"
    And Click on merchandise Menu
    

  @DataActivityLog
  Scenario Outline: Verifying the record exist in Data Activity log
    When I will select the Activity log from the Master tab
    And  I will select the filters with data "<Module Name>","<Table Name>","<User Name>","<From Date>","<To Date>"
    And I will click on Save button
    Then I will verify the records in the grid "<Module Name>","<Table Name>","<User Name>"

    Examples: 
      | Module Name    | Table Name         | User Name        | From Date    | To Date      |
      | reference-data | differentiator_key | johndoe@test.com | 21/July/2024 | 22/July/2024 |

  @DataActivityLog
  Scenario Outline: Verifying the reset button in Data Activity log
    When I will select the Activity log from the Master tab
    And I will select the filters with data "<Module Name>","<Table Name>","<User Name>","<From Date>","<To Date>"
    And I will click on Save button
    Then I will click on Reset button and verify the records gets cleared from the table

    Examples: 
      | Module Name    | Table Name         | User Name        | From Date    | To Date      |
      | reference-data | differentiator_key | johndoe@test.com | 21/July/2024 | 22/July/2024 |