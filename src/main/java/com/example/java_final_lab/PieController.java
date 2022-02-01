package com.example.java_final_lab;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import jdbc_connection.Books;
import jdbc_connection.DbOperations;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PieController implements Initializable,Status {
    @FXML
    PieChart pieChart;

    @FXML

    Button home,lineChartButton,barChartButton,logout,pieChartButton;

    @FXML

    public  void buttonHandler(ActionEvent e)throws Exception{

        ChangeScene.changeScene(e,lineChartButton,barChartButton,pieChartButton,logout,home);



    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        pieChart.setTitle("Books available in Library");

        pieChart.setLabelsVisible(true);

        ObservableList<Books> lst = null;
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();

        try {
            lst = DbOperations.getBookData();
            for (Books book: lst){
                pieChartData.add( new PieChart.Data(book.getName(), (book.getQuantity())));
            }
            pieChart.setData(pieChartData);

        } catch (Exception e) {
            e.printStackTrace();

    }
    }

    @Override
    public void status(boolean sts) {


    }
}
