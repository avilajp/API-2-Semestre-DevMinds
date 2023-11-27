package devminds.tgcontrol.apptg.obj;

import devminds.tgcontrol.objects.Avaliacao;

import java.time.LocalDateTime;

public class DTOAvaliacao {
    private static final DTOAvaliacao instance = new DTOAvaliacao();
    private int id_atividade;
    private String nome;
    private String feedback;
    private String tipo;
    private String semestre;
    private String materia;
    private double nota1;

    public DTOAvaliacao(){}
    public static DTOAvaliacao getInstance(){
        return instance;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getNota1() {
        return nota1;
    }

    public void setNota1(double nota1) {
        this.nota1 = nota1;
    }

    public int getId_atividade() {
        return id_atividade;
    }

    public void setId_atividade(int id_atividade) {
        this.id_atividade = id_atividade;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }
}
