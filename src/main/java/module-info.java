module com.example.alltraz {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.logging;
    requires java.sql;
    requires mysql.connector.java;


    opens com.example.alltraz to javafx.fxml;
    exports com.example.alltraz;
    exports com.example.model;

}