package devminds.example;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
//Essa Classe serve somente para abrir a caixinha de seleção
public class CsvImporter {
    public static void SelecionaArquivo(){
            JFileChooser chooser = new JFileChooser();
            //Isso aqui filtra o tipo de arquivo que pode ser inputado, bem útil.
            FileNameExtensionFilter filter = new FileNameExtensionFilter(
                    "Arquivo CSV", "csv");
            chooser.setFileFilter(filter);
            int returnVal = chooser.showOpenDialog(null);
            if(returnVal == JFileChooser.APPROVE_OPTION) {
                String nome = chooser.getSelectedFile().getAbsolutePath();
                CsvReader csvReader = new CsvReader();
                csvReader.LeitorCSV(nome);
            }


        }
    }

