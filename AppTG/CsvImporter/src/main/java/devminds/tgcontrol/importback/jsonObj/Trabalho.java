package devminds.tgcontrol.importback.jsonObj;


public class Trabalho {
    private String timestamp;
    private String nomeCompletoOrientador;
    private String emailOrientador;

    private String emailPessoal;
    private String tipoTG;
    private String problema;
    private String empresa;
    private String disciplina;
    private String emailFatec;

    private String nomeCompleto;



    public void setEmailFatec(String emailFatec) {
        this.emailFatec = emailFatec;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getNomeCompletoOrientador() {
        return nomeCompletoOrientador;
    }
    public String getEmailOrientador() {
        return emailOrientador;
    }
    public String getProblema() {
        return problema;
    }

    public String getEmpresa() {
        return empresa;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public String getTimestamp(){
        return timestamp;
    }

    public String getTipoTG() {
        return tipoTG;
    }


    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
    public void setTimestampProperty(String timestamp){
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
    public String getEmailPessoal() {
        return emailPessoal;
    }

    public void setEmailPessoal(String emailPessoal) {
        this.emailPessoal = emailPessoal;
    }


    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }


    public String getEmailFatec() {
        return emailFatec;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }
}