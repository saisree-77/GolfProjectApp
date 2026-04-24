package com.app.servlet;

import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.app.db.DBConnection;

public class LuckyDrawServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            Connection con = DBConnection.getConnection();

            // Random winner
            PreparedStatement ps = con.prepareStatement(
                "SELECT u.email FROM users u JOIN scores s ON u.user_id = s.user_id ORDER BY RAND() LIMIT 1"
            );

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String winner = rs.getString("email");
                request.setAttribute("winner", winner);
            }

            request.getRequestDispatcher("winner.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}