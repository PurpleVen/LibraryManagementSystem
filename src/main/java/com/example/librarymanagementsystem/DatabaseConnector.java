package com.example.librarymanagementsystem;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnector {
    public Connection databaseLink;

    public Connection getConnection() {
        String databaseName = "purpleven";
        String databaseUser = "purpleven";
        String databasePassword = "DxWTYB7IuaiGe0BS";

        String url = "jdbc:mysql://localhost:25060/purpleven" + databaseName;

        try {
            Class.forName("com.mysql.jdbc.Connection");
            databaseLink = DriverManager.getConnection(url, databaseUser, databasePassword);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return databaseLink;

    }
}
