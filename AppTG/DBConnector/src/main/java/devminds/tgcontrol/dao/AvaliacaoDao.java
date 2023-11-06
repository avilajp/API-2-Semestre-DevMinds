package devminds.tgcontrol.dao;

import devminds.tgcontrol.SqlConnection;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AvaliacaoDao {
    public void criarAvaliacaoDaAtividade(String nome,int count){
        try (Connection con = SqlConnection.getConnection()) {
            String sql_insert ="INSERT INTO sgtg.avaliacao (id_atividade, aluno_email_pessoal) " +
                    "VALUES ((SELECT id_atividade FROM atividade ORDER BY id_atividade desc limit ?,1), " +
                    "(SELECT aluno_email_pessoal FROM aluno WHERE nome = ?));";

            PreparedStatement pst;
            pst = con.prepareStatement(sql_insert);
            pst.setInt(1, count);
            pst.setString(2, nome);
            pst.executeUpdate();



        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
    public void updateAvaliacao(String feedback,Double nota,int id_avaliacao) throws SQLException, ClassNotFoundException {
        try (Connection con = SqlConnection.getConnection()){
            String sql_update = "UPDATE sgtg.avaliacao SET feedback = ?, nota = ? where id_avaliacao = ?";
            PreparedStatement pst;
            pst = con.prepareStatement(sql_update);
            pst.setString(1, feedback);
            pst.setDouble(2,nota);
            pst.setInt(3, id_avaliacao);
            pst.executeUpdate();
        }
    }
}
