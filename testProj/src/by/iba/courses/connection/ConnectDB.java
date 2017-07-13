package by.iba.courses.connection;

import java.sql.Connection;
import by.iba.courses.dao.*;

public interface ConnectDB {
	
	public Connection getConnection() throws DAOException;
	public UserDAO getUserDAO(Connection connection);
	public GroupDAO getGroupDAO(Connection connection);
	public MarkDAO getMarkDAO(Connection connection);
	public ProfessorDAO getProfessorDAO(Connection connection);
	public StudentDAO getStudentDAO(Connection connection);
	public StudyDAO getStudyDAO(Connection connection);
}
