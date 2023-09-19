module com.example.seila {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.csvscreen to javafx.fxml;
    exports com.example.csvscreen;
}