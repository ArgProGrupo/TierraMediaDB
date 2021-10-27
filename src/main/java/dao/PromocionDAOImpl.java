package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import jdbc.ConnectionProvider;
import model.Atraccion;
import model.Promocion;

public class PromocionDAOImpl implements PromocionDAO{
	// CAPAZ QUE NO SIRVE
	
	private Promocion toPromocion(ResultSet result) {
		try {
			return new Promocion(
					result.getInt(1),
					result.getString(2),
					result.getString(3),
					result.getInt(4));
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
		
	}

	public List<Promocion> findAll() {
		try {
			String query = "SELECT * FROM PROMOCION";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(query);
			ResultSet results = statement.executeQuery();
			
			List<Promocion> promocion = new LinkedList<Promocion>();
			while (results.next()) {
				promocion.add(toPromocion(results));
			}
			return promocion;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

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

	public int insert(Promocion t) {
		try {
			String query = "INSERT INTO PROMOCION (NOMBRE_PROMO, TIPO) VALUES (?, ?)";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, t.getNombre());
			statement.setString(2, t.getTipo());
			
			int rows = statement.executeUpdate();
			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	
	public int update(Promocion t) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public int delete(Promocion t) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public List<Promocion> findAllAtracciones(List<Atraccion> a) {
		// TODO Auto-generated method stub
		return null;
	}

	public Promocion findByIdPromocion(int idPromocion) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<Promocion> findByNombre(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Promocion> findByTipo(String tipoPromo) {
		// TODO Auto-generated method stub
		return null;
	}

}
