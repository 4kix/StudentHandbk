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
@WebServlet("/ProfFormController")
public class ProfFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfFormController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/forms/ProfessorForm.jsp").forward(request, response);
	}
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		fillFields(request, response);
		request.getRequestDispatcher("/WEB-INF/forms/ProfessorForm.jsp").forward(request, response);
	}

	protected void fillFields(HttpServletRequest request, HttpServletResponse response) {
		
		request.setAttribute("firstName", request.getParameter("firstName"));
		request.setAttribute("secondName", request.getParameter("secondName"));
		request.setAttribute("fatherName", request.getParameter("fatherName"));
		request.setAttribute("birthDate", request.getParameter("birthDate"));
		request.setAttribute("avgMark", request.getParameter("avgMark"));
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

}
