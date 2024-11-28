package Persona;

public class App {
    public static void main(String[] args) {
    // Creamos una variable del tipo persona, instanciando un objeto
    Persona persona1 = new Persona();
    // Damos valores a los atributos del objeto previamente instanciado
    persona1.nombre = "Pedro";
    persona1.edad = 80;
    // Invocamos al método para imprimir los datos
    persona1.imprimirDatos();
    // Realizamos lo mismo para crear una nueva Persona
    Persona persona2 = new Persona();
    persona2.nombre = "Ana";
    persona2.edad = 50;
    persona2.imprimirDatos();
    }
    }
