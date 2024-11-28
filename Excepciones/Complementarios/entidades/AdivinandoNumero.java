package Complementarios.entidades;
import java.util.Scanner;
import java.util.InputMismatchException;

public class AdivinandoNumero {
    //Este ejercicio ya tiene el MAIN aca
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numeroAdivinar = (int) (Math.random() * 50) + 1; // Número aleatorio entre 1 y 50
        int intentos = 0;
        boolean adivinado = false;

        System.out.println("¡Adivina el número entre 1 y 50!");

        while (!adivinado) {
            System.out.print("Introduce un número: ");
            try {
                int numeroUsuario = scanner.nextInt();
                intentos++;

                if (numeroUsuario < numeroAdivinar) {
                    System.out.println("El número a adivinar es mayor.");
                } else if (numeroUsuario > numeroAdivinar) {
                    System.out.println("El número a adivinar es menor.");
                } else {
                    adivinado = true;
                    System.out.println("¡Felicidades! Has adivinado el número en " + intentos + " intentos.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Error: Debes ingresar un número.");
                scanner.next(); // Limpiar el buffer del scanner
                intentos++; // Contabilizar el intento con error
            }
        }
        scanner.close();
    }
}

/*
 * *1. Adivinando un número

Tu tarea es escribir un programa en Java que entretenga al usuario mientras intenta adivinar un número. 
El programa generará aleatoriamente un número entre 1 y 50, y el desafío para el usuario será intentar adivinarlo. 
Cada vez que el usuario ingrese un valor, la computadora le informará si el número a adivinar es mayor o menor que 
el ingresado por el usuario. Cuando el usuario finalmente adivine el número, el programa indicará el logro y mostrará 
en pantalla la cantidad de intentos realizados para lograrlo. Además, si el usuario ingresa algo que no sea un número, 
el programa manejará esta excepción y lo notificará en pantalla. En este último caso, también se contabilizará el 
carácter erróneo como un intento. 
 */
