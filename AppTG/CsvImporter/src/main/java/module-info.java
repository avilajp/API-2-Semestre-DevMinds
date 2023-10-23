module devminds.tgcontrol.importback {
    requires javafx.fxml;
    requires com.google.gson;
    requires java.desktop;
    requires java.sql;

    opens devminds.tgcontrol.importback.objects to javafx.fxml, com.google.gson;
    exports devminds.tgcontrol.importback.jsonObj;
    exports devminds.tgcontrol.importback.csvImport;
    exports devminds.tgcontrol.importback.objects;
}