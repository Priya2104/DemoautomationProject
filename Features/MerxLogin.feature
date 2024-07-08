@tag
Feature: Login Merx Application

  @MerxLogin
Scenario: Successful Login with Valid Credentials
    Given The user navigates to login page of Merx
    When The user enters email as "johndoe@test.com" and password as "johndoe"
    And The user clicks on the Sign in button
    Then The user should be redirected to the Merchandise Page