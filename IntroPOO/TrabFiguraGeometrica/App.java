package TrabFiguraGeometrica;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Rectangulo[] rectangulos = new Rectangulo[10]; // Arreglo para almacenar hasta 10 rectángulos
        int opcion;
        do {
            System.out.println("\nMenú:");
            System.out.println("1. Crear rectángulo");
            System.out.println("2. Calcular área y perímetro de un rectángulo");
            System.out.println("3. Ver número total de rectángulos creados");
            System.out.println("4. Salir");
            System.out.print("Ingrese su opción: ");
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el ancho del rectángulo: ");
                    double ancho = scanner.nextDouble();
                    System.out.print("Ingrese el alto del rectángulo: ");
                    double alto = scanner.nextDouble();
                    Rectangulo nuevoRectangulo = new Rectangulo(ancho, alto);
                    rectangulos[Rectangulo.getContadorRectangulos() - 1] = nuevoRectangulo;
                    System.out.println("Rectángulo creado.");
                    break;
                case 2:
                    System.out.print("Ingrese el índice del rectángulo: ");
                    int indice = scanner.nextInt();
                    if (indice >= 0 && indice < Rectangulo.getContadorRectangulos()) {
                        System.out.println("Área del rectángulo: " + rectangulos[indice].area());
                        System.out.println("Perímetro del rectángulo: " + rectangulos[indice].perimetro());
                    } else {
                        System.out.println("Índice inválido.");
                    }
                    break;
                case 3:
                    System.out.println("Número total de rectángulos creados: " + Rectangulo.getContadorRectangulos());
                    break;
                case 4:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, ingrese una opción válida.");
            }
        } while (opcion != 4);
        scanner.close();
    }
}
