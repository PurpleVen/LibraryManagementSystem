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

    @FXML
    protected void IssueButton() {
        String BookID = Bookid.getText();
        String MemberID = Memberid.getText();
        LocalDate IssueDate = Issuedate.getValue();
        LocalDate ReturnDate = Returndate.getValue();
        DatabaseConnector connectnow = new DatabaseConnector();
        Connection connectdb = connectnow.getConnection();
        PreparedStatement psinsert = null;
        PreparedStatement pscheck = null;
        ResultSet resultSet = null;

        try {
            pscheck = connectdb.prepareStatement("select * from issuebook where BookID= ?");
            pscheck.setString(1, BookID);
            resultSet = pscheck.executeQuery();
            if (resultSet.isBeforeFirst()) {
                System.out.println("This Book Doesn't Exist...");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("NO.");
                alert.show();
            } else {

                psinsert = connectdb.prepareStatement("insert into issuebook VALUES (?,?,?,?)");
                psinsert.setString(1, BookID);
                psinsert.setString(2, MemberID);
                psinsert.setString(3, IssueDate.toString());
                psinsert.setString(4, ReturnDate.toString());
                psinsert.executeUpdate();

                IssueBookLabel.setText("Book Issued Successfully!");


            }
        } catch (SQLException ep) {
            ep.printStackTrace();
        }

    }

    public class IssueBookDetailsController implements Initializable {
        /* @FXML
    private Label IssueBookLabel;*/
        @FXML
        private TableView<IssueDetailsInfo> table1;
        @FXML
        private TableColumn<IssueDetailsInfo, Integer> bookid;
        @FXML
        private TableColumn<IssueDetailsInfo, Integer> memberid;
        @FXML
        private TableColumn<IssueDetailsInfo, java.util.Date> issuedate;
        @FXML
        private TableColumn<IssueDetailsInfo, Date> returndate;

        final ObservableList<IssueDetailsInfo> listview1 = FXCollections.observableArrayList();

        @Override
        public void initialize(URL url, ResourceBundle rb) {
            bookid.setCellValueFactory(new PropertyValueFactory<>("BookID"));
            memberid.setCellValueFactory(new PropertyValueFactory<>("MemberID"));
            issuedate.setCellValueFactory(new PropertyValueFactory<>("IssueDate"));
            returndate.setCellValueFactory(new PropertyValueFactory<>("ReturnDate"));
            try {
                DatabaseConnector connectnow = new DatabaseConnector();
                Connection connectdb = connectnow.getConnection();

                String sql = "select *  from issuebook";
                Statement s1 = connectdb.createStatement();
                ResultSet resultSet = s1.executeQuery(sql);

                while (resultSet.next()) {
                    listview1.add(new IssueDetailsInfo(resultSet.getInt("BookID"),
                            resultSet.getInt("MemberID"),
                            resultSet.getDate("IssueDate"),
                            resultSet.getDate("ReturnDate")));
                }
                table1.setItems(listview1);

            } catch (Exception ep) {
                ep.printStackTrace();

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
        protected void GoToManageMember(ActionEvent e) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MemberManage.fxml"));
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
}



