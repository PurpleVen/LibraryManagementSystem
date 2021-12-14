package com.example.librarymanagementsystem;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.*;
import java.util.Date;
import java.util.ResourceBundle;

public class BookDetailsController implements Initializable {

   /* @FXML
    private Label IssueBookLabel;*/
    @FXML
    private TableView<BookDetailsinfo> table;
    @FXML
    private TableColumn<BookDetailsinfo, String> id;
    @FXML
    private TableColumn<BookDetailsinfo, String> title;
    @FXML
    private TableColumn<BookDetailsinfo, String> isbn;
    @FXML
    private TableColumn<BookDetailsinfo, String> author;
    @FXML
    private TableColumn<BookDetailsinfo, String> quantity;
    @FXML
    private TableColumn<BookDetailsinfo, String> genre;


    final ObservableList<BookDetailsinfo> listview = FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle rb){
        id.setCellValueFactory(new PropertyValueFactory<>("BookID"));
        title.setCellValueFactory(new PropertyValueFactory<>("title"));
        isbn.setCellValueFactory(new PropertyValueFactory<>("BookISBN"));
        author.setCellValueFactory(new PropertyValueFactory<>("author"));
        genre.setCellValueFactory(new PropertyValueFactory<>("genre"));
        quantity.setCellValueFactory(new PropertyValueFactory<>("NoOfCopies"));
        try{
            DatabaseConnector connectnow = new DatabaseConnector();
            Connection connectdb = connectnow.getConnection();

            String sql = "select *  from addbook";
            Statement s = connectdb.createStatement();
            ResultSet resultSet = s.executeQuery(sql);

            while (resultSet.next()){
                listview.add(new BookDetailsinfo(resultSet.getString("BookID"),
                                      resultSet.getString("Title"),
                                      resultSet.getString("BookISBN"),
                                      resultSet.getString("Author"),
                                      resultSet.getString("Genre"),
                                      resultSet.getInt("NoOfCopies")));
            }
            table.setItems(listview);

        }
        catch (Exception e){
            e.printStackTrace();

        }
    }


    /*private void button(ActionEvent event){
        if(event.getSource() == EditButton){
            EditBookDetails();
        }
        else if (event.getSource() == DeleteButton){
            DeleteBookDetails();

        }

    }*/

   /* private void EditBookDetails(){
        String query = "Update addbook set Title = ' " +title.getText()+ " ', BookID = ' " +id.getText()+ " ',BookISBN =  " +isbn.getText()+ " ,Author =  " +author.getText()+ " ,NoOfCopies =  " +quantity.getText()+ "";
        executeQuery(query);
        //BookDetailsinfo();
    }

    private void executeQuery(String query){
        DatabaseConnector connectnow = new DatabaseConnector();
        Connection connectdb = connectnow.getConnection();
        Statement statement;
        try{
            statement = connectdb.createStatement();
            statement.executeUpdate(query);
        }catch (Exception ex){
            ex.printStackTrace();
        }

    }*/

    /*private void DeleteBookDetails(){
        String query = "Delete from addbook where BookID = " +id.getText()+ " ";
        executeQuery(query);
      //  BookDetailsinfo();
    }*/






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
    protected void GoToManageBook(ActionEvent e) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ManageBook.fxml"));
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





