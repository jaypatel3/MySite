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
import assign.dbaccess.EMailDBAccess;
import assign.dbaccess.EMailValidationException;

/*
 * Get Email Address Servlet 
 */

public class EditEmailAddress extends HttpServlet  {

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
        throws IOException, ServletException
    {
    	
    	
    	
    	String flag = request.getParameter("flag");
    	System.out.println(flag);
    	
    	System.out.println("----Inside the Loop");
    	System.out.println("JAY");
    	
    	if(flag!=null && flag.equals("edit"))
    	{
    		edit(request,response);
    	}
    	if(flag!=null && flag.equals("fetch"))
    	{
    		System.out.println("------delete-------");
    		update(request,response);
    		
    	}
    	if(flag!=null && flag.equals("viewall"))
    	{
    		System.out.println("Fetch");
    		fetch(request,response);
    	
    	}
    	
    	
    }

    public  void fetch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

    	
    //	String fname = request.getParameter("fname");
    	
    	//System.out.println(fname);
    	
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

	public  void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
    	
    	System.out.println("--Inside----");
		String errors = "";
		//Step1: capture input and populate the VO
		EmailAddressVO eMailAddressVO = new EmailAddressVO();
		// Get registration details and set to the EMailAddress
		//Step:1
		String id = request.getParameter("id");
		eMailAddressVO.setId(Long.parseLong(id));
		
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

	public void edit(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
    	
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

	public void doPost(HttpServletRequest request,
                      HttpServletResponse response)
        throws IOException, ServletException
    {
        doGet(request, response);
    }

}

