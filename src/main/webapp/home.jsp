<%@page import="java.util.List"%>
<%@page import="DAO.StudentDao"%>
<%@page import="DTO.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Page Title</title>
    <link rel="stylesheet" href="Adminhome.css">
    <style>
    #alert{
		  display:none;
		  background-color: pink;
		  position: absolute;
		  top: 100px;
		  left: 400px;
		  text-align: center;
		  width: 400px;
		  height: 150px;
		  padding: 10px;
		}
	#updatedata{
		  display:none;
		  background-color: pink;
		  position: absolute;
		  top: 100px;
		  left: 400px;
		  text-align: center;
		  width: 400px;
		  height: 230px;
		  padding: 10px;
		}
	#update{
		  display:none;
	      background-color: green;
		  position: absolute;
		  top: 100px;
		  left: 300px;
		  text-align: center;
		  width: 300px;
		  height: 300px;
		  padding: 50px;
	}
	
    </style>
</head>
<body>
	<%
        HttpSession ses = request.getSession();
		if(ses.getAttribute("email")!=null && ses.getAttribute("password")!=null){%>  
	 	<div id="parent">
        <div id="table" style="overflow:scroll;"><table>
        <tr><th colspan="7"><h1>Student Details</h1></th></tr>
        <tr>
        <th>ID</th>
        <th id="thname">Name</th>
        <th id="thPhy">Physics</th>
        <th id="thChy">Chemistry</th>
        <th id="thmath">Mathematics</th>
        <th id="thedit" class="button">Edit</th>
        <th id="thdele" class="button">Delete</th>
        </tr>
        <%!  List<Student> l=null,ll=null; %>
        <% l=(List<Student>)request.getAttribute("list");
            ll=(List<Student>)request.getSession().getAttribute("list");%>
       <% if (l !=null && ll != null){ %>
       <% for(Student s : l){%>
        	<tr>
            <td><%=s.getId()%></td>
            <td><%=s.getName()%></td>
            <td><%=s.getPhysics() %></td> 
            <td><%=s.getChemistry() %></td>
            <td><%=s.getMaths() %></td>
            <td><a href="edit?id=<%=s.getId()%>&name=<%=s.getName()%>&phy=<%=s.getPhysics() %>&chy=<%=s.getChemistry()%>&math=<%=s.getMaths()%>"><button class="but" id="edit" style="color:green; width: 50px;" >Edit</button></a></td>
            <td><a href="deleteStudent?id=<%= s.getId()%>"><button class="but" id="delete" style="color:red; width: 50px;">Delete</button></a></td>
            </tr>
        <%} }%>
        <% if ( l == null && ll != null){ %>
       <% for(Student s : ll){%>
        	<tr>
            <td><%=s.getId()%></td>
            <td><%=s.getName()%></td>``	`
            <td><%=s.getPhysics() %></td> 
            <td><%=s.getChemistry() %></td>
            <td><%=s.getMaths() %></td>
            <td><a href="edit?id=<%=s.getId()%>&name=<%=s.getName()%>&phy=<%=s.getPhysics() %>&chy=<%=s.getChemistry()%>&math=<%=s.getMaths()%>"><button class="but" id="edit" style="color:green; width: 50px;" >Edit</button></a></td>
            <td><a href="deleteStudent?id=<%= s.getId()%>"><button class="but" id="delete" style="color:red; width: 50px;">Delete</button></a></td>
            </tr>
        <%} }%>
        </table></div>
        <div id="button">
        <a href="AddStudent.jsp"><button>Add Student</button></a>
       <a href="logout.jsp"> <button>Logout</button></a>

        </div> 
        <% String mess = (String)request.getAttribute("mess");%>
        <% String css = (String)request.getAttribute("css");%>
        <div style="display:<%= css%>" id="alert">
             
            <%  if(mess != null){%>
            <h1 style="color:green;"><%=mess%></h1> <br>
           <a href="deleteStudent?display=none&id=0"> <button>Ok</button></a> 
            <% }%>
        </div> 
        <% String mess1 = (String)request.getAttribute("messupdate");%>
        <% String css1 = (String)request.getAttribute("cssupdate");%>
        <%  if(css1 != null){%>
        <div style="display:<%= css1%>;" id="updatedata">
             
            <%  if(mess1 != null ){%>
            <h1 style="color:green;"><%=mess1%></h1> <br>
           <a href="update?display=none&id=0&phy=0&chy=0&maths=0"> <button>Ok</button></a>
            <% }%>
 
        </div>
        <% }%>
        <%!
             String displayu,idu,nameu,phyu,chyu,mathu;
        %>
        <% displayu=(String)request.getAttribute("displayu"); 
         idu=(String)request.getAttribute("idu"); 
         nameu =(String)request.getAttribute("nameu");
         phyu=(String)request.getAttribute("phyu");
         chyu=(String)request.getAttribute("chyu");
         mathu=(String)request.getAttribute("mathu");%>
        <% if(displayu != null){%>
        <div id="update" style="display:<%=displayu %>;">
        <form action="update" method="get">
        ID : <br><input type="number" name="id" value="<%= idu %>" readonly style="color:red;"><br><br>
        Name : <br><input type="text" name="name" value="<%= nameu %>" style="color:green;"><br><br>
        Physics :<br><input type="number" name="phy" maxlength="3" max="100" class="mark" value="<%=phyu %>" style="color:green;"><br><br>
        Chemistry :<br><input type="number" name="chy" maxlength="3" max="100" class="mark" value="<%=chyu  %>" style="color:green;"><br><br>
        Maths :<br><input type="number" name="maths" maxlength="3" max="100" class="mark" value="<%= mathu %>" style="color:green;"><br><br>
        <input type="submit" value="UPDATE" style="color:blue; padding:5px 30px; font-size: medium;font-weight:bold;">
        </form> 
        </div> 
        <% } %>
</div>
		<% } else if(ses.getAttribute("email")==null && ses.getAttribute("passwor")==null){
		request.getRequestDispatcher("adminLogin.jsp").forward(request, response);%>
        	
        <% } %>
</body>
</html>