package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import jdbc.ConnectionProvider;
import model.Atraccion;
import model.DescuentoAbsoluto;
import model.DescuentoPorcentaje;
import model.DescuentoTresPorDos;

public class DescuentoPorcentajeDAOImpl implements DescuentoPorcentajeDAO {

	private DescuentoPorcentaje toDescuentoPorcentaje(ResultSet result) {
		try {
			DescuentoPorcentaje dp = new DescuentoPorcentaje(result.getString(2), result.getInt(3));
			String query2 = "SELECT p.nombre_promo, (sum(a.costo) - (sum(a.costo) * (pr.porcentaje) / 100) ) AS 'costo', sum(a.duracion) AS 'duracion_total' , min(a.cupo) AS 'cupo', pr.porcentaje AS 'porcentaje', a.tipo AS 'tipo', p.cant_atracciones \r\n"
					+ "FROM promocion p, pack_atracciones pa , atraccion a, promocion_porcentual pr \r\n"
					+ "WHERE p.id_promo == pa.id_promocion AND a.id_atraccion == pa.id_atraccion AND p.nombre_promo LIKE '%AVENTURA' \r\n";
			Connection conn2 = ConnectionProvider.getConnection();
			PreparedStatement statement2 = conn2.prepareStatement(query2);
			ResultSet results2 = statement2.executeQuery();
			dp.setCosto(results2.getInt(2));
			dp.setTiempo(results2.getDouble(3));
			dp.setCupo(results2.getInt(4));
			dp.setDescuento(results2.getInt(5));
			dp.setTipo(results2.getString(6));
			dp.setCantAtracciones(results2.getInt(7));

			return dp;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	public List<Atraccion> findAll(List<Atraccion> a) {
		try {

			List<Atraccion> promoAbs = new LinkedList<Atraccion>();

			String query2 = "SELECT a.id_atraccion, p.id_promo \r\n"
					+ "FROM atraccion a, pack_atracciones pa, promocion p \r\n"
					+ "WHERE a.id_atraccion == pa.id_atraccion AND p.id_promo == pa.id_promocion AND p.id_promo == ? \r\n";
			Connection conn2 = ConnectionProvider.getConnection();
			PreparedStatement statement2 = conn2.prepareStatement(query2);
			statement2.setInt(1,3);
			ResultSet results2 = statement2.executeQuery();
			while (results2.next()) {
				for (Atraccion atrac : a) {
					if (atrac.getIdAtraccion() == results2.getInt(1))
						promoAbs.add(atrac);
				}
			}
			return promoAbs;
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

	public List<DescuentoPorcentaje> findAll() {
		try {
			String query = "SELECT * FROM PROMOCION_PORCENTUAL";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(query);
			ResultSet results = statement.executeQuery();

			List<DescuentoPorcentaje> promoPor = new LinkedList<DescuentoPorcentaje>();
			while (results.next()) {
				promoPor.add(toDescuentoPorcentaje(results));
			}
			return promoPor;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

}
