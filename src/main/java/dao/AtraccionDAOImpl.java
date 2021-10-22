package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import jdbc.ConnectionProvider;
import model.Atraccion;
import model.Usuario;

public class AtraccionDAOImpl implements AtraccionDAO {
		
		private Atraccion toAtraccion(ResultSet result) {
			try {
				return new Atraccion(
								   result.getString(1), 
								   result.getInt(2),
								   result.getDouble(3),
								   result.getInt(4),
								   result.getString(5));
			} catch (Exception e) {
				throw new MissingDataException(e);
			}
			
		}

	public List<Atraccion> findAll() {
		try {
			String query = "SELECT * FROM ATRACCION";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(query);
			ResultSet results = statement.executeQuery();
			
			List<Atraccion> atraccion = new LinkedList<Atraccion>();
			while (results.next()) {
				atraccion.add(toAtraccion(results));
			}
			return atraccion;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	public int countAll() {
		try {
			String query = "SELECT COUNT(1) AS TOTAL FROM ATRACCION";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(query);
			ResultSet results = statement.executeQuery();
			
			results.next();
			
			int total = results.getInt("TOTAL");
			
			return total;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	public int insert(Atraccion t) {
		try {
			String query = "INSERT INTO ATRACCION (NOMBRE, COSTO, DURACION, CUPO, TIPO) VALUES (?, ?, ?, ?, ?)";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, t.getNombre());
			statement.setInt(2, t.getCosto());
			statement.setDouble(3, t.getTiempo());
			statement.setInt(4, t.getCupo());
			
			int rows = statement.executeUpdate();
			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	public int update(Atraccion t) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int delete(Atraccion t) {
		// TODO Auto-generated method stub
		return 0;
	}

	public Atraccion findByIdAtraccion(int idAtraccion) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Atraccion> findByNombre(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Atraccion> findByCosto(double costo) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Atraccion> findByDuracion(double duracion) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Atraccion> findByCupo(int cupo) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Atraccion> findByTipo(String tipo) {
		// TODO Auto-generated method stub
		return null;
	}

}
