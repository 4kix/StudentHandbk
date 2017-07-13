package by.iba.courses.connection;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import by.iba.courses.dao.DAOException;

public class DB2Connection implements ConnectionFactory {
	
	private Connection connection;

	@Override
	public Connection createConnection() throws DAOException {
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
	public Connection getConnection() {
		return this.connection;
	}

}
