Feature: Check the functionality of the Product Page

Background:
Given User is logged in with correct user name and passowrd
|username|password|
|standard_user|secret_sauce|

    
  Scenario: User checks the sort functionality
     Given User is on the Product page
     When User sorts by "Price (low to high)"
     Then The products should be sorted by price(low to high)
