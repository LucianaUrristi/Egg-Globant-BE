package  Compl_GestionBiblioteca.modelo;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import  Compl_GestionBiblioteca.interfaces.Catalogable;

public class Libro extends ItemBiblioteca implements Catalogable {
    private String titulo;
    private String autor;
    private LocalDate fechaDevolucion;
    private LocalDate fechaPrestamo;
    
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
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
        // Implementación específica para prestar un libro
    }

    @Override
    public void devolver() {
        // Implementación específica para devolver un libro
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
                "Autor: " + autor + "\n" +
                "Fecha de devolución: " + fechaDevolucion + "\n" +
                "******************************";
    };
}