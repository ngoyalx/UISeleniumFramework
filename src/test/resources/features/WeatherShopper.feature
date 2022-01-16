@shopping
Feature: Shopping
  As a user
  I want to be able to buy products

  Background:
    Given I am on weather shopper home page

  @shopping
  Scenario: buy products based on the temperature
    When I select product based on temperature
    And I add least expensive products to cart
    And I click on Cart
    Then I verify the price of products in cart is same as of products page
    And I make the payment
    Then I verify payment is successful
