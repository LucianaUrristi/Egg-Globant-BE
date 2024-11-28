import java.util.Random;


public class App {
    public static void main(String[] args) throws Exception {
        DiasDeLaSemana[] diasAleatorios = new DiasDeLaSemana[10];
        //Generar random
        Random random = new Random();

        // Llenar el arreglo con días aleatorios
        for (int i = 0; i < diasAleatorios.length; i++) {
            diasAleatorios[i] = DiasDeLaSemana.values()[random.nextInt(DiasDeLaSemana.values().length)];
        }

        // Imprimir si cada día es laboral o no
        imprimirDiasLaborales(diasAleatorios);
    }

    // Método para imprimir si cada día es laboral o no
    public static void imprimirDiasLaborales(DiasDeLaSemana[] dias) {
        for (DiasDeLaSemana dia : dias) {
            if (dia.esDiaLaboral()) {
                System.out.println(dia + ": Día laboral");
            } else {
                System.out.println(dia + ": Día NO laboral");
            }
        }
    }
}

/*CONSIGNA:
 * Actividad: Días de la semana

Crea el enum "DiaSemana" que represente los días de la semana, definiendo las constantes correspondientes a los días: LUNES, MARTES, MIÉRCOLES, JUEVES, VIERNES, SÁBADO y DOMINGO.

En la clase "DiaSemana", agrega un método llamado "esDiaLaboral()" que devuelva un valor booleano indicando si el día es laboral o no. Para esto, los días SÁBADO y DOMINGO no serán considerados días laborales.

En la clase "Application", crea un arreglo de objetos "DiaSemana" con 10 días de la semana generados al azar, esto es para evitar la entrada manual de datos.

Implementa un método llamado "imprimirDiaLaboral()" en la clase "Application" que tome como parámetro un objeto de tipo "DiaSemana" y utilice el método "esDiaLaboral()" para determinar si el día es laboral o no. Este método devolverá un mensaje indicando si es "Día laboral" o "No es día laboral", según corresponda al día proporcionado.
 */

