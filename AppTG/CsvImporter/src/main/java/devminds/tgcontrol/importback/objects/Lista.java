package devminds.tgcontrol.importback.objects;

import java.util.List;

public class Lista {

    public String allData;


    public Lista(List<String[]> valor){
        this.allData = "" + valor;

    }

    public String getAllData() {
        return allData;
    }

    @Override
    public String toString(){
        return this.allData;
    }




}
