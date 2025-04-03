package Servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.StudentDao;
import DTO.Student; 


@WebServlet("/edit")
public class Edit extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String sesmail = (String) session.getAttribute("email");
		String sespass = (String) session.getAttribute("password");
		if(sesmail != null && sespass != null) {
			StudentDao s = new StudentDao();
			List<Student> l=null;
			try {
				l = s.findAllStudent();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			req.setAttribute("list", l);
			req.setAttribute("idu", req.getParameter("id"));
			req.setAttribute("displayu", "block");
			req.setAttribute("nameu", req.getParameter("name"));
			req.setAttribute("phyu", req.getParameter("phy"));
			req.setAttribute("chyu", req.getParameter("chy"));
			req.setAttribute("mathu", req.getParameter("math"));
			
			req.getRequestDispatcher("home.jsp").include(req, resp);
		}else
			req.getRequestDispatcher("adminLogin.jsp").forward(req, resp);
		
	}
}
