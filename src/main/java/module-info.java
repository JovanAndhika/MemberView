module com.example.memberview {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.sql;


    opens com.example.memberview to javafx.fxml;
    exports com.example.memberview;
}