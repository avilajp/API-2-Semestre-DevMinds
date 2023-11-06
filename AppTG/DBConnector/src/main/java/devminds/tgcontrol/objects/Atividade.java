package devminds.tgcontrol.objects;

import java.time.LocalDateTime;

public class Atividade {
    private String nomeAtividade;
    private String descricaoAtividade;
    private LocalDateTime dataEntrega;

    public Atividade(String nomeAtividade, String descricaoAtividade, LocalDateTime dataEntrega) {
        this.nomeAtividade = nomeAtividade;
        this.descricaoAtividade = descricaoAtividade;
        this.dataEntrega = dataEntrega;
    }

    public Atividade() {
    }

    public String getNomeAtividade() {
        return nomeAtividade;
    }

    public void setNomeAtividade(String nomeAtividade) {
        this.nomeAtividade = nomeAtividade;
    }

    public String getDescricaoAtividade() {
        return descricaoAtividade;
    }

    public void setDescricaoAtividade(String descricaoAtividade) {
        this.descricaoAtividade = descricaoAtividade;
    }

    public LocalDateTime getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(LocalDateTime dataEntrega) {
        this.dataEntrega = dataEntrega;
    }
}
