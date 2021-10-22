package dao;

import java.sql.ResultSet;
import java.util.List;

import model.Atraccion;
import model.Promocion;

public class PromocionDAOImpl implements PromocionDAO{
	// CAPAZ QUE NO SIRVE
	
	private Promocion toPromocion(ResultSet result) {
		try {
			return new Promocion(
							   result.getString(2),
							   result.getString(3),
							   result.getInt(4));
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
		
	}

	@Override
	public List<Promocion> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countAll() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(Promocion t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Promocion t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Promocion t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Atraccion findByIdPromocion(int idPromocion) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Promocion> findByNombre(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

}
