package dao;

public class FactoryDAO {

	public static UsuarioDAO getUsuarioDAO() {
		return new UsuarioDAOImpl();
	}

	public static AtraccionDAO getAtraccionDAO() {
		return new AtraccionDAOImpl();
	}

	public static PromocionDAO getPromocionDAO() {
		return new PromocionDAOImpl();
	}

	public static DescuentoPorcentajeDAO getDescuentoPorcentajeDAO() {
		return new DescuentoPorcentajeDAOImpl();
	}

	public static DescuentoAbsolutoDAO getDescuentoAbsolutoDAO() {
		return new DescuentoAbsolutoDAOImpl();
	}

	public static DescuentoTresPorDosDAO getDescuentoTresPorDosDAO() {
		return new DescuentoTresPorDosDAOImpl();
	}
}
