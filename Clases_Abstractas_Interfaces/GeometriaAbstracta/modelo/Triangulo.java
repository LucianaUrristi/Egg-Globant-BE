package GeometriaAbstracta.modelo;

import GeometriaAbstracta.interfaces.Dibujable;

// Definición de la clase Triángulo que extiende de Figura
public class Triangulo extends Figura implements Dibujable {
    private int lado1;
    private int lado2;
    private int lado3;

    // Constructor de la clase Triángulo
    public Triangulo(int lado1, int lado2, int lado3) {
        this.lado1 = lado1;
        this.lado2 = lado2;
        this.lado3 = lado3;
    }

    public Triangulo() {
    }

    public int getLado1() {
        return lado1;
    }

    public void setLado1(int lado1) {
        this.lado1 = lado1;
    }

    public int getLado2() {
        return lado2;
    }

    public void setLado2(int lado2) {
        this.lado2 = lado2;
    }

    public int getLado3() {
        return lado3;
    }

    public void setLado3(int lado3) {
        this.lado3 = lado3;
    }

    // Implementación del método para calcular el área del triángulo
    @Override
    public double calcularArea() {
        // Utilizamos la fórmula de Herón para calcular el área de un triángulo

        double s = (lado1 + lado2 + lado3) / 2;
        return Math.sqrt(s * (s - lado1) * (s - lado2) * (s - lado3));
    }
    // Implementación del método para calcular el perímetro del triángulo

    @Override
    public double calcularPerimetro() {
        return lado1 + lado2 + lado3;
    }

    @Override
    public void dibujar() {
        System.out.println("Dibujando un triangulo ..." + '\n');
        if (!esTrianguloValido(lado1, lado2, lado3)) {
            System.out.println("Los lados proporcionados no forman un triángulo válido.");
            return;
        }

        if (!esTrianguloRectangulo(lado1, lado2, lado3)) {
            System.out.println("Los lados proporcionados no forman un triángulo rectángulo.");
            return;
        }

        // Dibujar un triángulo rectángulo basado en el lado más corto
        int filas = Math.min(lado1, Math.min(lado2, lado3));

        for (int i = 1; i <= filas; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    // Método para comprobar si los lados forman un triángulo válido
    public boolean esTrianguloValido(int lado1, int lado2, int lado3) {
        return (lado1 + lado2 > lado3) && (lado1 + lado3 > lado2) && (lado2 + lado3 > lado1);
    }

    // Método para comprobar si los lados forman un triángulo rectángulo
    public boolean esTrianguloRectangulo(int lado1, int lado2, int lado3) {
        int a = Math.min(lado1, Math.min(lado2, lado3)); // Lado más corto
        int c = Math.max(lado1, Math.max(lado2, lado3)); // Hipotenusa
        int b = lado1 + lado2 + lado3 - a - c; // Lado intermedio

        // Verificar el Teorema de Pitágoras
        return a * a + b * b == c * c;
    }
}