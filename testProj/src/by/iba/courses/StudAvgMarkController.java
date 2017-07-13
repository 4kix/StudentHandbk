package by.iba.courses;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.iba.courses.bean.Student;
import by.iba.courses.connection.ConnectDB;
import by.iba.courses.connection.ConnectMySQL;
import by.iba.courses.dao.DAOException;
import by.iba.courses.dao.StudentDAO;

/**
 * Servlet implementation class StudListController
 */
@WebServlet("/StudAvgMarkController")
public class StudAvgMarkController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudAvgMarkController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		avgMark(request, response);
		//request.getRequestDispatcher("/WEB-INF/lists/StudList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	protected void avgMark(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
	  
	 response.setContentType("text/html");
	 String page="StudListController";
	  
	 List<Student> dataList = new ArrayList<Student>(); 
	  		  
	 ConnectDB mydb = new ConnectMySQL();	  
	 try {
		 	StudentDAO dao = mydb.getStudentDAO(mydb.getConnection());
		 	dao.recalcAvgMark();
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
}
