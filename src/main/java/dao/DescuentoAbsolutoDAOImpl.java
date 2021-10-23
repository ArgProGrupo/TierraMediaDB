package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import jdbc.ConnectionProvider;
import model.DescuentoAbsoluto;

public class DescuentoAbsolutoDAOImpl implements DescuentoAbsolutoDAO {

	private DescuentoAbsoluto toDescuentoAbsoluto(ResultSet result) {
		try {
			return new DescuentoAbsoluto(result.getString(2), result.getString(3), result.getInt(4));
		} catch (Exception e) {
			throw new MissingDataException(e);
		}

	}

	public List<DescuentoAbsoluto> findAll() {
		try {
			String query = "SELECT * FROM PROMOCION_ABSOLUTA";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(query);
			ResultSet results = statement.executeQuery();

			List<DescuentoAbsoluto> promoAbs = new LinkedList<DescuentoAbsoluto>();
			while (results.next()) {
				promoAbs.add(toDescuentoAbsoluto(results));
			}
			return promoAbs;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	public int countAll() {
		try {
			String query = "SELECT COUNT(1) AS TOTAL FROM PROMOCION_ABSOLUTA";
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

	public int insert(DescuentoAbsoluto t) {
		try {
			String query = "INSERT INTO PROMOCION_ABSOLUTA (NOMBRE_PACK, TIPO, DESCUENTO) VALUES (?, ?, ?)";
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

	public int update(DescuentoAbsoluto t) {
		try {
			String query = "UPDATE PROMOCION_ABSOLUTA SET DESCUENTO = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setInt(1, t.getDescuento());

			int rows = statement.executeUpdate();
			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	public int delete(DescuentoAbsoluto t) {
		try {
			String query = "DELETE FROM PROMOCION_ABSOLUTA WHERE ID_ATRACCION = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(query);

			statement.setInt(1, t.getIdPromocion());

			int rows = statement.executeUpdate();
			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	public DescuentoAbsoluto findByIdDescuentoAbsoluto(int idDescuentoAbsoluto) {
		try {
			String query = "SELECT * FROM PROMOCION_ABSOLUTA WHERE ID_ATRACCION = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setInt(1, idDescuentoAbsoluto);

			ResultSet results = statement.executeQuery();

			DescuentoAbsoluto descuentoAbsoluto = null;
			if (results.next()) {
				descuentoAbsoluto = toDescuentoAbsoluto(results);
			}
			return descuentoAbsoluto;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	public List<DescuentoAbsoluto> findByNombrePack(String nombre) {
		try {
			String query = "SELECT * FROM PROMOCION_ABSOLUTA WHERE NOMBRE = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, nombre);

			ResultSet results = statement.executeQuery();

			List<DescuentoAbsoluto> descuentoAbsoluto = new LinkedList<DescuentoAbsoluto>();
			while (results.next()) {
				descuentoAbsoluto.add(toDescuentoAbsoluto(results));
			}
			return descuentoAbsoluto;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	public List<DescuentoAbsoluto> findByDescuento(int descuento) {
		try {
			String query = "SELECT * FROM PROMOCION_ABSOLUTA WHERE DESCUENTO = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setInt(1, descuento);

			ResultSet results = statement.executeQuery();

			List<DescuentoAbsoluto> promoAbs = new LinkedList<DescuentoAbsoluto>();
			while (results.next()) {
				promoAbs.add(toDescuentoAbsoluto(results));
			}
			return promoAbs;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

}
