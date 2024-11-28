import java.util.Scanner;

import entidades.EstacionDelAnio;
import enums.Mes;
import enums.Estacion;

public class Menu {
    public static void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\nMenú de Opciones:");
            System.out.println("1. Mostrar estaciones y sus meses");
            System.out.println("2. Determinar la estación de un mes");
            System.out.println("0. Salir");
            System.out.print("Selecciona una opción: ");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    EstacionDelAnio.imprimirEstaciones();
                    break;
                case 2:
                    System.out.print("Ingresa el número del mes (1-12): ");
                    int numeroMes = scanner.nextInt();

                    if (numeroMes < 1 || numeroMes > 12) {
                        System.out.println("Mes inválido. Por favor, ingresa un número entre 1 y 12.");
                    } else {
                        Mes mes = Mes.obtenerMesPorNumero(numeroMes);
                        Estacion estacion = EstacionDelAnio.obtenerEstacion(mes);
                        System.out.println("El mes " + mes + " pertenece a la estación: " + estacion);
                    }
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, selecciona una opción válida.");
            }
        } while (opcion != 0);

        scanner.close();
    }
}