package devminds.example;

import java.util.List;

public class Lista {

    public String tododata;


    public Lista(List<String[]> valor){
        this.tododata = "" + valor;

    }

    public String getTododata() {
        return tododata;
    }

    @Override
    public String toString(){
        return this.tododata;
    }




}
