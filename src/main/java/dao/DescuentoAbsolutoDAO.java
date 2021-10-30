package dao;

import java.util.List;

import model.DescuentoAbsoluto;
import model.Propuestas;

public interface DescuentoAbsolutoDAO extends GenericDAO<DescuentoAbsoluto>{
	
	public abstract List<Propuestas> findAll(List<Propuestas> atracciones);
	public abstract DescuentoAbsoluto findByIdDescuentoAbsoluto(int idDescuentoAbsoluto);
	public abstract List<DescuentoAbsoluto> findByNombrePack(String nombre);
	public abstract List<DescuentoAbsoluto> findByDescuento(int descuento);

}
