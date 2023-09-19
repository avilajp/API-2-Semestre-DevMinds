package devminds.example;

import devminds.example.csv.CsvImporter;

public class Main {
    public static void main(String[] args) {
        CsvImporter csvImporter = new CsvImporter();
        CsvImporter.SelecionaArquivo();
    }
}