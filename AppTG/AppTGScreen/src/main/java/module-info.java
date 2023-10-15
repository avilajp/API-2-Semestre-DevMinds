module devminds.tgcontrol.apptg {
    requires javafx.controls;
    requires javafx.fxml;
    requires devminds.tgcontrol.importback;

    opens devminds.tgcontrol.apptg to javafx.fxml;
    exports devminds.tgcontrol.apptg;
}