/// <reference types="cypress" />

context('wikipedia', () => {

    // Antes de cada test, cargar los datos de prueba y visitar la página
    
    beforeEach(() => {
      // Cargar fixture con alias "data"
    //   cy.fixture('formulario').as('data');
      // Visitar la baseUrl desde cypress.json
      cy.visit('/');
  
      
    });
  
   
    it('Test 01 - BDD Expectations', () => {
        //Navega a la página principal de Wikipedia.
        //Localiza el campo de búsqueda e ingresa la palabra “Globant”.
        //Presiona Enter para iniciar la búsqueda.
        cy.get('#searchInput').type('Globant{enter}');
        //Implementa una espera explícita
        //Localiza el título principal en la página de resultados.
        //Verifica que el título sea visible.
        //Usa una assertion para comprobar que el texto del título contiene la palabra “Globant”.
        cy.get('h1[id="firstHeading"] span[class="mw-page-title-main"]')
            .should('be.visible')
            .should('have.text', 'Globant');
    });
  
    it.only('Test 02 - Implicit Wait', () => {
        //Accede a la página principal de Wikipedia.
        //Localiza el campo de búsqueda e ingresa el texto “Globant”.
        //Presiona Enter para iniciar la búsqueda.
        cy.get('#searchInput').type('Globant{enter}');
        //Inserta una espera implícita de 6000 milisegundos antes de realizar las validaciones.
        cy.wait(6000);
        //Verifica que el título principal de la página de resultados esté visible.
        //Asegúrate de que dicho título contenga la palabra “Globant”.
        cy.get('h1[id="firstHeading"] span[class="mw-page-title-main"]')
            .should('be.visible')
            .should('have.text', 'Globant');
    });
    
});