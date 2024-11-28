

public class App {
    public static void main(String[] args) throws Exception {
        
        Menu.mostrarMenu();
    }
}
/*CONSIGNA:
    1. Gestión de Estaciones del Año

En esta actividad, se te solicita crear un programa en Java para gestionar las estaciones del año utilizando enumeraciones y métodos estáticos.


Definir Enumeraciones:

Enumeración "Mes": Define los meses del año con sus respectivos números (Ejemplo: ENERO(1), FEBRERO(2), etc.). Cada mes debe tener un atributo "numero" y un método getNumero() para obtener dicho número.

Enumeración "Estacion": Representa las estaciones del año: Primavera, Verano, Otoño e Invierno.

Crear Clase "EstacionDelAño":

Define los siguientes métodos estáticos:

obtenerEstacion(Mes mes): Recibe un objeto de tipo Mes y devuelve la estación del año correspondiente.

imprimirEstaciones(): Imprime todas las estaciones del año junto con los meses que les corresponden.

Menú de Opciones:

Crea un menú de opciones que contenga:

Una opción para mostrar qué meses corresponden a las distintas estaciones del año (invocando al método imprimirEstaciones()).

Una opción para que el usuario ingrese un número de mes (1-12) y se determine la estación del año correspondiente utilizando el método obtenerEstacion(Mes mes).

Opción para salir: Permite al usuario salir del programa ingresando el número 0.

Posibles Validaciones a Considerar:

Validar que el número ingresado por el usuario corresponda a un mes válido

Validar que la opción seleccionada del menú de opciones sea una opción válida

Estructura del proyecto :

Intenta que la clase Main invoque a una clase Menu, que contendrá los métodos necesarios. 
 */