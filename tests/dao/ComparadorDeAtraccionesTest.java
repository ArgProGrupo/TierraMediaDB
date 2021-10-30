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
	public void setup() {
						 
		uDAO = FactoryDAO.getUsuarioDAO();
		usuarios = uDAO.findAll();

		aDAO = FactoryDAO.getAtraccionDAO();
		atracciones = aDAO.findAll();

		daDAO = FactoryDAO.getDescuentoAbsolutoDAO();
		promocionAbs = daDAO.findAll(atracciones);

		dpDAO = FactoryDAO.getDescuentoPorcentajeDAO();
		promocionPorc = dpDAO.findAll(atracciones);

		dtpdDAO = FactoryDAO.getDescuentoTresPorDosDAO();
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
		
		// EOWYN
		assertEquals("Moria", usuarios.get(0).itinerarioUsuario.get(0).getNombre());
//		assertEquals("Bosque Negro", usuarios.get(0).itinerarioUsuario.get(1).getNombre());
		
		// GANDALF
		assertEquals("Erebor", usuarios.get(1).itinerarioUsuario.get(0).getNombre());
		
		// SAM
		assertEquals("Pack degustacion", usuarios.get(2).itinerarioUsuario.get(0).getNombre());
		
		// GALADRIEL
		assertEquals("Erebor", usuarios.get(3).itinerarioUsuario.get(0).getNombre());
		assertEquals("Minas Tirith", usuarios.get(3).itinerarioUsuario.get(1).getNombre());
		
	}

}
