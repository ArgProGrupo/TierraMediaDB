package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import jdbc.ConnectionProvider;
import model.Propuestas;
import model.Usuario;

public class UsuarioDAOImpl implements UsuarioDAO {

	private Usuario toUsuario(ResultSet result) {
		try {
			return new Usuario(result.getInt(1), result.getString(2), result.getString(3), result.getInt(4),
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

	/*public List<Propuestas> saveItinerario(Usuario u) throws SQLException {
		Connection conn;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);

			String query = "UPDATE USUARIO SET PRESUPUESTO = ?, TIEMPO_DISPONIBLE = ? WHERE ID_USUARIO = ?";
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setDouble(1, u.getPresupuesto());
			statement.setDouble(2, u.getTiempo());
			statement.setInt(3, u.getIdUsuario());
			statement.executeUpdate();

			for (Propuestas comprada : u.itinerarioUsuario) {
				String query2 = "INSERT INTO ITINERARIO (ID_USUARIO, ID_ATRACCION, ID_PROMOCION) VALUES (?, ?, ?)";
				Connection conn2 = ConnectionProvider.getConnection();
				PreparedStatement statement2 = conn2.prepareStatement(query2);
				statement2.setInt(1, u.getIdUsuario());
				statement2.setInt(2, comprada.getIdAtraccion());
				statement2.setInt(3, comprada.getIdPromocion());
				statement2.executeUpdate();

//			INSERT ITINERARIO
				String query3 = "UPDATE ATRACCION SET CUPO = ? WHERE ID_ATRACCION = ?";
				Connection conn3 = ConnectionProvider.getConnection();
				PreparedStatement statement3 = conn3.prepareStatement(query3);
				statement3.setInt(1, comprada.getCupo());
				statement3.setInt(2, comprada.getIdAtraccion());
				statement3.executeUpdate();
//			UPDATE ATRACCION
			}
		} catch (SQLException e) {
			conn.rollback();
		} finally {
			conn.commit();
		}
		return u.itinerarioUsuario;
	}*/

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

	public int delete(Integer t) {
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

	public Usuario findByIdUsuario(int idUsuario) {
		try {
			String query = "SELECT * FROM USUARIO WHERE ID_USUARIO = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setInt(1, idUsuario);

			ResultSet results = statement.executeQuery();

			Usuario usuario = null;
			if (results.next()) {
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

	public int delete(Usuario t) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	/*public List<Propuestas> saveItinerario(Usuario u) {
		Connection conn;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
		UPDATE USUARIO
		for (atraccion comprada) {
			INSERT ITINERARIO
			UPDATE ATRACCION
			}
		} catch (SQLException e) { 
			conn.rollback();
			} finnaly {
				conn.commit();
				}
			}*/
	
	public List<Propuestas> saveItinerario(Usuario u) throws SQLException {
		Connection conn;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);

			String query = "UPDATE USUARIO SET PRESUPUESTO = ?, TIEMPO_DISPONIBLE = ? WHERE ID_USUARIO = ?";
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setDouble(1, u.getPresupuesto());
			statement.setDouble(2, u.getTiempo());
			statement.setInt(3, u.getIdUsuario());
			statement.executeUpdate();

			for (Propuestas comprada : u.itinerarioUsuario) {
				String query2 = "INSERT INTO ITINERARIO (ID_USUARIO, ID_ATRACCION, ID_PROMOCION) VALUES (?, ?, ?)";
				PreparedStatement statement2 = conn.prepareStatement(query2);
				statement2.setInt(1, u.getIdUsuario());
				statement2.setInt(2, comprada.getIdAtraccion());
				statement2.setInt(3, comprada.getIdPromocion());
				statement2.executeUpdate();

//			INSERT ITINERARIO
				String query3 = "UPDATE ATRACCION SET CUPO = ? WHERE ID_ATRACCION = ?";
				PreparedStatement statement3 = conn.prepareStatement(query3);
				statement3.setInt(1, comprada.getCupo());
				statement3.setInt(2, comprada.getIdAtraccion());
				statement3.executeUpdate();
//			UPDATE ATRACCION
			}
		} catch (Exception e) {
			conn.rollback();
		} finally {
			conn.commit();
		}
		return u.itinerarioUsuario;
	}

}
