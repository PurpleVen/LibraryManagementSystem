package com.example.librarymanagementsystem;

/*import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}
*/

        import javafx.event.ActionEvent;
        import javafx.fxml.FXML;
        import javafx.scene.control.Button;
        import javafx.scene.control.Label;
        import javafx.stage.Stage;
        import javafx.scene.control.TextField;
        import javafx.scene.control.PasswordField;
        import java.sql.Connection;
        import java.sql.ResultSet;
        import java.sql.Statement;

public class HelloController {

    @FXML
    private Button cancelButton;

    @FXML
    private Label LoginMessage;

    @FXML
    private TextField Username;

    @FXML
    private PasswordField Password;

    public void loginButtonOnAction(ActionEvent e){
        // LoginMessage.setText("Invalid Login!");

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

    public void ValidateLibManLogin(){
        DatabaseConnector connectNow = new DatabaseConnector();
        Connection connectDB = connectNow.getConnection();

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

//Exampleeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee