package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import jdbc.ConnectionProvider;
import model.DescuentoAbsoluto;
import model.DescuentoPorcentaje;
import model.DescuentoTresPorDos;

public class DescuentoTresPorDosDAOImpl implements DescuentoTresPorDosDAO {
	
	private DescuentoTresPorDos toDescuentoTresPorDos(ResultSet result) {
		try {
			return new DescuentoTresPorDos(result.getString(2), 
												result.getString(3),
												result.getInt(4),
												result.getInt(5),
												result.getInt(6));
		} catch (Exception e) {
			throw new MissingDataException(e);
		}

	}

	public List<DescuentoTresPorDos> findAll() {
		try {
			String query = "SELECT * FROM PROMOCION_AXB";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(query);
			ResultSet results = statement.executeQuery();

			List<DescuentoTresPorDos> promoAxB = new LinkedList<DescuentoTresPorDos>();
			while (results.next()) {
				promoAxB.add(toDescuentoTresPorDos(results));
			}
			return promoAxB;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	public int countAll() {
		try {
			String query = "SELECT COUNT(1) AS TOTAL FROM PROMOCION_AXB";
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

	public int insert(DescuentoTresPorDos t) {
		try {
			String query = "INSERT INTO PROMOCION_AXB (NOMBRE_PACK, TIPO, ID_ATRACCION_GRATIS) VALUES (?, ?, ?)";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, t.getNombre());
			statement.setString(2, t.getTipo());
			statement.setInt(3, t.getIdAtraccionGratis());

			int rows = statement.executeUpdate();
			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}
	// SETEAR ATRACCION GRATIS. Propuestas.getAtraccionGratis DEVUELVE UNA ATRACCION
	// QUE ES LO QUE TIENE QUE ACTUALIZAR ?
	public int update(DescuentoTresPorDos t) {
		try {
			String query = "UPDATE PROMOCION_AXB SET PORCENTAJE = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setInt(1, t.getIdAtraccionGratis());

			int rows = statement.executeUpdate();
			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	public int delete(DescuentoTresPorDos t) {
		try {
			String query = "DELETE FROM PROMOCION_AXB WHERE ID_BENEFICIO_AXB = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(query);

			statement.setInt(1, t.getIdPromocion());

			int rows = statement.executeUpdate();
			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	public DescuentoTresPorDos findByIdDescuentoTresPorDos(int idDescuentoTresPorDos) {
		try {
			String query = "SELECT * FROM PROMOCION_AXB WHERE ID_BENEFICIO_AXB = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setInt(1, idDescuentoTresPorDos);

			ResultSet results = statement.executeQuery();

			DescuentoTresPorDos descuentoTresPorDos = null;
			if (results.next()) {
				descuentoTresPorDos = toDescuentoTresPorDos(results);
			}
			return descuentoTresPorDos;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	public List<DescuentoTresPorDos> findByNombrePack(String nombre) {
		try {
			String query = "SELECT * FROM PROMOCION_AXB WHERE NOMBRE = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, nombre);

			ResultSet results = statement.executeQuery();

			List<DescuentoTresPorDos> descuentoTresPorDos = new LinkedList<DescuentoTresPorDos>();
			while (results.next()) {
				descuentoTresPorDos.add(toDescuentoTresPorDos(results));
			}
			return descuentoTresPorDos;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	public List<DescuentoTresPorDos> findIdAtraccionGratis(int id) {
		try {
			String query = "SELECT * FROM PROMOCION_PORCENTUAL WHERE ID_ATRACCION_GRATIS = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setInt(1, id);

			ResultSet results = statement.executeQuery();

			List<DescuentoTresPorDos> promoAxB = new LinkedList<DescuentoTresPorDos>();
			while (results.next()) {
				promoAxB.add(toDescuentoTresPorDos(results));
			}
			return promoAxB;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	public List<DescuentoAbsoluto> findByDescuento(int descuento) {
		// TODO Auto-generated method stub
		return null;
	}
	}

