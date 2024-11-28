package POOAvanzado_Libros;
import POOAvanzado_Libros.servicios.MenuBiblioteca;

public class Main {
    public static void main(String[] args) {
        
        MenuBiblioteca menuBiblioteca = new MenuBiblioteca();
        menuBiblioteca.mostrarMenu();
    }
}
/*
 * Actividad: Desarrollo funcionalidades - Primera Parte 
Debes ampliar el sistema para poder almacenar libros dentro de la biblioteca. Para esto deberás:

Agregar los atributos “titulo”, “autor” y “numeroDePaginas” a la clase “Libro”. Además, implementa 
un método “mostrarInformación()” que muestre la información del libro en consola. En este caso, solo 
hay 1  ejemplar por título, por lo que no debe existir un atributo que controle la cantidad de ejemplares. 

Crea la clase “Biblioteca” que contenga un arreglo de objetos “Libro” para mantener un catálogo de 
libros disponibles en la biblioteca. La biblioteca también debe tener un método para agregar libros 
al catálogo.

Crear una instancia de la clase Biblioteca y agregar varios libros al catálogo 


Implementa un menú por consola que permite al usuario agregar libros a la biblioteca y mostrar la 
información de los libros en el catálogo.
 */