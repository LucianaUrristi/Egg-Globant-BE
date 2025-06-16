import HomePage from '../../support/pageObjects/HomePage';
import {Given, When, Then } from "cypress-cucumber-preprocessor/steps";

const homePage = new HomePage()

Given('I navigate to the home page', () => {
  homePage.visit()
})

Then('I should see featured products in the carousel', () => {
  cy.get('.carousel-item.active').should('exist')
})

When('I click the next button on the carousel', () => {
  homePage.clickNextCarousel()
})

Then('I should see the next featured product', () => {
  cy.get('.carousel-item.active').should('exist')
})

When('I click the back button on the carousel', () => {
  homePage.clickPreviousCarousel()
})

Then('I should see the first featured product', () => {
  cy.get('.carousel-item.active').should('exist')
})