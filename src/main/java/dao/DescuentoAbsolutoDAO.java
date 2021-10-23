package dao;

import java.util.List;

import model.DescuentoAbsoluto;

public interface DescuentoAbsolutoDAO extends GenericDAO<DescuentoAbsoluto>{
	
	public abstract DescuentoAbsoluto findByIdDescuentoAbsoluto(int idDescuentoAbsoluto);
	public abstract List<DescuentoAbsoluto> findByNombrePack(String nombre);
	public abstract List<DescuentoAbsoluto> findByDescuento(int descuento);

}
