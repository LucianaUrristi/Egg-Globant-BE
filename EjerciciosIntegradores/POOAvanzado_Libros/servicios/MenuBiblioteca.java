package POOAvanzado_Libros.servicios;
import POOAvanzado_Libros.entidades.Biblioteca;
import POOAvanzado_Libros.entidades.Libro;
import POOAvanzado_Libros.entidades.Persona;

import java.util.Scanner;


public class MenuBiblioteca {
    
    private Biblioteca biblioteca;
    private Persona usuario;

    // Constructor
    public MenuBiblioteca() {
        this.biblioteca = new Biblioteca();
        this.usuario = new Persona("Juan", "Pérez"); // Usuario predefinido
    }

    // Método para mostrar el menú principal
    public void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\nMenú Biblioteca:");
            System.out.println("1. Agregar un libro al catálogo");
            System.out.println("2. Mostrar el catálogo de libros");
            System.out.println("3. Prestar un libro");
            System.out.println("4. Devolver un libro");
            System.out.println("5. Mostrar libros prestados por el usuario");
            System.out.println("0. Salir");
            System.out.print("Selecciona una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea

            switch (opcion) {
                case 1:
                    agregarLibro(scanner);
                    break;
                case 2:
                    biblioteca.mostrarCatalogo();
                    break;
                case 3:
                    prestarLibro(scanner);
                    break;
                case 4:
                    devolverLibro(scanner);
                    break;
                case 5:
                    usuario.mostrarLibrosPrestados();
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida. Intenta nuevamente.");
            }
        } while (opcion != 0);

        scanner.close();
    }

    // Métodos auxiliares
    private void agregarLibro(Scanner scanner) {
        System.out.print("Ingrese el título del libro: ");
        String titulo = scanner.nextLine();

        System.out.print("Ingrese el autor del libro: ");
        String autor = scanner.nextLine();

        System.out.print("Ingrese el número de páginas: ");
        int numeroDePaginas = scanner.nextInt();
        scanner.nextLine();

        Libro libro = new Libro(titulo, autor, numeroDePaginas);
        biblioteca.agregarLibro(libro);
    }

    private void prestarLibro(Scanner scanner) {
        System.out.print("Ingrese el título del libro que desea prestar: ");
        String titulo = scanner.nextLine();
        biblioteca.prestarLibro(titulo, usuario);
    }

    private void devolverLibro(Scanner scanner) {
        System.out.print("Ingrese el título del libro que desea devolver: ");
        String titulo = scanner.nextLine();
        biblioteca.devolverLibro(titulo, usuario);
    }
}
