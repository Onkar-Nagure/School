<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 17-Oct-24
  Time: 23:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.List" %>
<%@ page import="com.example.jsp_assign.dao.Student" %>
<%@ page import="com.example.jsp_assign.dao.StudentDAO" %>
<%@ page import="java.sql.SQLException" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Update Student</title>
  <link rel="stylesheet" type="text/css" href="CSS/updateStudent.css">
</head>
<body>

<h2>Update Student</h2>

<%
  // Retrieve the student ID from the request
  String studentId = request.getParameter("id");
  StudentDAO studentDAO = new StudentDAO();
    Student student = null; // Fetch student details by ID
    try {
        student = studentDAO.getStudentById(Integer.parseInt(studentId));
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }

    if (student != null) {
%>
<form action="UpdateStudentServlet" method="POST">
  <input type="hidden" name="id" value="<%= student.getId() %>"> <!-- Hidden field for student ID -->

  <label for="name">Name:</label>
  <input type="text" id="name" name="name" value="<%= student.getName() %>" required>

  <label for="last_name">Last Name:</label>
  <input type="text" id="last_name" name="last_name" value="<%= student.getLastName() %>" required>

  <label for="dept">Department:</label>
  <select id="dept" name="dept" required>
    <option value="CSE" <%= student.getDept().equals("CSE") ? "selected" : "" %>>CSE</option>
    <option value="ENTC" <%= student.getDept().equals("ENTC") ? "selected" : "" %>>ENTC</option>
    <option value="IT" <%= student.getDept().equals("IT") ? "selected" : "" %>>IT</option>
    <option value="MECH" <%= student.getDept().equals("MECH") ? "selected" : "" %>>MECH</option>
  </select>

  <input type="submit" value="Update Student">
</form>

<a href="admin.jsp">Back to Admin Page</a> <!-- Link to go back to the admin page -->

<%
} else {
%>
<p>Student not found!</p>
<a href="admin.jsp">Back to Admin Page</a>
<%
  }
%>
</body>
</html>

