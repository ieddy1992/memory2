package com.mycompany.memory.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/memory";
    private static final String URL = "jdbc:mysql://localhost:port/seudb";
    private static final String USER = "root";
    private static final String PASSWORD = "201899";
    private static final String PASSWORD = "password";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}