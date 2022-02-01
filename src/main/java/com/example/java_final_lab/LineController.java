package com.example.java_final_lab;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import jdbc_connection.Books;
import jdbc_connection.DbOperations;

import java.net.URL;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class LineController implements Initializable {

    @FXML
    Button home,lineChartButton,barChartButton,logout,pieChartButton;

    @FXML
    public  void buttonHandler(ActionEvent e)throws Exception{

        ChangeScene.changeScene(e,lineChartButton,barChartButton,pieChartButton,logout,home);


    }

    static class CategoryList{
        public static String Romance = "Romantic";
        public static String Si_Fi = "Si-Fi";
        public static String Mystery = "Mystery";
        public static String Fiction = "Fiction";
        public static String Classic = "Classic";
    }

    @FXML
    LineChart<String,Number> lineChart;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
        XYChart.Series<String,Number> series = new HashMapData().series();
                series.setName("Books Category");
                lineChart.getData().add(series);
            } catch (Exception exception) {
            exception.printStackTrace();
        }


    }

}
