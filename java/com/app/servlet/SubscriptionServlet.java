package com.app.servlet;

import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.app.db.DBConnection;

public class SubscriptionServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String plan = request.getParameter("plan");

        HttpSession session = request.getSession();
        int userId = (int) session.getAttribute("user_id");

        try {
            Connection con = DBConnection.getConnection();

            LocalDate startDate = LocalDate.now();
            LocalDate endDate;

            if (plan.equals("monthly")) {
                endDate = startDate.plusMonths(1);
            } else {
                endDate = startDate.plusYears(1);
            }

            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO subscriptions(user_id, plan_type, status, start_date, end_date) VALUES(?,?,?,?,?)"
            );

            ps.setInt(1, userId);
            ps.setString(2, plan);
            ps.setString(3, "active");
            ps.setDate(4, Date.valueOf(startDate));
            ps.setDate(5, Date.valueOf(endDate));

            ps.executeUpdate();

            response.getWriter().println("Subscription Successful!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
