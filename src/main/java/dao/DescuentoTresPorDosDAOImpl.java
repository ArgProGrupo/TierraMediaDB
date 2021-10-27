package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import jdbc.ConnectionProvider;
import model.Atraccion;
import model.DescuentoAbsoluto;
import model.DescuentoTresPorDos;

public class DescuentoTresPorDosDAOImpl implements DescuentoTresPorDosDAO {

	private DescuentoTresPorDos toDescuentoTresPorDos(ResultSet result) {
		try {
			DescuentoTresPorDos paxb = new DescuentoTresPorDos(result.getString(2), result.getInt(3));
			String query2 = "SELECT p.nombre_promo, sum(a.costo)  AS 'costo', sum(a.duracion) AS 'duracion_total' , min(a.cupo) AS 'cupo', id_atraccion_gratis AS 'id_atraccion_gratis', a.tipo AS 'tipo', p.cant_atracciones \r\n"
					+ "FROM promocion p, pack_atracciones pa , atraccion a, promocion_AxB paxb \r\n"
					+ "WHERE p.id_promo == pa.id_promocion AND a.id_atraccion == pa.id_atraccion AND p.nombre_promo LIKE '%PAISAJE%' \r\n";
			Connection conn2 = ConnectionProvider.getConnection();
			PreparedStatement statement2 = conn2.prepareStatement(query2);
			ResultSet results2 = statement2.executeQuery();
			paxb.setCosto(results2.getInt(2));
			paxb.setTiempo(results2.getDouble(3));
			paxb.setCupo(results2.getInt(4));
			paxb.setTipo(results2.getString(6));
			paxb.setCantAtracciones(results2.getInt(7));
			
			String query = "SELECT a.* \r\n"
					+ "FROM atraccion a, promocion_AxB paxb \r\n"
					+ "WHERE a.id_atraccion == paxb.id_atraccion_gratis \r\n";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(query);
			ResultSet results = statement.executeQuery();
			Atraccion atraccionGratis = new Atraccion(
					results.getInt(1), 
					results.getString(2), 
					results.getInt(3), 
					results.getDouble(4),
					results.getInt(5), 
					results.getString(6));
			paxb.setAtraccionGratis(atraccionGratis);

			return paxb;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}
	

	public List<Atraccion> findAll(List<Atraccion> atracciones) {
		try {

			List<Atraccion> promoAxB = new LinkedList<Atraccion>();			

			String query2 = "SELECT a.id_atraccion, p.id_promo \r\n"
					+ "FROM atraccion a, pack_atracciones pa, promocion p \r\n"
					+ "WHERE a.id_atraccion == pa.id_atraccion AND p.id_promo == pa.id_promocion AND p.id_promo == ? \r\n";
			Connection conn2 = ConnectionProvider.getConnection();
			PreparedStatement statement2 = conn2.prepareStatement(query2);
			statement2.setInt(1,1);
			ResultSet results2 = statement2.executeQuery();
			while (results2.next()) {
				for (Atraccion atrac : atracciones) {
					if (atrac.getIdAtraccion() == results2.getInt(1))
						promoAxB.add(atrac);
				}
			}
			return promoAxB;
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

	public int update(DescuentoTresPorDos t) {
		try {
			String query = "UPDATE PROMOCION_AXB SET ID_ATRACCION_GRATIS = ?";
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
