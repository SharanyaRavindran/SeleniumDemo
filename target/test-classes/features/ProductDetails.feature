Feature: Check the functionality of the Product Page

Background:
Given User is logged in with correct user name and passowrd
|username|password|
|standard_user|secret_sauce|
And User clicks on the first product

Scenario: Check the add to cart fundtionality
Given User is on the Product page
When User clicks Add to Cart button
Then Product is added to cart

Scenario: Check remove from cart functionality
Given User added to product to cart
When User clicks Remove button
Then Product is removed from cart

