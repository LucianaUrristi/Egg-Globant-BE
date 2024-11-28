import entidades.ConvertidorColor;
import enums.Color;

public class App {
    public static void main(String[] args) throws Exception {
    // Arreglo de valores hexadecimales para probar
        String[] coloresPrueba = {
            "#FF0000",  // ROJO
            "#FFFF00",  // AMARILLO
            "#0000FF",  // AZUL
            "#00FF00",  // No es un color primario (VERDE)
            "#123456"   // No es un color primario
        };

        // Probar los colores ingresados
        for (String hex : coloresPrueba) {
            Color color = ConvertidorColor.convertirHexadecimal(hex);
            if (color != null) {
                System.out.println(hex + " corresponde al color primario: " + color);
            } else {
                System.out.println(hex + " no es un color primario.");
            }
        }
    }
}


/*CONSIGNA:
 *Actividad: Colores
Define el enum 'Color' para representar los colores primarios: ROJO, AMARILLO y AZUL. Cada constante
 del enum debe incluir una propiedad adicional llamada 'valorHexadecimal', que represente el valor hexadecimal 
 del color. Los valores hexadecimales correspondientes son: ROJO = "#FF0000", AMARILLO = "#FFFF00" y AZUL = "#0000FF". 
 Posteriormente, crea la clase 'ConvertidorColor', que contenga un método denominado 'convertirHexadecimal', el cual 
 tome como parámetro un valor hexadecimal. Este método deberá retornar el color correspondiente del enum si existe. 
 En caso contrario, retornará null.

En tu clase 'Application', realiza pruebas con 5 colores ingresados, verificando si son o no colores primarios. 
Si el color es válido, imprime el nombre del color; de lo contrario, imprime "No es un color primario".
 */