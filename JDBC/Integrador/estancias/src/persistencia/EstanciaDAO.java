package persistencia;
import entidades.Casa;
import entidades.Cliente;
import entidades.Estancia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.time.LocalDate;

public class EstanciaDAO extends DAO{
    
    // Método para obtener todos los clientes que realizaron estancias
    public List<Estancia> listarEstanciasConClientes() throws Exception {
        List<Estancia> estancias = new ArrayList<>();
        
        String sql = "SELECT c.id_cliente, c.nombre AS cliente_nombre, "
                    + "c.calle AS cliente_calle, c.numero AS cliente_numero, "
                    + "c.codigo_postal AS cliente_codigo_postal, c.ciudad AS cliente_ciudad, "
                    + "c.pais AS cliente_pais, ca.id_casa, "
                    + "ca.calle AS casa_calle, ca.numero AS casa_numero, "
                    + "ca.codigo_postal AS casa_codigo_postal, ca.ciudad AS casa_ciudad, "
                    + "ca.pais AS casa_pais, e.fecha_desde, e.fecha_hasta "
                    + "FROM clientes c "
                    + "JOIN estancias e ON c.id_cliente = e.id_cliente "
                    + "JOIN casas ca ON e.id_casa = ca.id_casa";
        ResultSet rs = ejecutarConsulta(sql);

        try  {
            while (rs.next()) {
                Estancia estancia = new Estancia();

                // Crear y establecer el cliente
                Cliente cliente = new Cliente();
                cliente.setIdCliente(rs.getInt("id_cliente"));
                cliente.setNombre(rs.getString("cliente_nombre"));
                cliente.setCalle(rs.getString("cliente_calle"));
                cliente.setNumero(rs.getInt("cliente_numero"));
                cliente.setCodigoPostal(rs.getString("cliente_codigo_postal"));
                cliente.setCiudad(rs.getString("cliente_ciudad"));
                cliente.setPais(rs.getString("cliente_pais"));
                estancia.setCliente(cliente); // Asignar cliente a la estancia

                // Crear y establecer la casa
                Casa casa = new Casa();
                casa.setId_casa(rs.getInt("id_casa"));
                casa.setCalle(rs.getString("casa_calle"));
                casa.setNumero(rs.getInt("casa_numero"));
                casa.setCodigo_postal(rs.getString("casa_codigo_postal"));
                casa.setCiudad(rs.getString("casa_ciudad"));
                casa.setPais(rs.getString("casa_pais"));
                estancia.setCasa(casa); // Asignar casa a la estancia

                // Establecer fechas
                estancia.setFechaLlegada(rs.getDate("fecha_desde").toLocalDate());
                estancia.setFechaSalida(rs.getDate("fecha_hasta").toLocalDate());
                
                estancias.add(estancia);
            }
        } catch (Exception e) {
            System.out.println("Error al listar estancias: " + e.getMessage());
        } finally {
            desconectarBase();
        }
        return estancias;
    }

    public List<Estancia> listarEstanciasConClientesYCasas() throws Exception {
        List<Estancia> estancias = new ArrayList<>();
    
        String sql = "SELECT c.id_cliente, c.nombre AS cliente_nombre, "
                    + "c.ciudad AS cliente_ciudad, c.pais AS cliente_pais, "
                    + "ca.id_casa, ca.calle, ca.numero, ca.ciudad, ca.pais, "
                    + "ca.codigo_postal, ca.precio_habitacion, "
                    + "e.fecha_desde, e.fecha_hasta "
                    + "FROM Estancias e "
                    + "JOIN Clientes c ON e.id_cliente = c.id_cliente "
                    + "JOIN Casas ca ON e.id_casa = ca.id_casa";
    
        ResultSet rs = ejecutarConsulta(sql);
    
        try {
            while (rs.next()) {
                // Crear instancia de Cliente
                Cliente cliente = new Cliente();
                cliente.setNombre(rs.getString("cliente_nombre"));
                cliente.setCiudad(rs.getString("cliente_ciudad"));
                cliente.setPais(rs.getString("cliente_pais"));
    
                // Crear instancia de Casa
                Casa casa = new Casa();
                casa.setId_casa(rs.getInt("id_casa"));
                casa.setCalle(rs.getString("calle"));
                casa.setNumero(rs.getInt("numero"));
                casa.setCiudad(rs.getString("ciudad"));
                casa.setPais(rs.getString("pais"));
                casa.setCodigo_postal(rs.getString("codigo_postal"));
                casa.setPrecio_habitacion(rs.getDouble("precio_habitacion"));
    
                // Crear instancia de Estancia
                Estancia estancia = new Estancia();
                estancia.setCliente(cliente);
                estancia.setCasa(casa);
                estancia.setFechaLlegada(rs.getDate("fecha_desde").toLocalDate());
                estancia.setFechaSalida(rs.getDate("fecha_hasta").toLocalDate());
    
                // Agregar estancia a la lista
                estancias.add(estancia);
            }
        } catch (Exception e) {
            System.out.println("Error al listar estancias: " + e.getMessage());
        } finally {
            desconectarBase(); 
        }
        return estancias;
    }
    
    public boolean verificarDisponibilidad(int idCasa, LocalDate fechaLlegada, LocalDate fechaSalida) throws Exception {
        String sql = "SELECT COUNT(*) AS total FROM estancias " +
                    "WHERE id_casa = ? " +
                    "AND (fecha_desde < ? AND fecha_hasta > ?)";
        
        try {
            conectarBase();
            PreparedStatement stmt = conexion.prepareStatement(sql);
            stmt.setInt(1, idCasa);
            stmt.setObject(2, fechaLlegada);
            stmt.setObject(3, fechaSalida);
            
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("total") == 0; // Retorna true si no hay conflictos
            }
        } catch (Exception e) {
            System.out.println("Error al verificar disponibilidad: " + e.getMessage());
        } finally {
            desconectarBase(); 
        }
        return false;
    }
    
    public void insertarEstancia(Estancia estancia) {
    String sql = "INSERT INTO estancia (id_cliente, id_casa, fecha_llegada, fecha_salida, cantidad_habitaciones) " +
                "VALUES (?, ?, ?, ?, ?)";

    try{
        conectarBase();
        PreparedStatement stmt = conexion.prepareStatement(sql);
        stmt.setInt(1, estancia.getCliente().getIdCliente());
        stmt.setInt(2, estancia.getCasa().getId_casa());
        stmt.setDate(3, java.sql.Date.valueOf(estancia.getFechaLlegada()));
        stmt.setDate(4, java.sql.Date.valueOf(estancia.getFechaSalida()));
        stmt.setInt(5, estancia.getCantidadHabitaciones());

        int rowsInserted = stmt.executeUpdate();
        if (rowsInserted > 0) {
            System.out.println("Estancia insertada correctamente en la base de datos.");
        }
    } catch (SQLException e) {
        System.out.println("Error al insertar estancia: " + e.getMessage());
    }
    

    }
}
