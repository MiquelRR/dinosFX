module com.example {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires javafx.base;
    opens com.example to javafx.fxml;
    opens com.example.clases;
    exports com.example;
}
