package Servicios;

import Entidades.Estudiante;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class EstudianteService {
    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    // Declara un ArrayList privado para almacenar objetos Estudiante. Este será el registro de todos los estudiantes.
    private ArrayList<Estudiante> listaEstudiantes = new ArrayList<>();

    // Agregar estudiante
    public void agregarEstudiante() {
        System.out.print("Ingrese el nombre del estudiante: ");
        String nombre = leer.nextLine();
        System.out.print("Ingrese el documento del estudiante: ");
        String documento = leer.nextLine();
        // Declara una variable edad que se inicializa como null. Esto se usa para
        // asegurar que se asignará un valor válido a edad más adelante.
        Integer edad = null;
        // Un bucle que sigue solicitando la edad hasta que el usuario ingrese un valor válido.
        while (edad == null) {
            System.out.print("Ingrese la edad del estudiante: ");
            String entrada = leer.nextLine(); // Leer la entrada como String

            // Intenta convertir la cadena ingresada a un entero. Si la conversión falla, se captura la excepción NumberFormatException.
            try {
                edad = Integer.parseInt(entrada); // Convertir la cadena a Integer
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingrese un número válido para la edad.");
            }
        }
        // Crea un nuevo objeto Estudiante con los valores ingresados y lo añade a la lista de estudiantes.
        listaEstudiantes.add(new Estudiante(nombre, documento, edad));
        System.out.println("Estudiante agregado con éxito.");
    }

    // Eliminar estudiante
    public void eliminarEstudiante() {
        System.out.print("Ingrese el documento del estudiante a eliminar: ");
        String documento = leer.nextLine();

        // Crea un iterador para recorrer la lista de estudiantes.
        Iterator<Estudiante> iterator = listaEstudiantes.iterator();

        boolean encontrado = false;

        // Recorre la lista de estudiantes utilizando el iterador.
        while (iterator.hasNext()) {
            Estudiante e = iterator.next();
            // Verifica si el documento del estudiante coincide con el ingresado. 
            // Si es así, elimina el estudiante y marca encontrado como true.
            if (e.getDocumento().equals(documento)) {
                // Elimina el estudiante de la lista.
                iterator.remove();
                encontrado = true;
                System.out.println("Estudiante eliminado.");
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Estudiante no encontrado.");
        }
    }

    // Mostrar lista de estudiantes
    public void mostrarEstudiantes() {
        // Verifica si la lista de estudiantes está vacía. 
        // Si es así, muestra un mensaje indicando que no hay estudiantes registrados.
        if (listaEstudiantes.isEmpty()) {
            System.out.println("No hay estudiantes registrados.");
        } else {
            // Recorre la lista y muestra la información
            for (Estudiante e : listaEstudiantes) {
                System.out.println(e);
            }
        }
    }

    // Buscar estudiante por documento
    public void buscarEstudiantePorDocumento() {
        System.out.print("Ingrese el documento del estudiante a buscar: ");
        String documento = leer.nextLine();
        // Recorre la lista de estudiantes y muestra la información del estudiante con el documento ingresado.
        for (Estudiante e : listaEstudiantes) {
            if (e.getDocumento().equals(documento)) {
                System.out.println("Estudiante encontrado: " + e.getNombre() + ", Edad: " + e.getEdad());
                return;
            }
        }
        System.out.println("Estudiante no encontrado.");
    }
}
