package entidades;

import enums.Mes;
import enums.Estacion;

public class EstacionDelAnio{
    // Método para obtener la estación según un mes
    public static Estacion obtenerEstacion(Mes mes) {
        switch (mes) {
            case MARZO:
            case ABRIL:
            case MAYO:
                return Estacion.PRIMAVERA;
            case JUNIO:
            case JULIO:
            case AGOSTO:
                return Estacion.VERANO;
            case SEPTIEMBRE:
            case OCTUBRE:
            case NOVIEMBRE:
                return Estacion.OTOÑO;
            case DICIEMBRE:
            case ENERO:
            case FEBRERO:
                return Estacion.INVIERNO;
            default:
                return null;
        }
    }

    // Método para imprimir todas las estaciones y sus meses correspondientes
    public static void imprimirEstaciones() {
        System.out.println("Estaciones del Año:");
        System.out.println("Primavera: Marzo, Abril, Mayo");
        System.out.println("Verano: Junio, Julio, Agosto");
        System.out.println("Otoño: Septiembre, Octubre, Noviembre");
        System.out.println("Invierno: Diciembre, Enero, Febrero");
    }
}
