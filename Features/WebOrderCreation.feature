@WebOrder
Feature: Web order creation


  Background: 
Given The user navigates to login page of WeoOrder
When User enters the user name onto the UserName and password
When User Click on the Login Page
Then The user should be redirected to the WeBpage Page 
    

  @CreateOrder
  Scenario: Create am Order
    When I Create Web Order
   