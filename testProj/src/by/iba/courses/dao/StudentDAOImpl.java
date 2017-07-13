package by.iba.courses.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import by.iba.courses.bean.Student;

public class StudentDAOImpl implements StudentDAO {
	
	private final Connection connection;

    public StudentDAOImpl(Connection connection) {
        this.connection = connection;
    }

	@Override
	public Student add(Student student) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student read(int key) throws DAOException {
		String sql = "SELECT * FROM students WHERE id = ?";
		Student student= new Student();
        try {
			PreparedStatement stm = connection.prepareStatement(sql);

			stm.setInt(1, key);

			ResultSet rs = stm.executeQuery();
			rs.next();
			
			student.setId(rs.getInt(1));
			student.setFirstName(rs.getString(2));
			student.setSecondName(rs.getString(3));
			student.setAvgMark(rs.getDouble(4));
			student.setGroupNumber(rs.getInt(5));
		} catch (SQLException e) {
			throw new DAOException(e);
		}
        return student;
	}

	@Override
	public void update(Student student) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Student student) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Student> getAll() throws DAOException {
		List<Student> list = new ArrayList<Student>();
		try {
			String sql = "SELECT * FROM students";
			Statement s = connection.createStatement();
			s.executeQuery(sql);
			ResultSet rs = s.getResultSet();
			
			while(rs.next()) {
				Student student = new Student();
				student.setId(rs.getInt(1));
			    student.setFirstName(rs.getString(2));
			    student.setSecondName(rs.getString(3));
			    student.setAvgMark(rs.getDouble(4));
			    student.setGroupNumber(rs.getInt(5));
				list.add(student);
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		}
		
		return list;
	}

	public void recalcAvgMark() throws DAOException {
		try {
			CallableStatement cstmt = connection.prepareCall("{call UPDATE_AVGMARK_NATIVE_SQL(1)}");

			cstmt.executeQuery();
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
}
