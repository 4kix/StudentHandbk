package by.iba.courses.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import by.iba.courses.bean.Mark;

public class MarkDAOImpl implements MarkDAO {
	
	private final Connection connection;

    public MarkDAOImpl(Connection connection) {
        this.connection = connection;
    }

	@Override
	public Mark add(Mark mark) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mark read(int key) throws DAOException {
		String sql = "SELECT * FROM marks WHERE id = ?";
		Mark mark = new Mark();
        try {
			PreparedStatement stm = connection.prepareStatement(sql);

			stm.setInt(1, key);

			ResultSet rs = stm.executeQuery();
			rs.next();
			
			mark.setId(rs.getInt(1));
			mark.setStudyId(rs.getInt(2));
			mark.setStudentId(rs.getInt(3));
			mark.setDate(rs.getString(4));	//date to string!!!
			mark.setProfessorId(rs.getInt(5));
			mark.setMark(rs.getInt(6));
			mark.setComments(rs.getString(7));
		} catch (SQLException e) {
			throw new DAOException(e);
		}    
        return mark;
        
	}

	@Override
	public void update(Mark mark) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Mark mark) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Mark> getAll() throws DAOException {
		List<Mark> list = new ArrayList<Mark>();
		try {
			String sql = "SELECT * FROM marks";
			Statement s = connection.createStatement();
			s.executeQuery(sql);
			ResultSet rs = s.getResultSet();
			
			while(rs.next()) {
				Mark mark = new Mark();
			    mark.setId(rs.getInt(1));
			    mark.setStudyId(rs.getInt(2));
			    mark.setStudentId(rs.getInt(3));
			    mark.setDate(rs.getString(4));	//date to string!!!
			    mark.setProfessorId(rs.getInt(5));
			    mark.setMark(rs.getInt(6));
			    mark.setComments(rs.getString(7));  
				list.add(mark);
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		}
		
		return list;
	}

}
