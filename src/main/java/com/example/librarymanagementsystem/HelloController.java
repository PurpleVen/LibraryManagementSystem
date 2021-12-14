/*package com.example.librarymanagementsystem;

        import javafx.application.Platform;
        import javafx.event.ActionEvent;
        import javafx.fxml.FXML;
        import javafx.fxml.FXMLLoader;
        import javafx.scene.Parent;
        import javafx.scene.Scene;
        import javafx.scene.control.Button;
        import javafx.scene.control.Label;
        import javafx.stage.Stage;
        import javafx.scene.Node;
        import javafx.scene.control.TextField;
        import javafx.scene.control.PasswordField;
        import javafx.stage.StageStyle;

        import java.sql.*;

public class HelloController extends NullPointerException{

    @FXML
    private Button cancelButton;

    @FXML
    private Label LoginMessage;

    @FXML
    private TextField Username;

    @FXML
    private PasswordField Password;

*/

  /*  @FXML
    public void loginButtonOnAction(ActionEvent e)  {
       // LoginMessage.setText("Invalid Login!");

        if(!Username.getText().isBlank() && !Password.getText().isBlank()) {
            //LoginMessage.setText("Invalid sakjhsaujn Login!");
            ValidateLibManLogin(e);
        }
        else{
            LoginMessage.setText("Please Enter Username And Password.");
        }
    }


    public void cancelButtonOnAction(ActionEvent e){
        Stage stage = (Stage)cancelButton.getScene().getWindow();
       stage.close();

    }

    @FXML
    public void login(ActionEvent e){
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Dashboard.fxml"));
            ((Node)(e.getSource())).getScene().getWindow().hide();
            Parent root1 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        }catch (Exception ep){
            ep.printStackTrace();
        }
    }


    public void ValidateLibManLogin(ActionEvent e) {
        DatabaseConnector connectNow = new DatabaseConnector();
       //Connection connectDB = DriverManager.getConnection("jdbc:mysql://jblminiproject-do-user-10209104-0.b.db.ondigitalocean.com", "purpleven", "DxWTYB7IuaiGe0BS");
        Connection connectDB = connectNow.getConnection();
        //Connection connectDB = DriverManager.getConnection("jblminiproject-do-user-10209104-0.b.db.ondigitalocean.com", "purpleven", "DxWTYB7IuaiGe0BS");

        //String verifyLogin = "SELECT COUNT(1) FROM login WHERE Username = ' " +Username.getText()+ " ' AND Password =  ' " +Password.getText()+ " ' ";
        //String verifyLogin = "SELECT * from login where Username = ? and Password = ?";
      //  String verifyLogin = "SELECT * FROM login WHERE Username = ' " +Username.getText()+ " ' AND Password =  ' " +Password.getText()+ " ' ";
        String verifyLogin = "Select count(1) from Login where username = ' "+ Username.getText() +  " ' and password =  ' " +Password.getText()+ " ' ";
        try {

            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(verifyLogin);

            while (queryResult.next()){
                if(queryResult.getInt(1) == 1){

                    try {

                            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Dashboard.fxml"));
                            ((Node)(e.getSource())).getScene().getWindow().hide();
                            Parent root1 = fxmlLoader.load();
                            Stage stage = new Stage();
                            stage.setScene(new Scene(root1));
                            stage.show();
                        }catch(Exception ep){
                            ep.printStackTrace();
                        }

                    //LoginMessage.setText("Welcome!");

                    //Parent root = FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
                }
                else{
                    LoginMessage.setText("Invalid Login!");
                }
            }
        }catch (Exception ep){
            ep.printStackTrace();
        }
    }
*/
   /* public void GoToDashboard(){
        try{
            Parent root = FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
            Stage DashboardStage = new Stage();
            DashboardStage.initStyle(StageStyle.UNDECORATED);
            DashboardStage.setScene(new Scene(root, 700, 600));
            DashboardStage.show();

        } catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }*/
//}

package com.example.librarymanagementsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.Node;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.event.ActionEvent;
import javafx.scene.Scene;

import java.sql.*;

public  class HelloController extends NullPointerException  {
    @FXML
    private Label LoginMessage;
    @FXML
    private TextField Username;
    @FXML
    private PasswordField Password;

    @FXML
    private Button cancelButton;

    @FXML
    private Label BookCount;


    @FXML
    public void loginButtonOnAction(ActionEvent e) {

        if (!Username.getText().isBlank() && !Password.getText().isBlank() ){
            validatelogin(e);
        } else {
            LoginMessage.setText("Please Enter Username And Password");
        }
    }

    public void validatelogin(ActionEvent e) {
        DatabaseConnector connectnow = new DatabaseConnector();
        Connection connectdb = connectnow.getConnection();
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        String verifylogin = "select count(1) from Login where Username ='" + Username.getText() + "' and Password='" + Password.getText() + "'";
        try {
            Statement statement = connectdb.createStatement();
            ResultSet queryResult = statement.executeQuery(verifylogin);
            while (queryResult.next()) {
                if (queryResult.getInt(1) == 1) {
                    try {
                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Dashboard.fxml"));
                        ((Node)(e.getSource())).getScene().getWindow().hide();
                        Parent root1 = fxmlLoader.load();
                        Stage stage = new Stage();
                        stage.setScene(new Scene(root1));
                        stage.setResizable(false);
                        stage.show();

                    } catch (Exception ep) {
                        ep.printStackTrace();
                    }
                } else {
                    LoginMessage.setText("Invalid Login!");
                }
            }
        } catch (Exception ep) {
            ep.printStackTrace();
        }

    }

    public void cancelButtonOnAction(ActionEvent e){
        Stage stage = (Stage)cancelButton.getScene().getWindow();
        stage.close();

    }





}

