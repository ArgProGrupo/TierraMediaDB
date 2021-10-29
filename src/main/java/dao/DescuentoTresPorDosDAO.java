package dao;

import java.util.List;

import model.Atraccion;
import model.DescuentoTresPorDos;
import model.Propuestas;

public interface DescuentoTresPorDosDAO extends GenericDAO<DescuentoTresPorDos>{
	
	public abstract List<Propuestas> findAll(List<Propuestas> atracciones);
	public abstract DescuentoTresPorDos findByIdDescuentoTresPorDos(int idDescuentoTresPorDos);
	public abstract List<DescuentoTresPorDos> findByNombrePack(String nombre);
	public abstract List<DescuentoTresPorDos> findIdAtraccionGratis(int id);

}
