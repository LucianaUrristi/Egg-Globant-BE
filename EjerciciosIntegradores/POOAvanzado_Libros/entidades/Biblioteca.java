package POOAvanzado_Libros.entidades;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<Libro> catalogo;

    // Constructor
    public Biblioteca() {
        this.catalogo = new ArrayList<>();
    }

    // Método para agregar un libro al catálogo
    public void agregarLibro(Libro libro) {
        catalogo.add(libro);
        System.out.println("Libro agregado: " + libro.getTitulo());
    }

    // Método para mostrar el catálogo
    public void mostrarCatalogo() {
        if (catalogo.isEmpty()) {
            System.out.println("El catálogo está vacío.");
        } else {
            System.out.println("Catálogo de Libros:");
            for (Libro libro : catalogo) {
                libro.mostrarInformacion();
            }
        }
    }

    // Método para prestar un libro
    public boolean prestarLibro(String titulo, Persona persona) {
        for (Libro libro : catalogo) {
            if (libro.getTitulo().equalsIgnoreCase(titulo) && !libro.isPrestado()) {
                libro.prestarLibro();
                persona.prestarLibro(libro);
                System.out.println("Libro prestado: " + titulo + " a " + persona.getNombre());
                return true;
            }
        }
        System.out.println("El libro no está disponible o no existe.");
        return false;
    }

    // Método para devolver un libro
    public boolean devolverLibro(String titulo, Persona persona) {
        for (Libro libro : catalogo) {
            if (libro.getTitulo().equalsIgnoreCase(titulo) && libro.isPrestado()) {
                libro.devolverLibro();
                persona.devolverLibro(libro);
                System.out.println("Libro devuelto: " + titulo + " por " + persona.getNombre());
                return true;
            }
        }
        System.out.println("El libro no está prestado o no existe.");
        return false;
    }
}
