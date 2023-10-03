package devminds.tgcontrol.importback.jsonObj;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

public class Adapter{
    public static class ObjToJsonAdapter extends TypeAdapter<JsonObjectMaker> {
        @Override
        public void write(JsonWriter out, JsonObjectMaker object) throws IOException {
            // Define como serializar um objeto Person em JSON
            out.beginObject();
            out.name("timestamp").value(object.getTimestamp());
            out.name("emailFatec").value(object.getEmailFatec());
            out.name("nomeAluno").value(object.getNomeCompleto());
            out.name("nomeOrientador").value(object.getNomeCompletoOrientador());
            out.name("emailOrientador").value(object.getEmailOrientador());
            out.name("tipoTG").value(object.getTipoTG());
            out.name("problema").value(object.getProblema());
            out.name("empresa").value(object.getEmpresa());
            out.name("disciplina").value(object.getDisciplina());
            out.endObject();
        }

        @Override
        public JsonObjectMaker read(JsonReader in) throws IOException {
            // Define como desserializar um objeto JSON em um objeto Person
            JsonObjectMaker mainObj = new JsonObjectMaker();
            in.beginObject();
            String timestamp = null;
            String nomeCompletoOrientador = null;
            String emailOrientador = null;
            String tipoTG = null;
            String problema = null;
            String empresa = null;
            String disciplina = null;
            String emailFatec = null;
            String nomeCompleto = null;

            while (in.hasNext()) {
                String fieldName = in.nextName();
                switch (fieldName) {
                    case "timestamp":
                        timestamp = in.nextString();
                        break;
                    case "nomeCompletoOrientador":
                        nomeCompletoOrientador = in.nextString();
                        break;
                    case "emailOrientador":
                        emailOrientador = in.nextString();
                        break;
                    case "tipoTG":
                        tipoTG = in.nextString();
                        break;
                    case "problema":
                        problema = in.nextString();
                        break;
                    case "empresa":
                        empresa = in.nextString();
                        break;
                    case "disciplina":
                        disciplina = in.nextString();
                        break;
                    case "emailFatec":
                        emailFatec = in.nextString();
                        break;
                    case "nomeCompleto":
                        nomeCompleto = in.nextString();
                        break;
                    default:
                        in.skipValue();
                        break;
                }
                in.endObject();

            }
            return mainObj;

    }
}}

