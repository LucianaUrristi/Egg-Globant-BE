package com.servicios;

import java.util.ArrayList;
import java.util.Scanner;

public class ServCiudades {

    Scanner scan = new Scanner(System.in);

    ArrayList<String> ciudades = new ArrayList<String>();

    public void servicio(){

        // Variables
        char opc = 's';

        // Va a pedir al ususario que ingrese ciudades hasta que indique que no
        do {

            System.out.print("Ingrese una ciudad: ");
            ciudades.add(scan.nextLine());

            System.out.print("Desea ingresar otra ciudad? (s/n): ");
            opc = scan.nextLine().toLowerCase().charAt(0);

        } while (opc != 'n');

        //Una vez que el usuario diga que no, se imprimiran las ciudades ingresadas
        System.out.println("Las ciudades ingresadas son: ");
        for (String ciudad : ciudades) {
            System.out.println(" - " + ciudad);
        }

    }

}
