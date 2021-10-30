package dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import model.Usuario;

public class UsuarioDAOTest {

	UsuarioDAO uDAO;
	List<Usuario> usuarios;
	
	@Before
	public void setup() {
		uDAO = FactoryDAO.getUsuarioDAO();
		usuarios = uDAO.findAll();
	}

	@Test
	public void findAllTest() {
		assertEquals(1, usuarios.get(0).getIdUsuario());
		assertEquals(2, usuarios.get(1).getIdUsuario());
		assertEquals(3, usuarios.get(2).getIdUsuario());
		assertEquals(4, usuarios.get(3).getIdUsuario());
		
		assertEquals(10, usuarios.get(0).getPresupuesto(), 0);
		assertEquals(100, usuarios.get(1).getPresupuesto(), 0);
		assertEquals(36, usuarios.get(2).getPresupuesto(), 0);
		assertEquals(120, usuarios.get(3).getPresupuesto(), 0);
		
		assertEquals(8, usuarios.get(0).getTiempo(), 0);
		assertEquals(5, usuarios.get(1).getTiempo(), 0);
		assertEquals(8, usuarios.get(2).getTiempo(), 0);
		assertEquals(6, usuarios.get(3).getTiempo(), 0);
		
		assertEquals("Eowyn", usuarios.get(0).getNombre());
		assertEquals("Gandalf", usuarios.get(1).getNombre());
		assertEquals("Sam", usuarios.get(2).getNombre());
		assertEquals("Galadriel", usuarios.get(3).getNombre());
		
		assertEquals("AVENTURA", usuarios.get(0).getTipoAtraccionFavorita());
		assertEquals("PAISAJE", usuarios.get(1).getTipoAtraccionFavorita());
		assertEquals("DEGUSTACION", usuarios.get(2).getTipoAtraccionFavorita());
		assertEquals("PAISAJE", usuarios.get(3).getTipoAtraccionFavorita());		
	}
	
	@Test
	public void countAllTest() {
		assertEquals(usuarios.size(), uDAO.countAll());
	}

}
