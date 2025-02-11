package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO {
    protected Connection conexion;
    private final String USER = "root";
    private final String PASSWORD = "root";
    private final String URL = "jdbc:mysql://localhost:3306/estancias_exterior";

    // Conectar a la base de datos
    protected void conectarBase() throws SQLException {
        try {
            conexion = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw new SQLException("Error al conectar a la base de datos", e);
        }
    }

    // Desconectar de la base de datos
    protected void desconectarBase() throws SQLException {
        if (conexion != null) {
            conexion.close();
        }
    }

    // Método para ejecutar consultas SELECT
    protected ResultSet ejecutarConsulta(String sql) throws SQLException {
        conectarBase();
        PreparedStatement stmt = conexion.prepareStatement(sql);
        return stmt.executeQuery();
    }

    // Método para ejecutar INSERT, UPDATE, DELETE
    protected void ejecutarModificacion(String sql) throws SQLException {
        conectarBase();
        PreparedStatement stmt = conexion.prepareStatement(sql);
        stmt.executeUpdate();
        desconectarBase();
    }
}
