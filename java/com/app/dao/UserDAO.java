package com.app.dao;

import java.sql.*;

import com.app.db.DBConnection;

public class UserDAO {

    // 🔹 Register User
    public boolean registerUser(String name, String email, String password, String charity) {

        boolean status = false;

        try {
            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO users(name,email,password,charity) VALUES(?,?,?,?)"
            );

            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, password);
            ps.setString(4, charity);

            int i = ps.executeUpdate();

            if (i > 0) {
                status = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }

    // 🔹 Login User
    public int loginUser(String email, String password) {

        int userId = -1;

        try {
            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(
                "SELECT user_id FROM users WHERE email=? AND password=?"
            );

            ps.setString(1, email);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                userId = rs.getInt("user_id");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return userId;
    }
}
