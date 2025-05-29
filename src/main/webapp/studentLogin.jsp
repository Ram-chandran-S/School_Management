<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Student Login</title>
    <link rel="stylesheet" href="adminLogin.css">
</head>
<body>
    <div id="div1">
    <h1>Student Login</h1>
    <table>
    <form action="StudentLogin" method="get">
    <tr>
    <td><label for="id">Id :</label></td>
    <td><input type="text" name="id" id="email"></td>
    </tr>
    <tr>
    <td><label for="UserName">User Name :</label></td>
    <td><input type="text" id="pssword" name="UserName"></td>
    </tr>
    <tr>
    <td colspan="2"><input type="submit" value="Submit"></td>
    </tr> 
     </form>
    </table>
    <% String mess = (String)request.getAttribute("mess"); 
    if(mess != null){%>
    <span style="color: red;"><%= mess %></span>
    <%} %>
    </div>
</body>
</html>