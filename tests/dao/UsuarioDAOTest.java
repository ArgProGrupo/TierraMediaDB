package dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import model.Usuario;

public class UsuarioDAOTest {

	UsuarioDAO usuarioDAO;
	Usuario u1;
	Usuario u2;
	Usuario u3;
	List<Usuario> usuarios;
	
	@Before
	public void setup() {
		usuarioDAO = FactoryDAO.getUsuarioDAO();
	}

	@Test
	public void findAllTest() {
		usuarios = usuarioDAO.findAll();

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
		usuarios = usuarioDAO.findAll();
		assertEquals(usuarios.size(), usuarioDAO.countAll());
	}
	
	@Test
	public void encuentraPorIdUsuario() {
		u1 = usuarioDAO.findByIdUsuario(1);
		assertEquals(1, u1.getIdUsuario());
		u2 = usuarioDAO.findByIdUsuario(3);
		assertEquals(3, u2.getIdUsuario());
		u3 = usuarioDAO.findByIdUsuario(4);
		assertEquals(4, u3.getIdUsuario());
		
	}
	
	@Test
	public void encuentraPorNombreUsuario() {
		usuarios = usuarioDAO.findByNombre("Facu");
		
		assertEquals(5, usuarios.get(0).getIdUsuario());
		assertEquals("Facu", usuarios.get(0).getNombre());
		assertEquals(100, usuarios.get(0).getPresupuesto(), 0);
		assertEquals(1, usuarios.get(0).getTiempo(), 0);
		assertEquals("AVENTURA", usuarios.get(0).getTipoAtraccionFavorita());
		
		assertEquals(7, usuarios.get(1).getIdUsuario());
		assertEquals("Facu", usuarios.get(1).getNombre());
		assertEquals(150, usuarios.get(1).getPresupuesto(), 0);
		assertEquals(3, usuarios.get(1).getTiempo(), 0);
		assertEquals("DEGUSTACION", usuarios.get(1).getTipoAtraccionFavorita());
		
	}
	
	@Test
	public void encuentraPorAtraccionFavorita() {
		usuarios = usuarioDAO.findByTipoFavorito("PAISAJE");
		
		assertEquals(2, usuarios.get(0).getIdUsuario());
		assertEquals("Gandalf", usuarios.get(0).getNombre());
		assertEquals(100, usuarios.get(0).getPresupuesto(), 0);
		assertEquals(5, usuarios.get(0).getTiempo(), 0);
		assertEquals("PAISAJE", usuarios.get(0).getTipoAtraccionFavorita());
		
		assertEquals(4, usuarios.get(1).getIdUsuario());
		assertEquals("Galadriel", usuarios.get(1).getNombre());
		assertEquals(120, usuarios.get(1).getPresupuesto(), 0);
		assertEquals(6, usuarios.get(1).getTiempo(), 0);
		assertEquals("PAISAJE", usuarios.get(1).getTipoAtraccionFavorita());
		
		assertEquals(6, usuarios.get(2).getIdUsuario());
		assertEquals("Calel", usuarios.get(2).getNombre());
		assertEquals(120, usuarios.get(2).getPresupuesto(), 0);
		assertEquals(1, usuarios.get(2).getTiempo(), 0);
		assertEquals("PAISAJE", usuarios.get(2).getTipoAtraccionFavorita());
		
	}
	
	@Test
	public void encuentraPorTiempoDisponible() {
		usuarios = usuarioDAO.findByTiempoDisponible(8.0);
		
		assertEquals(1, usuarios.get(0).getIdUsuario());
		assertEquals("Eowyn", usuarios.get(0).getNombre());
		assertEquals(10, usuarios.get(0).getPresupuesto(), 0);
		assertEquals(8, usuarios.get(0).getTiempo(), 0);
		assertEquals("AVENTURA", usuarios.get(0).getTipoAtraccionFavorita());
		
		assertEquals(3, usuarios.get(1).getIdUsuario());
		assertEquals("Sam", usuarios.get(1).getNombre());
		assertEquals(36, usuarios.get(1).getPresupuesto(), 0);
		assertEquals(8, usuarios.get(1).getTiempo(), 0);
		assertEquals("DEGUSTACION", usuarios.get(1).getTipoAtraccionFavorita());
	}
	
	@Test
	public void encuentraPorPresupuesto() {
		usuarios = usuarioDAO.findByPresupuesto(120);
		
		assertEquals(4, usuarios.get(0).getIdUsuario());
		assertEquals("Galadriel", usuarios.get(0).getNombre());
		assertEquals(120, usuarios.get(0).getPresupuesto(), 0);
		assertEquals(6, usuarios.get(0).getTiempo(), 0);
		assertEquals("PAISAJE", usuarios.get(0).getTipoAtraccionFavorita());
		
		assertEquals(6, usuarios.get(1).getIdUsuario());
		assertEquals("Calel", usuarios.get(1).getNombre());
		assertEquals(120, usuarios.get(1).getPresupuesto(), 0);
		assertEquals(1, usuarios.get(1).getTiempo(), 0);
		assertEquals("PAISAJE", usuarios.get(1).getTipoAtraccionFavorita());
	}
	
	@Test
	public void registraNuevoUsuario() {
		u1 = new Usuario("Sofi", "AVENTURA", 310, 7.0);
		usuarioDAO.insert(u1);
		assertEquals("Sofi", u1.getNombre());
		assertEquals("AVENTURA", u1.getTipoAtraccionFavorita());
		assertEquals(310, u1.getPresupuesto(), 0);
		assertEquals(7, u1.getTiempo(), 0);
		
		u2 = new Usuario("Alvaro", "PAISAJE", 300, 8.0);
		usuarioDAO.insert(u2);
		assertEquals("Alvaro", u2.getNombre());
		assertEquals("PAISAJE", u2.getTipoAtraccionFavorita());
		assertEquals(300, u2.getPresupuesto(), 0);
		assertEquals(8, u2.getTiempo(), 0);
	}
	
	@Test
	public void deleteaUsuarioPorId() {
		u1 = new Usuario(8);
		usuarioDAO.delete(u1);
		assertEquals(8, u1.getIdUsuario());
		assertNull(u1.getNombre());
		assertNull(u1.getTipoAtraccionFavorita());
		assertEquals(0, u1.getPresupuesto(), 0);
		assertEquals(0, u1.getTiempo(), 0);
		
	}

}
