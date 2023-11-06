package devminds.tgcontrol.dao;

import devminds.tgcontrol.SqlConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProfessorDao {
    public void registerProfessor(String email_professor,String nome_professor) {
        try (Connection con = SqlConnection.getConnection()) {
            String sql_update = "UPDATE sgtg.professor SET email_professor = ?, nome_professor = ? where email_professor = ?";
            PreparedStatement pst;
            pst = con.prepareStatement(sql_update);
            pst.setString(1, email_professor);
            pst.setString(2,nome_professor);
            pst.setString(3, email_professor);

            int updatedRowCount = pst.executeUpdate();

            if (updatedRowCount == 0) {
                String sql_insert = "INSERT INTO sgtg.professor (email_professor, nome_professor) VALUES (?, ?)";
                PreparedStatement pst2;
                pst2 = con.prepareStatement(sql_insert);
                pst2.setString(1, email_professor);
                pst2.setString(2, nome_professor);
                pst2.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao registrar Professor !!");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
