class CartPage {
    addItemToCart() {
      cy.get('.btn.btn-success.btn-lg').click()
    }
  
  
    checkout() {
      cy.contains('Place Order').click()
    }
  }
  
  export default CartPage
  
  