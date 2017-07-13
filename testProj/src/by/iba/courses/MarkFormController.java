package by.iba.courses;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StudentForm
 */
@WebServlet("/MarkFormController")
public class MarkFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MarkFormController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		fillFields(request, response);
    	request.getRequestDispatcher("/WEB-INF/forms/MarkForm.jsp").forward(request, response);
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/forms/MarkForm.jsp").forward(request, response);
	}
	
protected void fillFields(HttpServletRequest request, HttpServletResponse response) {
		
		request.setAttribute("studyId", request.getParameter("studyId"));
		request.setAttribute("studentId", request.getParameter("studentId"));
		request.setAttribute("date", request.getParameter("date"));
		request.setAttribute("professorId", request.getParameter("professorId"));
		request.setAttribute("mark", request.getParameter("mark"));
		request.setAttribute("comments", request.getParameter("comments"));
	}



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

}
