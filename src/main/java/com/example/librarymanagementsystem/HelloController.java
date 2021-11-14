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
            LoginMessage.setText("Invalid Login!");
        }
        else{
            LoginMessage.setText("Please Enter Username And Password.");
        }
    }


    public void cancelButtonOnAction(ActionEvent e){
        Stage stage = (Stage)cancelButton.getScene().getWindow();
        stage.close();
    }
}