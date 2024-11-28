package Auto;

public class Auto {
    // Declaramos los atributos de la clase
    String marca;
    String modelo;
    int anio;

    // Constructores
    public Auto(String marca, String modelo, Integer anio) {
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
    }

    public Auto(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }

    public Auto(String marca) {
        this.marca = marca;
    }

    public Auto() {
    }

    // Método para imprimir los datos, con algunas validaciones básicas por si el
    // dato es nulo.
    public void imprimirDatos() {
    if (this.marca == null && this.modelo == null && this.anio == 0) {
    System.out.println("Este OBJETO fue creado con constructor vacío, no hay datos para mostrar");
    
    } else {
    if (this.marca != null) {
    System.out.println("Marca: " + this.marca);
    } else {
    System.out.println("Marca: No especificada");
    }
    if (this.modelo != null) {
    System.out.println("Modelo: " + this.modelo);
    } else {
    System.out.println("Modelo: No especificado");
    }
    if (this.anio != 0) {
    System.out.println("Año: " + this.anio);
    } else {
    System.out.println("Año: No especificado");
    }
    System.out.println("------------------------------");
    }
    }
}
