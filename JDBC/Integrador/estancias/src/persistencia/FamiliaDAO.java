package persistencia;

import entidades.Familia;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class FamiliaDAO extends DAO {

    public List<Familia> listarFamilias() throws Exception {
        List<Familia> familias = new ArrayList<>();
        try {
            String sql = "SELECT * FROM familias";
            ResultSet rs = ejecutarConsulta(sql);

            while (rs.next()) {
                Familia familia = new Familia(
                    rs.getInt("id_familia"),
                    rs.getString("nombre"),
                    rs.getInt("edad_minima"),
                    rs.getInt("edad_maxima"),
                    rs.getInt("num_hijos"),
                    rs.getString("email")
                );
                familias.add(familia);
            }
            rs.close();
        } catch (Exception e) {
            throw new Exception("Error al listar familias", e);
        } finally {
            desconectarBase();
        }
        return familias;
    }

    public List<Familia> listarFamiliasConHijosYEdadMaxima() throws Exception {
        List<Familia> familias = new ArrayList<>();
        String sql = "SELECT * FROM familias WHERE num_hijos >= 3 AND edad_maxima < 10";
        ResultSet rs = ejecutarConsulta(sql);

        try  {

            while (rs.next()) {
                Familia familia = new Familia();
                familia.setId(rs.getInt("id_familia"));
                familia.setNombre(rs.getString("nombre"));
                familia.setEdadMinima(rs.getInt("edad_minima"));
                familia.setEdadMaxima(rs.getInt("edad_maxima"));
                familia.setNumHijos(rs.getInt("num_hijos"));
                familia.setEmail(rs.getString("email"));
                familias.add(familia);
            }
        } catch (Exception e) {
            throw new Exception("Error al listar familias: " + e.getMessage());
        } finally {
            desconectarBase();
        }
        return familias;
    }

    public List<Familia> listarFamiliasConEmailHotmail() throws Exception {
        List<Familia> familias = new ArrayList<>();
        String sql = "SELECT * FROM familias WHERE email LIKE '%@hotmail.com'";
        ResultSet rs = ejecutarConsulta(sql);
        try  {

            while (rs.next()) {
                Familia familia = new Familia();
                familia.setId(rs.getInt("id_familia"));
                familia.setNombre(rs.getString("nombre"));
                familia.setEdadMinima(rs.getInt("edad_minima"));
                familia.setEdadMaxima(rs.getInt("edad_maxima"));
                familia.setNumHijos(rs.getInt("num_hijos"));
                familia.setEmail(rs.getString("email"));
                familias.add(familia);
            }
        } catch (Exception e) {
            throw new Exception("Error al listar familias con email Hotmail: " + e.getMessage());
        } finally {
            desconectarBase();
        }
        return familias;
    }
}

