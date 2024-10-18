<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 17-Oct-24
  Time: 19:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.List" %>
<%@ page import="com.example.jsp_assign.dao.Student" %>
<%@ page import="com.example.jsp_assign.dao.StudentDAO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Landing Page</title>
    <script src="scripts/admin.js" defer></script>
    <link rel="stylesheet" type="text/css" href="CSS/admin.css">
</head>
<body>
<h2>Admin - Student Management</h2>

<a href="AddStudent.jsp" class="add-student-button">Add New Student</a>

<form class="search-form">
    <input type="text" class="search-bar" name="searchID" placeholder="Search student by ID">
    <button type="submit" class="search-button">Search</button>
</form>


<h2>All Students</h2>
<div class="student-table">
    <table>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Last Name</th>
            <th>Department</th>
            <th>Action</th>
        </tr>
        <%
            // Fetch all students from the database using DAO
            StudentDAO st = new StudentDAO();
            List<Student> students = st.getAllStudents();

            for (Student student : students) {
        %>
        <tr>
            <td><%= student.getId() %></td>
            <td><%= student.getName() %></td>
            <td><%= student.getLastName() %></td>
            <td><%= student.getDept() %></td>
            <td>
                <form action="UpdateStudent.jsp" method="GET" style="display:inline;">
                    <input type="hidden" name="id" value="<%= student.getId() %>">
                    <input type="submit" class="update-button" value="Update">
                </form>
                <form action="DeleteStudentServlet" method="POST" style="display:inline;" id = "deleteForm">
                    <input type="hidden" name="id" value="<%= student.getId() %>">
                    <input type="submit" class="delete-button" value="Delete" onclick="showPopup(this.form); return false;">
                </form>
            </td>
        </tr>
        <%
            }
        %>
    </table>
</div>
<br><br>
<a href="LogoutServlet" class="logout-button" onclick="return confirmLogOut()">Logout</a>
    <div id="myModal" class="modal">
        <div class="modal-content">
            <span class="close" onclick="closePopup()">&times;</span>
            <p>Are you sure you want to delete this student? This action cannot be undone.</p>
            <button id="confirmDeleteButton" class="logout-button">Delete</button>
            <button onclick="closePopup()" class="add-student-button">Cancel</button>
        </div>
    </div>

</body>
</html>
