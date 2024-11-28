package GestionBiblioteca;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import GestionBiblioteca.modelo.Revista;

public class Application {
    
    private static ArrayList<Revista> revistas;

    public static void main(String[] args) {
        actividad();
    }

    // Metodo para llenar el arraylist de revistas
    public static void llenarRevistas() {
        revistas = new ArrayList<>();
        revistas.add(new Revista(1, 10, "Revista 1"));
        revistas.add(new Revista(2, 10, "Revista 2"));
        revistas.add(new Revista(3, 10, "Revista 3"));
        revistas.add(new Revista(4, 10, "Revista 4"));
        revistas.add(new Revista(5, 10, "Revista 5"));
        revistas.add(new Revista(6, 10, "Revista 6"));
    }

    public static void actividad() {
        llenarRevistas();

        Scanner sc = new Scanner(System.in);
        int opcion;
        do {

            // Mostrar menu
            mostrarMenu();
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    mostrarRevistas();
                    System.out.print("Ingrese el numero de la revista que desea prestar: ");
                    int numRevista = sc.nextInt();
                    revistas.get(numRevista - 1).prestar();

                    System.out.print("Ingrese la fecha Hasta que fecha puede ser entregada: ");
                    revistas.get(numRevista - 1).setFechaPrestada(LocalDate.parse(sc.next()));
                    break;
                case 2:
                    mostrarRevistas();
                    System.out.print("Ingrese el numero de la revista que desea devolver: ");
                    int numRevistaDev = sc.nextInt();
                    revistas.get(numRevistaDev - 1).devolver();

                    double multa = revistas.get(numRevistaDev - 1).calcularMultas();
                    if (multa > 0) {
                        System.out.println("La multa es de: " + multa);
                    } 
                    System.out.println("La revista se ha devuelto correctamente");
                    break;
                case 3:
                    mostrarRevistas();
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        } while (opcion != 4);
        sc.close();
    }

    // Metodo para mostrar solo el menu de opciones
    public static void mostrarMenu() {
        System.out.println("-------------------------------------------------");
        System.out.println("1. Prestar revista");
        System.out.println("2. Devolver revista");
        System.out.println("3. Mostrar revistas");
        System.out.println("4. Salir");
        System.out.print("Ingrese una opcion: ");
    }

    // Mostrar revistas
    public static void mostrarRevistas() {
        int cont = 1;
        for (Revista revista : revistas) {

            System.out.println(cont + ".- " + revista.obtenerInformacion());
            cont++;
        }
        System.out.println("-------------------------------------------------");
    }
}

/*
 * Actividad: Gestión de biblioteca
En esta actividad, se requiere el diseño de un sistema de gestión de biblioteca que emplee clases abstractas e interfaces para representar 
libros, revistas y películas. Para lograrlo, sigue estos pasos:
Diseña una clase abstracta "ItemBiblioteca" que contenga métodos abstractos como "prestar()", "devolver()" y "calcularMultas()".
Crea las clases concretas “Libro”, “Revista” y “Película”, las cuales deben extender la clase "ItemBiblioteca" y proporcionar implementaciones concretas de los métodos. 
Desarrolla una interfaz llamada "Catalogable" con métodos para obtener información sobre el elemento bibliotecario llamado obtenerInformacion.
Luego, asegúrate de que todas las clases implementen esta interfaz.

Clase Revista: 
Incorpora los atributos nroEdicion, cantidadEjemplares, nombreRevista. Recuerda crear constructores, getters y setters.
Ajuste método prestar(): Este método, restará en 1 la cantidadEjemplares. Tener en cuenta que NO se puede prestar revistas cuyo stock sea cero.
Ajuste método devolver(): Este método, aumentará en 1 la cantidadEjemplares. 
Ajuste método obtenerInformacion(): Este método, deberá imprimir la información de TODOS los atributos de la clase.
Crea un arreglo en tu clase que contiene el método Main, con 3 objetos del tipo Revista e invoca los métodos para probarlos. 
*/