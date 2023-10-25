package devminds.tgcontrol.dao;

import devminds.tgcontrol.SqlConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
}
