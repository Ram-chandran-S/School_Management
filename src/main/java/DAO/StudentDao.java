package DAO;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DTO.Student;

public class StudentDao {
	public Connection getConnection(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/StudentManagement","root","root");
			
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public int SaveAdmin(int id,String name,String email,long contact,String password) throws SQLException {
		Connection con = getConnection();
		PreparedStatement pst = con.prepareStatement("insert into studentmanagement.admin values (?,?,?,?,?) ");
		pst.setInt(1, id);
		pst.setString(2, name); 
		pst.setString(3, email);
		pst.setString(5, password);
		pst.setLong(4, contact);
		return pst.executeUpdate();
	}
	
	public boolean FindAdmin(String email,String password)  {
		Connection con = getConnection();
		PreparedStatement st;
		try {
			st = con.prepareStatement("select * from studentmanagement.admin where email = ? and password = ?");
			st.setString(1, email);
			st.setString(2, password);
			ResultSet res = st.executeQuery();
			if(res.next()) {
				return true;
			}
			else 
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
		
		
		
	}
	
	public Student FindStudent(int id) throws SQLException {
		Connection con = getConnection();
		PreparedStatement st = con.prepareStatement("select * from studentmanagement.student where id = ? ");
		st.setInt(1, id);
		ResultSet res = st.executeQuery();
		while(res.next()) {
			return new Student(res.getInt(1), res.getString(2), res.getInt(3),res.getInt(4), res.getInt(5));
		}
		return null;
	}
	public Boolean checkStudent(int id,String name) throws SQLException {
		Connection con = getConnection();
		PreparedStatement st = con.prepareStatement("select * from studentmanagement.student where id = ? and Name=?");
		st.setInt(1, id);
		st.setString(2, name);
		ResultSet res = st.executeQuery();
		while(res.next()) {
				return true;
		} return false;
	}
	
	public int deleteStudent(int id) throws SQLException {
		Connection con = getConnection();
		PreparedStatement pst = con.prepareStatement("delete from studentmanagement.student where id = ?");
		pst.setInt(1, id);
		return pst.executeUpdate();
	}
	public List<Student> findAllStudent() throws SQLException{
		Connection con = getConnection();
		PreparedStatement pst = con.prepareStatement("select * from studentmanagement.student");
		ResultSet res = pst.executeQuery();
		List<Student> l = new ArrayList();
		while(res.next()) {
			Student s = new Student(res.getInt(1), res.getString(2), res.getInt(3),res.getInt(4), res.getInt(5));
			l.add(s);
		}
		return l;
	}
	public int saveStudent(int id,String name,int phy,int chy,int math) throws SQLException {
		Connection con = getConnection();
		PreparedStatement pst = con.prepareStatement("insert into studentmanagement.student values (?,?,?,?,?) ");
		pst.setInt(1, id);
		pst.setString(2, name);
		pst.setInt(3, phy);
		pst.setInt(4, chy);
		pst.setInt(5, math);
		return pst.executeUpdate();
	}
	public int updateStudent(int id,String name,int phy,int chy,int math) throws SQLException {
		Connection con = getConnection();
		PreparedStatement pst = con.prepareStatement("update studentmanagement.student set name=?,physics=?,chemistry=?,maths=? where id =? ");
		pst.setString(1, name);
		pst.setInt(2, phy);
		pst.setInt(3, chy);
		pst.setInt(4, math);
		pst.setInt(5, id);
		return pst.executeUpdate();
	}

}
