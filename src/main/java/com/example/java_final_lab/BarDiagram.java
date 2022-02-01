package com.example.java_final_lab;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;

public class BarDiagram implements Initializable {
    @FXML
    BarChart<String,Number> barChart;

    @FXML
    Button home,lineChartButton,barChartButton,logout,pieChartButton;

    @FXML

    public  void buttonHandler(ActionEvent e)throws Exception{

        ChangeScene.changeScene(e,lineChartButton,barChartButton,pieChartButton,logout,home);



    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();



        try {
            barChart.getData().add(new HashMapData().series());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
