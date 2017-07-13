package by.iba.courses.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import by.iba.courses.dao.DAOException;

public class MySQLConnection implements ConnectionFactory {
	
	private static MySQLConnection instance;
	private Connection connection;
	
	private String user = "root";
    private String password = "12345";							//Пароль пользователя
    private String url = "jdbc:mysql://localhost:3306/lapusha";	//URL адрес
    private String driver = "com.mysql.jdbc.Driver";			//Имя драйвера

    
    public static MySQLConnection getInstance() {
    	if (instance == null) {
    		instance = new MySQLConnection();
    	}
    	return instance;
    }
    
    
    private MySQLConnection() {
        try {
            Class.forName(driver);	//Регистрируем драйвер
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

	@Override
	public Connection createConnection() throws DAOException {
		try {
			return DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	@Override
	public Connection getConnection() {
		return this.connection;
	}

}
