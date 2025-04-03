package Servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.StudentDao;

@WebServlet("/adminSignup")
public class AdminSignup extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		StudentDao d = new StudentDao();
		d.getConnection();
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		long contact = Long.parseLong(req.getParameter("contact"));
		try {
		int count =	d.SaveAdmin(id, name,email,contact, password);
			if(count == 1) {
				
				req.setAttribute("mess", "Admin "+name +" SuccessFully Created");
				req.getRequestDispatcher("adminSignup.jsp").include(req, resp);
				req.getRequestDispatcher("home.jsp").forward(req, resp);
				
			}
			else {
				req.setAttribute("mess", "Admin "+name +" Unsuccessfull Cantact management");
				req.getRequestDispatcher("adminSignup.jsp").include(req, resp); 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
