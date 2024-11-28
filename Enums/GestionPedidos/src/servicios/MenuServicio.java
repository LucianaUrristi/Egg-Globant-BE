package servicios;

import java.util.List;
import java.util.Scanner;

import entidades.Pedido;
import enums.EstadoPedido;

public class MenuServicio {
    private PedidoServicio pedidoServicio = new PedidoServicio();

    public void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\nMenú de Opciones:");
            System.out.println("1. Crear un nuevo pedido");
            System.out.println("2. Actualizar el estado de un pedido");
            System.out.println("3. Buscar pedidos por estado");
            System.out.println("4. Mostrar la lista de pedidos");
            System.out.println("5. Filtrar pedidos por cliente");
            System.out.println("0. Salir");
            System.out.print("Selecciona una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea

            switch (opcion) {
                case 1:
                    crearNuevoPedido(scanner);
                    break;
                case 2:
                    actualizarEstadoDePedido(scanner);
                    break;
                case 3:
                    buscarPedidosPorEstado(scanner);
                    break;
                case 4:
                    mostrarListaDePedidos();
                    break;
                case 5:
                    filtrarPedidosPorCliente(scanner);
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida. Intenta nuevamente.");
            }
        } while (opcion != 0);

        scanner.close();
    }

    private void crearNuevoPedido(Scanner scanner) {
        System.out.print("Ingrese el nombre del cliente: ");
        String cliente = scanner.nextLine();
        System.out.print("Ingrese los productos separados por comas: ");
        String[] productos = scanner.nextLine().split(",");
        System.out.println("Seleccione el estado del pedido: 1. PENDIENTE 2. ENVIADO 3. ENTREGADO");
        int estadoSeleccionado = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea
        EstadoPedido estado = EstadoPedido.values()[estadoSeleccionado - 1];
        pedidoServicio.crearPedido(cliente, productos, estado);
    }

    private void actualizarEstadoDePedido(Scanner scanner) {
        System.out.print("Ingrese el número del pedido: ");
        int numeroDePedido = scanner.nextInt();
        System.out.println("Seleccione el nuevo estado: 1. PENDIENTE 2. ENVIADO 3. ENTREGADO");
        int estadoSeleccionado = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea
        EstadoPedido nuevoEstado = EstadoPedido.values()[estadoSeleccionado - 1];
        pedidoServicio.actualizarEstadoPedido(numeroDePedido, nuevoEstado);
    }

    private void buscarPedidosPorEstado(Scanner scanner) {
        System.out.println("Seleccione el estado: 1. PENDIENTE 2. ENVIADO 3. ENTREGADO");
        int estadoSeleccionado = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea
        EstadoPedido estado = EstadoPedido.values()[estadoSeleccionado - 1];
        List<Pedido> pedidos = pedidoServicio.buscarPedidosPorEstado(estado);
        pedidos.forEach(System.out::println);
    }

    private void mostrarListaDePedidos() {
        List<Pedido> pedidos = pedidoServicio.obtenerListaDePedidos();
        pedidos.forEach(System.out::println);
    }

    private void filtrarPedidosPorCliente(Scanner scanner) {
        System.out.print("Ingrese el nombre del cliente: ");
        String cliente = scanner.nextLine();
        List<Pedido> pedidos = pedidoServicio.filtrarPedidosPorCliente(cliente);
        pedidos.forEach(System.out::println);
    }
}
