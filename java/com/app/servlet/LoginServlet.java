package com.app.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.app.dao.UserDAO;

public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        UserDAO dao = new UserDAO();

        int userId = dao.loginUser(email, password);

        if (userId != -1) {

            HttpSession session = request.getSession();

            session.setAttribute("user", email);     // for display
            session.setAttribute("user_id", userId); // for DB

            response.sendRedirect("dashboard.jsp");

        } else {
            response.getWriter().println("Invalid Email or Password!");
        }
    }
}