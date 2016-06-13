package assign.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import VO.EmailAddressVO;
import assign.dbaccess.EMailBO;
import assign.dbaccess.EMailValidationException;

/*
 * Get Email Address Servlet 
 */

public class GetEMailAddressDtlsServlet extends HttpServlet  {

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
        throws IOException, ServletException
    {
    	
    	
    	
    	String flag = request.getParameter("flag");
    	System.out.println(flag);
    	List ls =null;
    	System.out.println("----Inside the Loop");
    	System.out.println("JAY");
    	String errors = "";
    	if(flag!=null && flag.equals("edit"))
    	{
    		edit(request,response);
    	}
    	//step1
    	EmailAddressVO emailaddressVO = new EmailAddressVO();
    	String emailaddress = request.getParameter("emailid");
    	emailaddressVO.seteMailID(emailaddress);
    	System.out.println(emailaddress);
    	
    	
    	//step2 JDBC
    	//2a
    	EMailBO eMailBO = new EMailBO();
    	
    	try {
    		ls = eMailBO.getEMailAddress(emailaddressVO);
		} catch (EMailValidationException e) {
			errors = e.getErrorMessage();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
		if (errors.equals("")) {
			System.out.println("first Name: " + ls);
			request.setAttribute("emailVO", emailaddressVO);
			HttpSession hs = request.getSession();
			hs.setAttribute("lslist", ls);
			RequestDispatcher rd = request.getRequestDispatcher("/viewsuccess.jsp");
			rd.forward(request, response);
		} else {
			request.getSession().setAttribute("Errors", errors);
			response.sendRedirect("/mysite/viewcontact.jsp");
		}
    	
    }

    public void edit(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		response.sendRedirect("modifycontact.jsp");
	}

	public void doPost(HttpServletRequest request,
                      HttpServletResponse response)
        throws IOException, ServletException
    {
        doGet(request, response);
    }

}

