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

//		PromocionDAO promocionDAO = FactoryDAO.getPromocionDAO();
		UsuarioDAO usuarioDAO = FactoryDAO.getUsuarioDAO();
		DescuentoTresPorDosDAO DescuentoTresPorDosDAO = FactoryDAO.getDescuentoTresPorDosDAO();
		List<Propuestas> descAxB = new ArrayList<Propuestas>();
		DescuentoPorcentajeDAO DescuentoPorcentajeDAO = FactoryDAO.getDescuentoPorcentajeDAO();
		List<Propuestas> descPor = new ArrayList<Propuestas>();
		DescuentoAbsolutoDAO DescuentoAbsolutoDAO = FactoryDAO.getDescuentoAbsolutoDAO();
		List<Propuestas> descAb = new ArrayList<Propuestas>();

		AtraccionDAO atraccionDAO = FactoryDAO.getAtraccionDAO();

		propuestas = new ArrayList<Propuestas>();
		propuestas = atraccionDAO.findAll();

		descAxB = DescuentoTresPorDosDAO.findAll(propuestas);
		descPor = DescuentoPorcentajeDAO.findAll(propuestas);
		descAb = DescuentoAbsolutoDAO.findAll(propuestas);

		propuestas.addAll(descAb);
		propuestas.addAll(descPor);
		propuestas.addAll(descAxB);
		List<Usuario> usuarios = new LinkedList<Usuario>();

//		System.out.println(propuestas);
		usuarios = usuarioDAO.findAll();

		Scanner scanner = new Scanner(System.in);

		for (Usuario u : usuarios) {
			System.out.println("Bienvenido al sistema de autogesti�n de TierraMediaExpeditions!\n"
					+ "A continuaci�n podr� observar y elegir entre nuestra extensa lista de atracciones \nqu� propuesta es "
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
							.println("Si quer�s comprar esta propuesta marc� 1, " + "sino marc� cualquier otro n�mero");
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
					+ "A continuaci�n podr� observar su itinerario: \n" + "\nIntinerario de " + u.getNombre() + "\n");
			System.out.println(u.getItinerarioString());
			System.out.println("###########################\n");
		}
		scanner.close();
	}
}
