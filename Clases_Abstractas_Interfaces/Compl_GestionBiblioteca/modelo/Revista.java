package Compl_GestionBiblioteca.modelo;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import GestionBiblioteca.interfaces.Catalogable;

public class Revista extends ItemBiblioteca implements Catalogable {
    private String nombreRevista;
    private int nroEdicion;
    private int cantidadEjemplares;
    private LocalDate fechaDevolucion;
    private LocalDate fechaPrestamo; // Nueva variable para registrar la fecha de préstamo

    public Revista() {
    }

    public Revista(String nombreRevista, int nroEdicion, int cantidadEjemplares, LocalDate fechaDevolucion) {
        this.nombreRevista = nombreRevista;
        this.nroEdicion = nroEdicion;
        this.cantidadEjemplares = cantidadEjemplares;
        this.fechaDevolucion = fechaDevolucion;
    }

    public String getNombreRevista() {
        return nombreRevista;
    }

    public void setNombreRevista(String nombreRevista) {
        this.nombreRevista = nombreRevista;
    }

    public int getNroEdicion() {
        return nroEdicion;
    }

    public void setNroEdicion(int nroEdicion) {
        this.nroEdicion = nroEdicion;
    }

    public int getCantidadEjemplares() {
        return cantidadEjemplares;
    }

    public void setCantidadEjemplares(int cantidadEjemplares) {

        this.cantidadEjemplares = cantidadEjemplares;
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(LocalDate fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    // Implementación de los métodos abstractos
    @Override
    public void prestar() {
        // Verificar si hay ejemplares disponibles para prestar
        if (cantidadEjemplares > 0) {
            cantidadEjemplares--;
            fechaPrestamo = LocalDate.now(); // Registrar la fecha del préstamo
            System.out.println("Revista prestada exitosamente.");
        } else {
            System.out.println("No hay ejemplares disponibles para prestar.");
        }
    }

    @Override
    public void devolver() {
        // Aumentar en 1 la cantidad de ejemplares
        cantidadEjemplares++;

        System.out.println("La revista " + this.nombreRevista.toUpperCase() + " se ha devuelto correctamente.");
    }

    @Override
    public double calcularMultas(LocalDate fechaRealDevolucion) {
        // Implementación específica para calcular multas de Revistas
        if (fechaRealDevolucion.isAfter(fechaDevolucion)) {
            long diasRetraso = ChronoUnit.DAYS.between(fechaDevolucion, fechaRealDevolucion);
            double multa = diasRetraso * 1.5; // Multa de 1.5 unidades por día
            System.out.println("Multa: $" + multa + "\n");
            return multa;
        }
        return 0.0; // Por defecto, no hay multa
    }

    // Implementación de la interfaz Catalogable
    @Override
    public String obtenerInformacion() {
        return "Nombre de la revista: " + nombreRevista + "\n" +
                "Número de edición: " + nroEdicion + "\n" +
                "Cantidad de ejemplares: " + cantidadEjemplares + "\n" +
                "Fecha de devolución: " + fechaDevolucion + "\n" +
                "Multa: " + calcularMultas(fechaDevolucion) + "\n" +
                "******************************";

    };
}
