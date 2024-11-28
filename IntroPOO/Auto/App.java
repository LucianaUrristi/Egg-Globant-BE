package Auto;

public class App {
    public static void main(String[] args) {
        // Crear objetos para probar los constructores
        Auto auto1 = new Auto("Toyota", "Corolla", 2020);
        Auto auto2 = new Auto("Ford", "Fiesta");
        Auto auto3 = new Auto("Chevrolet");
        Auto auto4 = new Auto();
        // Mostrar los atributos de los autos creados
        System.out.println("****DATOS AUTO 1****");
        auto1.imprimirDatos();
        System.out.println("****DATOS AUTO 2****");
        auto2.imprimirDatos();
        System.out.println("****DATOS AUTO 3****");
        auto3.imprimirDatos();
        System.out.println("****DATOS AUTO 4****");
        auto4.imprimirDatos();
    }
}
