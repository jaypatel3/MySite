package assign.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import VO.GroupVO;
import assign.dbaccess.GroupDBAccess;

/*
 * Add Group Servlet 
 */

public class AddGroupServlet extends HttpServlet {

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
        throws IOException, ServletException
    {
    	String emailid  = request.getParameter("emailid");
    	System.out.println(emailid);
    	System.out.println("------Inside Group ----");
    	
    	String flag = request.getParameter("flag");
    	System.out.println(flag);
    	
    	
    	
    	
    	 if(flag!=null && flag.equals("selectGroup"));
    	{
    		searchGroup(request,response);
    	
    	}
    	 if(flag!=null && flag.equals("insert"))
    	{
    		insertGroup(request,response);
    	}
    	 if(flag!=null && flag.equals("edit"))
    	{
    		edit(request,response);
    	}
    	 if(flag!=null && flag.equals("select")){
    		 
    		 fetch(request,response);
    		 
    	 }
    	
    	
	
    }

   public  void fetch(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
	   
	   System.out.println("---Inside the Getting Group---123");
	   
	   

	   	GroupVO groupvo = new GroupVO();
	   	
	   	groupvo.setgName("");
	   	
	   	GroupDBAccess groupdao = new GroupDBAccess();
	   	List ls = groupdao.fetch(groupvo);
	   	System.out.println(ls);
	   	HttpSession hs = request.getSession();
	   	hs.setAttribute("lsGroup", ls);
	   	
		   
		   response.sendRedirect("addcontact.jsp");
		   
		   
			
		}
	   
	   
		
	

public void edit(HttpServletRequest request, HttpServletResponse response) throws IOException {
	   System.out.println("---Inside the Edit---");
	   
	   
	   String emailid  = request.getParameter("emailid");
   	System.out.println(emailid);
	   	GroupVO groupvo = new GroupVO();
	   	
	   	groupvo.setgName("emailid");
	   	
	   	GroupDBAccess groupdao = new GroupDBAccess();
	   	List ls = groupdao.fetch(groupvo);
	   	System.out.println(ls);
	   	HttpSession hs = request.getSession();
	   	hs.setAttribute("lsGroup", ls);
	   	
	    
		   response.sendRedirect("/mysite/ajaxgroup.jsp");
		  
		   
		
	}

public  void fetchGroup(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		System.out.println("Fetch");
		
		
		response.sendRedirect("/mysite/addcontact.jsp");
		
	}

public void insertGroup(HttpServletRequest request,
			HttpServletResponse response) {
		
	   
	   System.out.println("-------Insert Group------");
	   
	   
	   String groupname = request.getParameter("group");
	   System.out.println(groupname);
	   
	   
	   GroupVO groupvo = new GroupVO();
	   groupvo.setgName(groupname);
	   
	   
	   
	   
	   GroupDBAccess groupdao = new GroupDBAccess();
	   
	   groupdao.addGroup(groupvo);
	   
	   
	   
	   
		
	}

public void searchGroup(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		
	   System.out.println("---Inside the Getting Group---");
	   
	   

   	GroupVO groupvo = new GroupVO();
   	
   	groupvo.setgName("");
   	
   	GroupDBAccess groupdao = new GroupDBAccess();
   	List ls = groupdao.fetch(groupvo);
   	System.out.println(ls);
   	HttpSession hs = request.getSession();
   	hs.setAttribute("lsGroup", ls);
   	
	   
	   response.sendRedirect("addgroup.jsp");
	   
	   
		
	}

	public void doPost(HttpServletRequest request,
                      HttpServletResponse response)
        throws IOException, ServletException
    {
        doGet(request, response);
    }

}

