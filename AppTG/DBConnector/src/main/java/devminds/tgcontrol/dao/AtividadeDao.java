package devminds.tgcontrol.dao;

import devminds.tgcontrol.ResultSetToArrayList;
import devminds.tgcontrol.SqlConnection;
import devminds.tgcontrol.objects.Atividade;
import devminds.tgcontrol.objects.ViewObjAtividadeXAluno;
import devminds.tgcontrol.objects.ViewObjAtividadeXAvaliacao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class AtividadeDao {
    public void createAtividade(String atividade_nome, LocalDateTime atividade_data_entrega, String descricao, String semestreColuna,String tipo, String semestreAtividade) {
        try (Connection con = SqlConnection.getConnection()) {
            String sql_insert = null;
            if (semestreColuna.equals("materia_tg1")){
                sql_insert = "INSERT INTO sgtg.atividade (atividade_nome, atividade_data_entrega, descricao, tipo, semestre_tg1) VALUES (?, ?, ?, ?, (select distinct semestre from materia_tg1 where semestre = ?))";
            } else {
                sql_insert = "INSERT INTO sgtg.atividade (atividade_nome, atividade_data_entrega, descricao, tipo, semestre_tg2) VALUES (?, ?, ?, ?, (select distinct semestre from materia_tg2 where semestre = ?))";
            }

            PreparedStatement pst;
            pst = con.prepareStatement(sql_insert);
            pst.setString(1, atividade_nome);
            pst.setObject(2, atividade_data_entrega);
            pst.setString(3, descricao);
            pst.setString(4, tipo);
            pst.setString(5, semestreAtividade);
            pst.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao gerar nova atividade!!");
        }
    }
    public ObservableList<ViewObjAtividadeXAluno> getAtividadeXAluno(String semestreMateria, String semestre) throws SQLException, ClassNotFoundException {
        ResultSet rs  = null;
        ObservableList<ViewObjAtividadeXAluno> lista = FXCollections.observableArrayList();
        try(Connection con = SqlConnection.getConnection()){
            String sql_select = String.format(
                    "select av.id_avaliacao AS id_avaliacao," +
                    "av.feedback," +
                    "al.nome AS nome," +
                    "av.nota AS nota," +
                    "at.atividade_nome AS atividade_nome" +
                    " FROM avaliacao AS av INNER JOIN aluno AS al ON av.aluno_email_pessoal  = al.aluno_email_pessoal" +
                    " INNER JOIN atividade AS at ON av.id_atividade = at.id_atividade WHERE %s = ?", semestreMateria);
            PreparedStatement pst;
            pst = con.prepareStatement(sql_select);
            pst.setString(1, semestre);
            rs = pst.executeQuery();
            ResultSetToArrayList rstal = new ResultSetToArrayList();
            lista = rstal.converterTelaAvaliar(rs);
        }
        return lista;
    }

    public ObservableList<ViewObjAtividadeXAluno> getAtividadeXAlunoPortfolio(String colunaMateria,String semestre) throws SQLException, ClassNotFoundException {
        ResultSet rs  = null;
        ObservableList<ViewObjAtividadeXAluno> lista = FXCollections.observableArrayList();
        try(Connection con = SqlConnection.getConnection()){
            String sql_select = String.format("SELECT av.id_avaliacao AS id_avaliacao, av.feedback, al.nome AS nome, av.nota AS nota, at.atividade_nome AS atividade_nome" +
                    " FROM avaliacao AS av INNER JOIN aluno AS al ON av.aluno_email_pessoal  = al.aluno_email_pessoal" +
                    " INNER JOIN atividade AS at ON av.id_atividade = at.id_atividade where at.%s = ?", colunaMateria);
            PreparedStatement pst;
            pst = con.prepareStatement(sql_select);
            pst.setString(1,semestre);
            rs = pst.executeQuery();
            ResultSetToArrayList rstal = new ResultSetToArrayList();
            lista = rstal.converterTelaAvaliar(rs);
        }
        return lista;
    }
}
