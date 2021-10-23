package dao;

import java.sql.ResultSet;
import java.util.List;

import model.Atraccion;
import model.DescuentoAbsoluto;
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

	public List<Promocion> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public int countAll() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int insert(Promocion t) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public int update(Promocion t) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public int delete(Promocion t) {
		// TODO Auto-generated method stub
		return 0;
	}


	public Atraccion findByIdPromocion(int idPromocion) {
		// TODO Auto-generated method stub
		return null;
	}


	public List<Promocion> findByNombre(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<DescuentoAbsoluto> findByDescuento(int descuento) {
		// TODO Auto-generated method stub
		return null;
	}

}
