import CategoryPage from '../../support/pageObjects/CategoryPage'
import CartPage from '../../support/pageObjects/CartPage'
import HomePage from '../../support/pageObjects/HomePage'

const categoryPage = new CategoryPage()
const cartPage = new CartPage()
const homePage = new HomePage()

Given('I navigate to the home page', () => {
    homePage.visit()
})

When('I select the Laptops category', () => {
  cy.get("body > div:nth-child(6) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > a:nth-child(3)", { timeout: 10000 }).contains("Laptops").click()

})

When('I click on a product', () => {
  categoryPage.selectProduct('Samsung galaxy s6') // Ejemplo, ajusta al producto deseado
})

Then('I should be taken to the product page', () => {
  cy.url().should('include', 'prod.html')
})

Given('I am on a product page', () => {
  cy.visit('https://www.demoblaze.com/prod.html?idp_=1') // Cambia según el producto
})

When('I add the product to the cart', () => {
  cartPage.addItemToCart()
})

Then('I should see it listed in the cart', () => {
  cy.contains('Cart').click()
  cy.contains('Samsung galaxy s6').should('be.visible') // Cambia según el producto
})

Given('I have products in my cart', () => {
  cy.visit('https://www.demoblaze.com/cart.html')
})

When('I proceed to checkout', () => {
  cartPage.checkout()
})

Then('I should be able to complete the purchase', () => {
  cy.get('#name').type('Pablin')
  cy.get('#country').type('Argentina')
  cy.get('#city').type('Tucuman')
  cy.get('#card').type('1234567890123456')
  cy.get('#month').type('12')
  cy.get('#year').type('2050')
  cy.contains('Purchase').click()
  cy.contains('Thank you for your purchase!').should('be.visible')
})

When('I remove a product', () => {
  cy.get('body > div:nth-child(7) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > table:nth-child(1) > tbody:nth-child(2) > tr:nth-child(1) > td:nth-child(4) > a:nth-child(1)', { timeout: 10000 }).click() // Cambia según el producto
})

Then('it should no longer appear in the cart', () => {
  cy.contains('Samsung galaxy s6').should('not.exist')
})
