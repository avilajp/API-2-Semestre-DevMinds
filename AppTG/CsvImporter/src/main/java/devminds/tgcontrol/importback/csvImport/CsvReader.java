package devminds.tgcontrol.importback.csvImport;



import devminds.tgcontrol.importback.jsonObj.Trabalho;

import java.io.BufferedReader;
import java.io.FileReader;

public class CsvReader {
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
                            javaObj.setTimestamp(nextRecord[0]);
                        case 1:

                        case 2:
                            javaObj.setEmailFatec(nextRecord[2]);
                        case 3:
                            javaObj.setNomeCompleto(nextRecord[3]);
                        case 4:
                            javaObj.setNomeCompletoOrientador(nextRecord[4]);
                        case 5:
                            javaObj.setEmailOrientador(nextRecord[5]);
                        case 6:

                        case 7:
                            javaObj.setTipoTG(nextRecord[7]);
                        case 8:
                            javaObj.setProblema(nextRecord[8]);
                        case 9:
                            javaObj.setEmpresa(nextRecord[9]);
                        case 10:
                            javaObj.setDisciplina(nextRecord[10]);
                        default:

                    }

                    } catch (Exception e){}
                }
//                JsonFileMaker fileMaker = new JsonFileMaker();
                indexFor += 1;
                    return javaObj;
//                fileMaker.salvarJson(jsonOBJ);



            }
            br.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}