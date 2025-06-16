class HomePage {
    visit() {
      cy.visit('https://www.demoblaze.com/')
    }
  
    clickNextCarousel() {
      cy.get('.carousel-control-next').click()
    }
  
    clickPreviousCarousel() {
      cy.get('.carousel-control-prev').click()
    }
  }
  
  export default HomePage
  