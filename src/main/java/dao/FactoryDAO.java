package dao;

public class FactoryDAO {
	
	public static UsuarioDAO getUsuarioDAO() {
		return new UsuarioDAOImpl();
	}

}
