package by.iba.courses.connection;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import by.iba.courses.dao.*;

public class ConnectDB2 implements ConnectDB {

	@Override
	public Connection getConnection() throws DAOException {
		try {
			InitialContext context = new InitialContext();
			DataSource source = (DataSource)context.lookup("jdbc/StudentHelperDB");
			return source.getConnection();
		}catch (NamingException e) {
			throw new DAOException(e);
		}catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	@Override
	public UserDAO getUserDAO(Connection connection) {
		return new UserDAOImpl(connection);
	}

	@Override
	public GroupDAO getGroupDAO(Connection connection) {
		return new GroupDAOImpl(connection);
	}

	@Override
	public MarkDAO getMarkDAO(Connection connection) {
		return new MarkDAOImpl(connection);
	}

	@Override
	public ProfessorDAO getProfessorDAO(Connection connection) {
		return new ProfessorDAOImpl(connection);
	}

	@Override
	public StudentDAO getStudentDAO(Connection connection) {
		return new StudentDAOImpl(connection);
	}

	@Override
	public StudyDAO getStudyDAO(Connection connection) {
		return new StudyDAOImpl(connection);
	}

}
