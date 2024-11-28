package SaludoAlUsuario;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        // Método principal que llama al método saludar
        saludar();
    }

    public static void saludar() {
        // Crear un objeto Scanner para recibir la entrada del usuario
        Scanner scanner = new Scanner(System.in);
        try {
            // Solicitar al usuario su nombre
            String nombre = solicitarNombre(scanner);
            // Imprimir el saludo
            System.out.println("¡Hola, " + nombre + "!");
        } catch (IllegalArgumentException e) {
            // Capturar la excepción si el nombre es demasiado corto
            System.err.println("Error: El nombre debe tener al menos 2 caracteres.");
        } finally {
            // Cerrar el Scanner después de su uso, asegurándose de que siempre se cierre

            scanner.close();
        }
    }

    public static String solicitarNombre(Scanner scanner) {
        // Solicitar al usuario que ingrese su nombre
        System.out.print("Por favor, ingresa tu nombre: ");
        // Leer el nombre ingresado por el usuario
        String nombre = scanner.nextLine();
        // Verificar si el nombre tiene menos de 2 caracteres
        if (nombre.length() < 2) {
            // Lanzar una excepción si el nombre es demasiado corto
            throw new IllegalArgumentException();
        }
        // Devolver el nombre ingresado por el usuario
        return nombre;
    }
}

/*
 * Actividad: Saludo al usuario
Para completar esta actividad, debes desarrollar un programa que salude a las personas por consola. Sigue estos pasos:


Crea una clase con un método main que llame a otro método encargado de solicitar al usuario su nombre y luego imprima un saludo en pantalla.

Este método deberá lanzar una excepción si el nombre ingresado por el usuario tiene menos de 2 caracteres.

Utiliza el bloque "finally" para asegurarte de cerrar el Scanner después de usarlo.
 */
