package entidades;

import java.util.Arrays;
import enums.EstadoPedido;

public class Pedido {
    private int numeroDePedido;
    private String cliente;
    private String[] listaDeProductos;
    private EstadoPedido estadoDelPedido;

    // Constructor
    public Pedido(int numeroDePedido, String cliente, String[] listaDeProductos, EstadoPedido estadoDelPedido) {
        this.numeroDePedido = numeroDePedido;
        this.cliente = cliente;
        this.listaDeProductos = listaDeProductos;
        this.estadoDelPedido = estadoDelPedido;
    }

    // Getters y Setters
    public int getNumeroDePedido() {
        return numeroDePedido;
    }

    public String getCliente() {
        return cliente;
    }

    public String[] getListaDeProductos() {
        return listaDeProductos;
    }

    public EstadoPedido getEstadoDelPedido() {
        return estadoDelPedido;
    }

    public void setEstadoDelPedido(EstadoPedido estadoDelPedido) {
        this.estadoDelPedido = estadoDelPedido;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "numeroDePedido=" + numeroDePedido +
                ", cliente='" + cliente + '\'' +
                ", listaDeProductos=" + Arrays.toString(listaDeProductos) +
                ", estadoDelPedido=" + estadoDelPedido +
                '}';
    }
}
