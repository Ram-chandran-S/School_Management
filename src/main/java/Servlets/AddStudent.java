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
@WebServlet("/addsudent")

public class AddStudent extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String sesmail = (String) session.getAttribute("email");
		String sespass = (String) session.getAttribute("password");
		if(sesmail != null && sespass != null) {
			StudentDao s = new StudentDao();
			int row = 0;
			int id = Integer.parseInt(req.getParameter("id"));
			String name = req.getParameter("name");
			int physics = Integer.parseInt(req.getParameter("phy"));
			int chemistry = Integer.parseInt(req.getParameter("chy"));
			int maths = Integer.parseInt(req.getParameter("math"));
			try {
				row = s.saveStudent(id, name, physics, chemistry, maths);
				req.setAttribute("mess", row +" Record Added Successfully");
				req.setAttribute("row", row );
				req.getRequestDispatcher("AddStudent.jsp").include(req, resp);
				
			} catch (SQLException e) {
				e.printStackTrace();
				if(e.getErrorCode()==1062) {
					req.setAttribute("mess", "The Id must be Unique");
					req.setAttribute("row", row );
					req.getRequestDispatcher("AddStudent.jsp").include(req, resp);
				}
			}
			List<Student> l = null;
			try {
				l = s.findAllStudent();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			req.setAttribute("list", l);
			req.getRequestDispatcher("home.jsp").forward(req, resp);
		}
		else
			req.getRequestDispatcher("adminLogin.jsp").forward(req, resp);
	}

}
