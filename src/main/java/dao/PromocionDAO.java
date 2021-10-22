package dao;

import java.util.List;

import model.Atraccion;
import model.Promocion;

public interface PromocionDAO extends GenericDAO<Promocion> {
	// CAPAZ QUE NO SIRVE
	
	public abstract Atraccion findByIdPromocion(int idPromocion);
	public abstract List<Promocion> findByNombre(String nombre);

}
