// Descripción del grupo de pruebas
context("Pruebas de espera con solicitudes AJAX", () => {
    // Selectores reutilizables definidos como constantes para facilitar el
    //mantenimiento del código
    const buttonSelector = "#ajaxButton";
    const successMsgSelector = ".bg-success";
    beforeEach(() => {
        cy.visit("/ajax"); // Navega a la URL base + /ajax
        cy.get(buttonSelector).as("ajaxBtn");
    });
    
    // Escenario 1: Espera implícita con 'should'
    it("Debería mostrar el mensaje de éxito utilizando espera implícita", () => {
        cy.get("@ajaxBtn").click(); // Hacer clic en el botón
        cy.get(successMsgSelector, { timeout: 25000 })
            .should("be.visible")
            .and("contain", "Data loaded with AJAX get request.");
    });

    // Escenario 2: Espera explícita con 'cy.wait'
    it("Debería esperar explícitamente hasta que el mensaje de éxito aparezca", () => {
        cy.get("@ajaxBtn").click(); // Hacer clic en el botón
        cy.wait(25000); // Espera simulada de 25 segundos
        cy.get(successMsgSelector).should("be.visible");
    });

    // Escenario 3: Espera condicional con 'cy.intercept'
    it("Debería mostrar el mensaje de éxito interceptando la solicitud AJAX", () => {
        cy.intercept("GET", "/ajaxdata").as("getData");
        cy.get("@ajaxBtn").click(); // Hacer clic en el botón
        cy.wait("@getData"); // Esperar a que la solicitud se complete
        cy.get(successMsgSelector)
            .should("be.visible")
            .and("contain", "Data loaded with AJAX get request.");
    });

    // Escenario adicional: Validar que el botón sigue activo después del clic
    it("Debería verificar que el botón sigue activo después de hacer clic", () => {
        cy.get("@ajaxBtn").click();
        cy.get("@ajaxBtn").should("be.enabled");
    });

        // Escenario adicional: Validar el estado inicial de la página
    it("Debería verificar que el mensaje no está visible antes de hacer clic en el botón", () => {
        cy.get(successMsgSelector).should("not.exist");
    });
});