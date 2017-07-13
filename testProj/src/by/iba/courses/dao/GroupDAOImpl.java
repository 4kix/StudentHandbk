package by.iba.courses.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import by.iba.courses.bean.Group;

public class GroupDAOImpl implements GroupDAO {
	
	private final Connection connection;

    public GroupDAOImpl(Connection connection) {
        this.connection = connection;
    }

	@Override
	public Group add(Group group) throws DAOException {
		try {
			String sql = "INSERT INTO lapusha.groups (GROUP_NUMBER, AVG_MARK) VALUES (?, ?)";
			PreparedStatement stm = connection.prepareStatement(sql);
			
			stm.setInt(1, group.getGroupNumber());
			stm.setDouble(2, 0.0);
			
			stm.executeUpdate();
			stm.close();
		} catch (SQLException e) {
			throw new DAOException(e);
		}
		return null;
	}

	@Override
	public Group read(int key) throws DAOException {
		Group group = new Group();
		
		try {
			String sql = "SELECT * FROM groups WHERE group_number = ?";
			PreparedStatement stm = connection.prepareStatement(sql);

			stm.setInt(1, key);

			ResultSet rs = stm.executeQuery();
			rs.next();
			group.setGroupNumber(rs.getInt(1));
			group.setAvgMark(rs.getDouble(2));
		} catch (SQLException e) {
			throw new DAOException(e);
		}
        return group;
	}

	@Override
	public void update(Group group) throws DAOException {
		try {
			String sql = "UPDATE lapusha.groups SET GROUP_NUMBER = ?,  AVG_MARK= ? WHERE GROUP_NUMBER= ?";
			PreparedStatement s = connection.prepareStatement(sql);
			
			s.setInt(1, group.getGroupNumber());
			s.setDouble(2, group.getAvgMark());
			s.setInt(3, group.getGroupNumber());
			
			s.executeUpdate();
			s.close();
		} catch (SQLException e) {
			throw new DAOException(e);
		}

	}

	@Override
	public void delete(Group group) throws DAOException {
		String sql = "DELETE FROM lapusha.groups WHERE GROUP_NUMBER = ?";
		PreparedStatement stm;
		try {
			stm = connection.prepareStatement(sql);
			stm.setInt(1, group.getGroupNumber());
			stm.executeUpdate();
			stm.close();
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	@Override
	public List<Group> getAll() throws DAOException {
		
		List<Group> list = new ArrayList<Group>();
		try {
			String sql = "SELECT * FROM groups";
			Statement s = connection.createStatement();
			s.executeQuery(sql);
			ResultSet rs = s.getResultSet();
			
			while(rs.next()) {
				Group group = new Group();
				group.setGroupNumber(rs.getInt(1));
				group.setAvgMark(rs.getDouble(2));
				list.add(group);
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		}
		
		return list;
	}

}
