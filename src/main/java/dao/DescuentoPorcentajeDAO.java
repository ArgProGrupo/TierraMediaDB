package dao;

import java.util.List;

import model.Atraccion;
import model.DescuentoPorcentaje;

public interface DescuentoPorcentajeDAO extends GenericDAO<DescuentoPorcentaje>{
	
	public abstract DescuentoPorcentaje findByIdDescuentoPorcentaje(int idDescuentoAbsoluto);
	public abstract List<DescuentoPorcentaje> findByNombrePack(String nombre);
	public abstract List<DescuentoPorcentaje> findByPorcentaje(int porcentaje);
	public abstract List<Atraccion> findAll(List<Atraccion> atracciones);
}
