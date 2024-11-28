package Complementarios;

import Complementarios.entidades.PalabraClave;

public class App_PalabraClave {
    public static void main(String[] args) {
        PalabraClave palabraClave = new PalabraClave();
        palabraClave.ingresarPalabraClave();
    }
}

/*

*2. Creación de una Palabra Clave en Java

Objetivo: Practicar el manejo de excepciones en Java al solicitar al usuario que ingrese una palabra para 
ser utilizada como clave y verificar si cumple con ciertos criterios.

Instrucciones:
-Define una clase llamada PalabraClave.La misma contendrá un atributo del tipo String para almacenar el dato. 
-Dentro de la clase, crea un método llamado ingresarPalabraClave() que solicite al usuario ingresar una palabra para ser utilizada como clave.
-Deberás realizar las validaciones necesarias para que la palabra clave deba cumplir con los siguientes criterios:
    -Debe tener al menos 8 caracteres.
    -Debe contener exactamente 4 números.
    -Debe contener la letra 'z'.
-Utiliza al menos dos excepciones específicas para manejar los casos en los que el usuario no cumpla con alguno de los criterios mencionados.
-Si la palabra clave cumple con todos los criterios, imprime un mensaje indicando que la palabra clave es válida para ser utilizada.
-Si la palabra clave no cumple con algún criterio, imprime un mensaje indicando el motivo específico.
*/