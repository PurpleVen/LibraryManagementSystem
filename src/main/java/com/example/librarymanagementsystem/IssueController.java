package com.example.librarymanagementsystem;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import java.net.URL;
import java.sql.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;

public  class IssueController extends NullPointerException {
    @FXML
    private Label IssueBookLabel;
    @FXML
    private TextField Bookid;
    @FXML
    private TextField Memberid;
    @FXML
    private DatePicker Issuedate;
    @FXML
    private DatePicker Returndate;

    private boolean validatebookid(){
        if (Bookid.getText().length()>0){
            return true;
        }else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Validate Book ID");
            alert.setHeaderText(null);
            alert.setContentText("Please Enter Book ID!");
            alert.showAndWait();
            return false;
        }
    }
    private boolean validatememberid(){
        if (Memberid.getText().length()>0){
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
    /*private boolean validateIssueDate(){
        if (Issuedate.toString().length()>0){
            return true;
        }else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Validate Issue Date");
            alert.setHeaderText(null);
            alert.setContentText("Please Enter Issue Date!");
            alert.showAndWait();
            return false;
        }
    }
    private boolean validateReturnDate(){
        if (Returndate.toString().length()>0){
            return true;
        }else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Validate Return Date");
            alert.setHeaderText(null);
            alert.setContentText("Please Enter Return Date!");
            alert.showAndWait();
            return false;
        }
    }*/


    @FXML
    protected void IssueButton() {
        String BookID = Bookid.getText();
        String MemberID = Memberid.getText();
        LocalDate IssueDate = Issuedate.getValue();
        LocalDate ReturnDate = Returndate.getValue();
        DatabaseConnector connectnow = new DatabaseConnector();
        Connection connectdb = connectnow.getConnection();
        PreparedStatement psinsert = null;
        PreparedStatement ptotal, pfull, pscheck = null;
        ResultSet resultSet = null;

        if (Bookid.getText().isBlank() && Memberid.getText().isBlank()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Validate Issue Details");
            alert.setHeaderText(null);
            alert.setContentText("LOL common sense");
            alert.showAndWait();
        } else if (validatebookid() && validatememberid()) {

            try {
                pscheck = connectdb.prepareStatement("select addbook.BookID, membermanage.MemberID from addbook, membermanage where addbook.BookID = ? and membermanage.MemberID = ?");
                pscheck.setString(1, BookID);
                pscheck.setString(2, MemberID);
                resultSet = pscheck.executeQuery();
                if(resultSet.isBeforeFirst()) {
                    PreparedStatement pbook = connectdb.prepareStatement("select * from issuebook where BookID =?");
                    pbook.setString(1, BookID);
                    ResultSet rs = pbook.executeQuery();

                    if (rs.isBeforeFirst()) {
                        System.out.println("This Book is already issued");
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setContentText("This Book is already issued");
                        alert.show();
                    }
                    else{
                        psinsert = connectdb.prepareStatement("insert into issuebook VALUES (?,?,?,?)");
                        psinsert.setString(1, BookID);
                        psinsert.setString(2, MemberID);
                        psinsert.setString(3, IssueDate.toString());
                        psinsert.setString(4, ReturnDate.toString());
                        psinsert.executeUpdate();

                        IssueBookLabel.setText("Book Issued Successfully!");
                        Bookid.clear();
                        Memberid.clear();
                        Issuedate.getEditor().clear();
                        Returndate.getEditor().clear();
                    }
                }


                    else {
                    System.out.println("This Book/Member Does Not Exist");
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("This Book/Member Does Not Exist");
                    alert.show();
                }
            } catch (SQLException ep) {
                ep.printStackTrace();
            }


        }
    }

        @FXML
        protected void GoToDashboard(ActionEvent e) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Dashboard.fxml"));
                ((Node) (e.getSource())).getScene().getWindow().hide();
                Parent root1 = fxmlLoader.load();
                Stage stage = new Stage();
                stage.setResizable(false);
                stage.setScene(new Scene(root1));
                stage.show();
            } catch (Exception ep) {
                ep.printStackTrace();
            }
        }

        @FXML
        protected void GoToAddBook(ActionEvent e) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AddBook.fxml"));
                ((Node) (e.getSource())).getScene().getWindow().hide();
                Parent root1 = fxmlLoader.load();
                Stage stage = new Stage();
                stage.setResizable(false);
                stage.setScene(new Scene(root1));
                stage.show();
            } catch (Exception ep) {
                ep.printStackTrace();
            }
        }

        @FXML
        protected void GoToManageDetailsBook(ActionEvent e) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("BookDetails.fxml"));
                ((Node) (e.getSource())).getScene().getWindow().hide();
                Parent root1 = fxmlLoader.load();
                Stage stage = new Stage();
                stage.setResizable(false);
                stage.setScene(new Scene(root1));
                stage.show();
            } catch (Exception ep) {
                ep.printStackTrace();
            }
        }

        @FXML
        protected void GoToAddMember(ActionEvent e) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MemberAdd.fxml"));
                ((Node) (e.getSource())).getScene().getWindow().hide();
                Parent root1 = fxmlLoader.load();
                Stage stage = new Stage();
                stage.setResizable(false);
                stage.setScene(new Scene(root1));
                stage.show();
            } catch (Exception ep) {
                ep.printStackTrace();
            }
        }

        @FXML
        protected void GoToManageMemberDetails(ActionEvent e) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MemberDetails.fxml"));
                ((Node) (e.getSource())).getScene().getWindow().hide();
                Parent root1 = fxmlLoader.load();
                Stage stage = new Stage();
                stage.setResizable(false);
                stage.setScene(new Scene(root1));
                stage.show();
            } catch (Exception ep) {
                ep.printStackTrace();
            }
        }

        @FXML
        protected void GoBackToLogin(ActionEvent e) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("login.fxml"));
                ((Node) (e.getSource())).getScene().getWindow().hide();
                Parent root1 = fxmlLoader.load();
                Stage stage = new Stage();
                stage.setResizable(false);
                stage.setScene(new Scene(root1));
                stage.show();
            } catch (Exception ep) {
                ep.printStackTrace();
            }
        }

    }




