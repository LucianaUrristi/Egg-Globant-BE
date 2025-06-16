

context('Complementary 01', () => {
  // Se ejecuta antes de cada caso de prueba dentro del contexto.
  beforeEach(() => {
    cy.visit('/'); // Se navega automáticamente a la baseUrl definida en cypress.json
  });

  it('Debería completar el login exitosamente', () => {
    // Completa el campo de nombre de usuario
    cy.get('input[name="UserName"]').type('User Name');

    // Completa el campo de contraseña
    cy.get('input[name="Password"]').type('pwd');

    // Hace clic en el botón de login
    cy.get('#login').click();

    // Verifica que aparezca el mensaje de bienvenida
    cy.contains('Welcome').should('exist');
  });
  it("Login 2.0", () => {
    cy.fixture("credenciales").then(({ usuarios }) => {
      usuarios.forEach(({ usuario, clave }) => {
      // Alias para campos
        cy.get('input[name="UserName"]').as("inputUsuario");
        cy.get('input[name="Password"]').as("inputPassword");
        cy.get(".btn.btn-primary").as("botonLogin");
        // Ingresar datos
        // Completar y limpiar campos
        cy.get('input[name="UserName"]').clear().type(usuario);
        cy.get('input[name="Password"]').clear().type(clave);
        // Enviar el formulario
        cy.get(".btn.btn-primary").click();
        // Verificar mensaje de bienvenida
        cy.contains("Welcome", { timeout: 10000 }).as("mensajeBienvenida");
        cy.get("@mensajeBienvenida").should("exist");
        // Volver al inicio antes de probar otra credencial
        cy.visit("/");
      });
    });
  });
});
