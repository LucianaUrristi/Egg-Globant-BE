import Servicios.EstudianteService;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        

        EstudianteService estudianteService = new EstudianteService();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- Menú de opciones ---");
            System.out.println("1. Agregar estudiante");
            System.out.println("2. Eliminar estudiante");
            System.out.println("3. Mostrar lista de estudiantes");
            System.out.println("4. Buscar estudiante por documento");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    estudianteService.agregarEstudiante();
                    break;
                case 2:
                    estudianteService.eliminarEstudiante();
                    break;
                case 3:
                    estudianteService.mostrarEstudiantes();
                    break;
                case 4:
                    estudianteService.buscarEstudiantePorDocumento();
                    break;
                case 5:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 5);
    }
}

/*
    Desarrolla un programa en Java que permita gestionar un registro de
    estudiantes. Cada estudiante estará representado
    por su nombre y su edad. El programa deberá permitir al usuario agregar
    nuevos estudiantes al registro, eliminar estudiantes
    existentes y mostrar la lista completa de estudiantes registrados. Además, se
    deberá implementar una función para buscar un
    estudiante por su nombre.
    Pasos a seguir:
    Inicializa un ArrayList para almacenar objetos de tipo Estudiante, donde
    Estudiante es una clase que contiene los atributos:
    documento de identidad (del tipo String), nombre (del tipo String) y la edad
    (del tipo Integer).
    Implementa un menú que permita al usuario seleccionar entre las siguientes
    opciones: agregar estudiante, eliminar estudiante,
    mostrar lista de estudiantes y buscar estudiante por nombre.
    Cada vez que el usuario elija agregar un estudiante, solicita por teclado el
    documento, el nombre y la edad del estudiante
    y añádelo al ArrayList.
    Para eliminar un estudiante, solicita por teclado el documento del estudiante
    a eliminar y elimina el objeto correspondiente del ArrayList.
    Implementa una función para mostrar la lista completa de estudiantes
    registrados, mostrando todos los datos de cada estudiante.
    Finalmente, implementa una función para buscar un estudiante por su
    documento. Si se encuentra, muestra su nombre y edad;
    de lo contrario, muestra un mensaje indicando que el estudiante no está
    registrado.
*/