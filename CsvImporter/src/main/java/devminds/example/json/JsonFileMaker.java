package devminds.example.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class JsonFileMaker {
    public void salvarJson(JsonObject object) throws IOException {
        final File dir = new File("jsonFilesOutput");
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String timestampTemp = object.getTimestamp();
        String aux = timestampTemp.replaceAll("[^a-zA-Z0-9]", "");
        FileWriter escritor = new FileWriter(new File(dir,object.getNomeCompleto() + "_" + aux+ ".json"));
        escritor.write(gson.toJson(object));
        escritor.close();
    }
}