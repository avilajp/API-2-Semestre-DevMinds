package devminds.tgcontrol.dao;

import devminds.tgcontrol.ResultSetToArrayList;
import devminds.tgcontrol.SqlConnection;
import devminds.tgcontrol.objects.Atividade;
import devminds.tgcontrol.objects.Avaliacao;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AvaliacaoDao {
    public void registrarAvaliacao(String email_aluno,double nota,String feedback){
        try (Connection con = SqlConnection.getConnection()) {
            String sql_insert = "INSERT INTO sgtg.avaliacao (aluno_email_pessoal, nota, feedback) VALUES (?, ?, ?)";
            PreparedStatement pst;
            pst = con.prepareStatement(sql_insert);
            pst.setString(1, email_aluno);
            pst.setDouble(2, nota);
            pst.setString(3, feedback);
            pst.executeUpdate();



        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
