package com.example.jsp_assign;

import com.example.jsp_assign.dao.Student;
import com.example.jsp_assign.dao.StudentDAO;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet(name = "AddStudentServlet", value = "/AddStudentServlet")
public class AddStudentServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String last_name = request.getParameter("last_name");
        String dept = request.getParameter("dept");

        Student student = new Student();
        student.setName(name);
        student.setLastName(last_name);
        student.setDept(dept);

        StudentDAO studentDAO = new StudentDAO();
        studentDAO.addStudent(student);

        // Redirect back to the admin page after adding the student
        response.sendRedirect("admin.jsp");
    }

    // Handle GET request - Display the form for adding a student
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
    }
}
