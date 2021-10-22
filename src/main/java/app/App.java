package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.*;
import model.Usuario;


public class App {
	public static void main(String[] args) throws SQLException {
		UsuarioDAO usuarioDAO = FactoryDAO.getUsuarioDAO();
		System.out.println(usuarioDAO.findAll());
		System.out.println(usuarioDAO.findByIdUsuario(2));
		System.out.println(usuarioDAO.findByNombre("Sam"));
		System.out.println(usuarioDAO.findByTiempoDisponible(8.0));
		System.out.println(usuarioDAO.findByTiempoDisponible(80.0));
		System.out.println(usuarioDAO.findByPresupuesto(36));
	Usuario Sofi = new Usuario ("Facu", 150, 3.0, "DEGUSTACION");
//		Usuario Facu = new Usuario ("Facu", 100, 1.0);
	System.out.println(usuarioDAO.insert(Sofi));
//		System.out.println(usuarioDAO.delete(Facu));
		
		
		/*String url = "jdbc:sqlite:C:\\Users\\Alvaro\\Desktop\\ALVARO\\INGENIERIA AGRONOMICA\\Cursos\\Argentina Programa 2\\TP PROYECT PARTE 2\\Tierra_Media_Prueba.db";
		Connection connection = DriverManager.getConnection(url);
		
		String sql = "SELECT COUNT (1) AS TOTAL FROM USERS";
		PreparedStatement statement = connection.prepareStatement(sql);
		
		ResultSet resultados = statement.executeQuery();
		
		resultados.next();
		System.out.println(resultados.getInt("TOTAL"));
		
		connection.close();*/
	}
}
