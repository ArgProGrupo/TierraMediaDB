package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import jdbc.ConnectionProvider;
import model.Atraccion;
import model.DescuentoAbsoluto;
import model.DescuentoPorcentaje;
import model.DescuentoTresPorDos;
import model.Propuestas;

//public class DescuentoAbsolutoDAOImpl implements DescuentoAbsolutoDAO {
//
//	private DescuentoAbsoluto toDescuentoAbsoluto(ResultSet result) {
//		try {
//			return new DescuentoAbsoluto(result.getString(2), result.getInt(3));
//		} catch (Exception e) {
//			throw new MissingDataException(e);
//		}		
//	}

public class DescuentoAbsolutoDAOImpl implements DescuentoAbsolutoDAO {

	private DescuentoAbsoluto toDescuentoAbsoluto(ResultSet result) {
		try {
			DescuentoAbsoluto pa = new DescuentoAbsoluto(result.getString(2), result.getInt(3));
			String query2 = "SELECT p.nombre_promo, (sum(a.costo) - ppa.descuento)  AS 'costo', sum(a.duracion) AS 'duracion_total' , min(a.cupo) AS 'cupo', ppa.descuento AS 'descuento',  a.tipo AS 'tipo', p.cant_atracciones \r\n"
					+ " FROM promocion p, pack_atracciones pa , atraccion a, promocion_absoluta ppa\r\n"
					+ " WHERE p.id_promo == pa.id_promocion AND a.id_atraccion == pa.id_atraccion AND p.nombre_promo LIKE '%DEGUSTACION'\r\n";
			Connection conn2 = ConnectionProvider.getConnection();
			PreparedStatement statement2 = conn2.prepareStatement(query2);
			ResultSet results2 = statement2.executeQuery();
			pa.setCosto(results2.getInt(2));
			pa.setTiempo(results2.getDouble(3));
			pa.setCupo(results2.getInt(4));
			pa.setDescuento(results2.getInt(5));
			pa.setTipo(results2.getString(6));
			pa.setCantAtracciones(results2.getInt(7));

			return pa;
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

	public List<Propuestas> findAll(List<Propuestas> a) {
		try {
			List<Propuestas> promoAbs = new LinkedList<Propuestas>();
			List<Propuestas> promoAtracciones = new LinkedList<Propuestas>();

			String query2 = "SELECT pa.id_atraccion, p.id_promo \r\n"
					+ "FROM pack_atracciones pa, promocion p \r\n"
					+ "WHERE p.id_promo == pa.id_promocion AND p.id_promo == ? \r\n";
			Connection conn2 = ConnectionProvider.getConnection();
			PreparedStatement statement2 = conn2.prepareStatement(query2);
			statement2.setInt(1,2);
			ResultSet results2 = statement2.executeQuery();
			while (results2.next()) {
				for (Propuestas atrac : a) {
					if (atrac.getIdAtraccion() == results2.getInt(1))
						promoAtracciones.add(atrac);
				}
			}
			return promoAbs;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

//		public List<DescuentoAbsoluto> findAll() {
//		try {
//			String query = "SELECT * FROM PROMOCION_ABSOLUTA";
//			Connection conn = ConnectionProvider.getConnection();
//			PreparedStatement statement = conn.prepareStatement(query);
//			ResultSet results = statement.executeQuery();
//			
//			
//			String query2 = "SELECT p.nombre_promo, (sum(a.costo) - ppa.descuento)  AS 'costo', sum(a.duracion) AS 'duracion_total' , min(a.cupo) AS 'cupo', ppa.descuento AS 'descuento',  a.tipo AS 'tipo', p.cant_atracciones \r\n" +
//					" FROM promocion p, pack_atracciones pa , atraccion a, promocion_absoluta ppa\r\n" +
//					" WHERE p.id_promo == pa.id_promocion AND a.id_atraccion == pa.id_atraccion AND p.nombre_promo LIKE '%DEGUSTACION'\r\n";
//			Connection conn2 = ConnectionProvider.getConnection();
//			PreparedStatement statement2 = conn2.prepareStatement(query2);
//			ResultSet results2 = statement2.executeQuery();
//			
//
//			List<DescuentoAbsoluto> promoAbs = new LinkedList<DescuentoAbsoluto>();
//			while (results.next()) {
//				promoAbs.add(toDescuentoAbsoluto(results));
//			}
//			for(DescuentoAbsoluto pa : promoAbs) {
//			pa.setCosto(results2.getInt(2));
//			pa.setTiempo(results2.getDouble(3));
//			pa.setCupo(results2.getInt(4));
//			pa.setDescuento(results2.getInt(5));
//			pa.setTipo(results2.getString(6));
//			pa.setCantAtracciones(results2.getInt(7));
//			}
//			return promoAbs;
//		} catch (Exception e) {
//			throw new MissingDataException(e);
//		}
//	}

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

	public List<DescuentoPorcentaje> findByPorcentaje(int porcentaje) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
