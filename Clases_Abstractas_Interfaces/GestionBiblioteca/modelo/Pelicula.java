package GestionBiblioteca.modelo;
import java.time.LocalDate;
import java.util.Scanner;

import GestionBiblioteca.interfaces.Catalogable;

public class Pelicula extends ItemBiblioteca implements Catalogable {
    // Implementación de los métodos abstractos
    private Scanner sc = new Scanner(System.in);

    // Atributos
    private String nombrePelicula;
    private String genero;
    private int cantidadEjemplares;
    private LocalDate fechaPrestada;
    private LocalDate fechaDevolucion;
    private static double costoPrestamo = 2.0; // Costo por día de retraso de película

    // Constructor vacío y con parámetros
    public Pelicula() {
        this.fechaPrestada = LocalDate.now();
    }

    public Pelicula(String nombrePelicula, String genero, int cantidadEjemplares) {
        this.nombrePelicula = nombrePelicula;
        this.genero = genero;
        this.cantidadEjemplares = cantidadEjemplares;
    }

    // Getters y Setters
    public String getNombrePelicula() {
        return nombrePelicula;
    }

    public void setNombrePelicula(String nombrePelicula) {
        this.nombrePelicula = nombrePelicula;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getCantidadEjemplares() {
        return cantidadEjemplares;
    }

    public void setCantidadEjemplares(int cantidadEjemplares) {
        this.cantidadEjemplares = cantidadEjemplares;
    }

    public LocalDate getFechaPrestada() {
        return fechaPrestada;
    }

    public void setFechaPrestada(LocalDate fechaPrestada) {
        this.fechaPrestada = fechaPrestada;
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    // Métodos
    @Override
    public void prestar() {
        if (cantidadEjemplares > 0) {
            cantidadEjemplares--;
            System.out.println("Se presta la película: " + nombrePelicula);
        } else {
            System.out.println("No hay ejemplares disponibles para esta película.");
        }
    }

    @Override
    public void devolver() {
        cantidadEjemplares++;
        System.out.println("Se devuelve la película: " + nombrePelicula);
    }

    @Override
    public double calcularMultas() {
        System.out.println("Calculando multa para la película...");
        System.out.print("Ingrese la fecha de devolución de la película (AAAA-MM-DD): ");
        this.fechaDevolucion = LocalDate.parse(sc.nextLine());

        if (fechaDevolucion.isAfter(fechaPrestada)) {
            long diasRetraso = fechaPrestada.until(fechaDevolucion).getDays();
            return diasRetraso * costoPrestamo;
        }

        return 0.0;
    }

    @Override
    public String obtenerInformacion() {
        return  "Nombre de la película: " + nombrePelicula + "\n" +
                "Género: " + genero + "\n" +
                "Cantidad de ejemplares disponibles: " + cantidadEjemplares + "\n" +
                "******************************";
    }
}
