<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="DAO.StudentDao"%>
<%@page import="DTO.Student"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    body {
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        background: linear-gradient(to right, #dfe9f3, #ffffff);
        padding: 40px;
        margin: 0;
    }

    h1 {
        color: #2c3e50;
        text-align: center;
        margin-bottom: 40px;
        font-size: 28px;
        letter-spacing: 1px;
    }

    table {
        margin: auto;
        border-collapse: collapse;
        width: 70%;
        background-color: #ffffff;
        box-shadow: 0 6px 12px rgba(0, 0, 0, 0.1);
        border-radius: 10px;
        overflow: hidden;
        transition: transform 0.2s ease-in-out;
    }

    table:hover {
        transform: scale(1.01);
    }

    th, td {
        padding: 14px 24px;
        text-align: left;
        border-bottom: 1px solid #e0e0e0;
        transition: background-color 0.3s, color 0.3s;
    }

    th {
        background-color: #3498db;
        color: #fff;
        font-size: 16px;
        text-transform: uppercase;
    }

    tr:hover td {
        background-color: #f0faff;
        color: #000;
    }

    tr:nth-child(even) {
        background-color: #f9f9f9;
    }

    tr:last-child td {
        font-weight: bold;
        background-color: #ecf0f1;
    }
</style>

</head>
<body>
	<%!  Student student;%>
	<% HttpSession ses = request.getSession();
	student=(Student)ses.getAttribute("studentDTO");
	if(student!=null){%>
		<h1><%= student.getName() %> Details</h1>
		<table>
		<tr>
		<th style="color: red;">Subjects</th>
		<td style="color: red;">Marks</td>
		</tr>
		<tr>
		<th >Physics</th>
		<td><%= student.getPhysics()%></td>
		</tr>
		<tr>
		<th>Chemistry</th>
		<td><%= student.getChemistry()%></td>
		</tr>
		<tr>
		<th>Mathematics</th>
		<td><%= student.getMaths()%></td>
		</tr>
		<tr>
		<th>Total Mark</th>
		<td><%= ses.getAttribute("totalmark")%></td>
		</tr>
		</table>
	<%}%>

</body>
</html>