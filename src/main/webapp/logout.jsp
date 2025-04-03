<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Admin Login</title>
    <link rel="stylesheet" href="adminLogin.css">
</head>
<body>
    <div id="div1">
    <h1>Admin LogOut</h1>
    <table>
    <form action="AdminLogout" method="get">
    <tr>
    <td><label for="email">Email Id :</label></td>
    <td><input type="email" name="email" id="email"></td>
    </tr>
    <tr>
    <td><label for="pssword">Password :</label></td>
    <td><input type="password" id="pssword" name="password"></td>
    </tr>
    <tr>
    <td colspan="2"><input type="submit" value="Logout"></td>
    </tr> 
     </form>
    </table>
    <% String mess = (String)request.getAttribute("mess"); 
    if(mess != null){%>
    <h3 style="color: green;"><%= mess %></h3>
    <%} %>
    <div id="di">
    <a href="index.jsp"><button>Start Again 🔄</button></a>
    </div>
    </div>
</body>
</html>