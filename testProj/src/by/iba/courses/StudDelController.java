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
@WebServlet("/StudDelController")
public class StudDelController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudDelController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//delete(request, response);
		request.getRequestDispatcher("/WEB-INF/lists/StudList.jsp").forward(request, response);
	}

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

}
