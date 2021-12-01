/*package com.example.librarymanagementsystem;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class DuedateDetailsController implements Initializable {

    /* @FXML
     private Label IssueBookLabel;*/
  /*  @FXML
    private TableView<DuedateDetailsInfo> table;
    @FXML
    private TableColumn<DuedateDetailsInfo, String> memberid;
    @FXML
    private TableColumn<DuedateDetailsInfo, String> membername;
    @FXML
    private TableColumn<DuedateDetailsInfo, String> bookname;
    @FXML
    private TableColumn<DuedateDetailsInfo, Date> duedate;
    @FXML
    private TableColumn<DuedateDetailsInfo, Double> fine;

    final ObservableList<DuedateDetailsInfo> listview = FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle rb){
        memberid.setCellValueFactory(new PropertyValueFactory<>("BookID"));
        membername.setCellValueFactory(new PropertyValueFactory<>("title"));
        bookname.setCellValueFactory(new PropertyValueFactory<>("BookISBN"));
        duedate.setCellValueFactory(new PropertyValueFactory<>("author"));
        fine.setCellValueFactory(new PropertyValueFactory<>("genre"));
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

*/