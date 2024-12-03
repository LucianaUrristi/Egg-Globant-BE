package Servicios;

import Entidades.Tarea;
import java.util.ArrayList;
import java.util.List;


public class TareaServicio {
    private List<Tarea> listaTareas = new ArrayList<>();

    // Agregar tarea
    public void agregarTarea(String descripcion) {
        listaTareas.add(new Tarea(descripcion));
        System.out.println("Tarea agregada exitosamente.");
    }

    // Marcar tarea como completada
    public void marcarTareaComoCompletada(int id) {
        for (Tarea tarea : listaTareas) {
            if (tarea.getIdTarea() == id && tarea.getEstado().equals("pendiente")) {
                tarea.setEstado("completada");
                System.out.println("Tarea marcada como completada.");
                return;
            }
        }
        System.out.println("Tarea no encontrada o ya completada.");
    }

    // Eliminar tarea
    public void eliminarTarea(int id) {
        boolean eliminada = listaTareas.removeIf(tarea -> tarea.getIdTarea() == id);
        if (eliminada) {
            System.out.println("Tarea eliminada exitosamente.");
        } else {
            System.out.println("Tarea no encontrada.");
        }
    }

    // Mostrar tareas pendientes
    public void mostrarTareasPendientes() {
        System.out.println("\n--- Tareas Pendientes ---");
        for (Tarea tarea : listaTareas) {
            if (tarea.getEstado().equals("pendiente")) {
                System.out.println(tarea);
            }
        }
    }

    // Mostrar tareas completadas
    public void mostrarTareasCompletadas() {
        System.out.println("\n--- Tareas Completadas ---");
        for (Tarea tarea : listaTareas) {
            if (tarea.getEstado().equals("completada")) {
                System.out.println(tarea);
            }
        }
    }
}
