package com.app.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.app.db.DBConnection;

public class ScoreServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String gameDate = request.getParameter("game_date");
        int score = Integer.parseInt(request.getParameter("score"));

        HttpSession session = request.getSession();
        int userId = (int) session.getAttribute("user_id");

        try {
            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO scores(user_id, game_date, score) VALUES(?,?,?)"
            );

            ps.setInt(1, userId);
            ps.setDate(2, Date.valueOf(gameDate));
            ps.setInt(3, score);

            ps.executeUpdate();

            // Redirect back to dashboard
            response.sendRedirect("dashboard.jsp");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}