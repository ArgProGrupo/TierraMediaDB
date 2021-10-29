package dao;

import java.util.List;

import model.Atraccion;
import model.DescuentoPorcentaje;
import model.Propuestas;

public interface DescuentoPorcentajeDAO extends GenericDAO<Propuestas>{
	
	public abstract DescuentoPorcentaje findByIdDescuentoPorcentaje(int idDescuentoAbsoluto);
	public abstract List<DescuentoPorcentaje> findByNombrePack(String nombre);
	public abstract List<DescuentoPorcentaje> findByPorcentaje(int porcentaje);
	public abstract List<Propuestas> findAll(List<Propuestas> atracciones);
}
