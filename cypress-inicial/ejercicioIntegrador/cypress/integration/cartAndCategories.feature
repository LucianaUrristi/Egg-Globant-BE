Feature: Cart and Product Selection
  @cart @categories @regression
  Scenario: Select a category and product

    Given I navigate to the home page
    When I select the Laptops category
    When I click on a product
    Then I should be taken to the product page

  Scenario: Add product to cart
    Given I am on a product page
    When I add the product to the cart
    Then I should see it listed in the cart

  Scenario: Purchase product from cart
    Given I have products in my cart
    When I proceed to checkout
    Then I should be able to complete the purchase

  Scenario: Remove a product from the cart
    Given I have products in my cart
    When I remove a product
    Then it should no longer appear in the cart
