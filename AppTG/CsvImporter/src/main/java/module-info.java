module devminds.tgcontrol.importback {
    requires com.google.gson;
    requires java.desktop;

    opens devminds.tgcontrol.importback.objects to com.google.gson;
    exports devminds.tgcontrol.importback.jsonObj;
    exports devminds.tgcontrol.importback.csvImport;
    exports devminds.tgcontrol.importback.objects;
}