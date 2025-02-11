package servicios;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import entidades.Casa;
import persistencia.ComentarioDAO;
import persistencia.CasaDAO;


public class CasaServicio {
    private ComentarioDAO comentarioDAO = new ComentarioDAO();
    private CasaDAO casaDAO = new CasaDAO();
    
    public void listarCasasDisponiblesAgosto2020() {
        try {
            List<Casa> casas = casaDAO.listarCasasDisponiblesAgosto2020();
            if (casas.isEmpty()) {
                System.out.println("No hay casas disponibles en Reino Unido para el periodo solicitado.");
            } else {
                System.out.println("Casas disponibles en Reino Unido del 1 al 31 de agosto de 2020:");
                for (Casa casa : casas) {
                    System.out.println("ID: " + casa.getId_casa() + ", Dirección: " + casa.getCiudad() +
                            ", Código Postal: " + casa.getCodigo_postal() + ", Precio: " + casa.getPrecio_habitacion());
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void listarCasasPorFechaYDias() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la fecha de inicio (YYYY-MM-DD): ");
        String fechaInicio = scanner.nextLine();
        System.out.print("Ingrese el número de días: ");
        int dias = scanner.nextInt();
        try {
            List<Casa> casas = casaDAO.listarCasasPorFechaYDias(fechaInicio, dias);
            if (casas.isEmpty()) {
                System.out.println("No hay casas disponibles para las fechas indicadas.");
            } else {
                System.out.println("Casas disponibles desde " + fechaInicio + " por " + dias + " días:");
                for (Casa casa : casas) {
                    System.out.println("ID: " + casa.getId_casa() + ", Dirección: " + casa.getCiudad() +
                            ", Código Postal: " + casa.getCodigo_postal() + ", Precio por habitación: "
                            + casa.getPrecio_habitacion());
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

    public void incrementarPrecioPorcentaje(double porcentaje) {
        try {
            // Mostrar precios antes del aumento
            System.out.println("Precios ANTES del aumento:");
            List<Casa> casasAntes = casaDAO.listarCasasReinoUnido();
            for (Casa casa : casasAntes) {
                System.out.println("ID: " + casa.getId_casa() +
                        ", Dirección: " + casa.getCalle() + " " + casa.getNumero() +
                        ", Ciudad: " + casa.getCiudad() +
                        ", Precio por día: " + casa.getPrecio_habitacion());
            }

            casaDAO.incrementarPrecioPorcentaje(porcentaje);
            System.out.println("Precios incrementados en un " + porcentaje + "%.");

            // Mostrar precios actualizados
            System.out.println("Casas con precios actualizados:");
            List<Casa> casasDespues = casaDAO.listarCasasReinoUnido();
            for (Casa casa : casasDespues) {
                System.out.println("ID: " + casa.getId_casa() +
                        ", Dirección: " + casa.getCalle() + " " + casa.getNumero() +
                        ", Ciudad: " + casa.getCiudad() +
                        ", Precio por día: " + casa.getPrecio_habitacion());
            }
        } catch (Exception e) {
            System.out.println("Error en el servicio: " + e.getMessage());
        }
    }

    public void contarCasasPorPais() {
        try {
            Map<String, Integer> casasPorPais = casaDAO.contarCasasPorPais();

            System.out.println("Número de casas por país:");
            for (Map.Entry<String, Integer> entry : casasPorPais.entrySet()) {
                System.out.println("País: " + entry.getKey() + ", Total de casas: " + entry.getValue());
            }
        } catch (Exception e) {
            System.out.println("Error al obtener el conteo de casas por país: " + e.getMessage());
        }
    }

    public void listarCasasLimpiasReinoUnido() {
        try {
            List<Casa> casasLimpias = comentarioDAO.listarCasasLimpiasReinoUnido();
            
            if (casasLimpias.isEmpty()) {
                System.out.println("No se encontraron casas limpias en Reino Unido.");
            } else {
                for (Casa casa : casasLimpias) {
                    System.out.println("ID Casa: " + casa.getId_casa() +
                                        ", Dirección: " + casa.getCalle() + " " + casa.getNumero() +
                                        ", Ciudad: " + casa.getCiudad());
                }
            }
        } catch (Exception e) {
            System.out.println("Error al listar casas limpias: " + e.getMessage());
        }
    }
}
