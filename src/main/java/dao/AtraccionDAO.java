package dao;

import java.util.List;

import model.Atraccion;
import model.Propuestas;

public interface AtraccionDAO extends GenericDAO<Propuestas> {
	
	public abstract Atraccion findByIdAtraccion(int idAtraccion);
	public abstract List<Atraccion> findByNombre(String nombre);
	public abstract List<Atraccion> findByCosto(int costo);
	public abstract List<Atraccion> findByDuracion(double duracion);
	public abstract List<Atraccion> findByCupo(int cupo);
	public abstract List<Atraccion> findByTipo(String tipo);

}
