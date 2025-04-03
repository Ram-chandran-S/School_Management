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

@WebServlet("/deleteStudent")
public class deleteStudent extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String sesmail = (String) session.getAttribute("email");
		String sespass = (String) session.getAttribute("password");
		if(sesmail != null && sespass != null) {
			int id = Integer.parseInt(req.getParameter("id"));
			String display = req.getParameter("display");
			StudentDao s = new StudentDao();
			try {
				if(id != 0) {
					List<Student> list = s.findAllStudent();
					int row=s.deleteStudent(id);
					req.setAttribute("mess",row + " Rows Deleted successfully");
					req.setAttribute("list",list);
					req.setAttribute("css","block");
					req.getRequestDispatcher("home.jsp").include(req, resp);
					req.getRequestDispatcher("home.jsp").forward(req, resp);
				}
				
				if(display != null) {
					List<Student> list = s.findAllStudent();
					req.setAttribute("list",list);
					req.setAttribute("css",display);
					req.getRequestDispatcher("home.jsp").include(req, resp);
					req.getRequestDispatcher("home.jsp").forward(req, resp);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else
			req.getRequestDispatcher("adminLogin.jsp").forward(req, resp);
			
		}

}
