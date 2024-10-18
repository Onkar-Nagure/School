package com.example.jsp_assign;


import com.example.jsp_assign.dao.Student;
import com.example.jsp_assign.dao.StudentDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "UpdateStudentServlet", value = "/UpdateStudentServlet")
public class UpdateStudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve student information from the request
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String lastName = request.getParameter("last_name");
        String dept = request.getParameter("dept");

        Student student = new Student();
        student.setId(id);
        student.setName(name);
        student.setLastName(lastName);
        student.setDept(dept);

        // Update the student in the database
        StudentDAO studentDAO = new StudentDAO();
        boolean isUpdated = studentDAO.updateStudent(student);

        // Redirect to the admin page after update
        if (isUpdated) {
            response.sendRedirect("admin.jsp?message=Student updated successfully!");
        } else {
            response.sendRedirect("admin.jsp?message=Failed to update student.");
        }
    }
}
