package assign.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import VO.EmailAddressVO;
import assign.dbaccess.EMailBO;

/**
 * Servlet implementation class for Servlet: GetEmailAddresswithAjax
 *
 */
 public class GetEmailAddresswithAjax extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get the email address
		//set to session
		System.out.println("----Indside----");
		String flag = request.getParameter("flag");
		
		System.out.println(flag);
		
		
		List ls = null;
		String emailID = request.getParameter("emailid");
		System.out.println("Email ID got from client: " + emailID);
		
		EMailBO eMailBO = new EMailBO();
		EmailAddressVO emailvo = new EmailAddressVO();
		emailvo.seteMailID(emailID);
	try{
			ls = eMailBO.getEMailAddress(emailvo);
			System.out.println(ls);
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getSession().setAttribute("emailobject", ls);
			response.sendRedirect("/mysite/ajaxoutput.jsp");
	}  		
}