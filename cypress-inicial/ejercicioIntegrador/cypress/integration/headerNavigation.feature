Feature: Header Navigation

Background:
Given I am on any page

  @header @sanity
  Scenario: Navigate to Home
    When I click on the "Home" link
    Then I should be redirected to the home page

  Scenario: Navigate to Contact
    When I click on the "Contact" link
    Then I should be taken to the Contact page

  Scenario: Navigate to About Us
    When I click on the About Us button
    Then I should see the About Us page
