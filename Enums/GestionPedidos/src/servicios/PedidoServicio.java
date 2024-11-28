package servicios;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import entidades.Pedido;
import enums.EstadoPedido;

public class PedidoServicio {
    private List<Pedido> pedidos = new ArrayList<>();
    private int contadorPedidos = 1;

    // Crear un nuevo pedido
    public void crearPedido(String cliente, String[] listaDeProductos, EstadoPedido estado) {
        Pedido nuevoPedido = new Pedido(contadorPedidos++, cliente, listaDeProductos, estado);
        pedidos.add(nuevoPedido);
        System.out.println("Pedido creado: " + nuevoPedido);
    }

    // Actualizar el estado de un pedido
    public void actualizarEstadoPedido(int numeroDePedido, EstadoPedido nuevoEstado) {
        Pedido pedido = pedidos.stream()
                .filter(p -> p.getNumeroDePedido() == numeroDePedido)
                .findFirst()
                .orElse(null);
        if (pedido != null) {
            pedido.setEstadoDelPedido(nuevoEstado);
            System.out.println("Estado del pedido actualizado: " + pedido);
        } else {
            System.out.println("Pedido no encontrado.");
        }
    }

    // Buscar pedidos por estado
    public List<Pedido> buscarPedidosPorEstado(EstadoPedido estado) {
        return pedidos.stream()
                .filter(p -> p.getEstadoDelPedido() == estado)
                .collect(Collectors.toList());
    }

    // Obtener la lista completa de pedidos
    public List<Pedido> obtenerListaDePedidos() {
        return pedidos;
    }

    // Filtrar pedidos por cliente
    public List<Pedido> filtrarPedidosPorCliente(String cliente) {
        return pedidos.stream()
                .filter(p -> p.getCliente().equalsIgnoreCase(cliente))
                .collect(Collectors.toList());
    }
}
