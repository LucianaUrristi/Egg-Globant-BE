class Header {
    navigateTo(linkText) {
      cy.contains('a', linkText).click()
    }
  }
  
  export default Header
  