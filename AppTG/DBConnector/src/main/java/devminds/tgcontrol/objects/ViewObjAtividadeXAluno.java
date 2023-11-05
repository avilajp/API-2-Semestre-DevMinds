package devminds.tgcontrol.objects;

public class ViewObjAtividadeXAluno {
    private int id_avaliacao;
    private String nome_aluno;
    private double nota;
    private String atividade_nome;
    private String feedback;

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public int getId_avaliacao() {
        return id_avaliacao;
    }

    public void setId_avaliacao(int id_avaliacao) {
        this.id_avaliacao = id_avaliacao;
    }

    public String getNome_aluno() {
        return nome_aluno;
    }

    public void setNome_aluno(String nome_aluno) {
        this.nome_aluno = nome_aluno;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public String getAtividade_nome() {
        return atividade_nome;
    }

    public void setAtividade_nome(String atividade_nome) {
        this.atividade_nome = atividade_nome;
    }
}
