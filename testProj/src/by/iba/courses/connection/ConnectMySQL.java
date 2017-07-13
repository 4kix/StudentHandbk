package by.iba.courses.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import by.iba.courses.dao.*;

public class ConnectMySQL implements ConnectDB {
	
	
    private String user = "root";
    private String password = "12345";							//Пароль пользователя
    private String url = "jdbc:mysql://localhost:3306/lapusha";	//URL адрес
    private String driver = "com.mysql.jdbc.Driver";			//Имя драйвера

    public ConnectMySQL() {
        try {
            Class.forName(driver);	//Регистрируем драйвер
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

	@Override
	public Connection getConnection() throws DAOException {
		try {
			return DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			throw new DAOException(e);
		}
		}
	
	@Override
	public UserDAO getUserDAO(Connection connection) {return new UserDAOImpl(connection);}
	
	@Override
	public GroupDAO getGroupDAO(Connection connection) {return new GroupDAOImpl(connection);}

	@Override
	public MarkDAO getMarkDAO(Connection connection) {return new MarkDAOImpl(connection);}

	@Override
	public ProfessorDAO getProfessorDAO(Connection connection) {return new ProfessorDAOImpl(connection);}

	@Override
	public StudentDAO getStudentDAO(Connection connection) {return new StudentDAOImpl(connection);}

	@Override
	public StudyDAO getStudyDAO(Connection connection) {return new StudyDAOImpl(connection);}

}
