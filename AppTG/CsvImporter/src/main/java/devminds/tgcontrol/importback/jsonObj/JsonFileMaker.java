package devminds.tgcontrol.importback.jsonObj;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class JsonFileMaker {
    public void salvarJson(JsonObjectMaker object) throws IOException {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(JsonObjectMaker.class, new Adapter.ObjToJsonAdapter())
                .setPrettyPrinting()
                .create();

        String json = gson.toJson(object);

        final File dir = new File("jsonFilesOutput");
        String timestampTemp = object.getTimestamp();
        String aux = timestampTemp.replaceAll("[^a-zA-Z0-9]", "");
        FileWriter escritor = new FileWriter(new File(dir,object.getNomeCompleto() + "_" + aux+ ".json"));
        escritor.write(json);
        escritor.close();
    }
}