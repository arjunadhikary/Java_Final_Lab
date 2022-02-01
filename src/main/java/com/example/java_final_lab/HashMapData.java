package com.example.java_final_lab;

import javafx.collections.ObservableList;
import javafx.scene.chart.XYChart;
import jdbc_connection.Books;
import jdbc_connection.DbOperations;

import java.util.HashMap;
import java.util.Map;

public class HashMapData {

    private int getQuantify(Books book,HashMap<String,Number> hashMap,String category){
        if((Integer) hashMap.get(category)!=0) {
            return (Integer) hashMap.get(category) + (book.getQuantity());
        }else {
            return (book.getQuantity());
        }
    }

    public XYChart.Series<String,Number> series() throws Exception {
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        try {
            ObservableList<Books> lst = DbOperations.getBookData();
            HashMap<String, Number> hashMap = new HashMap<>();
            hashMap.put(LineController.CategoryList.Romance, 0);
            hashMap.put(LineController.CategoryList.Si_Fi, 0);
            hashMap.put(LineController.CategoryList.Mystery, 0);
            hashMap.put(LineController.CategoryList.Fiction, 0);
            hashMap.put(LineController.CategoryList.Classic, 0);


            for (Books books : lst) {
                System.out.println(books.getCategory());
                switch (books.getCategory()) {
                    case "Fiction" -> {
                        int total = getQuantify(books, hashMap, LineController.CategoryList.Fiction);
                        hashMap.put(LineController.CategoryList.Fiction, total);
                    }
                    case "Romance" -> {
                        int total = getQuantify(books, hashMap, LineController.CategoryList.Romance);
                        hashMap.put(LineController.CategoryList.Romance, total);

                    }
                    case "Mystery" -> {
                        int total = getQuantify(books, hashMap, LineController.CategoryList.Mystery);
                        hashMap.put(LineController.CategoryList.Mystery, total);
                    }
                    case "Classic" -> {
                        int total = getQuantify(books, hashMap, LineController.CategoryList.Classic);
                        hashMap.put(LineController.CategoryList.Classic, total);
                    }
                    case "Si-Fi" -> {
                        int total = getQuantify(books, hashMap, LineController.CategoryList.Si_Fi);
                        hashMap.put(LineController.CategoryList.Si_Fi, total);
                    }
                    default -> throw new IllegalStateException("Unexpected value: ");
                }

            }
            for (Map.Entry<String, Number> entry : hashMap.entrySet()) {
                String key = entry.getKey();
                Number value = entry.getValue();
                System.out.println(key + value);
                series.getData().add(new XYChart.Data<>(key, value));

            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return series;
    }

}


