package by.iba.courses.security;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.iba.courses.bean.User;

/**
 * Servlet Filter implementation class PermissionFilter
 */
@WebFilter("/PermissionFilter")
public class PermissionFilter implements Filter {

    /**
     * Default constructor. 
     */
    public PermissionFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest)request;
		HttpServletResponse httpServletResponse = (HttpServletResponse)response;
		
		User user = (User) httpServletRequest.getSession().getAttribute("user");
		String url = httpServletRequest.getRequestURI();
		
		if((user) == null || user.getRole().toString().equals("admin")) {
			chain.doFilter(request, response);	
		}
		else if(user.getRole().toString().equals("professor") && (url.endsWith("MarkListController") 
				|| url.endsWith("MarkFormController") || url.endsWith("GroupListController")
				|| url.endsWith("StudListController") || url.endsWith("ProfListController") 
				|| url.endsWith("StudyListController")) || url.endsWith("Logout") 
				|| url.endsWith("ActMenuController") || url.endsWith("AccessDenied") 
				|| url.endsWith("SendMsg") || url.endsWith("ReadMsg")) {
			chain.doFilter(request, response);
		}
		else if(user.getRole().toString().equals("student") && (url.endsWith("MarkListController") 
				|| url.endsWith("GroupListController") || url.endsWith("StudListController") 
				|| url.endsWith("ProfListController") || url.endsWith("StudyListController"))
				|| url.endsWith("Logout") 
				|| url.endsWith("ActMenuController") || url.endsWith("AccessDenied")
				|| url.endsWith("SendMsg") || url.endsWith("ReadMsg")) {
			chain.doFilter(request, response);
		}
		else {
			httpServletResponse.sendRedirect("AccessDenied");
		}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
