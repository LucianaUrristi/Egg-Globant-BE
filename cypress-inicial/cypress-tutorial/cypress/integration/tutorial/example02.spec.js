/// <reference types='cypress' />


context('Alias y variables', () => {
    beforeEach(() => {
        cy.visit('/');
        cy.fixture("todos").as('todos');
    });
    
    


    it('Test 01', () => {
        // Variable para almacenar el texto de la nueva tarea
        const TEXTO_TAREA = "Something...";
        // Agrega una nueva tarea usando el valor de la variable
        cy.get('.new-todo').type(`${TEXTO_TAREA}{enter}`);
        // Asigna un alias a los elementos de la lista de tareas
        cy.get('.todo-list li').as('items');
        // Verifica la cantidad de tareas usando el alias
        cy.get('@items').should('have.length', 3);
        // También puedes verificar sin alias, repitiendo el selector
        cy.get('.todo-list li').should('have.length', 3);
    });

    it("Test 02", () => {
        // Cargar el fixture y almacenarlo en un alias
        cy.fixture("todos").as("todoss");
        // Utilizar el alias para acceder al arreglo y cargar tareas
        cy.get("@todoss").then((todos) => {
          todos.todos.forEach((todo) => {
            cy.get(".new-todo").type(todo + "{enter}");
          });
        });
      })
    
    

    it("Test #4: Assertions 2.0", () =>{
        const TASK_TEXT="My long task #1";
        //Alias para los elementos li de la lista
        cy.get('.todo-list li').as("taskItems");
        //Validación inicial: hay 2 tareas
        cy.get("@taskItems").should("have.length", 2);
        // Ingreso de nueva tarea
        cy.get(".new-todo").type(`${TASK_TEXT}{enter}`);
        // Revalidación: ahora debe haber 3 tareas
        cy.get(".todo-list li").as("updatedTaskItems");
        cy.get("@updatedTaskItems").should("have.length", 3);
        // Alias para el label de la tarea recién agregada
        cy.contains("label", TASK_TEXT).as("newTaskLabel");
        // Marcar como completada
        cy.get("@newTaskLabel").parent().find("input.toggle").click();
        // Validar que tenga la clase 'completed'
        cy.get("@newTaskLabel").parent().parent().should("have.class", "completed");
    });
});

