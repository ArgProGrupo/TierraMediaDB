package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {
	
	private static String url = "jdbc:sqlite:C:\\Users\\agustin\\Downloads\\Tierra_media_expeditions.db";
//	private static String url = "jdbc:sqlite:C:\\Users\\Alvaro\\Desktop\\ALVARO\\INGENIERIA AGRONOMICA\\Cursos\\Argentina Programa 2\\TP PROYECT PARTE 2\\Tierra_Media_Prueba.db";
//	private static String url = "jdbc:sqlite:C:\\Users\\Calel\\Documents\\SQL\\Tierra Media db 1\\Tierra_Media_Prueba.db";
	
	private static Connection connection;

	public static Connection getConnection() throws SQLException {
		if (connection == null) {
			connection = DriverManager.getConnection(url);
		}
		return connection;
	}
}
