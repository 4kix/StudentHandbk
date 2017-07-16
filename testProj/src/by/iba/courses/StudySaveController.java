package by.iba.courses;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.iba.courses.bean.Study;
import by.iba.courses.dao.StudyDAO;
import by.iba.courses.connection.ConnectDB;
import by.iba.courses.connection.ConnectMySQL;
import by.iba.courses.dao.DAOException;

/**
 * Servlet implementation class StudentForm
 */
@WebServlet("/StudySaveController")
public class StudySaveController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudySaveController() {
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
		String name = new String(request.getParameter("name"));
		int hours = Integer.parseInt(new String(request.getParameter("hours")));
		int professorId = Integer.parseInt(new String(request.getParameter("professorId")));
	
		Study study = new Study(0, name, hours, professorId); 
		String message;
		 ConnectDB mydb = new ConnectMySQL();	  
		 try {		 	
			 	StudyDAO dao = mydb.getStudyDAO(mydb.getConnection());
			 	message =  dao.add(study); 
			 			 	
		 } 
		 catch(DAOException e) {
			 	throw new ServletException(e);
		 }
		 		request.setAttribute("msg", message);
				request.getRequestDispatcher("StudyListController").forward(request, response);
		 	
	}
	
	
	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(new String(request.getParameter("id")));
		String name = new String(request.getParameter("name"));
		int hours = Integer.parseInt(new String(request.getParameter("hours")));
		int professorId = Integer.parseInt(new String(request.getParameter("professorId")));
	
	
		Study study = new Study(id, name, hours, professorId); 
		String message;
		 ConnectDB mydb = new ConnectMySQL();	  
		 try {		 	
			 	StudyDAO dao = mydb.getStudyDAO(mydb.getConnection());
			 	dao.update(study); 
			 			 	
		 } 
		 catch(DAOException e) {
			 	throw new ServletException(e);
		 }
		 
		 		request.setAttribute("msg", "Success!");
				request.getRequestDispatcher("StudyListController").forward(request, response);
		 	
	}
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

}
