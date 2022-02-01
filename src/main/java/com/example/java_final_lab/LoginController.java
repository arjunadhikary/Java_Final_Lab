package com.example.java_final_lab;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import jdbc_connection.DbOperations;



public class LoginController implements Status {

    DbOperations db;
    public static boolean  failedStatus = false;

    @FXML
    Label invalidMessage;

    @FXML
    Label success;
    @FXML
    TextField email;
    @FXML
    TextField password;

    @FXML
    protected void loginEvent(ActionEvent event) throws Exception {


        boolean isSuccess = DbOperations.login(email.getText().trim(), password.getText().trim());
        System.out.println(isSuccess);
        if (isSuccess) {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("home.fxml"));
            //window object
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        Scene old_scene =  (Scene) ((Node)event.getSource()).getScene();
            Scene sc = new Scene(fxmlLoader.load());
            stage.setTitle("Signup!");
            stage.setScene(sc);
            stage.show();
            stage.setResizable(false);
        } else {
            invalidMessage.setVisible(true);
        }
    }



    @FXML
    protected void signupbth(ActionEvent event) throws Exception {


            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("signup.fxml"));
            //window object
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        Scene old_scene =  (Scene) ((Node)event.getSource()).getScene();
            Scene sc = new Scene(fxmlLoader.load());
            stage.setTitle("Signup!");
            stage.setScene(sc);
            stage.show();
            stage.setResizable(false);

    }


    @Override
    public void status(boolean sts) {

        if(SignupController.status){
            System.out.println(sts);
            success.setVisible(true);
        }

    }
}