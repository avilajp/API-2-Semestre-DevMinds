package devminds.tgcontrol.dao;

import devminds.tgcontrol.SqlConnection;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AvaliacaoDao {
    public void criarAvaliacaoDaAtividade(String nome){
        try (Connection con = SqlConnection.getConnection()) {
            String sql_insert ="INSERT INTO sgtg.avaliacao (id_atividade, email_aluno_pessoal) " +
                    "VALUES ((SELECT id_atividade FROM atividade ORDER BY id_atividade desc limit 1), " +
                    "(SELECT nome FROM aluno WHERE nome = ?));";

            PreparedStatement pst;
            pst = con.prepareStatement(sql_insert);
            pst.setString(1, nome);
            pst.executeUpdate();



        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
