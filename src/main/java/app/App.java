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

		UsuarioDAO usuarioDAO = FactoryDAO.getUsuarioDAO();
		PromocionDAO promocionDAO = FactoryDAO.getPromocionDAO();
		AtraccionDAO atraccionDAO = FactoryDAO.getAtraccionDAO();
		List<Propuestas> desc = new ArrayList<Propuestas>();
		propuestas = new ArrayList<Propuestas>();
		List<Usuario> usuarios = new LinkedList<Usuario>();

		propuestas = atraccionDAO.findAll();
		desc = promocionDAO.findAll(propuestas);
		propuestas.addAll(desc);
		usuarios = usuarioDAO.findAll();

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
					System.out.println(
							"Si quieres comprar esta propuesta marca 1, " + "sino marca cualquier otro número");
					int acepta = scanner.nextInt();
					if (acepta == 1) {
						System.out.println("Compraste " + a + "\n");
						u.comprarPropuesta(a);
						a.restarCupo();
					}
				}
			}
			usuarioDAO.saveItinerario(u);
			System.out.println("Gracias " + u.getNombre() + " por elegir y confiar en TierraMediaExpeditions.\n"
					+ "A continuación podrá observar su itinerario: \n" + "\nIntinerario de " + u.getNombre() + "\n");
			System.out.println(u.getItinerarioString());
			System.out.println("###########################\n");
		}
		scanner.close();
	}
}
