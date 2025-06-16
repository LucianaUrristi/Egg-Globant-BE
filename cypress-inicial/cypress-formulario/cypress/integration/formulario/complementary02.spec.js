/// <reference types="cypress" />

context('Complementary 02', () => {

  // Ignorar errores de publicidad de Google que no afectan el test
  Cypress.on('uncaught:exception', (err) => {
    if (err.message.includes('adsbygoogle.push() error')) return false
  })

  // Antes de cada test, cargar los datos de prueba y visitar la página
  
  beforeEach(() => {
    // Cargar fixture con alias "data"
    cy.fixture('formulario').as('data');
    // Visitar la baseUrl desde cypress.json
    cy.visit('/');

    // Alias para campos usados en múltiples tests
    cy.get('#g4072-fullname').as('fullname');
    cy.get('#g4072-email').as('email');
    cy.get('#g4072-phonenumber').as('phonenumber');
    cy.get('#g4072-gender').as('gender');
    cy.get('#g4072-qatools').as('tools');
    cy.get('label[for="contact-form-comment-g4072-otherdetails"]').as('commentBox');
    cy.get('button[data-id-attr="placeholder"]').as('submitBtn');
  });

  // Escenario 1: Completar todos los campos correctamente
  it('Escenario 1: Completar todos los campos correctamente', function () {
    const d = this.data;
    // Ingresar nombre completo
    cy.get('@fullname').type(d.fullname);
    // Ingresar email válido
    cy.get('@email').type(d.emailValid);
    // Ingresar teléfono
    cy.get('@phonenumber').type(d.phone);
    // Seleccionar género
    cy.get('@gender').select(d.gender);
    // Seleccionar experiencia
    cy.get(`input[name="g4072-yearsofexperience"][value="${d.experience}"]`).check();
    // Seleccionar skill
    cy.get(`input[name="g4072-skills[]"][value="${d.skills[0]}"]`).check();
    // Seleccionar herramienta QA
    cy.get('@tools').select(d.tool);
    // Ingresar comentario
    cy.get('@commentBox').type(d.comment);
    // Enviar formulario
    cy.get('@submitBtn').click();
    // Verificar mensaje de éxito
    cy.contains('Your message has been sent').should('be.visible');
  })

  // Escenario 2: Validar errores al dejar campos obligatorios vacíos
  it('Escenario 2: Campos obligatorios vacíos', () => {
    // Enviar sin completar
    cy.get('@submitBtn').click();
    // Mensaje de alerta general
    cy.get('div[role="alert"]').should('contain', 'Please make sure all fields are valid');
    // Error por nombre vacío
    cy.get('#content li').eq(0).should('contain', 'Full Name(required)');
    // Error por email vacío
    cy.get('#content li').eq(1).should('contain', 'Email(required)');
  })

  // Escenario 3: Validar email no válido
  it('Escenario 3: Email no válido', function () {
    // Ingresar nombre
    cy.get('@fullname').type('Ana Gómez');
    // Email sin "@"
    cy.get('@email').type(this.data.emailInvalid);
    // Enviar formulario
    cy.get('@submitBtn').click();
    // Error general de email
    cy.get('div[role="alert"]').should('contain', 'Email');
    // Detalle del error
    cy.get('#content li').first().should('contain', 'Email(required)');
  });

  // Escenario 4: Seleccionar múltiples opciones
  it('Escenario 4: Seleccionar múltiples opciones', function () {
    this.data.skills.forEach(skill => {
      // Chequear cada habilidad
      cy.get(`input[name="g4072-skills[]"][value="${skill}"]`).check()       
    });
    // Verificar que se seleccionaron todas
    cy.get('input[name="g4072-skills[]"]:checked').should('have.length', this.data.skills.length);
  });

  // Escenario 5: Validar mensaje de error específico
  it('Escenario 5: Validar mensaje de error', () => {
    // Solo nombre ingresado
    cy.get('@fullname').type('Luis Fernández');
    // Enviar formulario
    cy.get('@submitBtn').click();
    // Error bajo campo email
    cy.get('#g4072-email-error').should('contain', 'Please fill out this field.');
    // Mensaje general
    cy.get('div[role="alert"]').should('contain', 'Please make sure all fields are valid');
    // Detalle del campo requerido
    cy.get('div[role="alert"] ul li').should('contain', 'Email(required)');   
  });

});
