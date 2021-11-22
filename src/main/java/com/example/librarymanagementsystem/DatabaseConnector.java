package com.example.librarymanagementsystem;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnector{
    public Connection databaseLink;

    public Connection getConnection() {
        String databaseName = "purpleven";
        String databaseUser = "purpleven";
        String databasePassword = "DxWTYB7IuaiGe0BS";

        String url = "jdbc:mysql://jblminiproject-do-user-10209104-0.b.db.ondigitalocean.com/purpleven" + databaseName;
       // String url = "jblminiproject-do-user-10209104-0.b.db.ondigitalocean.com/purpleven" + databaseName;

        try {
            //Class.forName("com.mysql.jdbc.cj.Connection");
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaseLink = DriverManager.getConnection(url, databaseUser, databasePassword);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return databaseLink;

    }
}
