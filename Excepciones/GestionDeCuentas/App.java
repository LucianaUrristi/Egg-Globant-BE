package GestionDeCuentas;
import GestionDeCuentas.entidades.CuentaBancaria;
import GestionDeCuentas.excepciones.SaldoInsuficienteException;

// Clase Principal
public class App {
    public static void main(String[] args) {
        // Crear una instancia de CuentaBancaria con un saldo inicial de 1000
        CuentaBancaria cuenta = new CuentaBancaria(1000);

        // Realizar pruebas exhaustivas del programa
        try {
            // Caso de retiro exitoso
            cuenta.retirar(500);
            // Caso de saldo insuficiente
            cuenta.retirar(1500);
        } catch (SaldoInsuficienteException e) {
            // Capturar la excepción de saldo insuficiente y mostrar el mensaje de error

            System.out.println("Error: " + e.getMessage());
        }
    }
}

/*
 * Actividad: Gestión de cuentas
Desarrolla una aplicación de gestión de cuentas bancarias que pueda manejar excepciones personalizadas. Para lograrlo, sigue estos pasos:

Clase "CuentaBancaria": Crea una clase llamada "CuentaBancaria" que contenga un atributo llamado saldo inicial y un método llamado "retirar" para efectuar retiros de la cuenta. Este método deberá lanzar una excepción personalizada denominada "SaldoInsuficienteException" si el saldo disponible no es suficiente para cubrir la cantidad solicitada.

Clase Excepción Personalizada "SaldoInsuficienteException": Define una excepción personalizada llamada "SaldoInsuficienteException", que herede de la clase Exception. Esta excepción debe tener un constructor que permita pasar un mensaje de error personalizado.

Manejo de Excepciones en la Clase Principal: En la clase principal del programa, crea una instancia de la clase "CuentaBancaria" y maneja las excepciones de manera adecuada al intentar realizar retiros. Asegúrate de manejar las excepciones "SaldoInsuficienteException" de manera específica.

Prueba del Programa: Realiza pruebas exhaustivas del programa, incluyendo casos donde los retiros sean exitosos y casos donde se genere una excepción por saldo insuficiente.
 */
