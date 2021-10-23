package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import jdbc.ConnectionProvider;
import model.DescuentoAbsoluto;
import model.DescuentoPorcentaje;

public class DescuentoPorcentajeDAOImpl implements DescuentoPorcentajeDAO {

	private DescuentoPorcentaje toDescuentoPorcentaje(ResultSet result) {
		try {
			return new DescuentoPorcentaje(result.getString(2), result.getString(3), result.getInt(4));
		} catch (Exception e) {
			throw new MissingDataException(e);
		}

	}

	public List<DescuentoPorcentaje> findAll() {
		try {
			String query = "SELECT * FROM PROMOCION_PORCENTUAL";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(query);
			ResultSet results = statement.executeQuery();

			List<DescuentoPorcentaje> promoPorc = new LinkedList<DescuentoPorcentaje>();
			while (results.next()) {
				promoPorc.add(toDescuentoPorcentaje(results));
			}
			return promoPorc;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	public int countAll() {
		try {
			String query = "SELECT COUNT(1) AS TOTAL FROM PROMOCION_PORCENTUAL";
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

	public int insert(DescuentoPorcentaje t) {
		try {
			String query = "INSERT INTO PROMOCION_PORCENTUAL (NOMBRE_PACK, TIPO, DESCUENTO) VALUES (?, ?, ?)";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, t.getNombre());
			statement.setString(2, t.getTipo());
			statement.setDouble(3, t.getDescuento());

			int rows = statement.executeUpdate();
			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	public int update(DescuentoPorcentaje t) {
		try {
			String query = "UPDATE PROMOCION_PORCENTUAL SET PORCENTAJE = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setInt(1, t.getDescuento());

			int rows = statement.executeUpdate();
			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	public int delete(DescuentoPorcentaje t) {
		try {
			String query = "DELETE FROM PROMOCION_PORCENTUAL WHERE ID_ATRACCION = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(query);

			statement.setInt(1, t.getIdPromocion());

			int rows = statement.executeUpdate();
			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	public DescuentoPorcentaje findByIdDescuentoPorcentaje(int idDescuentoPorcentaje) {
		try {
			String query = "SELECT * FROM PROMOCION_PORCENTUAL WHERE ID_ATRACCION = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setInt(1, idDescuentoPorcentaje);

			ResultSet results = statement.executeQuery();

			DescuentoPorcentaje descuentoPorcentaje = null;
			if (results.next()) {
				descuentoPorcentaje = toDescuentoPorcentaje(results);
			}
			return descuentoPorcentaje;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	public List<DescuentoPorcentaje> findByNombrePack(String nombre) {
		try {
			String query = "SELECT * FROM PROMOCION_PORCENTUAL WHERE NOMBRE = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, nombre);

			ResultSet results = statement.executeQuery();

			List<DescuentoPorcentaje> descuentoPorcentaje = new LinkedList<DescuentoPorcentaje>();
			while (results.next()) {
				descuentoPorcentaje.add(toDescuentoPorcentaje(results));
			}
			return descuentoPorcentaje;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	public List<DescuentoPorcentaje> findByPorcentaje(int porcentaje) {
		try {
			String query = "SELECT * FROM PROMOCION_PORCENTUAL WHERE DESCUENTO = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setInt(1, porcentaje);

			ResultSet results = statement.executeQuery();

			List<DescuentoPorcentaje> promoPorc = new LinkedList<DescuentoPorcentaje>();
			while (results.next()) {
				promoPorc.add(toDescuentoPorcentaje(results));
			}
			return promoPorc;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	public List<DescuentoAbsoluto> findByDescuento(int descuento) {
		// TODO Auto-generated method stub
		return null;
	}

}
