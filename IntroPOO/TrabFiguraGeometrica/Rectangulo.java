package TrabFiguraGeometrica;

public class Rectangulo {
    double ancho;
    double alto;
    static int contadorRectangulos = 0;

    public Rectangulo(double ancho, double alto) {
        this.ancho = ancho;
        this.alto = alto;
        contadorRectangulos++;
    }

    public double area() {
        return ancho * alto;
    }

    public double perimetro() {
        return 2 * (ancho + alto);
    }

    public static int getContadorRectangulos() {
        return contadorRectangulos;
    }
}
