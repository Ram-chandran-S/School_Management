<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Edit Student Profile</title>
    <link rel="stylesheet" href="AddStudent.css">
</head>
<body>
    <div class="form-container">
        <h2>Fill Student Details</h2>
        <form action="addsudent" method="get">
            <div class="input-group">
                <input type="number" id="id" name="id" required>
                <label for="id">Student Id</label>
            </div>
            <div class="input-group">
                <input type="text" id="name" name="name" required >
                <label for="name">Student Name</label>
            </div>
            <div class="input-group">
                <input type="number" id="phy" name="phy" required max="100">
                <label for="phy">Physics Mark</label> 
            </div>
            <div class="input-group">
                <input type="number" id="chy" name="chy" required max="100">
                <label for="chy">Chemistry Mark</label>
            </div>
            <div class="input-group">
                <input type="number" id="math" name="math" required max="100">
                <label for="math">Maths Mark</label>
            </div>
            <button type="submit" >Submit</button>
        </form>
    </div>
    <% String mess = (String)request.getAttribute("mess"); %>
    <% Object obj = request.getAttribute("row"); %>
    <% if(obj != null){
    	int row =(int)obj; %>
    <% if(row==1) %>
    <h3 style="color: green;"><%= mess %></h3>
    <% if(row!=1) %>
    <h3 style="color: red;"><%= mess %></h3>
    <%} %>
    
</body>
</html>
