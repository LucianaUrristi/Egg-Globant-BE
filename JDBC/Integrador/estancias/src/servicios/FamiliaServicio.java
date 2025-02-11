package servicios;

import entidades.Familia;
import persistencia.FamiliaDAO;
import java.util.List;

public class FamiliaServicio {

    private FamiliaDAO familiaDAO = new FamiliaDAO();

    public void listarFamilias() {
        try {
            List<Familia> familias = familiaDAO.listarFamilias();
            if (familias.isEmpty()) {
                System.out.println("No hay familias registradas.");
            } else {
                for (Familia familia : familias) {
                    System.out.println(familia.getNombre() + " - " + familia.getEmail());
                }
            }
        } catch (Exception e) {
            System.out.println("Error al listar familias: " + e.getMessage());
        }
    }
    public void listarFamiliasConHijosYEdadMaxima() {
        try {
            System.out.println("Familias con al menos 3 hijos y edad máxima inferior a 10 años:");
            familiaDAO.listarFamiliasConHijosYEdadMaxima()
                    .forEach(familia -> System.out.println(familia.getNombre()));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void listarFamiliasConEmailHotmail() {
        try {
            System.out.println("Familias con email de Hotmail:");
            familiaDAO.listarFamiliasConEmailHotmail()
                    .forEach(familia -> System.out.println(familia.getNombre()));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

