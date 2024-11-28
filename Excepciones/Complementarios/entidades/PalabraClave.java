package Complementarios.entidades;

import java.util.Scanner;

public class PalabraClave {
    private String clave;

    public PalabraClave() {
        this.clave = "";
    }

    public void ingresarPalabraClave() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce una palabra clave que contenga al menos 8 caracteres, 4 números y la letra 'z': ");
        this.clave = scanner.nextLine();

        try {
            if (clave.length() < 8) {
                throw new Exception("La palabra clave debe tener al menos 8 caracteres.");
            }

            int contadorNumeros = 0;
            for (int i = 0; i < clave.length(); i++) {
                if (Character.isDigit(clave.charAt(i))) {
                    contadorNumeros++;
                }
            }
            if (contadorNumeros != 4) {
                throw new Exception("La palabra clave debe contener exactamente 4 números.");
            }

            if (!clave.contains("z")) {
                throw new Exception("La palabra clave debe contener la letra 'z'.");
            }

            System.out.println("La palabra clave es válida.");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    
}
