package dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import model.Atraccion;
import model.Propuestas;


public class AtraccionDAOTest {
	
	AtraccionDAO aDAO;
	Atraccion a1;
	Atraccion a2;
	List<Propuestas> atraccionesPropuestas;
	List<Atraccion> atracciones;
	
	@Before
	public void setup() {
		aDAO = FactoryDAO.getAtraccionDAO();
	}

	@Test
	public void findAllTest() {
		atraccionesPropuestas = aDAO.findAll();
		
		assertEquals(1, atraccionesPropuestas.get(0).getIdAtraccion());
		assertEquals(2, atraccionesPropuestas.get(1).getIdAtraccion());
		assertEquals(3, atraccionesPropuestas.get(2).getIdAtraccion());
		assertEquals(4, atraccionesPropuestas.get(3).getIdAtraccion());
		assertEquals(5, atraccionesPropuestas.get(4).getIdAtraccion());
		assertEquals(6, atraccionesPropuestas.get(5).getIdAtraccion());
		assertEquals(7, atraccionesPropuestas.get(6).getIdAtraccion());
		assertEquals(8, atraccionesPropuestas.get(7).getIdAtraccion());
		
		assertEquals("Moria", atraccionesPropuestas.get(0).getNombre());
		assertEquals("Minas Tirith", atraccionesPropuestas.get(1).getNombre());
		assertEquals("La Comarca", atraccionesPropuestas.get(2).getNombre());
		assertEquals("Mordor", atraccionesPropuestas.get(3).getNombre());
		assertEquals("Abismo de Helm", atraccionesPropuestas.get(4).getNombre());
		assertEquals("Lothlórien", atraccionesPropuestas.get(5).getNombre());
		assertEquals("Erebor", atraccionesPropuestas.get(6).getNombre());
		assertEquals("Bosque Negro", atraccionesPropuestas.get(7).getNombre());
		
		assertEquals(10, atraccionesPropuestas.get(0).getCosto());
		assertEquals(5, atraccionesPropuestas.get(1).getCosto());
		assertEquals(3, atraccionesPropuestas.get(2).getCosto());
		assertEquals(25, atraccionesPropuestas.get(3).getCosto());
		assertEquals(5, atraccionesPropuestas.get(4).getCosto());
		assertEquals(35, atraccionesPropuestas.get(5).getCosto());
		assertEquals(12, atraccionesPropuestas.get(6).getCosto());
		assertEquals(3, atraccionesPropuestas.get(7).getCosto());
		
		assertEquals(2, atraccionesPropuestas.get(0).getTiempo(), 0);
		assertEquals(2.5, atraccionesPropuestas.get(1).getTiempo(), 0);
		assertEquals(6.5, atraccionesPropuestas.get(2).getTiempo(), 0);
		assertEquals(3, atraccionesPropuestas.get(3).getTiempo(), 0);
		assertEquals(2, atraccionesPropuestas.get(4).getTiempo(), 0);
		assertEquals(1, atraccionesPropuestas.get(5).getTiempo(), 0);
		assertEquals(3, atraccionesPropuestas.get(6).getTiempo(), 0);
		assertEquals(4, atraccionesPropuestas.get(7).getTiempo(), 0);
		
		assertEquals("AVENTURA", atraccionesPropuestas.get(0).getTipo());
		assertEquals("PAISAJE", atraccionesPropuestas.get(1).getTipo());
		assertEquals("DEGUSTACION", atraccionesPropuestas.get(2).getTipo());
		assertEquals("AVENTURA", atraccionesPropuestas.get(3).getTipo());
		assertEquals("PAISAJE", atraccionesPropuestas.get(4).getTipo());
		assertEquals("DEGUSTACION", atraccionesPropuestas.get(5).getTipo());
		assertEquals("PAISAJE", atraccionesPropuestas.get(6).getTipo());
		assertEquals("AVENTURA", atraccionesPropuestas.get(7).getTipo());
	}

	@Test
	public void countAllTest() {
		atraccionesPropuestas = aDAO.findAll();
		assertEquals(atraccionesPropuestas.size(), aDAO.countAll());
	}
	
	@Test
	public void encuentraPorIdAtraccion() {
		a1 = aDAO.findByIdAtraccion(1);
		assertEquals(1, a1.getIdAtraccion());
		a2 = aDAO.findByIdAtraccion(7);
		assertEquals(7, a2.getIdAtraccion());
	}
	
	@Test
	public void encuentraPorNombre() {
		atracciones = aDAO.findByNombre("La Comarca");
		
		assertEquals(3, atracciones.get(0).getIdAtraccion());
		assertEquals("La Comarca", atracciones.get(0).getNombre());
		assertEquals(3, atracciones.get(0).getCosto());
		assertEquals(6.5, atracciones.get(0).getTiempo(), 0.001);
		assertEquals(150, atracciones.get(0).getCupo());
		assertEquals("DEGUSTACION", atracciones.get(0).getTipo());
		
	}
	
