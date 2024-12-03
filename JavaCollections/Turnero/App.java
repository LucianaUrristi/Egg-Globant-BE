import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ArrayList<Integer> turnos = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int ultimoTurnoEmitido = 0;
        int opcion;

        do {
            System.out.println("\n--- Sistema de Turnos ---");
            System.out.println("1. Emitir turno");
            System.out.println("2. Atender siguiente turno");
            System.out.println("3. Realizar sorteo");
            System.out.println("4. Mostrar turnos pendientes");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    emitirTurno(turnos, ++ultimoTurnoEmitido);
                    break;
                case 2:
                    atenderSiguienteTurno(turnos);
                    break;
                case 3:
                    realizarSorteo(turnos, random);
                    break;
                case 4:
                    mostrarTurnosPendientes(turnos);
                    break;
                case 5:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción inválida, intente de nuevo.");
            }
        } while (opcion != 5);

        scanner.close();
    }

    // Emitir un nuevo turno
    private static void emitirTurno(ArrayList<Integer> turnos, int nuevoTurno) {
        turnos.add(nuevoTurno);
        System.out.println("Turno emitido: " + nuevoTurno);
    }

    // Atender el siguiente turno (el primero en la lista)
    private static void atenderSiguienteTurno(ArrayList<Integer> turnos) {
        if (!turnos.isEmpty()) {
            int turnoAtendido = turnos.remove(0);
            System.out.println("Atendiendo al turno: " + turnoAtendido);
        } else {
            System.out.println("No hay turnos pendientes.");
        }
    }

    // Realizar un sorteo y atender un turno al azar
    private static void realizarSorteo(ArrayList<Integer> turnos, Random random) {
        if (!turnos.isEmpty()) {
            int indiceAleatorio = random.nextInt(turnos.size());
            int turnoSorteado = turnos.get(indiceAleatorio);
            System.out.println("Turno sorteado: " + turnoSorteado);
            turnos.remove(indiceAleatorio);
        } else {
            System.out.println("No hay turnos disponibles para sortear.");
        }
    }

    // Mostrar la lista de turnos pendientes
    private static void mostrarTurnosPendientes(ArrayList<Integer> turnos) {
        if (!turnos.isEmpty()) {
            System.out.println("\nTurnos pendientes: " + turnos);
        } else {
            System.out.println("No hay turnos pendientes.");
        }
    }
}

/*
 * Actividad: Turnero
 * Te han encomendado desarrollar un sistema de asignación de turnos para un
 * servicio al cliente en Java.
 * 
 * El procedimiento es el siguiente: los clientes obtienen un número de turno al
 * llegar y se colocan en una lista en el orden en que llegaron. Además del
 * servicio habitual, donde se atiende al cliente que ha estado esperando por
 * más tiempo, periódicamente se realiza un sorteo. En este sorteo, se
 * selecciona un número aleatorio y el cliente con ese número es atendido de
 * inmediato.
 * 
 * Para lograr esto, necesitas:
 * 
 * Guardar una lista de números de turno en el orden en que fueron emitidos.
 * 
 * Buscar eficientemente un número de turno específico en la lista cuando se
 * selecciona en el sorteo. Para buscar eficientemente un número de turno
 * específico en la lista cuando se selecciona en el sorteo, debes tener en
 * cuenta cómo manejar la situación cuando un número ha sido sorteado. En este
 * caso, es importante considerar qué sucede con su posición inicial en la
 * lista. ¿Los datos se mueven o permanecen en su lugar?
 * 
 * 
 * Implementa esta funcionalidad utilizando un ArrayList. Este tipo de lista
 * permite mantener los elementos en el orden de inserción y realizar búsquedas
 * eficientes por índice cuando se realiza el sorteo.
 */