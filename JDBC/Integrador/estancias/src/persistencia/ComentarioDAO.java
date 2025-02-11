package persistencia;

import entidades.Casa;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import persistencia.ComentarioDAO;


public class ComentarioDAO extends DAO {
    // Método para listar casas del Reino Unido con comentarios que contengan 'limpia'
    public List<Casa> listarCasasLimpiasReinoUnido() throws Exception {
        List<Casa> casasLimpias = new ArrayList<>();
        String sql = "SELECT ca.id_casa, ca.calle, ca.numero, ca.codigo_postal, ca.ciudad, ca.pais, co.comentario " +
                    "FROM casas ca " +
                    "JOIN comentarios co ON ca.id_casa = co.id_casa " +
                    "WHERE ca.pais = 'Reino Unido' AND LOWER(co.comentario) LIKE '%limpia%'";

        try {
            conectarBase();
            ResultSet rs = ejecutarConsulta(sql);
            
            while (rs.next()) {
                Casa casa = new Casa();
                casa.setId_casa(rs.getInt("id_casa"));
                casa.setCalle(rs.getString("calle"));
                casa.setNumero(rs.getInt("numero"));
                casa.setCodigo_postal(rs.getString("codigo_postal"));
                casa.setCiudad(rs.getString("ciudad"));
                casa.setPais(rs.getString("pais"));

                casasLimpias.add(casa);
                
                String comentario = rs.getString("comentario");
                System.out.println("Comentario: " + comentario); 
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

