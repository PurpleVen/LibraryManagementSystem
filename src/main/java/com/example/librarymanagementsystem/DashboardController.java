package com.example.librarymanagementsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DashboardController implements Initializable {

    @FXML
    private Label IssuedBookCount;
    @FXML
    private  Label TotalBookCount;
    @FXML
    private  Label MemberCount;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        DatabaseConnector connectnow = new DatabaseConnector();
        Connection connectdb = connectnow.getConnection();
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connectdb.prepareStatement("select count(*) as BookID from issuebook");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int d = resultSet.getInt("BookID");
                IssuedBookCount.setText(String.valueOf(d));
            }

        }catch (SQLException pr) {
            pr.printStackTrace();
        }

        try {
            preparedStatement = connectdb.prepareStatement("select count(*) as MemberID from membermanage");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int d = resultSet.getInt("MemberID");
                MemberCount.setText(String.valueOf(d));
            }

        }catch (SQLException pr) {
            pr.printStackTrace();
        }

    try {
        preparedStatement = connectdb.prepareStatement("select count(*) as BookID from addbook");
        resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            int d = resultSet.getInt("BookID");
            TotalBookCount.setText(String.valueOf(d));
        }

    }catch (
    SQLException pr) {
        pr.printStackTrace();
    }

    }

    /*@FXML
    protected void ToatlIssuedBook(ActionEvent e){


        DatabaseConnector connectnow = new DatabaseConnector();
        Connection connectdb = connectnow.getConnection();
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connectdb.prepareStatement("select count(*) as BookID from issuebook");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int d = resultSet.getInt("BookID");
                IssuedBookCount.setText(String.valueOf(d));
            }

        }catch (SQLException pr) {
            pr.printStackTrace();
        }
    }*/



   /* @FXML
    protected void TotalMembers(ActionEvent e){


        DatabaseConnector connectnow = new DatabaseConnector();
        Connection connectdb = connectnow.getConnection();
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connectdb.prepareStatement("select count(*) as MemberID from membermanage");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int d = resultSet.getInt("MemberID");
                MemberCount.setText(String.valueOf(d));
            }

        }catch (SQLException pr) {
            pr.printStackTrace();
        }
    }*/

    /*@FXML
    protected void ToatlBooks(ActionEvent e){


        DatabaseConnector connectnow = new DatabaseConnector();
        Connection connectdb = connectnow.getConnection();
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connectdb.prepareStatement("select count(*) as BookID from addbook");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int d = resultSet.getInt("BookID");
                TotalBookCount.setText(String.valueOf(d));
            }

        }catch (
                SQLException pr) {
            pr.printStackTrace();
        }
    }*/

    @FXML
    protected void IssueBook(ActionEvent e){
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("IssueBook.fxml"));
            ((Node)(e.getSource())).getScene().getWindow().hide();
            Parent root1 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.setResizable(false);
            stage.show();
        } catch (Exception ep){
            ep.printStackTrace();
        }
    }

    @FXML
    protected void IssueBookDetails(ActionEvent e){
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("IssueDetails.fxml"));
            ((Node)(e.getSource())).getScene().getWindow().hide();
            Parent root1 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.setResizable(false);
            stage.show();
        } catch (Exception ep){
            ep.printStackTrace();
        }
    }

    @FXML
    protected void AddBook(ActionEvent e){
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AddBook.fxml"));
            ((Node)(e.getSource())).getScene().getWindow().hide();
            Parent root1 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setResizable(false);
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (Exception ep){
            ep.printStackTrace();
        }
    }

    @FXML
    protected void ManageDetailsBook(ActionEvent e){
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("BookDetails.fxml"));
            ((Node)(e.getSource())).getScene().getWindow().hide();
            Parent root1 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setResizable(false);
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (Exception ep){
            ep.printStackTrace();
        }
    }

    @FXML
    protected void AddMember(ActionEvent e){
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MemberAdd.fxml"));
            ((Node)(e.getSource())).getScene().getWindow().hide();
            Parent root1 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.setResizable(false);
            stage.show();
        } catch (Exception ep){
            ep.printStackTrace();
        }
    }

    @FXML
    protected void ManageMemberDetails(ActionEvent e){
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MemberDetails.fxml"));
            ((Node)(e.getSource())).getScene().getWindow().hide();
            Parent root1 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setResizable(false);
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (Exception ep){
            ep.printStackTrace();
        }
    }

    @FXML
    protected void DueDate(ActionEvent e){
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("DueDate.fxml"));
            ((Node)(e.getSource())).getScene().getWindow().hide();
            Parent root1 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setResizable(false);
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (Exception ep){
            ep.printStackTrace();
        }
    }

    @FXML
    protected void GoBackToLogin(ActionEvent e){
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("login.fxml"));
            ((Node)(e.getSource())).getScene().getWindow().hide();
            Parent root1 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setResizable(false);
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (Exception ep){
            ep.printStackTrace();
        }
    }

}
