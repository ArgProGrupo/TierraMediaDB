package app;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.*;
import model.*;


public class App {
	public static void main(String[] args) throws SQLException {
		UsuarioDAO usuarioDAO = FactoryDAO.getUsuarioDAO();
		System.out.println(usuarioDAO.findAll());
		//System.out.println(usuarioDAO.findByIdUsuario(6));
		//System.out.println(usuarioDAO.findByNombre("Facu"));
		//System.out.println(usuarioDAO.findByTiempoDisponible(8.0));
		//System.out.println(usuarioDAO.findByTiempoDisponible(80.0));
		//System.out.println(usuarioDAO.findByPresupuesto(36));
		//Usuario alvaro = new Usuario ("alvaro", "PAISAJE", 300, 8.0);
        //System.out.println(usuarioDAO.insert(alvaro));
		//System.out.println(usuarioDAO.delete(alvaro));
		//Usuario facu = new Usuario(12);
		//usuarioDAO.deleteById(13);
		//System.out.println(usuarioDAO.findByTipoFavorito("AVENTURA"));
		
		//AtraccionDAO atraccionDAO = FactoryDAO.getAtraccionDAO();
		//System.out.println(atraccionDAO.findAll());
		//System.out.println(atraccionDAO.findByIdAtraccion(2));
		//System.out.println(atraccionDAO.findByNombre("Moria"));
		//System.out.println(atraccionDAO.findByCupo(25));
		//System.out.println(atraccionDAO.findByCosto(25));
		//System.out.println(atraccionDAO.findByTipo("AVENTURA"));
		//System.out.println(atraccionDAO.findByDuracion(6.5));
		//Atraccion nueva = new Atraccion("Montaña Azul", 5, 6.0, 50, "PAISAJE");
		//atraccionDAO.insert(nueva);
		//Atraccion nueva = new Atraccion(12);
		//System.out.println(atraccionDAO.delete(nueva));
		//DescuentoPorcentajeDAO DescuentoPorcentajeDAO = FactoryDAO.getDescuentoPorcentajeDAO();
		//System.out.println(DescuentoPorcentajeDAO.findAll());
		
//		DescuentoAbsolutoDAO DescuentoAbsolutoDAO = FactoryDAO.getDescuentoAbsolutoDAO();
//		System.out.println(DescuentoAbsolutoDAO.findAll());
		
		//PromocionDAO promocionDAO = FactoryDAO.getPromocionDAO();
		//System.out.println(promocionDAO.findAll());
	
	
//		UsuarioDAO usuarioDAO = FactoryDAO.getUsuarioDAO();
//		System.out.println(usuarioDAO.findAll());
//		System.out.println(usuarioDAO.findByIdUsuario(2));
//		System.out.println(usuarioDAO.findByNombre("Sam"));
//		System.out.println(usuarioDAO.findByTiempoDisponible(8.0));
//		System.out.println(usuarioDAO.findByTiempoDisponible(80.0));
//		System.out.println(usuarioDAO.findByPresupuesto(36));
//		UsuarioDAOImpl Sofi = new UsuarioDAOImpl ();
//		Usuario Facu = new Usuario ("Facu", 100, 1.0);
//		System.out.println(usuarioDAO.insert(Sofi));
//		System.out.println(Sofi.delete(6));
		
		/*AtraccionDAO atraccionDAO = FactoryDAO.getAtraccionDAO();
		List <Atraccion> atracciones = new ArrayList<Atraccion>();
		atracciones = atraccionDAO.findAll();// agregar una varriable y guardar en variable
		System.out.println(atracciones);
//		System.out.println(atraccionDAO.findByIdAtraccion(2));
//		System.out.println(atraccionDAO.findByNombre("Moria"));
//		System.out.println(atraccionDAO.findByCupo(25));
//		System.out.println(atraccionDAO.findByCosto(25));
//		System.out.println(atraccionDAO.findByTipo("AVENTURA"));
//		System.out.println(atraccionDAO.findByDuracion(6.5));
//		
		DescuentoAbsolutoDAO DescuentoAbsolutoDAO = FactoryDAO.getDescuentoAbsolutoDAO();
		List <Atraccion> descAb = new ArrayList<Atraccion>();
		descAb = DescuentoAbsolutoDAO.findAll(atracciones);
		System.out.println(descAb);

		DescuentoPorcentajeDAO DescuentoPorcentajeDAO = FactoryDAO.getDescuentoPorcentajeDAO();
		List <Atraccion> descPor = new ArrayList<Atraccion>();
		descPor = DescuentoPorcentajeDAO.findAll(atracciones);
		System.out.println(descPor);
		
		DescuentoTresPorDosDAO DescuentoTresPorDosDAO = FactoryDAO.getDescuentoTresPorDos();
		List <Atraccion> descAxB = new ArrayList<Atraccion>();
		descAxB = DescuentoTresPorDosDAO.findAll(atracciones);
		System.out.println(descAxB);
		
		System.out.println(DescuentoAbsolutoDAO.findAll());
		System.out.println(DescuentoPorcentajeDAO.findAll());
		System.out.println(DescuentoTresPorDosDAO.findAll()); */
	}
}
