@WebOrder
Feature: Order Deletion


  Background: 
Given The user navigates to login page of WeoOrder
When User enters the user name onto the UserName and password
When User Click on the Login Page
Then The user should be redirected to the WeBpage Page 
    

  @DeleteOrder
  Scenario: Delete an specific Order
    When Select an order 
    Then Delete specific order
    Then Check order is deleted or not 
   