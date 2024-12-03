package Entidades;



// Clase Tarea
public class Tarea {
    private static int contador = 0; // Generador incremental para idTarea
    private int idTarea;
    private String descripcion;
    private String estado; // "pendiente" o "completada"

    // Constructor
    public Tarea(String descripcion) {
        this.idTarea = ++contador;
        this.descripcion = descripcion;
        this.estado = "pendiente";
    }

    // Getters y Setters
    public int getIdTarea() {
        return idTarea;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "ID: " + idTarea + " | Descripción: " + descripcion + " | Estado: " + estado;
    }
}
