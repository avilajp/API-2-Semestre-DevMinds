package devminds.screenCodes;

import devminds.tgcontrol.importback.csvImport.CsvReader;

public class Testete {
    private String filename;

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public static String csvSender(String filename){
        CsvReader csvReader = new CsvReader();
        csvReader.leitorCsv(filename);
        return null;

    }
}
