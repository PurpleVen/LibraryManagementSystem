package com.example.librarymanagementsystem;

        import javafx.application.Platform;
        import javafx.event.ActionEvent;
        import javafx.fxml.FXML;
        import javafx.scene.control.Button;
        import javafx.scene.control.Label;
        import javafx.stage.Stage;
        import javafx.scene.control.TextField;
        import javafx.scene.control.PasswordField;

        import java.sql.*;

public class HelloController{

    @FXML
    private Button cancelButton;

    @FXML
    private Label LoginMessage;

    @FXML
    private TextField Username;

    @FXML
    private PasswordField Password;

    public void loginButtonOnAction(ActionEvent e) throws SQLException {
        LoginMessage.setText("Invalid Login!");

        if(Username.getText().isBlank() ==  false && Password.getText().isBlank() == false) {
           // LoginMessage.setText("Invalid Login!");
            ValidateLibManLogin();
        }
        else{
            LoginMessage.setText("Please Enter Username And Password.");
        }
    }


    public void cancelButtonOnAction(ActionEvent e){
        Stage stage = (Stage)cancelButton.getScene().getWindow();
       stage.close();

    }

    public void ValidateLibManLogin() throws SQLException {
        DatabaseConnector connectNow = new DatabaseConnector();
       //Connection connectDB = DriverManager.getConnection("jdbc:mysql://jblminiproject-do-user-10209104-0.b.db.ondigitalocean.com", "purpleven", "DxWTYB7IuaiGe0BS");
        Connection connectDB = connectNow.getConnection();
        //Connection connectDB = DriverManager.getConnection("jblminiproject-do-user-10209104-0.b.db.ondigitalocean.com", "purpleven", "DxWTYB7IuaiGe0BS");

        String verifyLogin = "SELECT COUNT(1) FROM login WHERE Username = ' " +Username.getText()+ " ' AND Password =  ' " +Password.getText()+ " ' ";


        try {

            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(verifyLogin);

            while (queryResult.next()){
                if(queryResult.getInt(1) == 1){
                    LoginMessage.setText("Welcome!");
                }
                else{
                    LoginMessage.setText("Invalid Login!");
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}



