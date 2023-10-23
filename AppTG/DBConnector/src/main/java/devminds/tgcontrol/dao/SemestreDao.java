package devminds.tgcontrol.dao;

import devminds.tgcontrol.SqlConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class SemestreDao {

    public void createSemestre(String nome) {
        try (Connection con = SqlConnection.getConnection()) {
            String sql_insert = "INSERT INTO sgtg.semestre (nome) VALUES (?)";
            PreparedStatement pst;
            pst = con.prepareStatement(sql_insert);
            pst.setString(1, nome);
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao criar um novo semestre!!", e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}