#Author: Sharanya Ravindran

Feature: Check the functionality of the Login Page


  Scenario Outline: User logins in with user names and passwords
    Given  User is on the login page
    When User enters user name "<user name>"
    And User enters  password "<password>"
    And User clicks Login Button
    Then User should be logged in

    Examples: 
      |user name|password|
      |standard_user|secret_sauce|
      |locked_out_user|secret_sauce|
      |error_user|secret_sauce|
      
  

 
      
      