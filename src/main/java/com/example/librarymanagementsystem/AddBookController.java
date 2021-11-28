package com.example.librarymanagementsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class AddBookController extends NullPointerException{

    @FXML
    private Label AddBookLabel;
    @FXML
    private TextField Booktitle;
    @FXML
    private TextField Bookid;
    @FXML
    private TextField isbn;
    @FXML
    private TextField author;
    @FXML
    private TextField genre;
    @FXML
    private TextField noofcopies;

    @FXML
    protected void AddButton()
    {
        String Title= Booktitle.getText();
        String BookId= Bookid.getText();
        String BookISBN = isbn.getText();
        String Author = author.getText();
        String Genre = genre.getText();
        String NoOfCopies = noofcopies.getText();
        DatabaseConnector connectnow = new DatabaseConnector();
        Connection connectdb = connectnow.getConnection();
        PreparedStatement psinsert=null;
        PreparedStatement pscheck=null;
        ResultSet resultSet=null;

        try
        {
            pscheck=connectdb.prepareStatement("select * from addbook where BookID= ?");
            pscheck.setString(1,BookId);
            resultSet=pscheck.executeQuery();
            if(resultSet.isBeforeFirst())
            {
                System.out.println("This Book Doesn't Exist...");
                Alert alert=new Alert(Alert.AlertType.ERROR);
                alert.setContentText("NO.");
                alert.show();
            }
            else
            {

                psinsert = connectdb.prepareStatement("insert into addbook VALUES (?,?,?,?,?,?)");
                psinsert.setString(1, Title);
                psinsert.setString(2, BookId);
                psinsert.setString(3, BookISBN);
                psinsert.setString(4, Author);
                psinsert.setString(5, Genre);
                psinsert.setString(6, NoOfCopies);
                psinsert.executeUpdate();

                AddBookLabel.setText("Book Added Successfully!");



            }
        }catch(SQLException ep)
        {
            ep.printStackTrace();
        }

    }





    @FXML
    protected void GoToDashboard(ActionEvent e)

    {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Dashboard.fxml"));
            ((Node)(e.getSource())).getScene().getWindow().hide();
            Parent root1 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        } catch(Exception ep) {
            ep.printStackTrace();
        }}

    @FXML
    protected void GoToIssueBook(ActionEvent e)

    {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("IssueBook.fxml"));
            ((Node)(e.getSource())).getScene().getWindow().hide();
            Parent root1 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        } catch(Exception ep) {
            ep.printStackTrace();
        }}

    @FXML
    protected void GoToManageDetailsBook(ActionEvent e){
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
    protected void GoToAddMember(ActionEvent e){
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MemberAdd.fxml"));
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
    protected void GoToManageMember(ActionEvent e){
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MemberManage.fxml"));
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
