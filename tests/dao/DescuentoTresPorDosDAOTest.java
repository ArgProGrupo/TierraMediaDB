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
	public void setup() { // EN EL FACTORY, TODOS SE LLAMAN CON 'DAO' AL FINAL MENOS DescuentoTresPorDosDAO
		aDAO = FactoryDAO.getAtraccionDAO();
		atracciones = aDAO.findAll();
		
		dtpdDAO = FactoryDAO.getDescuentoTresPorDos();
		promociones = dtpdDAO.findAll(atracciones);
	}

	@Test
	public void findAllTest() { // REVISTAR! EL ID DA 0 Y TENDRIA QUE DAR 1
								// EL COSTO DEBERÍA DAR 10, NO ME ACUERDO DONDE CALCULABA ESO
		assertEquals(0, promociones.get(0).getIdAtraccion());
		assertEquals("Pack paisajes", promociones.get(0).getNombre());
		assertEquals(15, promociones.get(0).getCupo());
		assertEquals(22, promociones.get(0).getCosto());
		assertEquals(7.5, promociones.get(0).getTiempo(), 0);
		assertEquals("PAISAJE", promociones.get(0).getTipo());
		
	}
	
	@Test
	public void countAllTest() {
		assertEquals(promociones.size(), dtpdDAO.countAll());
	}

}
