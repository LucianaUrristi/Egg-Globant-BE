package servicios;

import java.util.List;

import entidades.Casa;
import entidades.Cliente;
import entidades.Estancia;
import persistencia.EstanciaDAO;
// import java.util.Scanner;
// import java.time.LocalDate;

public class EstanciaServicio {
    private EstanciaDAO estanciaDAO = new EstanciaDAO();

    // Método para listar estancias con información del cliente
    public void listarClientesConEstancia() {
        try {
            List<Estancia> estancias = estanciaDAO.listarEstanciasConClientes();
            if (estancias.isEmpty()) {
                System.out.println("No hay registros.");
            } else {
                System.out.println("Registros disponibles:");
                for (Estancia estancia : estancias) {
                    Casa casa = estancia.getCasa(); // Obtener la casa de la estancia
                    Cliente cliente = estancia.getCliente(); // Obtener el cliente

                    System.out.println("Cliente: " + cliente.getNombre());
                    System.out.println("Casa ID: " + casa.getId_casa() +
                            ", Dirección: " + casa.getCalle() + " " + casa.getNumero() +
                            ", Ciudad: " + casa.getCiudad() +
                            ", Código Postal: " + casa.getCodigo_postal() +
                            ", Precio por día: $" + casa.getPrecio_habitacion());
                    System.out.println("Fechas: Desde " + estancia.getFechaLlegada() +
                            " hasta " + estancia.getFechaSalida());
                    System.out.println("---------------------------------");
                }
            }
        } catch (Exception e) {
            System.out.println("Error al obtener estancias: " + e.getMessage());
        }
    }

    public void listarEstanciasConClientes() {
        try {
            List<Estancia> estancias = estanciaDAO.listarEstanciasConClientes();
            if (estancias.isEmpty()) {
                System.out.println("No hay estancias registradas.");
            } else {
                System.out.println("Estancias reservadas por clientes:");
                for (Estancia estancia : estancias) {
                    // Obtener Cliente y Casa desde la estancia
                    Cliente cliente = estancia.getCliente();
                    Casa casa = estancia.getCasa();

                    // Mostrar información del cliente
                    System.out.println("Cliente: " + cliente.getNombre());
                    System.out.println("Ubicación: " + cliente.getCiudad() + ", " + cliente.getPais());

                    // Mostrar información de la casa reservada
                    System.out.println("Casa ID: " + casa.getId_casa() +
                            ", Dirección: " + casa.getCalle() + " " + casa.getNumero() +
                            ", Ciudad: " + casa.getCiudad() +
                            ", País: " + casa.getPais() +
                            ", Código Postal: " + casa.getCodigo_postal() +
                            ", Precio por día: $" + casa.getPrecio_habitacion());

                    // Mostrar fechas de la estancia
                    System.out.println("Fechas: Desde " + estancia.getFechaLlegada() +
                            " hasta " + estancia.getFechaSalida());
                    System.out.println("---------------------------------");
                }
            }
        } catch (Exception e) {
            System.out.println("Error al obtener estancias: " + e.getMessage());
        }
    }

    public void listarEstanciasConClientesYCasas() {
        try {
            List<Estancia> estancias = estanciaDAO.listarEstanciasConClientesYCasas();

            if (estancias.isEmpty()) {
                System.out.println("No hay estancias registradas.");
            } else {
                System.out.println("Listado de estancias reservadas por clientes:");
                for (Estancia estancia : estancias) {
                    Cliente cliente = estancia.getCliente();
                    Casa casa = estancia.getCasa();

                    // Imprimir datos del cliente
                    System.out.println("Cliente: " + cliente.getNombre());
                    System.out.println("Ubicación del Cliente: " + cliente.getCiudad() + ", " + cliente.getPais());

                    // Imprimir datos de la casa reservada
                    System.out.println("Casa ID: " + casa.getId_casa());
                    System.out.println("Dirección: " + casa.getCalle() + " " + casa.getNumero());
                    System.out.println("Ciudad: " + casa.getCiudad() + ", País: " + casa.getPais());
                    System.out.println("Código Postal: " + casa.getCodigo_postal());
                    System.out.println("Precio por habitación: $" + casa.getPrecio_habitacion());

                    // Imprimir fechas de la estancia
                    System.out.println("Fechas: Desde " + estancia.getFechaLlegada() +
                            " hasta " + estancia.getFechaSalida());
                    System.out.println("-----------------------------------");
                }
            }
        } catch (Exception e) {
            System.out.println("Error al listar estancias: " + e.getMessage());
        }
    }

    

}
