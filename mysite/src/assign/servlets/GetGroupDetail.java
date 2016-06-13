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

/**
 * Servlet implementation class GetGroupDetail
 */
public class GetGroupDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetGroupDetail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		 System.out.println("---Inside the Getting Group---");
		   
		   

		   	GroupVO groupvo = new GroupVO();
		   	
		   	groupvo.setgName("");
		   	
		   	GroupDBAccess groupdao = new GroupDBAccess();
		   	List ls = groupdao.fetch(groupvo);
		   	System.out.println(ls);
		   	HttpSession hs = request.getSession();
		   	hs.setAttribute("lsGroup", ls);
		   	
			   
			   response.sendRedirect("addcontact.jsp");
			   
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}

}
