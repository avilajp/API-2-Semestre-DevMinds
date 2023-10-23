package devminds.tgcontrol;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AlunoDao {
    public void registerAluno(String aluno_email_fatec, String nome_aluno) {
        try (Connection con = SqlConnection.getConnection()) {
            String sql_update = "UPDATE sgtg.aluno SET aluno_email_fatec = ?, nome = ? where aluno_email_fatec = ?";
            PreparedStatement pst;
            pst = con.prepareStatement(sql_update);
            pst.setString(1, aluno_email_fatec);
            pst.setString(2, nome_aluno);
            int updatedRowCount = pst.executeUpdate();

            if (updatedRowCount == 0) {
                String sql_insert = "INSERT INTO sgtg.aluno (aluno_email_fatec, nome) VALUES (?, ?)";
                PreparedStatement pst2;
                pst2 = con.prepareStatement(sql_insert);
                pst2.setString(1, aluno_email_fatec);
                pst2.setObject(2, nome_aluno);
                pst2.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao gerar nova atividade!!");
        }
    }
}
