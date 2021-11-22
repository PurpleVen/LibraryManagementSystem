package com.example.librarymanagementsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Hyperlink;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.Scene;
import java.net.URI;
import java.net.URISyntaxException;


import java.io.IOException;
import java.net.URISyntaxException;

public class SceneController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void switchTologin(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
       // Image image = new Image("file: src/main/java/Assets/undraw_book_lover_mkck__1_-removebg-preview.png");
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToDashboard(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToDueDate(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("DueDate.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToIssueBook(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("IssueBook.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToAddBook(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("AddBook.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToBookDetails(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("BookDetails.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToManageBook(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("ManageBook.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToMemberAdd(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("MemberAdd.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToMemberDetails(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("MemberDetails.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToMemberManage(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("MemberManage.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /*@FXML
    private Hyperlink hyperlink;

    @FXML
    void openLink(ActionEvent event) throws URISyntaxException, IOException{
        System.out.println("Yayyy!");
        Desktop.getDesktop().browse(new URI("https://github.com/PurpleVen"));
    }*/

}


