package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import jdbc.ConnectionProvider;
import model.Atraccion;
import model.Propuestas;

public class AtraccionDAOImpl implements AtraccionDAO {
		
		private Atraccion toAtraccion(ResultSet result) {
			try {
				return new Atraccion(
						result.getInt(1),
						result.getString(2), 
						result.getInt(3),
						result.getDouble(4),
						result.getInt(5),
						result.getString(6));
			} catch (Exception e) {
				throw new MissingDataException(e);
			}
		}

	public List<Propuestas> findAll() {
		try {
			String query = "SELECT * FROM ATRACCION";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(query);
			ResultSet results = statement.executeQuery();

			List<Propuestas> atraccion = new LinkedList<Propuestas>();
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

	public int insert(Propuestas t) {
		try {
			String query = "INSERT INTO ATRACCION (NOMBRE, COSTO, DURACION, CUPO, TIPO) VALUES (?, ?, ?, ?, ?)";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, t.getNombre());
			statement.setInt(2, t.getCosto());
			statement.setDouble(3, t.getTiempo());
			statement.setInt(4, t.getCupo());
			statement.setString(5, t.getTipo());
			
			int rows = statement.executeUpdate();
			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	public int update(Propuestas t) {
		try {
			String query = "UPDATE ATRACCION SET CUPO = ? WHERE ID_ATRACCION = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setInt(1, t.getCupo());
			statement.setInt(2, t.getIdAtraccion());

			int rows = statement.executeUpdate();
			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	public int delete(Propuestas t) {
		try {
			String query = "DELETE FROM ATRACCION WHERE ID_ATRACCION = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(query);

			statement.setInt(1, t.getIdAtraccion());

			int rows = statement.executeUpdate();
			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	public Atraccion findByIdAtraccion(int idAtraccion) {
		try {
			String query = "SELECT * FROM ATRACCION WHERE ID_ATRACCION = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setInt(1, idAtraccion);

			ResultSet results = statement.executeQuery();

			Atraccion atraccion = null;
			if (results.next()) {
				atraccion = toAtraccion(results);
			}
			return atraccion;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	public List<Atraccion> findByNombre(String nombre) {
		try {
			String query = "SELECT * FROM ATRACCION WHERE NOMBRE = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, nombre);

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

	public List<Atraccion> findByCosto(int costo) {
		try {
			String query = "SELECT * FROM ATRACCION WHERE COSTO = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setInt(1, costo);

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

	public List<Atraccion> findByDuracion(double duracion) {
		try {
			String query = "SELECT * FROM ATRACCION WHERE DURACION = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setDouble(1, duracion);

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

	public List<Atraccion> findByCupo(int cupo) {
		try {
			String query = "SELECT * FROM ATRACCION WHERE CUPO = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setInt(1, cupo);

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

	public List<Atraccion> findByTipo(String tipo) {
		try {
			String query = "SELECT * FROM ATRACCION WHERE TIPO = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, tipo);

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

	@Override
	public List<Propuestas> findAll(List<Propuestas> a) {
		// TODO Auto-generated method stub
		return null;
	}

}
