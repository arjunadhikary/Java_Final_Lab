package com.example.java_final_lab;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import jdbc_connection.DbOperations;
import java.net.URL;
import java.util.ResourceBundle;


public class SignupController implements Initializable {
public static boolean status = false;

    @FXML
    TextField nameField,emailField;
    @FXML
    PasswordField passwordField;


    @FXML
    private void signUp(ActionEvent e) throws Exception {
        DbOperations.connect();
        String name = nameField.getText();
        String email = emailField.getText();
        String password = passwordField.getText();
        boolean signup = DbOperations.insertData(name.trim(), email.trim(), password.trim());
        System.out.println(signup);
        if (signup) {
            status = true;
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login.fxml"));
            //window object
            Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
//        Scene old_scene =  (Scene) ((Node)event.getSource()).getScene();
            Scene sc = new Scene(fxmlLoader.load());
            stage.setTitle("Signup!");
            stage.setScene(sc);
            stage.show();
            stage.setResizable(false);

        }
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void signback(ActionEvent event) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login.fxml"));
        //window object
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        Scene old_scene =  (Scene) ((Node)event.getSource()).getScene();
        Scene sc = new Scene(fxmlLoader.load());
        stage.setTitle("Signup!");
        stage.setScene(sc);
        stage.show();
        stage.setResizable(false);
    }
}
