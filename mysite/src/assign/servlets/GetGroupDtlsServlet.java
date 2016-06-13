package assign.servlets;

import java.io.*;
import java.util.List;

import javax.servlet.*;
import javax.servlet.http.*;

import VO.GroupVO;
import assign.dbaccess.EMailDBAccess;
import assign.dbaccess.EMailBO;
import assign.dbaccess.EMailValidationException;
import assign.dbaccess.GroupDBAccess;


 
 

public class GetGroupDtlsServlet extends HttpServlet {

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws IOException
                      {
    	
    	System.out.println("---Inside Edit---");
    	
                      String groupname = request.getParameter("groupname");
	String gid = request.getParameter("id");
	   	GroupVO groupvo = new GroupVO();
	   	
	   	groupvo.setgName(groupname);
	   	groupvo.setGid(Long.parseLong(gid));
	   	
	   	GroupDBAccess groupdao = new GroupDBAccess();
	    groupdao.update(groupvo);
	   
	   	
	    System.out.println("----Finish---");
		   response.sendRedirect("/mysite/addgroup.jsp");
    }

    public void doPost(HttpServletRequest request,
                      HttpServletResponse response)
        throws IOException, ServletException
    {
        doGet(request, response);
    }

}

