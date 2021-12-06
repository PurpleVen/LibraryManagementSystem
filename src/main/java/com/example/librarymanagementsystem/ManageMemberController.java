package com.example.librarymanagementsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ManageMemberController {
    @FXML
    protected void GoToDashboard(ActionEvent e)

    {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Dashboard.fxml"));
            ((Node)(e.getSource())).getScene().getWindow().hide();
            Parent root1 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setResizable(false);
            stage.setScene(new Scene(root1));
            stage.show();
        } catch(Exception ep) {
            ep.printStackTrace();
        }}

    @FXML
    protected void GoToIssueBook(ActionEvent e){
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("IssueBook.fxml"));
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
    protected void GoToAddBook(ActionEvent e)

    {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AddBook.fxml"));
            ((Node)(e.getSource())).getScene().getWindow().hide();
            Parent root1 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setResizable(false);
            stage.setScene(new Scene(root1));
            stage.show();
        } catch(Exception ep) {
            ep.printStackTrace();
        }}

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
    protected void GoToManageBook(ActionEvent e){
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
