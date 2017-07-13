package by.iba.courses.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import by.iba.courses.bean.Study;

public class StudyDAOImpl implements StudyDAO {
	
	private final Connection connection;

    public StudyDAOImpl(Connection connection) {
        this.connection = connection;
    }

	@Override
	public Study add(Study study) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Study read(int key) throws DAOException {
		String sql = "SELECT * FROM studies WHERE id = ?";
		Study study = new Study();
		try {
			PreparedStatement stm = connection.prepareStatement(sql);
			stm.setInt(1, key);
			ResultSet rs = stm.executeQuery();
			rs.next();
			
			study.setId(rs.getInt(1));
			study.setName(rs.getString(2));
			study.setHours(rs.getInt(3));
			study.setProfessorId(rs.getInt(4));
			study.setAvgMark(rs.getDouble(5));
		} catch (SQLException e) {
			throw new DAOException(e);
		}
        return study;
	}

	@Override
	public void update(Study study) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Study study) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Study> getAll() throws DAOException {
		List<Study> list = new ArrayList<Study>();
		try {
			String sql = "SELECT * FROM studies";
			Statement s = connection.createStatement();
			s.executeQuery(sql);
			ResultSet rs = s.getResultSet();
			
			while(rs.next()) {
			    Study study = new Study();
			    study.setId(rs.getInt(1));
			    study.setName(rs.getString(2));
			    study.setHours(rs.getInt(3));
			    study.setProfessorId(rs.getInt(4));
			    study.setAvgMark(rs.getDouble(5));
				list.add(study);
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		}		
		return list;
	}

	public void recalcAvgMark() throws DAOException {
		try {
			CallableStatement cstmt = connection.prepareCall("{call UPDATE_AVGMARK_NATIVE_SQL(3)}");
			//cstmt.setInt(1, 2);
			cstmt.executeQuery();
		} catch (SQLException e) {
			throw new DAOException(e);
		}
		
	}
}
