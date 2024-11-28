package GeometriaAbstracta;

import GeometriaAbstracta.modelo.Circulo;
import GeometriaAbstracta.modelo.Rectangulo;
import GeometriaAbstracta.modelo.Triangulo;

public class Application {
    public static void main(String[] args) {
        Circulo circulo1 = new Circulo(5);
        circulo1.dibujar();
        Rectangulo rectangulo1 = new Rectangulo(4, 2);
        rectangulo1.dibujar();
        Triangulo triangulo1 = new Triangulo(3, 4, 5);
        triangulo1.dibujar();
    }
}
/*
*Actividad: Geometría abstracta
En esta ocasión, te desafiamos a crear un programa con una jerarquía de clases para representar figuras geométricas abstractas. Este programa debe incluir lo siguiente:

Una clase abstracta denominada “Figura”, que contiene dos métodos abstractos llamados “calcularArea()” y “calcularPerimetro()”.

3 clases para distintas figuras geométricas llamadas  “Círculo”, “Rectángulo” y “Triángulo”. Cada una de estas clases debe extender la clase "Figura" y proporcionar implementaciones concretas de los métodos abstractos.

Para concluir, desarrolla una interfaz llamada "Dibujable" con un método "dibujar()", e implementa esta interfaz en cada figura.

Recuerda invocar estos métodos desde el método main() para demostrar su funcionamiento.
 */