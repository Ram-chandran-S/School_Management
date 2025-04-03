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
@WebServlet("/update")
public class Update extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String sesmail = (String) session.getAttribute("email");
		String sespass = (String) session.getAttribute("password");
		if(sesmail != null && sespass != null) {
			StudentDao s= new StudentDao();
			int id= Integer.parseInt(req.getParameter("id"));
			String name = req.getParameter("name");
			String display = req.getParameter("display");
			int phy= Integer.parseInt(req.getParameter("phy"));
			int chy= Integer.parseInt(req.getParameter("chy"));
			int maths= Integer.parseInt(req.getParameter("maths"));
			try { 
				if(id != 0 ||name != null || phy != 0 || chy != 0 || maths != 0) {
					int row = s.updateStudent(id, name, phy, chy, maths); 
					List<Student> list = s.findAllStudent();
					req.setAttribute("messupdate",name + " Data Was Updated");
					req.setAttribute("list",list);
					req.setAttribute("cssupdate","block");
					req.getRequestDispatcher("home.jsp").include(req, resp);
					req.getRequestDispatcher("home.jsp").forward(req, resp);
				}
				
				if(display!=null) {
					List<Student> list = s.findAllStudent();
					req.setAttribute("list",list);
					req.setAttribute("cssupdate",display);
//					req.getRequestDispatcher("home.jsp").include(req, resp);
					req.getRequestDispatcher("home.jsp").forward(req, resp);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else
			req.getRequestDispatcher("adminLogin.jsp").forward(req, resp);
		
	}
}
