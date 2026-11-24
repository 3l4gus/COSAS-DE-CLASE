import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

	private final String USER = "root";
	private final String PWD = "root";
	private final String URL = "jdbc:mysql://localhost:3306/tienda";

	public Connection abrirConexion() {

		Connection con = null;

		try {
			con = DriverManager.getConnection(URL, USER, PWD);
		} catch (SQLException e) {
			System.out.println("Error de conexion");
		}
		return con;
	}
}
