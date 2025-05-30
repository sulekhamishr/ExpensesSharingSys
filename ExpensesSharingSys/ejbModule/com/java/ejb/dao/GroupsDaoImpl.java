package com.java.ejb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.java.ejb.model.Groups;
import com.java.ejb.util.ConnectionHelper;

public class GroupsDaoImpl implements GroupDao {

    @Override
    public String CreateGroupDao(Groups groups) {
        String result = "Failed to create group";
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = ConnectionHelper.getConnection();
            String query = "INSERT INTO groups (name, created_at) VALUES (?, ?)";

            ps = conn.prepareStatement(query);
            ps.setString(1, groups.getName());
            ps.setDate(2, groups.getCreatedAt());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                result = "Group created successfully";
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            result = "Error: " + e.getMessage();
        } finally {
            try {
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return result;
    }
}
