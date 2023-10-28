module devminds.tgcontrol.apptg {
    requires javafx.controls;
    requires javafx.fxml;
    requires devminds.tgcontrol.importback;
    requires devminds.tgcontrol.dao;
    requires java.sql;

    opens devminds.tgcontrol.apptg to javafx.fxml;
    exports devminds.tgcontrol.apptg;
    exports devminds.tgcontrol.apptg.obj;
}