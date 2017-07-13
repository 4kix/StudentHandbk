package by.iba.courses.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import by.iba.courses.bean.User;

public class UserDAOImpl implements UserDAO {

	private final Connection connection;

    public UserDAOImpl(Connection connection) {
        this.connection = connection;
    }

	@Override
	public String add(User user) throws DAOException {
		try {
			String sql = "INSERT INTO lapusha.users (USER, PASSWORD, ROLE) VALUES (?, ?, ?)";
			PreparedStatement stm = connection.prepareStatement(sql);
			
			stm.setString(1, user.getUser());
			stm.setString(2, user.getPassword());
			stm.setString(3, user.getRole().toString());
			
			stm.executeUpdate();
			stm.close();
		} catch (SQLIntegrityConstraintViolationException e) {
			return "Key Constraint Error";
		}
		catch (SQLException e) {
			throw new DAOException(e);
		}
		return "Success!";
	}

	@Override
	public User read(String key) throws DAOException {
		
		User user;
		try {
			String sql = "SELECT * FROM lapusha.users WHERE user = ?";
			PreparedStatement stm = connection.prepareStatement(sql);

			stm.setString(1, key);

			ResultSet rs = stm.executeQuery();
			rs.next();
			user = new User();
			user.setUser(rs.getString(1));
			user.setPassword(rs.getString(2));
			user.setRole(User.Role.valueOf(rs.getString(3)));
			
			rs.close();
			stm.close();
		} catch (SQLException e) {
			throw new DAOException(e);
		}
        return user;
	}

	@Override
	public void update(String id, User user) throws DAOException {
		String sql = "UPDATE lapusha.users SET USER= ?, PASSWORD= ?, ROLE= ? WHERE USER= ?";
		try {
			PreparedStatement s = connection.prepareStatement(sql);
			
			s.setString(1, user.getUser());
			s.setString(2, user.getPassword());
			s.setString(3, user.getRole().toString());
			s.setString(4, id);
			
			s.executeUpdate();
			s.close();
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					throw new DAOException(e);
				}
			}
		}
	}

	@Override
	public void delete(String id, User user) throws DAOException {
		String sql = "DELETE FROM lapusha.users WHERE USER = ?;";
		PreparedStatement stm;
		try {
			stm = connection.prepareStatement(sql);
			stm.setString(1, id);
			stm.executeUpdate();
			stm.close();
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					throw new DAOException(e);
				}
			}
		}
        
	}

	@Override
	public List<User> getAll() throws DAOException {
		
		List<User> list = new ArrayList<User>();
		String sql = "SELECT * FROM lapusha.users";
		try {
			Statement s = connection.createStatement();
			ResultSet rs;
			s.executeQuery(sql);
			rs = s.getResultSet();
			
			while (rs.next()) {
				User user = new User();
			    user.setUser(rs.getString(1));
			    user.setPassword(rs.getString(2));
			    user.setRole(User.Role.valueOf(rs.getString(3).toLowerCase()));
			    list.add(user);
			}
			rs.close();
			s.close();
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					throw new DAOException(e);
				}
			}
		}
        return list;
	}

	@Override
	public User authCheck(String login, String password) throws DAOException {
		
		String sql = String.format("SELECT USER,ROLE FROM lapusha.users where (USER = ? and PASSWORD = ?)", login, password);
		// "SELECT \"USER\",ROLE FROM lapusha.users where (\"USER\" = '%s' and PASSWORD = '%s')
		User user = new User();
		PreparedStatement s = null;
		ResultSet rs = null;
		try {
			 s = connection.prepareStatement(sql);
			
			s.setString(1, login);
			s.setString(2, password);
			
			rs = s.executeQuery();
			if(rs.next()) {
			
			user.setUser(rs.getString(1));
			user.setRole(User.Role.valueOf(rs.getString(2).toLowerCase()));
			return user;
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
		try {
			if (connection!= null) {
			connection.close();
			}
			if (s != null) {
				s.close();
			}
			
		} catch (SQLException e) {
			throw new DAOException(e);
		}
			
		}
		return null;  
	}

	

}
