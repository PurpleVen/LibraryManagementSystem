package com.example.librarymanagementsystem;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnector{
    public Connection databaseLink;

    public Connection getConnection() {
        String databaseName = "purpleven";
        String databaseUser = "purpleven";
        String databasePassword = "IpszNgCbbg9Ygbdf";

        //String url = "jdbc:mysql://localhost/" + databaseName;
        String url = "jdbc:mysql://jblminiproject-do-user-10209104-0.b.db.ondigitalocean.com:25060/" + databaseName;

        try {
            //Class.forName("com.mysql.jdbc.cj.Connection");
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaseLink = DriverManager.getConnection(url, databaseUser, databasePassword);
            System.out.println("DB Connection done !");
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("DB Connection Failures !");

        }

        return databaseLink;

    }
}
