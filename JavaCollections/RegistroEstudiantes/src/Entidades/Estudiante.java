package Entidades;

public class Estudiante {
    private String nombre;
    private String documento;
    private Integer edad;

    public Estudiante() {}

    public Estudiante(String nombre, String documento, Integer edad) {
        this.nombre = nombre;
        this.documento = documento;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Nombre=" + nombre + ", Documento=" + documento + ", Edad=" + edad;
    }
}
