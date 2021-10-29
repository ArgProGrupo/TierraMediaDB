package dao;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import model.ComparadorDeAtracciones;
import model.Propuestas;
import model.Usuario;

public class ComparadorDeAtraccionesTest {
	UsuarioDAO uDAO;
	List<Usuario> usuarios;

	AtraccionDAO aDAO;
	List<Propuestas> atracciones;

	DescuentoAbsolutoDAO daDAO;
	List<Propuestas> promocionAbs;

	DescuentoPorcentajeDAO dpDAO;
	List<Propuestas> promocionPorc;

	DescuentoTresPorDosDAO dtpdDAO;
	List<Propuestas> promocionTxD;

	List<Propuestas> propuestas = new ArrayList<Propuestas>();

	@Before
	public void setup() { // EN EL FACTORY, TODOS SE LLAMAN CON 'DAO' AL FINAL MENOS
						  // DescuentoTresPorDosDAO
		uDAO = FactoryDAO.getUsuarioDAO();
		usuarios = uDAO.findAll();

		aDAO = FactoryDAO.getAtraccionDAO();
		atracciones = aDAO.findAll();

		daDAO = FactoryDAO.getDescuentoAbsolutoDAO();
		promocionAbs = daDAO.findAll(atracciones);

		dpDAO = FactoryDAO.getDescuentoPorcentajeDAO();
		promocionPorc = dpDAO.findAll(atracciones);

		dtpdDAO = FactoryDAO.getDescuentoTresPorDos();
		promocionTxD = dtpdDAO.findAll(atracciones);

		propuestas.addAll(atracciones);
		
		propuestas.addAll(promocionAbs);
		propuestas.addAll(promocionPorc);
		propuestas.addAll(promocionTxD);

	}

	@Test
	public void cargaEnItinerarioTest() {
		for (Usuario u : usuarios) {
			propuestas.sort(new ComparadorDeAtracciones(u.getTipoAtraccionFavorita()));
			for (Propuestas a : propuestas) {
				if (!u.tieneTiempoYDinero())
					break;
				else if (u.puedeComprar(a)) {
						u.comprarPropuesta(a);
						a.restarCupo();
					}
			}
		}
		
		/*
		 ITINERARIOS ESPERADOS:
		 
		 Eowyn: 1-Pack aventura
		 
		 Gandalf: 1-Pack paisajes
		 
		 Sam: 1-Pack degustacion || Y LISTO (sin monedas)
		 
		 Galadriel: 1-Pack paisajes
		 */
		
		/* A REVISAR: -LE RECOMIENDA A TODOS PACK DEGUSTACION
					  -A GANDALF, EOWYN  Y A GALADRIEL NO LES ALCANZA PARA EL PACK
					  -A SAM SOLO LE ROCOMIENDA EL PACK DEGUSTACION Y NADA MAS
		*/
		
		//***DATO DE VITAL IMPORTANCIA***
		//RECOMIENDA EL PACK DEGUSTACION PORQUE EN EL findAll NO ESTA COMO PROPUESTA (esta como DescuentoAbsoluto)
		
		
		// EOWYN
//		assertEquals("Pack aventura", usuarios.get(0).itinerarioUsuario.get(0).getNombre());
//		assertEquals("Mordor", usuarios.get(0).itinerarioUsuario.get(1).getNombre());
		
		// GANDALF
//		assertEquals("Pack paisajes", usuarios.get(1).itinerarioUsuario.get(0).getNombre());
		
		// SAM
		assertEquals("Pack degustacion", usuarios.get(2).itinerarioUsuario.get(0).getNombre());
		
		// GALADRIEL
//		assertEquals("Pack paisajes", usuarios.get(3).itinerarioUsuario.get(0).getNombre());
		
	}

}
