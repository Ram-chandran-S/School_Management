package Servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.StudentDao;
import DTO.Student;

@WebServlet("/AdminLogin")
public class AdminLgin extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		StudentDao s = new StudentDao();
		Connection con = s.getConnection();
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		try {
			if(s.FindAdmin(email, password)) {
				HttpSession session = req.getSession();
				session.setAttribute("email", email);
				session.setAttribute("password", password);
				session.setAttribute("list", s.findAllStudent());
				req.setAttribute("list", s.findAllStudent());
				RequestDispatcher dispatcher = req.getRequestDispatcher("home.jsp");
				dispatcher.forward(req, resp);
			}
			else {
				req.setAttribute("mess", "password or email is incorrect");
				req.getRequestDispatcher("adminLogin.jsp").include(req, resp);
			}
		} catch (Exception e) {
			
		
			req.setAttribute("mess", "There is no Data found Please Signin");
			req.getRequestDispatcher("adminLogin.jsp").include(req, resp);
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
