package GeometriaAbstracta.modelo;
import GeometriaAbstracta.interfaces.Dibujable;

// Definición de la clase Círculo que extiende de Figura
public class Circulo extends Figura implements Dibujable {
    private double radio;

    // Constructor de la clase Círculo
    public Circulo(double radio) {
        this.radio = radio;
    }

    public Circulo() {
    }

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }

    // Implementación del método para calcular el área del círculo
    @Override
    public double calcularArea() {
        return Math.PI * radio * radio;
    }

    // Implementación del método para calcular el perímetro del círculo
    @Override
    public double calcularPerimetro() {
        return 2 * Math.PI * radio;
    }

    // Implementacion del metodo de la interfaz Dibujable
    @Override
    public void dibujar() {
        System.out.println("Dibujando un circulo ..."+'\n');
        int radio = (int)this.radio;
        for (int i = -radio; i <= radio; i++) {
            for (int j = -radio; j <= radio; j++) {
                if (i * i + j * j <= radio * radio) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
}
