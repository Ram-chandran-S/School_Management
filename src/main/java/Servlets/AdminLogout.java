package Servlets;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.StudentDao;

@WebServlet("/AdminLogout")
public class AdminLogout extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		StudentDao s = new StudentDao();
		Connection con = s.getConnection();
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		if(s.FindAdmin(email, password)) {
			session.invalidate();
			req.setAttribute("mess", "Logged Out Succesfully");
			req.getRequestDispatcher("logout.jsp").include(req, resp);
		}
		else {
			req.setAttribute("mess", "password or email not correct");
			req.getRequestDispatcher("logout.jsp").include(req, resp);
		}
	}
}
