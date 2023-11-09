package devminds.tgcontrol.apptg.obj.csvimport;



import devminds.tgcontrol.apptg.obj.Trabalho;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CsvReader {
    private ObservableList<Trabalho> listaDeObjetos = FXCollections.observableArrayList();
    public Trabalho leitorCsv(String filename) {
        try {

            FileReader fileReader = new FileReader(filename);
            BufferedReader br = new BufferedReader(fileReader);
            br.readLine();
            String line = "";
            String[] nextRecord;
            int indexFor = 0;
            while ((line = br.readLine()) != null) {
                nextRecord = line.split(",");
                Trabalho javaObj = new Trabalho();
                indexFor = 0;
                for (String tempStr : nextRecord) {
//                    System.out.println(indexFor + " " + tempStr + " ");
                    try{
                    switch (indexFor) {
                        case 0:

                        case 1:
                            javaObj.setEmailAlunoPessoal(nextRecord[1]);
                        case 2:
                            javaObj.setEmailFatec(nextRecord[2]);
                        case 3:
                            javaObj.setNomeCompleto(nextRecord[3]);
                        case 4:
                            javaObj.setNomeCompletoOrientador(nextRecord[4]);
                        case 5:
                            javaObj.setEmailOrientador(nextRecord[5].trim());
                        case 6:
                            javaObj.setMatriculadoEm(nextRecord[6]);
                        case 7:
                            javaObj.setTipoTG(nextRecord[7]);
                        case 8:
                            javaObj.setProblema(nextRecord[8].trim());
                        case 9:
                            javaObj.setEmpresa(nextRecord[9].trim());
                        case 10:
                            javaObj.setDisciplina(nextRecord[10].trim());
                        default:

                    }

                    } catch (Exception e){}
                }
//                JsonFileMaker fileMaker = new JsonFileMaker();
                indexFor += 1;
                    listaDeObjetos.add(javaObj);

//                fileMaker.salvarJson(jsonOBJ);



            }
            br.close();


        } catch (NullPointerException | IOException e) {
            System.out.println("Parece que você se esqueceu de selecionar o CSV.");;
        }
        return null;
    }

    public ObservableList<Trabalho> getListaDeObjetos(){
        return this.listaDeObjetos;
    }
}