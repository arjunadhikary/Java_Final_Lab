package com.example.java_final_lab;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import jdbc_connection.DbOperations;


public class HelloApplication extends Application implements Status{
    boolean failedStatus;
    public  static boolean isLoggedIn = false;
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login.fxml"));
        try {
            DbOperations.connect();
        } catch (Exception e) {
            System.out.println("Database couldn't be connected");
            this.failedStatus = true;
            isLoggedIn = false;

        }
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Login");
        stage.getIcons().add(new Image("https://codekavya.com/wp-content/uploads/2021/07/Codekaya-White-in-Black-Square-scaled.jpg"));
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);

    }

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void status(boolean sts) {
        LoginController.failedStatus = this.failedStatus;
    }
}