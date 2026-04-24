package com.app.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.app.dao.UserDAO;

public class RegisterServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get form data
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String charity = request.getParameter("charity");

        // DAO object
        System.out.println("Data received:");
        System.out.println(name + " " + email + " " + password + " " + charity);
        UserDAO dao = new UserDAO();

        boolean result = dao.registerUser(name, email, password, charity);

        if (result) {
            // Redirect to login after successful registration
            response.sendRedirect("login.jsp");
        } else {
            response.getWriter().println("Registration Failed!");
        }
    }
}

