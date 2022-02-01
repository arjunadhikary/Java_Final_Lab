module com.example.java_final_lab {
    requires javafx.controls;
    requires javafx.fxml;

    requires java.sql;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires mysql.connector;


    opens com.example.java_final_lab to javafx.fxml;
    exports com.example.java_final_lab;
}