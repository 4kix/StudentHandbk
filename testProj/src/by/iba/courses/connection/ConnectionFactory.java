package by.iba.courses.connection;

import java.sql.Connection;

import by.iba.courses.dao.DAOException;

public interface ConnectionFactory {

	public Connection createConnection() throws DAOException;
	
	public Connection getConnection();
}
