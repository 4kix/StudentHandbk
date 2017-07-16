package by.iba.courses;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import by.iba.courses.connection.*;
import by.iba.courses.dao.DAOException;
import by.iba.courses.dao.StudentDAO;

/**
 * Servlet implementation class StudListController
 */
@WebServlet("/RecalcStudController")
public class RecalcStudController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecalcStudController() {
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
		 String page="StudListController";
		  
		
		ConnectDB mydb = new ConnectMySQL();
		 try  {
			 	StudentDAO dao = mydb.getStudentDAO(mydb.getConnection());
			 	dao.recalcAvgMark();
		 } 
		 catch(DAOException e) {
			 	throw new ServletException(e);
		 }
		
		  
		
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
