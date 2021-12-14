package com.example.librarymanagementsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AddMemberController extends NullPointerException{

    @FXML
    private Label AddMemberLabel;
    @FXML
    private TextField name;
    @FXML
    private TextField mem_id;
    @FXML
    private TextField e_id;
    @FXML
    private TextField phoneno;


    private boolean validatemembername(){
        if (name.getText().length()>0){
            return true;
        }else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Validate member name");
            alert.setHeaderText(null);
            alert.setContentText("Please Enter Member Name!");
            alert.showAndWait();
            return false;
        }
    }
    private boolean validatememberid(){
        if (mem_id.getText().length()>0){
            return true;
        }else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Validate member ID");
            alert.setHeaderText(null);
            alert.setContentText("Please Enter Member ID!");
            alert.showAndWait();
            return false;
        }
    }
    private boolean validatememberemail(){
        if (e_id.getText().length()>0){
            return true;
        }else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Validate Member Email");
            alert.setHeaderText(null);
            alert.setContentText("Please Enter Member EmailID!");
            alert.showAndWait();
            return false;
        }
    }
    private boolean validatephoneno(){
        if (phoneno.getText().length()>0){
            return true;
        }else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Validate Member Phone No");
            alert.setHeaderText(null);
            alert.setContentText("Please Enter Member Phoneno!");
            alert.showAndWait();
            return false;
        }
    }



    @FXML
    protected void AddMemberButton() {
        String Name = name.getText();
        String MemberID = mem_id.getText();
        String EmailID = e_id.getText();
        String PhoneNo = phoneno.getText();
        DatabaseConnector connectnow = new DatabaseConnector();
        Connection connectdb = connectnow.getConnection();
        PreparedStatement psinsert = null;
        PreparedStatement pscheck = null;
        ResultSet resultSet = null;

        if(name.getText().isBlank() && mem_id.getText().isBlank() && e_id.getText().isBlank() && phoneno.getText().isBlank()){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Validate Member Details");
            alert.setHeaderText(null);
            alert.setContentText("Please Enter All The Details!");
            alert.showAndWait();
        }

        else if (validatemembername() && validatememberid() && validatememberemail() && validatephoneno()) {


            try {
                pscheck = connectdb.prepareStatement("select * from membermanage where MemberID= ?");
                pscheck.setString(1, MemberID);
                resultSet = pscheck.executeQuery();
                if (resultSet.isBeforeFirst()) {
                    System.out.println("There Exists Already A Member With The Given ID");
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("MemberID Already Exists");
                    alert.show();
                } else {

                    psinsert = connectdb.prepareStatement("insert into membermanage VALUES (?,?,?,?)");
                    psinsert.setString(1, Name);
                    psinsert.setString(2, MemberID);
                    psinsert.setString(3, EmailID);
                    psinsert.setString(4, PhoneNo);
                    psinsert.executeUpdate();

                    AddMemberLabel.setText("Member Added Successfully!");

                }
            } catch (SQLException ep) {
                ep.printStackTrace();
            }

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
    protected void GoToAddBook(ActionEvent e){
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
    protected void GoToManageMemberDetails(ActionEvent e){
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