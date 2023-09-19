package devminds.example.json;

import devminds.example.objetos.Aluno;

public class JsonObject extends Aluno {
    private String timestamp;
    private String nomeCompletoOrientador;
    private String emailOrientador;
    private String tipoTG;
    private String problema;
    private String empresa;
    private String disciplina;

    public String getTimestamp() {
        return timestamp;
    }

    public String getTipoTG() {
        return tipoTG;
    }


    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public void setNomeCompletoOrientador(String nomeCompletoOrientador) {
        this.nomeCompletoOrientador = nomeCompletoOrientador;
    }

    public void setEmailOrientador(String emailOrientador) {
        this.emailOrientador = emailOrientador;
    }

    public void setTipoTG(String tipoTG) {
        this.tipoTG = tipoTG;
    }

    public void setProblema(String problema) {
        this.problema = problema;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }
}