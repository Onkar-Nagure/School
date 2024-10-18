package com.example.jsp_assign;

import com.example.jsp_assign.dao.StudentDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet(name = "DeleteStudentServlet", value = "/DeleteStudentServlet")
public class DeleteStudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        try {

            StudentDAO studentDAO = new StudentDAO();
            studentDAO.deleteStudent(id);

            // Redirect back to the admin page after deleting the student
            response.sendRedirect("admin.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
