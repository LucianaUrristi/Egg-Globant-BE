package GestionBiblioteca.modelo;

import java.time.LocalDate;
import java.util.Scanner;

import GestionBiblioteca.interfaces.Catalogable;

public class Revista extends ItemBiblioteca implements Catalogable {
    private Scanner sc = new Scanner(System.in);

    //Atributos
    private int nroEdicion;
    private int cantidadEjemplares;
    private String nombreRevista;
    private LocalDate fechaPrestada;
    private LocalDate fechaDevolucion;
    private static double costoPrestamo = 1.6;

    //Constructor vacio y con parametros
    public Revista() {
        this.fechaPrestada = LocalDate.now();
    }

    public Revista(int nroEdicion, int cantidadEjemplares, String nombreRevista) {
        this.nroEdicion = nroEdicion;
        this.cantidadEjemplares = cantidadEjemplares;
        this.nombreRevista = nombreRevista;
    }

    //Getters y Setters
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

    public String getNombreRevista() {
        return nombreRevista;
    }

    public void setNombreRevista(String nombreRevista) {
        this.nombreRevista = nombreRevista;
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


    //Métodos
    @Override
    public void prestar() {
        if (cantidadEjemplares > 0) {
            cantidadEjemplares--;
            System.out.println("Se presta la revista");
        } else {
            System.out.println("No hay ejemplares disponibles");
        }
    }

    @Override
    public void devolver() {
        cantidadEjemplares++;
        System.out.println("Se devuelve la revista");
    }

    @Override
    public double calcularMultas() {
        
        
        System.out.println("Se calcula la multa de la revista");
        System.out.print("Ingrese la fecha de devolución de la revista (AAAA-MM-DD): ");
        this.fechaDevolucion = LocalDate.parse(sc.nextLine());

        if (fechaDevolucion.isAfter(fechaPrestada)) {
            long dias = fechaPrestada.until(fechaDevolucion).getDays();
            return  (dias * costoPrestamo);
        
        } 
        return 0.0;
    }


    @Override
    public String obtenerInformacion() {
        return "Nombre de la revista: " + nombreRevista + "\n" +
                "Número de edición: " + nroEdicion + "\n" +
                "Cantidad de ejemplares: " + cantidadEjemplares + "\n" +
                "******************************";

    };
}
