package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import jdbc.ConnectionProvider;
import model.Promocion;
import model.Propuestas;

public class PromocionDAOImpl implements PromocionDAO {
	
	private Promocion toPromocion(ResultSet result) {
		try {
			return new Promocion(result.getInt(1), result.getString(2), result.getInt(3), result.getString(4),result.getString(5));
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public List<Propuestas> findAll() {
		try {
			String query = "SELECT * FROM PROMOCION";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(query);
			ResultSet results = statement.executeQuery();

			List<Propuestas> promo = new LinkedList<Propuestas>();
			while (results.next()) {
				promo.add(toPromocion(results));
			}
			return promo;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}
	
	@Override
	public List<Propuestas> findAll(List<Propuestas> atracciones) {
			try {
				List<Propuestas> promo = new LinkedList<Propuestas>();
				List<Propuestas> desc1 = findAll();

				for (Propuestas p : desc1) {					

					String query2 = "SELECT pa.id_atraccion, p.id_promo \r\n" + "FROM pack_atracciones pa, promocion p \r\n"
							+ "WHERE p.id_promo == pa.id_promocion AND p.id_promo == ? \r\n";
					Connection conn2 = ConnectionProvider.getConnection();
					PreparedStatement statement2 = conn2.prepareStatement(query2);
	
					statement2.setInt(1,p.getIdPromocion() );
					ResultSet results2 = statement2.executeQuery();
					ArrayList<Propuestas> promoAtracciones = new ArrayList<Propuestas>();
					while (results2.next()) {
					
						for (Propuestas atrac : atracciones) {
							if (atrac.getIdAtraccion() == results2.getInt(1))
								promoAtracciones.add(atrac);			
					}
					((Promocion) p).setLista(promoAtracciones);
					}
					promo.add(p);
				}
				return promo;
			} catch (Exception e) {
				throw new MissingDataException(e);
			}
	}

	@Override
	public int countAll() {
		try {
			String query = "SELECT COUNT(1) AS TOTAL FROM PROMOCION";
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

	@Override
	public int insert(Propuestas t) {
		try {
			String query = "INSERT INTO PROMOCION (NOMBRE_PACK, TIPO, DESCUENTO) VALUES (?, ?, ?)";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, t.getNombre());
			statement.setInt(2, ((Promocion) t).getDescuento());
			statement.setString(3, ((Promocion) t).getTipoPromo());

			int rows = statement.executeUpdate();
			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public int update(Propuestas t) {
		try {
			String query = "UPDATE PROMOCION SET DESCUENTO = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setInt(1, ((Promocion) t).getDescuento());

			int rows = statement.executeUpdate();
			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public int delete(Propuestas t) {
		try {
			String query = "DELETE FROM PROMOCION WHERE ID_PROMO = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(query);

			statement.setInt(1, t.getIdPromocion());

			int rows = statement.executeUpdate();
			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}		

	@Override
	public Promocion findByIdPromo(int idPromo) {
		try {
			String query = "SELECT * FROM PROMOCION WHERE ID_PROMO = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setInt(1, idPromo);

			ResultSet results = statement.executeQuery();

			Promocion promo = null;
			if (results.next()) {
				promo = toPromocion(results);
			}
			return promo;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public List<Promocion> findByNombrePack(String nombre) {
		try {
			String query = "SELECT * FROM PROMOCION WHERE NOMBRE = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, nombre);

			ResultSet results = statement.executeQuery();

			List<Promocion> promo = new LinkedList<Promocion>();
			while (results.next()) {
				promo.add(toPromocion(results));
			}
			return promo;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public List<Promocion> findByDescuento(String tipoPromo) {
		try {
			String query = "SELECT * FROM PROMOCION WHERE TIPO_PROMO = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, tipoPromo);

			ResultSet results = statement.executeQuery();

			List<Promocion> promo = new LinkedList<Promocion>();
			while (results.next()) {
				promo.add(toPromocion(results));
			}
			return promo;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}
}
