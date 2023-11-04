package devminds.tgcontrol.apptg.obj;

import devminds.tgcontrol.objects.Avaliacao;

import java.time.LocalDateTime;

public class DTOAvaliacao extends Avaliacao {
    private static final DTOAvaliacao instance = new DTOAvaliacao();
    private String nome;
    private String feedback;
    private String tipo;
    private double nota1;
    private double nota2;
    private double nota3;
    private double nota4;

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

    @Override
    public String getFeedback() {
        return feedback;
    }

    @Override
    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public double getNota1() {
        return nota1;
    }

    @Override
    public void setNota1(double nota1) {
        this.nota1 = nota1;
    }

    @Override
    public double getNota2() {
        return nota2;
    }

    @Override
    public void setNota2(double nota2) {
        this.nota2 = nota2;
    }

    @Override
    public double getNota3() {
        return nota3;
    }

    @Override
    public void setNota3(double nota3) {
        this.nota3 = nota3;
    }

    @Override
    public double getNota4() {
        return nota4;
    }

    @Override
    public void setNota4(double nota4) {
        this.nota4 = nota4;
    }
}
