package assign.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import VO.EmailAddressVO;
import assign.dbaccess.EMailBO;
import assign.dbaccess.EMailValidationException;

/*
 * Delete Email Address Servlet 
 */

public class DeleteEMailAddressServlet extends HttpServlet {
	
	
	


    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
        throws IOException, ServletException
    {
    	System.out.println("----Inside the delete=------");
	String errors = "";
	String inEmailID = request.getParameter("emailid");
        response.setContentType("text/html");

	EMailBO eMailBO = new EMailBO();
	EmailAddressVO eMailAddress = new EmailAddressVO();
	eMailAddress.seteMailID(inEmailID);

	try{
	    eMailBO.deleteEMailAddress(eMailAddress);
	}catch (EMailValidationException emve){
		errors = emve.getErrorMessage();
	} 
	catch (Exception e){
		e.printStackTrace();
	}
	if (errors.equals("")){
		response.sendRedirect("/mysite/home.jsp");	
	}
	else {
		System.out.println(request.getRequestURI());
		request.getSession().setAttribute("Errors", errors);
		response.sendRedirect("/mysite/deletecontact.jsp");
	}
    }

    public void doPost(HttpServletRequest request,
                      HttpServletResponse response)
        throws IOException, ServletException
    {
        doGet(request, response);
    }

}

