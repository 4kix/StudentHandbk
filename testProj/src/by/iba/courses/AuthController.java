package by.iba.courses;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.iba.courses.bean.User;

import by.iba.courses.connection.ConnectDB;
import by.iba.courses.connection.ConnectMySQL;
import by.iba.courses.connection.ConnectionFactory;
import by.iba.courses.connection.MySQLConnection;
import by.iba.courses.dao.DAOException;
import by.iba.courses.dao.UserDAO;

/**
 * Servlet implementation class AuthController
 */
@WebServlet("/AuthController")
public class AuthController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuthController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		
		User user = getUser(login, password);	
		if(user != null)
		{
			request.getSession().setAttribute("user", user);
			request.getRequestDispatcher("/WEB-INF/ActionMenu.jsp").forward(request, response);
		}
		else
		{
			request.setAttribute("errorMessage", "Login or password is incorrect");
			request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
		}
		
	}


	
	//проверка соответствия имени пользователя и пароля
	private User getUser(String login, String password) throws ServletException {		
		
		User user  = new User();
		ConnectionFactory factory = MySQLConnection.getInstance();
		ConnectDB mydb = new ConnectMySQL();	  
		 try  {		 
			 	UserDAO dao = mydb.getUserDAO(factory.createConnection());
			 	user = dao.authCheck(login, password);
			 	//con.close();
		 } 
		 catch(DAOException e) {
			 throw new ServletException(e);
		 }
		
		 return user;
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

}
