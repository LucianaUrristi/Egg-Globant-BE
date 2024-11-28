package POOAvanzado_Libros.entidades;

import java.util.ArrayList;
import java.util.List;

public class Persona {
    private String nombre;
    private String apellido;
    private List<Libro> librosPrestados;

    // Constructor
    public Persona(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.librosPrestados = new ArrayList<>();
    }

    // Método para agregar un libro a la lista de préstamos
    public void prestarLibro(Libro libro) {
        librosPrestados.add(libro);
    }

    // Método para devolver un libro
    public void devolverLibro(Libro libro) {
        librosPrestados.remove(libro);
    }

    // Mostrar libros prestados
    public void mostrarLibrosPrestados() {
        if (librosPrestados.isEmpty()) {
            System.out.println(nombre + " " + apellido + " no tiene libros prestados.");
        } else {
            System.out.println("Libros prestados por " + nombre + " " + apellido + ":");
            for (Libro libro : librosPrestados) {
                System.out.println("- " + libro.getTitulo());
            }
        }
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }
}
