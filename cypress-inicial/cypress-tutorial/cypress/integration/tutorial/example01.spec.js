/// <reference types='cypress' />

// Define un contexto que agrupa un conjunto de casos de prueba relacionados
context('Example 01', () => {
    // Se ejecuta antes de cada caso de prueba dentro del contexto.
    beforeEach(() => {
      cy.visit('/'); // Se navega automáticamente a la baseUrl definida en cypress.json
    });

    // Caso de prueba individual: Test #1
    it('Test #1', () => {
      // Agregar la primera tarea
        cy.get('.new-todo').type("My long task #1{enter}");// Selecciona el campo de texto con la clase CSS .new-todo
        //Agregar la segunda tarea utilizando el mismo selector
        cy.get('.new-todo').type("My long task #2{enter}");//Escribe el texto "My long task #1" y presiona Enter
        //Cambiar a la vista de tareas completadas
        cy.contains('Completed').click();// Localiza el botón con el texto 'Completed' y hace clic
        //Cambiar a la vista de tareas activas
        cy.contains('Active').click();// Localiza el botón con el texto 'Active' y hace clic
    });

    it('Test #1 con selectores XPath', () =>{
        cy.xpath('//input[@class="new-todo"]')
        .type("My long task #1 con XPath{enter}");
        cy.xpath('//input[@class="new-todo"]')
        .type("My long task #2 con XPath{enter}");
        cy.xpath('//a[normalize-space()="Completed"]').click();
        cy.xpath('//a[normalize-space()="Active"]').click();
    });

    it('Test #2: Select using CSS selectors', () =>{
      cy.get(".new-todo").type("My long task #1{enter}");
      cy.get(".new-todo").type("My long task #2{enter}");
      cy.get(":nth-child(2) > .view > .toggle").click();
      cy.contains("Completed").click();
    });

    it("Test #3: Select using Text Content", () =>{
      cy.get('.new-todo').type("My long task #1{enter}");
      cy.get('.new-todo').type("My long task #2{enter}");
      cy.contains('label', "My long task #1").parent().find("input.toggle").click();
      cy.contains("Completed").click();
    });

    it("Test #4: Assertions", () =>{
      cy.get('.todo-list li').should("have.length", 2);
      cy.get('.new-todo').type("My long task #1{enter}");
      cy.get('.todo-list li').should("have.length", 3);
      cy.contains('label', "My long task #1")
        .parent()
        .find("input.toggle")
        .click();
      cy.contains('label', "My long task #1")
      .parent()
      .parent()
      .should("have.class", "completed");
    });

    it("Test #5: Reversing the Default Assertions", () =>{
      cy.get(".button-close").should("not.exist");
      cy.get('selector-del-elemento', { timeout: 0}).should('not.exist');
      cy.get(".button-close").should("exist");
    });
    
  });
