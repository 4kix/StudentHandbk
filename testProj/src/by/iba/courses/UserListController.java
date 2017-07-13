package by.iba.courses;

import java.io.IOException;



import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import java.util.ArrayList;
import java.util.List;

import by.iba.courses.bean.User;

import by.iba.courses.connection.*;
import by.iba.courses.dao.DAOException;
import by.iba.courses.dao.UserDAO;

/**
 * Servlet implementation class StudListController
 */
@WebServlet("/UserListController")
public class UserListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		processRequest(request, response);
	}
	
	 protected void processRequest(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	       
		  
		 response.setContentType("text/html");
		 String page="/WEB-INF/lists/UserList.jsp";
		  
		 List<User> dataList = new ArrayList<User>(); 
		  		  
		 ConnectDB mydb = new ConnectMySQL();	  
		 try  {
			 	UserDAO dao = mydb.getUserDAO(mydb.getConnection());
			 	dataList = dao.getAll();
			 	//con.close();
		 } 
		 catch(DAOException e) {
			 	throw new ServletException(e);
		 }
		
		  
		 request.setAttribute("data", dataList);
		 RequestDispatcher dispatcher = request.getRequestDispatcher(page);
		 if (dispatcher != null){
			 dispatcher.forward(request, response);
		 } 
	}
	    
  

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>


}
