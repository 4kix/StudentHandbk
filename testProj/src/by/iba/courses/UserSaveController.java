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
@WebServlet("/UserSaveController")
public class UserSaveController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserSaveController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if("Edit".equals(request.getParameter("action"))) {
			edit(request, response);   
		}	
		else if ("Add".equals(request.getParameter("action")))  {
		addNew(request, response);
		}
		
	}

	protected void addNew(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = new String(request.getParameter("username"));
		String password = new String(request.getParameter("password"));
		String role = new String(request.getParameter("role"));
	
	
		User user = new User(username, password, Role.valueOf(role)); 
		String message;
		 ConnectDB mydb = new ConnectMySQL();	  
		 try {		 	
			 	UserDAO dao = mydb.getUserDAO(mydb.getConnection());
			 	message =  dao.add(user); 
			 			 	
		 } 
		 catch(DAOException e) {
			 	throw new ServletException(e);
		 }
		 		request.setAttribute("msg", message);
				request.getRequestDispatcher("UserListController").forward(request, response);
		 	
	}
	
	
	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = new String(request.getParameter("username"));
		String password = new String(request.getParameter("password"));
		String role = new String(request.getParameter("role"));
	
	
		User user = new User(username, password, Role.valueOf(role));  
		 ConnectDB mydb = new ConnectMySQL();	  
		 try  {
			 	UserDAO dao = mydb.getUserDAO( mydb.getConnection());
			 	dao.update(username, user);  
			 			 	
		 } 
		 catch(DAOException e) {
			 	throw new ServletException(e);
		 }
		 
		 		request.setAttribute("msg", "Success!");
				request.getRequestDispatcher("UserListController").forward(request, response);
		 	
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

}
