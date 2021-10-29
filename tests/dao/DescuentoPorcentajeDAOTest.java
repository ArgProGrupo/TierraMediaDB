package dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import model.Propuestas;

public class DescuentoPorcentajeDAOTest {

	AtraccionDAO aDAO;
	List<Propuestas> atracciones;
	
	DescuentoPorcentajeDAO dpDAO;
	List<Propuestas> promociones;
	
	@Before
	public void setup() {
		aDAO = FactoryDAO.getAtraccionDAO();
		atracciones = aDAO.findAll();
		
		dpDAO = FactoryDAO.getDescuentoPorcentajeDAO();
		promociones = dpDAO.findAll(atracciones);
	}

	@Test
	public void findAllTest() { // REVISTAR! EL ID DA 0 Y TENDRIA QUE DAR 1
		assertEquals(0, promociones.get(0).getIdAtraccion());
		assertEquals("Pack aventura", promociones.get(0).getNombre());
		assertEquals(4, promociones.get(0).getCupo());
		assertEquals(23, promociones.get(0).getCosto());
		assertEquals(7, promociones.get(0).getTiempo(), 0);
		assertEquals("AVENTURA", promociones.get(0).getTipo());
		
	}
	
	@Test
	public void countAllTest() {
		assertEquals(promociones.size(), dpDAO.countAll());
	}

}
