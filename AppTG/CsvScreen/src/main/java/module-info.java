module devminds.screenCodes {
    requires javafx.controls;
    requires javafx.fxml;
    requires devminds.tgcontrol.importback;


    opens devminds.tgcontrol.importback.csvscreen to com.google.gson;
    opens devminds.screenCodes to javafx.fxml;
    exports devminds.screenCodes;
}