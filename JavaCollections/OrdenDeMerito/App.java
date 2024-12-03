import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        // Inicializar ArrayList para almacenar números enteros
        ArrayList<Integer> notas = new ArrayList<>();
        // Crear un objeto Scanner para la entrada del usuario
        Scanner scanner = new Scanner(System.in);
        // Bucle para solicitar al usuario que ingrese números enteros
        String respuesta;
        do {
        System.out.print("Ingrese una nota (entre 1 y 10): ");
        int nota = scanner.nextInt();
        // Verificar que la nota esté en el rango especificado
        if (nota >= 1 && nota <= 10) {
        notas.add(nota);
        } else {
        System.out.println("La nota debe estar entre 1 y 10. Inténtelo de nuevo.");

        }
        System.out.print("¿Desea ingresar otra nota? (s/n): ");
        respuesta = scanner.next();
        } while (respuesta.equalsIgnoreCase("s"));
        // Ordenar la lista de notas de forma descendente
        Collections.sort(notas, Collections.reverseOrder());
        // Imprimir la lista ordenada en orden descendente

        System.out.println("\nLista de notas ordenadas (descendente):");
        for (int nota : notas) {
        System.out.println(nota);
        }
        // Imprimir la lista ordenada en orden ascendente
        System.out.println("\nLista de notas ordenadas (ascendente):");
        Collections.sort(notas);
        for (int nota : notas) {
            System.out.println(nota);
        }
        
    }
}

/*
 * Actividad: Orden de mérito
Desarrolla un programa en Java que emplee un ArrayList para almacenar una serie
de notas enteras en el rango del 1 al 10.
El programa debe permitir al usuario ingresar varios números a la lista,
asegurándose de que cada número esté dentro del rango especificado. Luego,
ordenará estos números de manera descendente y los imprimirá por pantalla en
ambas direcciones.
Pasos a seguir:
● Inicializa un ArrayList de tipo Integer para almacenar los números enteros.

● Implementa un bucle que solicite al usuario ingresar números enteros uno por
uno. Puedes usar un bucle while o for que pregunte al usuario si desea
agregar un número en cada iteración.
● En cada iteración del bucle, verifica que el número ingresado esté dentro del
rango del 1 al 10 y agrégalo al ArrayList utilizando el método add. Continúa
solicitando al usuario que ingrese números hasta que decida no agregar más.
● Después de que el usuario haya ingresado todos los números, utiliza el
método sort para ordenar la lista de números de forma descendente.
● Imprime por pantalla la lista ordenada tanto en orden ascendente como
descendente.
 */