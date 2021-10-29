package app;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import dao.*;
import model.*;

public class App {

	private static List<Propuestas> propuestas;

	public static void main(String[] args) throws SQLException {
//		UsuarioDAO usuarioDAO = FactoryDAO.getUsuarioDAO();
//		System.out.println(usuarioDAO.findAll());
//		//System.out.println(usuarioDAO.findByIdUsuario(6));
//		//System.out.println(usuarioDAO.findByNombre("Facu"));
//		//System.out.println(usuarioDAO.findByTiempoDisponible(8.0));
//		//System.out.println(usuarioDAO.findByTiempoDisponible(80.0));
//		//System.out.println(usuarioDAO.findByPresupuesto(36));
//		//Usuario alvaro = new Usuario ("alvaro", "PAISAJE", 300, 8.0);
//        //System.out.println(usuarioDAO.insert(alvaro));
//		//System.out.println(usuarioDAO.delete(alvaro));
//		//Usuario facu = new Usuario(12);
//		//usuarioDAO.deleteById(13);
//		//System.out.println(usuarioDAO.findByTipoFavorito("AVENTURA"));
//		
//		AtraccionDAO atraccionDAO = FactoryDAO.getAtraccionDAO();
//		//System.out.println(atraccionDAO.findAll());
//		//System.out.println(atraccionDAO.findByIdAtraccion(2));
//		//System.out.println(atraccionDAO.findByNombre("Moria"));
//		//System.out.println(atraccionDAO.findByCupo(25));
//		//System.out.println(atraccionDAO.findByCosto(25));
//		//System.out.println(atraccionDAO.findByTipo("AVENTURA"));
//		//System.out.println(atraccionDAO.findByDuracion(6.5));
//		//Atraccion nueva = new Atraccion("Montaña Azul", 5, 6.0, 50, "PAISAJE");
//		//atraccionDAO.insert(nueva);
//		//Atraccion nueva = new Atraccion(12);
//		//System.out.println(atraccionDAO.delete(nueva));
//			DescuentoPorcentajeDAO DescuentoPorcentajeDAO = FactoryDAO.getDescuentoPorcentajeDAO();
//		//System.out.println(DescuentoPorcentajeDAO.findAll());
//		
//			DescuentoAbsolutoDAO DescuentoAbsolutoDAO = FactoryDAO.getDescuentoAbsolutoDAO();
////		System.out.println(DescuentoAbsolutoDAO.findAll());
//		
		PromocionDAO promocionDAO = FactoryDAO.getPromocionDAO();
//		//System.out.println(promocionDAO.findAll());
//	
//	
////		UsuarioDAO usuarioDAO = FactoryDAO.getUsuarioDAO();
////		System.out.println(usuarioDAO.findAll());
////		System.out.println(usuarioDAO.findByIdUsuario(2));
////		System.out.println(usuarioDAO.findByNombre("Sam"));
////		System.out.println(usuarioDAO.findByTiempoDisponible(8.0));
////		System.out.println(usuarioDAO.findByTiempoDisponible(80.0));
////		System.out.println(usuarioDAO.findByPresupuesto(36));
////		UsuarioDAOImpl Sofi = new UsuarioDAOImpl ();
////		Usuario Facu = new Usuario ("Facu", 100, 1.0);
////		System.out.println(usuarioDAO.insert(Sofi));
////		System.out.println(Sofi.delete(6));
		AtraccionDAO atraccionDAO = FactoryDAO.getAtraccionDAO();
		List<Propuestas> atracciones = new ArrayList<Propuestas>();
		atracciones = atraccionDAO.findAll();// agregar una varriable y guardar en variable
//		 System.out.println(atracciones);
//		 System.out.println(atraccionDAO.findByIdAtraccion(2));
//		 System.out.println(atraccionDAO.findByNombre("Moria"));
//		 System.out.println(atraccionDAO.findByCupo(25));
//		 System.out.println(atraccionDAO.findByCosto(25));
//		 System.out.println(atraccionDAO.findByTipo("AVENTURA"));
//		 System.out.println(atraccionDAO.findByDuracion(6.5));
//		
		DescuentoAbsolutoDAO DescuentoAbsolutoDAO = FactoryDAO.getDescuentoAbsolutoDAO();
		List<Propuestas> descAb = new ArrayList<Propuestas>();
		descAb = DescuentoAbsolutoDAO.findAll(atracciones);
//		System.out.println(descAb);

		DescuentoPorcentajeDAO DescuentoPorcentajeDAO = FactoryDAO.getDescuentoPorcentajeDAO();
		List<Propuestas> descPor = new ArrayList<Propuestas>();
		descPor = DescuentoPorcentajeDAO.findAll(atracciones);
//		System.out.println(descPor);

		DescuentoTresPorDosDAO DescuentoTresPorDosDAO = FactoryDAO.getDescuentoTresPorDos();
		List<Propuestas> descAxB = new ArrayList<Propuestas>();
		descAxB = DescuentoTresPorDosDAO.findAll(atracciones);
//		System.out.println(descAxB);

//		System.out.println(DescuentoAbsolutoDAO.findAll());
//		System.out.println(DescuentoPorcentajeDAO.findAll());
//		System.out.println(DescuentoTresPorDosDAO.findAll());

		UsuarioDAO usuarioDAO = FactoryDAO.getUsuarioDAO();
		propuestas = new ArrayList<Propuestas>();
		propuestas = atraccionDAO.findAll();
		propuestas.addAll(descAb);
		propuestas.addAll(descPor);
		propuestas.addAll(descAxB);
//		propuestas.add(descAb.get(0));
//		propuestas.add(descPor.get(0));
//		propuestas.add(descAxB.get(0));
		List<Usuario> usuarios = new LinkedList<Usuario>();

		System.out.println(propuestas);
		usuarios = usuarioDAO.findAll();

//		Usuario alvaro = new Usuario ("alvaro", "AVENTURA", 300, 8.0);
//		Usuario alvaro1 = new Usuario ("alvaro", "PAISAJE", 300, 8.0);
//		System.out.println(alvaro1.getTipoAtraccionFavorita().compareTo(alvaro.getTipoAtraccionFavorita()));

		Scanner scanner = new Scanner(System.in);

		for (Usuario u : usuarios) {
			System.out.println("Bienvenido al sistema de autogestión de TierraMediaExpeditions!\n"
					+ "A continuación podrá observar y elegir entre nuestra extensa lista de atracciones \nqué propuesta es "
					+ "la indicada para usted y se convierta en la mejor experiencia de su vida!");
			System.out.println("\nPROPUESTAS ORDENADAS POR PREFERENCIA PARA USUARIO:\n");
			System.out.println(u);
			propuestas.sort(new ComparadorDeAtracciones(u.getTipoAtraccionFavorita()));
			System.out.println("---------------");
			for (Propuestas a : propuestas) {
				if (!u.tieneTiempoYDinero())
					break;
				else if (u.puedeComprar(a)) {
					System.out.println(a);
					System.out
							.println("Si querés comprar esta propuesta marcá 1, " + "sino marcá cualquier otro número");
					int acepta = scanner.nextInt();
					if (acepta == 1) {
						System.out.println("Compraste " + a + "\n");
						u.comprarPropuesta(a);
						a.restarCupo();
					}
				}
			}
			System.out.println("Gracias " + u.getNombre() + " por elegir y confiar en TierraMediaExpeditions.\n"
					+ "A continuación podrá observar su itinerario: \n" + "\nIntinerario de " + u.getNombre() + "\n");
			System.out.println(u.getItinerarioString());
			System.out.println("###########################\n");
		}
		scanner.close();
	}
}
