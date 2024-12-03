import Servicios.TareaServicio;

import java.util.Scanner;

public class Menu {
    private TareaServicio tareaServicio = new TareaServicio();
    private Scanner scanner = new Scanner(System.in);

    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n--- Gestión de Tareas ---");
            System.out.println("1. Agregar tarea");
            System.out.println("2. Marcar tarea como completada");
            System.out.println("3. Eliminar tarea");
            System.out.println("4. Mostrar tareas pendientes");
            System.out.println("5. Mostrar tareas completadas");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1 -> agregarTarea();
                case 2 -> marcarTareaComoCompletada();
                case 3 -> eliminarTarea();
                case 4 -> tareaServicio.mostrarTareasPendientes();
                case 5 -> tareaServicio.mostrarTareasCompletadas();
                case 6 -> System.out.println("Saliendo del programa...");
                default -> System.out.println("Opción inválida, intente de nuevo.");
            }
        } while (opcion != 6);
    }

    private void agregarTarea() {
        System.out.print("Ingrese la descripción de la tarea: ");
        String descripcion = scanner.nextLine();
        tareaServicio.agregarTarea(descripcion);
    }

    private void marcarTareaComoCompletada() {
        System.out.print("Ingrese el ID de la tarea a completar: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        tareaServicio.marcarTareaComoCompletada(id);
    }

    private void eliminarTarea() {
        System.out.print("Ingrese el ID de la tarea a eliminar: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        tareaServicio.eliminarTarea(id);
    }
}

/*
 * Gestión de tareas pendientes

Desarrolla un programa en Java que permita gestionar una lista de tareas pendientes. 
Cada tarea estará representada por su descripción y su estado (pendiente o completada).
El programa deberá permitir al usuario agregar nuevas tareas, marcar tareas como completadas, 
eliminar tareas y mostrar la lista completa de tareas pendientes o completadas.

Pasos a seguir:

Inicializa un ArrayList para almacenar objetos de tipo Tarea, donde Tarea es una clase que 
contiene atributos para la descripción y el estado de la tarea. Además, cada tarea debe tener 
un atributo idTarea que se autogenera de forma incremental, es decir, incrementando en 1 cada 
vez que se crea una nueva tarea, garantizando así la unicidad de identificadores para cada tarea
Implementa un menú que permita al usuario seleccionar entre las siguientes opciones: agregar 
tarea, marcar tarea como completada, eliminar tarea y mostrar lista de tareas pendientes.
Cada vez que el usuario elija agregar una tarea, solicita por teclado la descripción de la 
tarea y añádela al ArrayList con el estado "pendiente" (por defecto).
Para marcar una tarea como completada, solicita por teclado el número de la tarea a completar 
y cambia su estado a "completada".
Para eliminar una tarea, solicita por teclado el número de la tarea a eliminar y elimina el 
objeto correspondiente del ArrayList.
Implementa una función para mostrar la lista completa de tareas pendientes, mostrando tanto 
la descripción como el idTarea.
Implementa una función para mostrar la lista completa de tareas completadas, mostrando tanto 
la descripción como el idTarea.

 */