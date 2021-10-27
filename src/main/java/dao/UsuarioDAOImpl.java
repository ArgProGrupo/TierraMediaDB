package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import jdbc.ConnectionProvider;
import model.Usuario;

public class UsuarioDAOImpl implements UsuarioDAO {
	
	private Usuario toUsuario(ResultSet result) {
		try {
			return new Usuario(
					result.getInt(1),
					result.getString(2),
					result.getString(3),
					result.getInt(4),
					result.getDouble(5));
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
		
	}

	public List<Usuario> findAll() {
		try {
			String query = "SELECT * FROM USUARIO";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(query);
			ResultSet results = statement.executeQuery();
			
			List<Usuario> usuarios = new LinkedList<Usuario>();
			while (results.next()) {
				usuarios.add(toUsuario(results));
			}
			return usuarios;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	public int countAll() {
		try {
			String query = "SELECT COUNT(1) AS TOTAL FROM USUARIO";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(query);
			ResultSet results = statement.executeQuery();
			
			results.next();
			
			int total = results.getInt("TOTAL");
			
			return total;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	public int insert(Usuario t) {
		try {
			String query = "INSERT INTO USUARIO (NOMBRE, TIPO_FAVORITO, PRESUPUESTO, TIEMPO_DISPONIBLE) VALUES (?, ?, ?, ?)";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, t.getNombre());
			statement.setString(2, t.getTipoAtraccionFavorita());
			statement.setDouble(3, t.getPresupuesto());
			statement.setDouble(4, t.getTiempo());
			
			int rows = statement.executeUpdate();
			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	public int update(Usuario t) {
		try {
			String query = "UPDATE USUARIO SET PRESUPUESTO = ?, TIEMPO_DISPONIBLE = ? WHERE ID_USUARIO = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setDouble(1, t.getPresupuesto());
			statement.setDouble(2, t.getTiempo());
			statement.setInt(3, t.getIdUsuario());
			
			int rows = statement.executeUpdate();
			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	public int delete(Usuario t) {
		try {
			String query = "DELETE FROM USUARIO WHERE ID_USUARIO = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(query);

			statement.setInt(1, t.getIdUsuario());
			
			int rows = statement.executeUpdate();
			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	public Usuario findByIdUsuario(int idUsuario) {
		try {
			String query = "SELECT * FROM USUARIO WHERE ID_USUARIO = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setInt(1, idUsuario);

			ResultSet results = statement.executeQuery();
			
			Usuario usuario = null;
			if(results.next()) {
				usuario = toUsuario(results);
			}
			return usuario;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	public List<Usuario> findByNombre(String nombre) {
		try {
			String query = "SELECT * FROM USUARIO WHERE NOMBRE = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, nombre);

			ResultSet results = statement.executeQuery();
			
			List<Usuario> usuarios = new LinkedList<Usuario>();
			while (results.next()) {
				usuarios.add(toUsuario(results));
			}
			return usuarios;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}
	
	public List<Usuario> findByTipoFavorito(String atraccionFavorita) {
		try {
			String query = "SELECT * FROM USUARIO WHERE TIPO_FAVORITO = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, atraccionFavorita);

			ResultSet results = statement.executeQuery();
			
			List<Usuario> usuarios = new LinkedList<Usuario>();
			while (results.next()) {
				usuarios.add(toUsuario(results));
			}
			return usuarios;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	public List<Usuario> findByPresupuesto(int presupuesto) {
		try {
			String query = "SELECT * FROM USUARIO WHERE PRESUPUESTO = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setInt(1, presupuesto);

			ResultSet results = statement.executeQuery();
			
			List<Usuario> usuarios = new LinkedList<Usuario>();
			while (results.next()) {
				usuarios.add(toUsuario(results));
			}
			return usuarios;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	public List<Usuario> findByTiempoDisponible(double tiempoDisponible) {
		try {
			String query = "SELECT * FROM USUARIO WHERE TIEMPO_DISPONIBLE = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setDouble(1, tiempoDisponible);

			ResultSet results = statement.executeQuery();
			
			List<Usuario> usuarios = new LinkedList<Usuario>();
			while (results.next()) {
				usuarios.add(toUsuario(results));
			}
			return usuarios;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}
	
	public int deleteById(int t) {
		try {
			String query = "DELETE FROM USUARIO WHERE ID_USUARIO = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(query);

			statement.setInt(1, t);
			
			int rows = statement.executeUpdate();
			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

}
