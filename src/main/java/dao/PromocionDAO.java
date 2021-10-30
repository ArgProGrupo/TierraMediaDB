package dao;

import java.util.List;

import model.Atraccion;
import model.Promocion;

public interface PromocionDAO extends GenericDAO<Promocion> {	
	public abstract List<Promocion> findAllAtracciones(List<Atraccion> a);
	public abstract Promocion findByIdPromocion(int idPromocion);
	public abstract List<Promocion> findByNombre(String nombre);
	public abstract List<Promocion> findByTipo(String tipoPromo);
}
