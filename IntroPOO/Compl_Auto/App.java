package Compl_Auto;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Auto auto = null;
        int opcion;

        do {
            // Menú de opciones
            System.out.println("******** Menú de Opciones ********");
            System.out.println("1. Crear Auto");
            System.out.println("2. Imprimir datos del Auto");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    // Opción para crear un auto
                    System.out.println("Ingrese la marca del auto: ");
                    String marca = scanner.nextLine();

                    System.out.println("Ingrese el modelo del auto (deje en blanco si no desea especificar): ");
                    String modelo = scanner.nextLine();
                    if (modelo.isEmpty()) modelo = null;  // Si no se especifica, se asigna null

                    System.out.println("Ingrese el año del auto (deje en blanco si no desea especificar): ");
                    String anioStr = scanner.nextLine();
                    Integer anio = null;
                    if (!anioStr.isEmpty()) {
                        try {
                            anio = Integer.parseInt(anioStr);
                        } catch (NumberFormatException e) {
                            System.out.println("Año no válido. El año será asignado como 'No especificado'.");
                        }
                    }
                    // Crear el objeto Auto según los datos ingresados
                    if (anio != null) {
                        auto = new Auto(marca, modelo, anio);
                    } else if (modelo != null) {
                        auto = new Auto(marca, modelo);
                    } else {
                        auto = new Auto(marca);
                    }
                    break;
                case 2:
                    // Opción para imprimir los datos del auto
                    if (auto != null) {
                        System.out.println("****DATOS DEL AUTO****");
                        auto.imprimirDatos();
                    } else {
                        System.out.println("No se ha creado un auto aún.");
                    }
                    break;
                case 3:
                    // Opción para salir
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida, intente nuevamente.");
            }
        } while (opcion != 3);
        // // Crear objetos para probar los constructores
        // Auto auto1 = new Auto("Toyota", "Corolla", 2020);
        // Auto auto2 = new Auto("Ford", "Fiesta");
        // Auto auto3 = new Auto("Chevrolet");
        // Auto auto4 = new Auto();
        // // Mostrar los atributos de los autos creados
        // System.out.println("****DATOS AUTO 1****");
        // auto1.imprimirDatos();
        // System.out.println("****DATOS AUTO 2****");
        // auto2.imprimirDatos();
        // System.out.println("****DATOS AUTO 3****");
        // auto3.imprimirDatos();
        // System.out.println("****DATOS AUTO 4****");
        // auto4.imprimirDatos();
    }
}
