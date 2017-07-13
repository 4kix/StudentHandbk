package by.iba.courses.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import by.iba.courses.bean.Professor;

public class ProfessorDAOImpl implements ProfessorDAO {
	
	private final Connection connection;

    public ProfessorDAOImpl(Connection connection) {
        this.connection = connection;
    }

	@Override
	public Professor add(Professor professor) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Professor read(int key) throws DAOException {
		String sql = "SELECT * FROM professors WHERE id = ?";
		Professor professor= new Professor();
        try {
			PreparedStatement stm = connection.prepareStatement(sql);

			stm.setInt(1, key);

			ResultSet rs = stm.executeQuery();
			rs.next();
			
			professor.setId(rs.getInt(1));
			professor.setFirstName(rs.getString(2));
			professor.setSecondName(rs.getString(3));
			professor.setFatherName(rs.getString(4));
			professor.setBirthDate(rs.getString(5));
			professor.setAvgMark(rs.getDouble(6));
		} catch (SQLException e) {
			throw new DAOException(e);
		}
        return professor;
	}

	@Override
	public void update(Professor professor) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Professor professor) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Professor> getAll() throws DAOException {
		List<Professor> list = new ArrayList<Professor>();
		try {
			String sql = "SELECT * FROM professors";
			Statement s = connection.createStatement();
			s.executeQuery(sql);
			ResultSet rs = s.getResultSet();
			
			while(rs.next()) {
				Professor professor= new Professor();
			    professor.setId(rs.getInt(1));
			    professor.setFirstName(rs.getString(2));
			    professor.setSecondName(rs.getString(3));
			    professor.setFatherName(rs.getString(4));
			    professor.setBirthDate(rs.getString(5));
			    professor.setAvgMark(rs.getDouble(6));
			    list.add(professor);
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		}
		
		return list;
	}
	
	public void recalcAvgMark() throws DAOException {
		try {
			CallableStatement cstmt = connection.prepareCall("{call UPDATE_AVGMARK_NATIVE_SQL(2)}");
			//cstmt.setInt(1, 2);
			cstmt.executeQuery();
		} catch (SQLException e) {
			throw new DAOException(e);
		}
		
	}

}
