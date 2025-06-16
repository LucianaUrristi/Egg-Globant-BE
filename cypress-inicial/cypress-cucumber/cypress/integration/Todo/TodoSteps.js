import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";


Given('I visit the TODO homepage', () => {
    cy.visit("/");
});


When('I submit(ted) a new TODO {string}', text => {
    cy.get(".new-todo").type(text + '{enter}');
});


When('I check the item #{int}', item => {
    cy.get(`:nth-child(${item}) > .view > .toggle`).click();
});


Then('the count of pending is {int}', pendingItems => {
    cy.get('.todo-count > strong').invoke('text').then(parseInt)
        .should('eq', pendingItems);
});