	@Test
	public void encuentraPorCosto() {
		atracciones = aDAO.findByCosto(5);
		
		assertEquals(2, atracciones.get(0).getIdAtraccion());
		assertEquals("Minas Tirith", atracciones.get(0).getNombre());
		assertEquals(5, atracciones.get(0).getCosto());
		assertEquals(2.5, atracciones.get(0).getTiempo(), 0.001);
		assertEquals(25, atracciones.get(0).getCupo());
		assertEquals("PAISAJE", atracciones.get(0).getTipo());
		
		assertEquals(5, atracciones.get(1).getIdAtraccion());
		assertEquals("Abismo de Helm", atracciones.get(1).getNombre());
		assertEquals(5, atracciones.get(1).getCosto());
		assertEquals(2, atracciones.get(1).getTiempo(), 0.001);
		assertEquals(15, atracciones.get(1).getCupo());
		assertEquals("PAISAJE", atracciones.get(1).getTipo());
	}
	
	@Test
	public void encuentraPorDuracion() {
		atracciones = aDAO.findByDuracion(2);
		
		assertEquals(1, atracciones.get(0).getIdAtraccion());
		assertEquals("Moria", atracciones.get(0).getNombre());
		assertEquals(10, atracciones.get(0).getCosto());
		assertEquals(2, atracciones.get(0).getTiempo(), 0.001);
		assertEquals(6, atracciones.get(0).getCupo());
		assertEquals("AVENTURA", atracciones.get(0).getTipo());
		
		assertEquals(5, atracciones.get(1).getIdAtraccion());
		assertEquals("Abismo de Helm", atracciones.get(1).getNombre());
		assertEquals(5, atracciones.get(1).getCosto());
		assertEquals(2, atracciones.get(1).getTiempo(), 0.001);
		assertEquals(15, atracciones.get(1).getCupo());
		assertEquals("PAISAJE", atracciones.get(1).getTipo());
	}
	
	@Test
	public void encuentraPorCupoDisponible() {
		atracciones = aDAO.findByCupo(12);
		
		assertEquals(8, atracciones.get(0).getIdAtraccion());
		assertEquals("Bosque Negro", atracciones.get(0).getNombre());
		assertEquals(3, atracciones.get(0).getCosto());
		assertEquals(4, atracciones.get(0).getTiempo(), 0.001);
		assertEquals(12, atracciones.get(0).getCupo());
		assertEquals("AVENTURA", atracciones.get(0).getTipo());
		
	}
	
	@Test
	public void encuentraPorTipoAtraccion() {
		atracciones = aDAO.findByTipo("AVENTURA");
		
		assertEquals(1, atracciones.get(0).getIdAtraccion());
		assertEquals("Moria", atracciones.get(0).getNombre());
		assertEquals(10, atracciones.get(0).getCosto());
		assertEquals(2, atracciones.get(0).getTiempo(), 0.001);
		assertEquals(6, atracciones.get(0).getCupo());
		assertEquals("AVENTURA", atracciones.get(0).getTipo());
		
		assertEquals(4, atracciones.get(1).getIdAtraccion());
		assertEquals("Mordor", atracciones.get(1).getNombre());
		assertEquals(25, atracciones.get(1).getCosto());
		assertEquals(3, atracciones.get(1).getTiempo(), 0.001);
		assertEquals(4, atracciones.get(1).getCupo());
		assertEquals("AVENTURA", atracciones.get(1).getTipo());
		
		assertEquals(8, atracciones.get(2).getIdAtraccion());
		assertEquals("Bosque Negro", atracciones.get(2).getNombre());
		assertEquals(3, atracciones.get(2).getCosto());
		assertEquals(4, atracciones.get(2).getTiempo(), 0.001);
		assertEquals(12, atracciones.get(2).getCupo());
		assertEquals("AVENTURA", atracciones.get(2).getTipo());
		
	}
	
	@Test
	public void insertaNuevaAtraccion() {
		a1 = new Atraccion("Laguna Antigua", 20, 4, 100, "PAISAJE");
		aDAO.insert(a1);
		
		assertEquals("Laguna Antigua", a1.getNombre());
		assertEquals(20, a1.getCosto());
		assertEquals(4, a1.getTiempo(), 0.001);
		assertEquals(100, a1.getCupo());
		assertEquals("PAISAJE", a1.getTipo());
		
		a2 = new Atraccion("Luna de los Lobos", 50, 3, 50, "AVENTURA");
		aDAO.insert(a2);
		
		assertEquals("Luna de los Lobos", a2.getNombre());
		assertEquals(50, a2.getCosto());
		assertEquals(3, a2.getTiempo(), 0.001);
		assertEquals(50, a2.getCupo());
		assertEquals("AVENTURA", a2.getTipo());
	}
	
	@Test
	public void eliminaAtraccionPorId() {
		a1 = new Atraccion(9);
		aDAO.delete(a1);
		
		assertEquals(9, a1.getIdAtraccion());
		assertNull(a1.getNombre());
		assertEquals(0, a1.getCosto());
		assertEquals(0, a1.getTiempo(), 0.001);
		assertEquals(0, a1.getCupo());
		assertNull(a1.getTipo());
	
	}
	
}
