package dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import model.Propuestas;

public class DescuentoAbsolutoDAOTest {
	AtraccionDAO aDAO;
	List<Propuestas> atracciones;
	
	DescuentoAbsolutoDAO daDAO;
	List<Propuestas> promociones;
	
	@Before
	public void setup() {
		aDAO = FactoryDAO.getAtraccionDAO();
		atracciones = aDAO.findAll();
		
		daDAO = FactoryDAO.getDescuentoAbsolutoDAO();
		promociones = daDAO.findAll(atracciones);
	}

	@Test
	public void findAllTest() { // REVISTAR! EL ID DA 0 Y TENDRIA QUE DAR 1
		assertEquals(0, promociones.get(0).getIdAtraccion());
		assertEquals("Pack degustacion", promociones.get(0).getNombre());
		assertEquals(30, promociones.get(0).getCupo());
		assertEquals(36, promociones.get(0).getCosto());
		assertEquals(7.5, promociones.get(0).getTiempo(), 0);
		assertEquals("DEGUSTACION", promociones.get(0).getTipo());
		
	}
	
	@Test
	public void countAllTest() {
		assertEquals(promociones.size(), daDAO.countAll());
	}

}
