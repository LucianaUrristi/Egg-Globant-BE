import java.util.Scanner;
import servicios.FamiliaServicio;
import servicios.CasaServicio;
import servicios.EstanciaServicio;

public class Menu {

    private final Scanner scanner = new Scanner(System.in);
    private final FamiliaServicio familiaServicio = new FamiliaServicio();
    private final CasaServicio casaServicio = new CasaServicio();
    private final EstanciaServicio estanciaServicio = new EstanciaServicio();

    public void iniciarMenu() {
        int opcion;
        do {
            mostrarOpciones();
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            ejecutarOpcion(opcion);
        } while (opcion != 0);
    }

    private void mostrarOpciones() {
        System.out.println("\n--- Menú de Funcionalidades ---");
        System.out.println("1. Listar familias con al menos 3 hijos y edad máxima inferior a 10 años.");
        System.out.println("2. Listar casas disponibles en Reino Unido entre 1/08/2020 y 31/08/2020.");
        System.out.println("3. Listar familias con email de Hotmail.");
        System.out.println("4. Listar casas disponibles desde una fecha y número de días específicos.");
        System.out.println("5. Listar clientes con descripción de la casa donde se alojaron.");
        System.out.println("6. Listar estancias reservadas por clientes con información de la casa.");
        System.out.println("7. Incrementar precio diario de casas del Reino Unido en 5%.");
        System.out.println("8. Obtener número de casas por país.");
        System.out.println("9. Listar casas del Reino Unido con comentarios que mencionan 'limpias'.");
        System.out.println("10. Insertar una nueva estancia.");
        System.out.println("0. Salir.");
    }

    private void ejecutarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                familiaServicio.listarFamiliasConHijosYEdadMaxima();
                break;
            case 2:
                casaServicio.listarCasasDisponiblesAgosto2020();
                break;
            case 3:
                familiaServicio.listarFamiliasConEmailHotmail();
                break;
            case 4:
                casaServicio.listarCasasPorFechaYDias();
                break;
            case 5:
                estanciaServicio.listarClientesConEstancia();
                break;
            case 6:
                estanciaServicio.listarEstanciasConClientesYCasas();
                break;
            case 7:
                casaServicio.incrementarPrecioPorcentaje(5);
                break;
            case 8:
                casaServicio.contarCasasPorPais();
                break;
            case 9:
                casaServicio.listarCasasLimpiasReinoUnido();
                break;
            // case 10:
            //     estanciaServicio.agregarEstancia();
            //     break;
            case 0:
                System.out.println("Saliendo del sistema...");
                break;
            default:
                System.out.println("Opción no válida. Intente nuevamente.");
        }
    }
}
