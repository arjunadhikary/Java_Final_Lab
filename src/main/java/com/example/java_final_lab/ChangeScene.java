package com.example.java_final_lab;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public  class ChangeScene {

      static void changeScene(ActionEvent e,Button lineChart,Button barChart,Button pieChart,Button logout,Button home) throws Exception{
         Button btn =(Button)e.getSource();
           System.out.println("Called"+btn);
         if(btn == lineChart){
             changeScene("line.fxml",e);
         }else  if(btn == barChart){
             changeScene("bar.fxml",e);

         }else  if(btn == pieChart){
             changeScene("pie.fxml",e);
         }
         else  if(btn == logout){
             changeScene("login.fxml",e);

         }else  if(btn == home){
             System.out.println("Here");
             changeScene("home.fxml",e);

         }

     }

     static void  changeScene(String fxmlName,ActionEvent event) throws  Exception{
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(fxmlName));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene sc = new Scene(fxmlLoader.load());
        stage.setScene(sc);
        stage.show();

    }
}
