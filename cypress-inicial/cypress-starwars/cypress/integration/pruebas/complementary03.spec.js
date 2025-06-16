/// <reference types='cypress' />
//{"baseUrl": "https://swapi.dev/api" }
describe("Pruebas de la API de Star Wars", () => {
    let filmUrl; // Variable para almacenar la URL de la película
    let planetUrl; // Variable para almacenar la URL del planeta
    let planetData; // Variable para almacenar los datos del planeta para comparar

    // Se ejecuta antes de cada caso de prueba dentro del contexto.
    beforeEach(() => {
        cy.visit('/'); // Se navega automáticamente a la baseUrl definida en cypress.json
    });
    
    // 1. Probar el endpoint /people/2/ (C-3PO)
    it("Debe verificar que el color de piel de C-3PO sea dorado y aparezca en 6 películas", () => {
        cy.request("/people/2/").its("status").should("equal", 200); // Verificar que la respuesta sea exitosa (200)
        cy.request("/people/2/")
            .its("body")
            .then((body) => {
                expect(body.skin_color).to.equal("gold"); // Validar color de piel
                expect(body.films.length).to.equal(6); // Validar que aparece en 6 películas
                // Guardar la URL de la segunda película
            filmUrl = body.films[1]; // Segunda película en la lista
        });
    });
    // 2. Solicitar el endpoint de la segunda película en la que aparece C-3PO
    it("Debe verificar la fecha de lanzamiento y la presencia de campos específicos en la segunda película", () => {
        cy.request(filmUrl).its("status").should("equal", 200); // Verificar que la respuesta sea exitosa
        cy.request(filmUrl)
        .its("body")
        .then((body) => {
            // Verificar que la fecha de lanzamiento esté en formato correcto YYYY-MM-DD
            expect(body.release_date).to.match(/^\d{4}-\d{2}-\d{2}$/);
            // Verificar que los campos requeridos existen y contienen más de un elemento
            expect(body.characters.length).to.be.greaterThan(1);
            expect(body.planets.length).to.be.greaterThan(1);
            expect(body.starships.length).to.be.greaterThan(1);
            expect(body.vehicles.length).to.be.greaterThan(1);
            expect(body.species.length).to.be.greaterThan(1);
            // Guardar la URL del primer planeta
            planetUrl = body.planets[0];
        });
    });
    // 3. Solicitar el endpoint del primer planeta presente en la respuesta de la película
    it("Debe verificar que los valores de gravedad y terrenos coincidan con la respuesta original del planeta", () => {
        cy.request(planetUrl)
        .its("body")
        .then((body) => {
        // Almacenar los datos de gravedad y terrenos para comparaciones futuras
        planetData = {
            gravity: body.gravity,
            terrain: body.terrain,
        };
        // Verificar que los valores de gravedad y terrenos coinciden
        expect(body.gravity).to.exist;
        expect(body.terrain).to.exist;
        });
    });
    // 4. Solicitar nuevamente la URL del planeta y comparar la respuesta
    it("Debe validar que la respuesta del planeta es idéntica a la anterior", () => {
        cy.request(planetUrl)
        .its("body")
        .then((body) => {
            // Comparar los datos actuales con los almacenados previamente
            expect(body.gravity).to.equal(planetData.gravity);
            expect(body.terrain).to.equal(planetData.terrain);
        });
    });
    // 5. Solicitar el endpoint /films/7/ y verificar que la respuesta devuelva un código de estado 404
    it("Debe devolver un error 404 al solicitar el endpoint de la película 7", () => {
        cy.request({
            url: "/films/7/",
            failOnStatusCode: false, // Evita que Cypress falle automáticamente en caso de error
        })
        .its("status")
        .should("equal", 404); // Verificar que la respuesta es 404
    });
});