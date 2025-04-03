<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Admin SignUp</title>
    <link rel="stylesheet" href="adminSignup.css">
</head>
<body>
    <div id="div1">
        <table>
        <form action="adminSignup" method="get">
        <tr>
        <th colspan="4"><h4>Fill the Below Details!</h4></th>
        </tr>
        <tr>
        <td><label for="id">Enter Id :</label></td>
        <td><input type="text" id="id" name="id" required placeholder="000"></td>
        <td><label for="name">Enter Name :</label></td>
        <td><input type="text" id="name" name="name" required placeholder="Full name"></td>
        </tr>
        <tr>
        <td><label for="con">Contact :</label></td>
        <td><input type="tel" id="con" name="contact" maxlength="10"  placeholder="10 digit number" required></td>
        <td><label for="mail">Enter Mail :</label></td>
        <td><input type="email" id="mail" name="email" required placeholder="example@gmail.com"></td>
        </tr>
        <tr>
        <td><label for="pass">Password :</label></td>
        <td><input type="password" id="pass" name="password" required placeholder="********"></td>
        <td><label for="repass">Confirm Password :</label></td>
        <td ><input type="password" id="repass" name="repass" required placeholder="********"></td>
        </tr>
        <tr>
        <td id="mess" colspan="4" ></td>
        </tr>
        <tr>
        <td colspan="2"><input type="submit" value="Submit" id="button"></td>
        </form>
        <td colspan="2"><a href="adminLogin.jsp"><button>Admin Login</button></a></td>
        </tr>
        
        </table>
        <%String mess = (String)request.getAttribute("mess");
        if(mess != null){%>
        <h1 style="color: green;"><%= mess %></h1>
        <%} %>
    </div>



    <script src="adminSignup.js"></script>
</body>
</html>