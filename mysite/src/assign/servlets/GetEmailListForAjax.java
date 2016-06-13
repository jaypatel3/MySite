package assign.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import VO.EmailAddressVO;
import assign.dbaccess.EMailDBAccess;

/**
 * Servlet implementation class GetEmailListForAjax
 */
public class GetEmailListForAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetEmailListForAjax() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
				System.out.println("----Inside----");
				
				
				String flag = request.getParameter("flag");
				System.out.println(flag);
				
				List ls = null;
				EmailAddressVO emailvo = new EmailAddressVO();
				
				EMailDBAccess emaildao = new EMailDBAccess();
				ls = emaildao.getAllEMailAddress(emailvo);
				
				
				System.out.println("outout");
				
				
				HttpSession hs = request.getSession();
				
				hs.setAttribute("lslist", ls);
				
				
				response.sendRedirect("/mysite/getemailaddresswithajax.jsp");
				
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

}
