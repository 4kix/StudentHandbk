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

import by.iba.courses.bean.Group;
import by.iba.courses.connection.ConnectDB;
import by.iba.courses.connection.ConnectMySQL;
import by.iba.courses.dao.DAOException;
import by.iba.courses.dao.GroupDAO;

/**
 * Servlet implementation class StudListController
 */
@WebServlet("/GroupListController")
public class GroupListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GroupListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
		//request.getRequestDispatcher("/WEB-INF/lists/GroupList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
	  
	 response.setContentType("text/html");
	 String page="/WEB-INF/lists/GroupList.jsp";
	  
	 List<Group> dataList = new ArrayList<Group>(); 
	  		  
	 ConnectDB mydb = new ConnectMySQL();	  
	 try {
	
		 	GroupDAO dao = mydb.getGroupDAO(mydb.getConnection());
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

}
