package factoryMethod.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AppFactoryJDBC {
//	private static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
//	private static final String USERNAME = "postgres";
//	private static final String PASSWORD = "unicesumar";
	private static final String DB_URL = "jdbc:h2:mem:test";
	private static final String USERNAME = "sa";
	private static final String PASSWORD = "";
	
	public static void main(String[] args) {
		try (Connection conn = DriverManager.getConnection(DB_URL,USERNAME,PASSWORD)) {
			System.out.println(conn.getClass().getName());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
