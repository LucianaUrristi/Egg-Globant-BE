import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        // Método para leer los valores ingresados por el usuario
        ArrayList<Integer> valores = leerValores();

        // Método para calcular la suma de los valores
        int suma = calcularSuma(valores);
        // Método para calcular el promedio de los valores
        double promedio = calcularPromedio(valores, suma);
        // Método para mostrar los resultados
        mostrarResultados(valores, suma, promedio);
    }

    // Método para leer los valores ingresados por el usuario
    public static ArrayList<Integer> leerValores() {
        ArrayList<Integer> valores = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int valor;
        System.out.println("Ingrese los valores (ingrese -99 para finalizar):");
        do {
            valor = scanner.nextInt();
            if (valor != -99) {
                valores.add(valor);
            }
        } while (valor != -99);
        scanner.close();
        return valores;
    }

    // Método para calcular la suma de los valores
    public static int calcularSuma(ArrayList<Integer> valores) {
        int suma = 0;
        Iterator<Integer> iterator = valores.iterator();
        while (iterator.hasNext()) {
            suma += iterator.next();
        }
        return suma;
    }

    // Método para calcular el promedio de los valores
    public static double calcularPromedio(ArrayList<Integer> valores,
            int suma) {
        return (double) suma / valores.size();
    }

    // Método para mostrar los resultados
    public static void mostrarResultados(ArrayList<Integer> valores, int suma, double promedio) {
        System.out.println("Valores ingresados:");
        for (int valor : valores) {
            System.out.print(valor + " ");
        }
        System.out.println("\n\nSuma de los valores: " + suma);
        System.out.println("Promedio de los valores: " + promedio);
        int valoresMayoresAlPromedio = 0;
        for (int valor : valores) {
            if (valor > promedio) {
                valoresMayoresAlPromedio++;
            }

        }
        System.out.println("Cantidad de valores mayores que el promedio: " + valoresMayoresAlPromedio);
    }
}

/*
 * Actividad: Sopa de números
Desarrolla un programa que solicite al usuario ingresar una serie de valores
numéricos enteros desde el teclado y los guarde en un ArrayList de tipo Integer. La
lectura de números finalizará cuando se introduzca el valor -99. Este valor no será
almacenado en el ArrayList.
Una vez completada la entrada de datos, el programa mostrará por pantalla el
número total de valores ingresados, su suma y su media (promedio). Además, se
mostrará cuántos de los valores ingresados son mayores que la media.
Para abordar esta tarea, asegúrate de desarrollar al menos los siguientes métodos:
● Método leerValores(): Este método solicita por teclado los números y los
almacena en el ArrayList. La lectura finaliza cuando se introduce el valor -99.
El método devuelve el ArrayList con los valores introducidos.
● Método calcularSuma(): Recibe como parámetro el ArrayList con los valores
numéricos y calcula su suma. Utiliza un Iterator para recorrer el ArrayList.
● Método calcularPromedio(): Recibe como parámetro el ArrayList con los
valores numéricos y calcula su media. Utiliza un Iterator para recorrer el
ArrayList.
● Método mostrarResultados(): Recibe como parámetro el ArrayList, la suma
y la media aritmética. Este método muestra por pantalla todos los valores, su
suma y su media, y calcula y muestra cuántos números son superiores a la
media.
 */
