package dao;

import java.util.ArrayList;
import java.util.List;

import model.Atraccion;
import model.DescuentoAbsoluto;

public interface DescuentoAbsolutoDAO extends GenericDAO<DescuentoAbsoluto>{
	
	public abstract List<Atraccion> findAll(List<Atraccion> atracciones);
	public abstract DescuentoAbsoluto findByIdDescuentoAbsoluto(int idDescuentoAbsoluto);
	public abstract List<DescuentoAbsoluto> findByNombrePack(String nombre);
	public abstract List<DescuentoAbsoluto> findByDescuento(int descuento);

}
