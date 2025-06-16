Feature: Product Carousel
  @carousel @smoke @regression
  Scenario: Display initial featured products
    Given I navigate to the home page
    Then I should see featured products in the carousel

  Scenario: Navigate through carousel products
    Given I navigate to the home page
    When I click the next button on the carousel
    Then I should see the next featured product

  Scenario: Carousel loops back to the first product
    Given I navigate to the home page
    When I click the back button on the carousel
    Then I should see the first featured product