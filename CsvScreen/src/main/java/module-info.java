module com.example.seila {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.seila to javafx.fxml;
    exports com.example.seila;
}