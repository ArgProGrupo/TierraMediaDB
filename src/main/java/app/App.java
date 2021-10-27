package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.*;
import model.*;


public class App {
	public static void main(String[] args) throws SQLException {
//		UsuarioDAO usuarioDAO = FactoryDAO.getUsuarioDAO();
//		System.out.println(usuarioDAO.findAll());
//		System.out.println(usuarioDAO.findByIdUsuario(2));
//		System.out.println(usuarioDAO.findByNombre("Sam"));
//		System.out.println(usuarioDAO.findByTiempoDisponible(8.0));
//		System.out.println(usuarioDAO.findByTiempoDisponible(80.0));
//		System.out.println(usuarioDAO.findByPresupuesto(36));
//		UsuarioDAOImpl Sofi = new UsuarioDAOImpl ();
//		Usuario Facu = new Usuario ("Facu", 100, 1.0);
//		System.out.println(usuarioDAO.insert(Sofi));
//		System.out.println(Sofi.delete(6));
		
		AtraccionDAO atraccionDAO = FactoryDAO.getAtraccionDAO();
		List <Atraccion> atracciones = new ArrayList<Atraccion>();
		atracciones = atraccionDAO.findAll();// agregar una varriable y guardar en variable
		System.out.println(atracciones);
//		System.out.println(atraccionDAO.findByIdAtraccion(2));
//		System.out.println(atraccionDAO.findByNombre("Moria"));
//		System.out.println(atraccionDAO.findByCupo(25));
//		System.out.println(atraccionDAO.findByCosto(25));
//		System.out.println(atraccionDAO.findByTipo("AVENTURA"));
//		System.out.println(atraccionDAO.findByDuracion(6.5));
//		
		DescuentoAbsolutoDAO DescuentoAbsolutoDAO = FactoryDAO.getDescuentoAbsolutoDAO();
		List <Atraccion> descAb = new ArrayList<Atraccion>();
		descAb = DescuentoAbsolutoDAO.findAll(atracciones);
		System.out.println(descAb);

		DescuentoPorcentajeDAO DescuentoPorcentajeDAO = FactoryDAO.getDescuentoPorcentajeDAO();
		List <Atraccion> descPor = new ArrayList<Atraccion>();
		descPor = DescuentoPorcentajeDAO.findAll(atracciones);
		System.out.println(descPor);
		
		DescuentoTresPorDosDAO DescuentoTresPorDosDAO = FactoryDAO.getDescuentoTresPorDos();
		List <Atraccion> descAxB = new ArrayList<Atraccion>();
		descAxB = DescuentoTresPorDosDAO.findAll(atracciones);
		System.out.println(descAxB);
		
		System.out.println(DescuentoAbsolutoDAO.findAll());
		System.out.println(DescuentoPorcentajeDAO.findAll());
		System.out.println(DescuentoTresPorDosDAO.findAll());
	}
}
