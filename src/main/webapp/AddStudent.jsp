<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 17-Oct-24
  Time: 23:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Add New Student</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      background-color: #e7f3ff; /* Light blue background */
      margin: 0;
      padding: 20px;
    }
    h2 {
      color: #007BFF; /* Blue color for headings */
      margin-top: 20px;
    }
    form {
      background-color: white;
      padding: 15px;
      border-radius: 5px;
      box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
      margin-bottom: 20px;
      max-width: 400px; /* Limit the maximum width of the form */
      margin: auto; /* Center the form */
    }
    label {
      display: block;
      margin: 10px 0 5px;
      color: #333;
    }
    input[type="text"],
    select {
      width: calc(100% - 22px); /* Adjusted width for padding */
      padding: 8px; /* Reduced padding */
      border: 1px solid #007BFF; /* Blue border */
      border-radius: 4px;
      margin-bottom: 10px;
    }
    input[type="submit"] {
      background-color: #007BFF; /* Blue color for submit button */
      color: white;
      border: none;
      padding: 10px;
      border-radius: 4px;
      cursor: pointer;
      width: 100%;
    }
    input[type="submit"]:hover {
      background-color: #0056b3; /* Darker blue on hover */
    }
    a {
      display: inline-block;
      margin-top: 10px;
      text-decoration: none;
      color: #007BFF; /* Blue color for the link */
    }
    a:hover {
      text-decoration: underline;
    }
  </style>
</head>
<body>

<h2>Add New Student</h2>
<form action="AddStudentServlet" method="POST">
  <label for="name">Name:</label>
  <input type="text" id="name" name="name" required>

  <label for="last_name">Last Name:</label>
  <input type="text" id="last_name" name="last_name" required>

  <label for="dept">Department:</label>
  <select id="dept" name="dept" required>
    <option value="CSE">CSE</option>
    <option value="ENTC">ENTC</option>
    <option value="IT">IT</option>
    <option value="MECH">MECH</option>
  </select>

  <input type="submit" value="Add Student">
</form>
<a href="admin.jsp">Back to Admin Page</a> <!-- Link to go back to the admin page -->

</body>
</html>
