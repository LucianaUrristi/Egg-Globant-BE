import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        obtenerNumeros();
    }

    // Método para obtener los números enteros y realizar la división segura
    public static void obtenerNumeros() {
        Scanner scanner = new Scanner(System.in);
        // Pedir al usuario que ingrese dos números enteros
        System.out.print("Ingrese el dividendo (número a dividir): ");
        int dividendo = scanner.nextInt();
        System.out.print("Ingrese el divisor (número por el cual dividir): ");

        int divisor = scanner.nextInt();
        // Realizar la división segura
        realizarDivision(dividendo, divisor);
        scanner.close();
    }

    // Método para realizar la división segura
    public static void realizarDivision(int dividendo, int divisor) {
        try {
            double resultado = dividir(dividendo, divisor);
            System.out.println("El resultado de la división es: " +

                    resultado);

        } catch (ArithmeticException e) {
            System.out.println("Error: No se puede dividir por cero.");
        }
    }

    // Método para realizar la división
    public static double dividir(int dividendo, int divisor) {
        if (divisor == 0) {
            throw new ArithmeticException(); // Lanzar una excepción si el divisor es cero

        }
        return (double) dividendo / divisor;
    }
}

/*
*Actividad: Division Segura
Escribe un programa que pida al usuario que ingrese dos números enteros y realice la división del primer número entre el segundo número.

Invocar un método llamado “obtenerNumerador()” que solicite el número por el cual se desea dividir.

Este método, "obtenerNumerador()", verificará que ingreses un número distinto de 0. Si ingresas 0, 
el método lanzará una excepción que será controlada por el método que lo invocó.
 */