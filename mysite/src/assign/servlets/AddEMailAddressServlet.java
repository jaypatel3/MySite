package assign.servlets;

import java.io.*;
import java.util.List;

import javax.servlet.*;
import javax.servlet.http.*;

import VO.EmailAddressVO;
import assign.dbaccess.EMailDBAccess;
import assign.dbaccess.EMailBO;
import assign.dbaccess.EMailValidationException;

/*
 * Add Email Address Servlet 
 */

public class AddEMailAddressServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		
		System.out.println("--Inside------AddEmailAddressServlet");
		String flag = request.getParameter("flag");
		System.out.println("Flag-----"+flag);
		
		if(flag!=null && flag.equals("insert"))
		{
			insert(request,response);
		}
		else if(flag!=null && flag.equals("delete"))
				{
					delete(request,response);
				}
		else if(flag!=null && flag.equals("edit"))
		{
			edit(request,response);
		}
		else if(flag!=null && flag.equals("viewall"))
		{
			viewall(request,response);
		}
		else if(flag!=null && flag.equals("update")){
			
			update(request,response);
		}

	}
	public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String flag = request.getParameter("flag");
    	System.out.println(flag);
    	List ls =null;
    	System.out.println("----Inside the Loop------update");
    	
    	String errors = "";
    	
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
	public  void viewall(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		
		System.out.println("----Inside------viewall");
		
		
		EmailAddressVO emailaddressVO = new EmailAddressVO();
    	//String emailaddress = request.getParameter("emailid");
    	emailaddressVO.seteMailID("");
    	//System.out.println(emailaddress);
    	
    	String errors = "";
    	//step2 JDBC
    	//2a
    	EMailBO eMailBO = new EMailBO();
    	List ls =null;
    	EMailDBAccess emaildao = new EMailDBAccess();
    	ls = emaildao.getAllEMailAddress(emailaddressVO);
    	
    	System.out.println(ls);
    	HttpSession hs = request.getSession();
    	hs.setAttribute("lslist", ls);
    	response.sendRedirect("/mysite/viewsuccess.jsp");
		
		
	}
	public  void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		System.out.println("----Inside-----edit");
		
		
		String id = request.getParameter("id");
    	System.out.println(id);
    	String fname = request.getParameter("fname");
    	
    	System.out.println(fname);
    	
    	EmailAddressVO emailaddressVO = new EmailAddressVO();
    	String emailaddress = request.getParameter("emailid");
    	emailaddressVO.seteMailID(emailaddress);
    	System.out.println(emailaddress);
    	
    	String errors = "";
    	//step2 JDBC
    	//2a
    	EMailBO eMailBO = new EMailBO();
    	List ls =null;
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
			RequestDispatcher rd = request.getRequestDispatcher("/modifycontact.jsp");
			rd.forward(request, response);
		} else {
			request.getSession().setAttribute("Errors", errors);
			response.sendRedirect("/mysite/viewcontact.jsp");
		}
		
		
	}
	public void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("----Inside------delete");
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
	public void insert(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		
		
		
		System.out.println("---inside-----insert");
		String errors = "";
		//Step1: capture input and populate the VO
		EmailAddressVO eMailAddressVO = new EmailAddressVO();
		// Get registration details and set to the EMailAddress
		//Step:1
		String emailaddress = request.getParameter("emailid");
		eMailAddressVO.seteMailID(request.getParameter("emailid"));
		eMailAddressVO.setfName(request.getParameter("fname"));
		eMailAddressVO.setmName(request.getParameter("mname"));
		eMailAddressVO.setlName(request.getParameter("lname"));
		eMailAddressVO.sethPhone(request.getParameter("hphone"));
		eMailAddressVO.setwPhone(request.getParameter("wphone"));
		eMailAddressVO.setmPhone(request.getParameter("mphone"));
		eMailAddressVO.setgroupID(request.getParameter("group"));

		// Step2: Do processing or Business logic
		 EMailBO eMailBO = new EMailBO();
		
		 try{
		 	eMailBO.addEMailAddress(eMailAddressVO);
		 }catch (EMailValidationException emve){
			 errors = emve.getErrorMessage();
		 }
		 catch (Exception e){
		 e.printStackTrace();
		 }
		 
		//step3: Response Back
		if (errors.equals("")) {
			System.out.println("-----yupeeeeeeeee--------");
			response.sendRedirect("/mysite/home.jsp");
		} else {
			request.getSession().setAttribute("Errors", errors);
			response.sendRedirect("/mysite/addcontact.jsp");
		}
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException {
				doPost(request, response);
}

}
