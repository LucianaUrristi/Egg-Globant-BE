class CategoryPage {
    selectCategory(category) {
      cy.contains("'a', category").click()
    }
  
    selectProduct(product) {
      cy.contains('a', product).click()
    }
  }
  
  export default CategoryPage
  