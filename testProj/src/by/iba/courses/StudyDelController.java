package by.iba.courses;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.iba.courses.connection.ConnectDB;
import by.iba.courses.connection.ConnectMySQL;
import by.iba.courses.dao.DAOException;
import by.iba.courses.dao.StudyDAO;

/**
 * Servlet implementation class StudentForm
 */
@WebServlet("/StudyDelController")
public class StudyDelController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudyDelController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		delete(request, response);
		//request.getRequestDispatcher("/WEB-INF/lists/StudyList.jsp").forward(request, response);
	}
	
	protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		int id = Integer.parseInt(new String(request.getParameter("id")));
		/*String name = new String(request.getParameter("name"));
		int hours = Integer.parseInt(new String(request.getParameter("hours")));
		int professorId = Integer.parseInt(new String(request.getParameter("professorId")));*/
		  
		 ConnectDB mydb = new ConnectMySQL();	  
		 try  {
			 	StudyDAO dao = mydb.getStudyDAO( mydb.getConnection());
			 	dao.delete(id);
			 			 	
		 } 
		 catch(DAOException e) {
			 	throw new ServletException(e);
		 }
		 
		 		request.setAttribute("msg", "Success!");
				request.getRequestDispatcher("StudyListController").forward(request, response);
		 	
	}

}
