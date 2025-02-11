package persistencia;

import entidades.Casa;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CasaDAO extends DAO {

    public List<Casa> listarCasasDisponiblesAgosto2020() throws Exception {
        List<Casa> casas = new ArrayList<>();
        String sql = "SELECT * FROM casas WHERE pais = 'Reino Unido' AND "
                + "(fecha_desde <= '2020-08-01' AND fecha_hasta >= '2020-08-31')";
        ResultSet rs = ejecutarConsulta(sql);

        try {

            while (rs.next()) {
                Casa casa = new Casa();
                casa.setId_casa(rs.getInt("id_casa"));
                casa.setNumero(rs.getInt("numero"));
                casa.setCodigo_postal(rs.getString("codigo_postal"));
                casa.setCiudad(rs.getString("ciudad"));
                casa.setPais(rs.getString("pais"));
                casa.setFecha_desde(rs.getDate("fecha_desde").toLocalDate());
                casa.setFecha_hasta(rs.getDate("fecha_hasta").toLocalDate());
                casa.setTiempo_minimo(rs.getInt("tiempo_minimo"));
                casa.setTiempo_maximo(rs.getInt("tiempo_maximo"));
                casa.setPrecio_habitacion(rs.getDouble("precio_habitacion"));
                casa.setTipo_vivienda(rs.getString("tipo_vivienda"));
                casas.add(casa);
            }
        } catch (Exception e) {
            System.out.println("Error al listar casas: " + e.getMessage());
            throw e;
        } finally {
            desconectarBase();
        }
        return casas;
    }

    public List<Casa> listarCasasPorFechaYDias(String fechaInicio, int dias) throws Exception {
        List<Casa> casas = new ArrayList<>();
        String sql = "SELECT * FROM casas " +
                "WHERE fecha_desde <= ? " +
                "AND fecha_hasta >= DATE_ADD(?, INTERVAL ? DAY) " +
                "AND tiempo_minimo <= ? " +
                "AND tiempo_maximo >= ?";

        try {

            conectarBase();
            PreparedStatement stmt = conexion.prepareStatement(sql);
            stmt.setString(1, fechaInicio);// fecha de inicio
            stmt.setString(2, fechaInicio);// fecha de inicio para sumar días
            stmt.setInt(3, dias);// número de días
            stmt.setInt(4, dias); // número de días para el mínimo
            stmt.setInt(5, dias); // número de días para el máximo

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Casa casa = new Casa();
                casa.setId_casa(rs.getInt("id_casa"));
                casa.setNumero(rs.getInt("numero"));
                casa.setCodigo_postal(rs.getString("codigo_postal"));
                casa.setCiudad(rs.getString("ciudad"));
                casa.setPais(rs.getString("pais"));
                casa.setFecha_desde(rs.getDate("fecha_desde").toLocalDate());
                casa.setFecha_hasta(rs.getDate("fecha_hasta").toLocalDate());
                casa.setTiempo_minimo(rs.getInt("tiempo_minimo"));
                casa.setTiempo_maximo(rs.getInt("tiempo_maximo"));
                casa.setPrecio_habitacion(rs.getDouble("precio_habitacion"));
                casa.setTipo_vivienda(rs.getString("tipo_vivienda"));
                casas.add(casa);
            }
        } catch (Exception e) {
            System.out.println("Error al listar casas disponibles: " + e.getMessage());
            throw e;
        } finally {
            desconectarBase();
        }
        return casas;
    }

    public void incrementarPrecioPorcentaje(double porcentaje) throws Exception {
        String sql = "UPDATE Casas SET precio_habitacion = precio_habitacion * (1 + ? / 100) " +
                "WHERE pais = 'Reino Unido'";

        try {
            conectarBase();
            PreparedStatement stmt = conexion.prepareStatement(sql);
            stmt.setDouble(1, porcentaje);
            int filasAfectadas = stmt.executeUpdate();
            System.out.println("Precios actualizados en " + filasAfectadas + " casas.");
        } catch (Exception e) {
            System.out.println("Error al incrementar precios: " + e.getMessage());
            throw e;
        } finally {
            desconectarBase();
        }
    }

    public List<Casa> listarCasasReinoUnido() throws Exception {
        List<Casa> casas = new ArrayList<>();
        String sql = "SELECT id_casa, calle, numero, ciudad, precio_habitacion " +
                "FROM casas WHERE pais = 'Reino Unido'";

        ResultSet rs = ejecutarConsulta(sql);
        try {
            while (rs.next()) {
                Casa casa = new Casa();
                casa.setId_casa(rs.getInt("id_casa"));
                casa.setCalle(rs.getString("calle"));
                casa.setNumero(rs.getInt("numero"));
                casa.setCiudad(rs.getString("ciudad"));
                casa.setPrecio_habitacion(rs.getDouble("precio_habitacion"));
                casas.add(casa);
            }
        } catch (Exception e) {
            System.out.println("Error al listar casas: " + e.getMessage());
            throw e;
        } finally {
            desconectarBase();
        }
        return casas;
    }

    public Map<String, Integer> contarCasasPorPais() throws Exception {
        Map<String, Integer> casasPorPais = new HashMap<>();
        String sql = "SELECT pais, COUNT(*) AS total FROM casas GROUP BY pais";

        try {
            conectarBase();
            PreparedStatement stmt = conexion.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String pais = rs.getString("pais");
                int total = rs.getInt("total");
                casasPorPais.put(pais, total);
            }
        } catch (Exception e) {
            System.out.println("Error al contar casas por país: " + e.getMessage());
            throw e;
        } finally {
            desconectarBase();
        }

        return casasPorPais;
    }

    public List<Casa> listarCasasLimpiasReinoUnido() throws Exception {
        List<Casa> casasLimpias = new ArrayList<>();
        String sql = "SELECT ca.id_casa, ca.calle, ca.numero, ca.ciudad, ca.precio_habitacion " +
                    "FROM casas ca " +
                    "JOIN comentarios co ON ca.id_casa = co.id_casa " +
                    "WHERE co.comentario LIKE '%limpia%' AND ca.pais = 'Reino Unido'";
    
        ResultSet rs = ejecutarConsulta(sql);
        
        try {
            while (rs.next()) {
                Casa casa = new Casa();
                casa.setId_casa(rs.getInt("id_casa"));
                casa.setCalle(rs.getString("calle"));
                casa.setNumero(rs.getInt("numero"));
                casa.setCiudad(rs.getString("ciudad"));
                casa.setPrecio_habitacion(rs.getDouble("precio_habitacion"));
                casasLimpias.add(casa);
            }
        } catch (Exception e) {
            System.out.println("Error al listar casas limpias: " + e.getMessage());
            throw e;
        } finally {
            desconectarBase();
        }
        
        return casasLimpias;
    }

}
