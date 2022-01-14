@shopping
Feature: Shopping
  As a user
  I want to be able to buy products

  Background:
    Given I am on weather shopper home page

  @shopping
  Scenario: buy products based on the temperature
    When I select product to cart based on temperature
    And I add cheapest products to cart
    And I click on Cart
    And I make the payment
    Then I verify payment is successful
