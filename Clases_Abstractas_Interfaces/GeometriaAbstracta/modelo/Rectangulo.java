package GeometriaAbstracta.modelo;
import GeometriaAbstracta.interfaces.Dibujable;

// Definición de la clase Rectángulo que extiende de Figura
public class Rectangulo extends Figura implements Dibujable {
    private double base;
    private double altura;

    // Constructor de la clase Rectángulo
    public Rectangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    public Rectangulo() {
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    // Implementación del método para calcular el área del rectángulo
    @Override
    public double calcularArea() {
        return base * altura;
    }

    // Implementación del método para calcular el perímetro del rectángulo
    @Override
    public double calcularPerimetro() {
        return 2 * (base + altura);
    }

    @Override
    public void dibujar() {
        System.out.println("Dibujando un rectangulo ..."+'\n');
        int ancho = (int)this.base;
        int alto = (int)this.altura;
        for (int i = 0; i < alto; i++) {
            for (int j = 0; j < ancho; j++) {
                if (i == 0 || i == alto - 1 || j == 0 || j == ancho - 1) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
}