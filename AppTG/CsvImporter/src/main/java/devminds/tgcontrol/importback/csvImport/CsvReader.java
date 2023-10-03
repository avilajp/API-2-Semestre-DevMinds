package devminds.tgcontrol.importback.csvImport;


import devminds.tgcontrol.importback.jsonObj.JsonFileMaker;
import devminds.tgcontrol.importback.jsonObj.JsonObjectMaker;

import java.io.BufferedReader;
import java.io.FileReader;

public class CsvReader {
    public void leitorCsv(String filename) {
        try {
            FileReader fileReader = new FileReader(filename);
            BufferedReader br = new BufferedReader(fileReader);
            br.readLine();
            String line = "";
            String[] nextRecord;
            int indexFor = 0;
            while ((line = br.readLine()) != null) {
                nextRecord = line.split(",");
                JsonObjectMaker jsonOBJ = new JsonObjectMaker();
                indexFor = 0;
                for (String tempStr : nextRecord) {
//                    System.out.println(indexFor + " " + tempStr + " ");
                    try{
                    switch (indexFor) {
                        case 0:
                            jsonOBJ.setTimestamp(nextRecord[0]);
                        case 1:

                        case 2:
                            jsonOBJ.setEmailFatec(nextRecord[2]);
                        case 3:
                            jsonOBJ.setNomeCompleto(nextRecord[3]);
                        case 4:
                            jsonOBJ.setNomeCompletoOrientador(nextRecord[4]);
                        case 5:
                            jsonOBJ.setEmailOrientador(nextRecord[5]);
                        case 6:

                        case 7:
                            jsonOBJ.setTipoTG(nextRecord[7]);
                        case 8:
                            jsonOBJ.setProblema(nextRecord[8]);
                        case 9:
                            jsonOBJ.setEmpresa(nextRecord[9]);
                        case 10:
                            jsonOBJ.setDisciplina(nextRecord[10]);
                        default:

                    }

                    } catch (Exception e){}
                }
                JsonFileMaker fileMaker = new JsonFileMaker();
                fileMaker.salvarJson(jsonOBJ);
                indexFor += 1;


            }
            br.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}