/*package com.example.librarymanagementsystem;

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
                System.out.println("There Exists Already A Book With The Given ID");
                Alert alert=new Alert(Alert.AlertType.ERROR);
                alert.setContentText("BookID Already Exists");
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
*/

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

    private boolean validatebooktitle(){
        if (Booktitle.getText().length()>0){
            return true;
        }else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Validate book title");
            alert.setHeaderText(null);
            alert.setContentText("PLease enter valid book title");
            alert.showAndWait();
            return false;
        }
    }
    private boolean validatebookid(){
        if (Bookid.getText().length()>0){
            return true;
        }else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Validate book ID");
            alert.setHeaderText(null);
            alert.setContentText("PLease enter valid book id");
            alert.showAndWait();
            return false;
        }
    }
    private boolean validateisbn(){
        if (isbn.getText().length()>0){
            return true;
        }else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Validate ISBN");
            alert.setHeaderText(null);
            alert.setContentText("PLease enter valid book isbn");
            alert.showAndWait();
            return false;
        }
    }
    private boolean validateauthor(){
        if (author.getText().length()>0){
            return true;
        }else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Validate book author");
            alert.setHeaderText(null);
            alert.setContentText("PLease enter valid book author");
            alert.showAndWait();
            return false;
        }
    }
    private boolean validategenre(){
        if (genre.getText().length()>0){
            return true;
        }else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Validate book genre");
            alert.setHeaderText(null);
            alert.setContentText("PLease enter valid book genre");
            alert.showAndWait();
            return false;
        }
    }
    private boolean validatenoofcopies(){
        if (noofcopies.getText().length()>0){
            return true;
        }else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Validate no of books");
            alert.setHeaderText(null);
            alert.setContentText("PLease enter no of copies");
            alert.showAndWait();
            return false;
        }
    }

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
        if(Booktitle.getText().isBlank() && Bookid.getText().isBlank() && isbn.getText().isBlank() && author.getText().isBlank() && genre.getText().isBlank() && noofcopies.getText().isBlank()){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Validate add book");
            alert.setHeaderText(null);
            alert.setContentText("Please Enter Details!");
            alert.showAndWait();
        }
        else if (validatebooktitle()&&validatebookid()&&validateisbn()&&validateauthor()&&validategenre()&&validatenoofcopies()){
            try
            {
                pscheck=connectdb.prepareStatement("select * from addbook where BookID= ?");
                pscheck.setString(1,BookId);
                resultSet=pscheck.executeQuery();
                if(resultSet.isBeforeFirst())
                {
                    System.out.println("There Exists Already A Book With The Given ID");
                    Alert alert=new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("BookID Already Exists");
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
                    Booktitle.clear();
                    Bookid.clear();
                    isbn.clear();
                    author.clear();
                    genre.clear();
                    noofcopies.clear();



                }
            }catch(SQLException ep)
            {
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