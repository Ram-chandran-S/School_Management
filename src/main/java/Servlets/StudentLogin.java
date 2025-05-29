package Servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.StudentDao;
import DTO.Student;
@WebServlet("/StudentLogin")
public class StudentLogin extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		StudentDao s = new StudentDao();
		Connection con = s.getConnection();
		int id = Integer.parseInt(req.getParameter("id"));
		String userName = req.getParameter("UserName");
		System.out.println(id+" "+userName);
		try {
			if(s.checkStudent(id, userName)) {
				Student data = s.FindStudent(id);
				int total = data.getChemistry()+data.getPhysics()+data.getMaths();
				HttpSession session = req.getSession();
				session.setAttribute("studentDTO", data);
				session.setAttribute("totalmark", total);
				
				req.setAttribute("data", data);
				RequestDispatcher dispatcher = req.getRequestDispatcher("Student.jsp");
				dispatcher.forward(req, resp);
			}
			else {
				req.setAttribute("mess", "id or userName is incorrect");
				req.getRequestDispatcher("studentLogin.jsp").include(req, resp);
			}
		} catch (Exception e) {
			
		
			req.setAttribute("mess", "There is no Data found Please Contact your class Advisor");
			req.getRequestDispatcher("studentLogin.jsp").include(req, resp);
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
