package com.example.jsp_assign;

import java.io.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final String usr_name = "admin";
    private static final String pwd = "123";

    // Handle GET requests (show login form)
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.setContentType("text/html");

            PrintWriter out = response.getWriter();
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            System.out.println(username + " & " + password);

            if (usr_name.contains(username) && pwd.equals(password)) {
                HttpSession session = request.getSession();
                session.setAttribute("username", username);

                request.setAttribute("username", username);
                RequestDispatcher dispatcher = request.getRequestDispatcher("admin.jsp");
                dispatcher.forward(request, response);
            } else {
                out.println("<html><body>");
                out.println("<h2>Invalid username or password. Please try again.</h2>");
                out.println("<a href='LoginServlet'>Go back to login page</a>");
                out.println("</body></html>");
            }
        }
        catch (Exception e) {e.printStackTrace();}
    }
}
