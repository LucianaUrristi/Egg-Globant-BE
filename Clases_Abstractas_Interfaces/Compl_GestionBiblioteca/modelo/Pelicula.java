package Compl_GestionBiblioteca.modelo;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import Compl_GestionBiblioteca.interfaces.Catalogable;

public class Pelicula extends ItemBiblioteca implements Catalogable {
    private String titulo;
    private String director;
    private int duracion; // Duración en minutos
    private LocalDate fechaDevolucion;
    private LocalDate fechaPrestamo;

    public Pelicula(String titulo, String director, int duracion, LocalDate fechaDevolucion) {
        this.titulo = titulo;
        this.director = director;
        this.duracion = duracion;
        this.fechaDevolucion = fechaDevolucion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    // Implementación de los métodos abstractos
    @Override
    public void prestar() {
        // Implementación específica para prestar una pelicula
        System.out.println("Película prestada exitosamente.");
    }

    @Override
    public void devolver() {
        // Implementación específica para devolver una pelicula
        System.out.println("Película devuelta exitosamente.");
    }

    @Override
    public double calcularMultas(LocalDate fechaRealDevolucion) {
        // Implementación específica para calcular multas de Revistas
        if (fechaRealDevolucion.isAfter(fechaDevolucion)) {
            long diasRetraso = ChronoUnit.DAYS.between(fechaDevolucion, fechaRealDevolucion);
            double multa = diasRetraso * 2.0; // Multa de 1.5 unidades por día
            System.out.println("Multa: $" + multa + "\n");
            return multa;
        }
        return 0.0; // Por defecto, no hay multa
    }

    @Override
    public String obtenerInformacion() {
        return "Título: " + titulo + "\n" +
                "Director: " + director + "\n" +
                "Duración: " + duracion + " minutos." + "\n" +
                "Fecha de devolución: " + fechaDevolucion + "\n" +
                "******************************";
    }

    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(LocalDate fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }
}
