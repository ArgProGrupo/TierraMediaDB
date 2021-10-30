package dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import model.Propuestas;

public class DescuentoTresPorDosDAOTest {

	AtraccionDAO aDAO;
	List<Propuestas> atracciones;
	
	DescuentoTresPorDosDAO dtpdDAO;
	List<Propuestas> promociones;
	
	@Before
	public void setup() {
		aDAO = FactoryDAO.getAtraccionDAO();
		atracciones = aDAO.findAll();
		
		dtpdDAO = FactoryDAO.getDescuentoTresPorDosDAO();
		promociones = dtpdDAO.findAll(atracciones);
	}

	@Test
	public void findAllTest() {
		assertEquals(0, promociones.get(0).getIdAtraccion());
		assertEquals("Pack paisajes", promociones.get(0).getNombre());
		assertEquals(15, promociones.get(0).getCupo());
		assertEquals(10, promociones.get(0).getCosto());
		assertEquals(7.5, promociones.get(0).getTiempo(), 0);
		assertEquals("PAISAJE", promociones.get(0).getTipo());
		
	}
	
	@Test
	public void countAllTest() {
		assertEquals(promociones.size(), dtpdDAO.countAll());
	}

}
