package dao;

import java.util.List;

import model.Usuario;

public interface UsuarioDAO extends GenericDAO<Usuario> {
	
	public abstract Usuario findByIdUsuario(int idUsuario);
	public abstract List<Usuario> findByNombre(String nombre);
	public abstract List<Usuario> findByPresupuesto(int presupuesto);
	public abstract List<Usuario> findByTiempoDisponible(double tiempoDisponible);
}
