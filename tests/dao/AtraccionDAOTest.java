package dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import model.Propuestas;

public class AtraccionDAOTest {
	AtraccionDAO aDAO;
	List<Propuestas> atracciones;
	
	@Before
	public void setup() {
		aDAO = FactoryDAO.getAtraccionDAO();
		atracciones = aDAO.findAll();
	}

	@Test
	public void findAllTest() {
		
		assertEquals(1, atracciones.get(0).getIdAtraccion());
		assertEquals(2, atracciones.get(1).getIdAtraccion());
		assertEquals(3, atracciones.get(2).getIdAtraccion());
		assertEquals(4, atracciones.get(3).getIdAtraccion());
		assertEquals(5, atracciones.get(4).getIdAtraccion());
		assertEquals(6, atracciones.get(5).getIdAtraccion());
		assertEquals(7, atracciones.get(6).getIdAtraccion());
		assertEquals(8, atracciones.get(7).getIdAtraccion());
		
		assertEquals("Moria", atracciones.get(0).getNombre());
		assertEquals("Minas Tirith", atracciones.get(1).getNombre());
		assertEquals("La Comarca", atracciones.get(2).getNombre());
		assertEquals("Mordor", atracciones.get(3).getNombre());
		assertEquals("Abismo de Helm", atracciones.get(4).getNombre());
		assertEquals("Lothlórien", atracciones.get(5).getNombre());
		assertEquals("Erebor", atracciones.get(6).getNombre());
		assertEquals("Bosque Negro", atracciones.get(7).getNombre());
		
		assertEquals(10, atracciones.get(0).getCosto());
		assertEquals(5, atracciones.get(1).getCosto());
		assertEquals(3, atracciones.get(2).getCosto());
		assertEquals(25, atracciones.get(3).getCosto());
		assertEquals(5, atracciones.get(4).getCosto());
		assertEquals(35, atracciones.get(5).getCosto());
		assertEquals(12, atracciones.get(6).getCosto());
		assertEquals(3, atracciones.get(7).getCosto());
		
		assertEquals(2, atracciones.get(0).getTiempo(), 0);
		assertEquals(2.5, atracciones.get(1).getTiempo(), 0);
		assertEquals(6.5, atracciones.get(2).getTiempo(), 0);
		assertEquals(3, atracciones.get(3).getTiempo(), 0);
		assertEquals(2, atracciones.get(4).getTiempo(), 0);
		assertEquals(1, atracciones.get(5).getTiempo(), 0);
		assertEquals(3, atracciones.get(6).getTiempo(), 0);
		assertEquals(4, atracciones.get(7).getTiempo(), 0);
		
		assertEquals("AVENTURA", atracciones.get(0).getTipo());
		assertEquals("PAISAJE", atracciones.get(1).getTipo());
		assertEquals("DEGUSTACION", atracciones.get(2).getTipo());
		assertEquals("AVENTURA", atracciones.get(3).getTipo());
		assertEquals("PAISAJE", atracciones.get(4).getTipo());
		assertEquals("DEGUSTACION", atracciones.get(5).getTipo());
		assertEquals("PAISAJE", atracciones.get(6).getTipo());
		assertEquals("AVENTURA", atracciones.get(7).getTipo());
	}

	@Test
	public void countAllTest() {
		assertEquals(atracciones.size(), aDAO.countAll());
	}
	
}
