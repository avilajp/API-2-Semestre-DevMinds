package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class JsonFileMaker {
    public void salvaJson(JsonObject object) throws IOException {
        final File dir = new File("jsonFilesOutput");
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileWriter escritor = new FileWriter(new File(dir,object.getNomeCompleto() + ".json"));
        //FileWriter escritor = new FileWriter(object.getNomeCompleto() + ".json");
        escritor.write(gson.toJson(object));
        escritor.close();
    }
}