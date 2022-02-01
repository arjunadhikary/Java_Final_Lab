package com.example.java_final_lab;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class TableController {



    public TableController() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("table.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Button btn = new Button();
       Stage stage =  (Stage)btn.getScene().getWindow();
       stage.setScene(scene);
    }
}
