package by.iba.courses;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.iba.courses.bean.User;
import by.iba.courses.bean.User.Role;
import by.iba.courses.connection.ConnectDB;
import by.iba.courses.connection.ConnectMySQL;
import by.iba.courses.dao.DAOException;
import by.iba.courses.dao.UserDAO;

/**
 * Servlet implementation class StudentForm
 */
@WebServlet("/UserDelController")
public class UserDelController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserDelController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		delete(request, response);
	}

	protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = new String(request.getParameter("username"));
		String password = new String(request.getParameter("password"));
		String role = new String(request.getParameter("role"));
	
	
		User user = new User(username, password, Role.valueOf(role));  
		 ConnectDB mydb = new ConnectMySQL();	  
		 try  {
			 	UserDAO dao = mydb.getUserDAO( mydb.getConnection());
			 	dao.delete(username, user);
			 			 	
		 } 
		 catch(DAOException e) {
			 	throw new ServletException(e);
		 }
		 
		 		request.setAttribute("msg", "Success!");
				request.getRequestDispatcher("UserListController").forward(request, response);
		 	
	}


}
