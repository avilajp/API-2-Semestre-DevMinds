package devminds.tgcontrol.dao;

import devminds.tgcontrol.ResultSetToArrayList;
import devminds.tgcontrol.SqlConnection;
import devminds.tgcontrol.objects.ViewObjAtividadeXAvaliacao;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AlunoDao {
    public void registerAluno(String aluno_email_pessoal,String aluno_email_fatec, String nome_aluno) {
        try (Connection con = SqlConnection.getConnection()) {
            String sql_update = "UPDATE sgtg.aluno SET aluno_email_pessoal = ?, aluno_email_fatec = ?, nome = ? where aluno_email_pessoal = ?";
            PreparedStatement pst;
            pst = con.prepareStatement(sql_update);
            pst.setString(1, aluno_email_pessoal);
            pst.setString(2,aluno_email_fatec);
            pst.setString(3, nome_aluno);
            pst.setString(4,aluno_email_pessoal);

            int updatedRowCount = pst.executeUpdate();

            if (updatedRowCount == 0) {
                String sql_insert = "INSERT INTO sgtg.aluno (aluno_email_pessoal, aluno_email_fatec, nome) VALUES (?, ?, ?)";
                PreparedStatement pst2;
                pst2 = con.prepareStatement(sql_insert);
                pst2.setString(1, aluno_email_pessoal);
                pst2.setString(2, aluno_email_fatec);
                pst2.setObject(3,nome_aluno);
                pst2.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao registrar aluno !!");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public ObservableList<ViewObjAtividadeXAvaliacao> getNomeAluno(String materia,String semestre) throws SQLException, ClassNotFoundException {
        ObservableList<ViewObjAtividadeXAvaliacao> lista  = null;
        try (Connection con = SqlConnection.getConnection()){
            String sql_select = String.format("SELECT DISTINCT REPLACE (aluno_email_pessoal, aluno_email_pessoal,(select nome from aluno where aluno_email_pessoal = %s.aluno_email_pessoal)) as nome_aluno FROM %s WHERE semestre = (SELECT nome FROM semestre WHERE nome = %s)", materia,materia,semestre);


            PreparedStatement pst;
            pst = con.prepareStatement(sql_select);
            pst.executeQuery();
            ResultSet rs = pst.executeQuery();
            ResultSetToArrayList converter = new ResultSetToArrayList();
            lista = converter.converterTelaAtividade(rs);



        }

        return lista;

    }
}
