package com.example.java_final_lab;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import jdbc_connection.DbOperations;

import java.net.URL;
import java.util.ResourceBundle;

public class Home implements Initializable {

    @FXML
    ComboBox<String> comboBox;


    @FXML
    Button home,lineChartButton,barChartButton,logout,pieChartButton;

    @FXML
    TextField bookName,price,quantity;

    @FXML
    StackPane stackpane;


    @FXML
    public void addBook(){
        try {
           boolean added =  DbOperations
                   .insertDataIntoBooksTable(
                           bookName.getText().trim(),
                           comboBox.getValue(),
                           Integer.parseInt(price.getText().trim()),
                           Integer.parseInt(quantity.getText().trim())
                   );
            System.out.println(added);
           if(added){
               bookName.setText("");
               price.setText("");
               quantity.setText("");

           }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    @FXML

    public  void buttonHandler(ActionEvent e)throws Exception {
        ChangeScene.changeScene(e,lineChartButton,barChartButton,pieChartButton,logout,home);
        Button btn = new Button();

    }







    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        comboBox.getItems().removeAll(comboBox.getItems());
        comboBox.getItems().addAll("Classic", "Mystery", "Romance","Si-Fi","Fictions");
        comboBox.getSelectionModel().select("Mystery");
        
    }
}
