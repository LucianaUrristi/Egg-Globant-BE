import Header from '../../support/pageObjects/HeaderPage'

const header = new Header()

Given('I am on any page', () => {
  cy.visit('/')
})

When('I click on the {string} link', (linkText) => {
  header.navigateTo(linkText)
})

Then('I should be redirected to the home page', () => {
  cy.url().should('eq', 'https://www.demoblaze.com/index.html')
})

Then('I should be taken to the Contact page', () => {
  cy.get("div#exampleModal div.modal-footer button:nth-child(1)").should('be.visible')
})

When('I click on the About Us button', () => {
  cy.get("a[data-target='#videoModal']").click()
})

Then('I should see the About Us page', () => {
  cy.get("div[id='videoModal']").should('be.visible')
})

