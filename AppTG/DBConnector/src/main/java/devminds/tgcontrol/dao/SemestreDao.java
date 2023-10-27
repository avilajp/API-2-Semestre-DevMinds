package devminds.tgcontrol.dao;

import devminds.tgcontrol.SqlConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.SQLIntegrityConstraintViolationException;

public class SemestreDao {

    public static String createSemestre(String nome) {
        String exist = null;
        try (Connection con = SqlConnection.getConnection()) {
            exist = null;
            try {
                String sql_insert = "INSERT INTO sgtg.semestre (nome) VALUES (?)";
                PreparedStatement pst;
                pst = con.prepareStatement(sql_insert);
                pst.setString(1, nome);
                pst.executeUpdate();
            } catch (SQLIntegrityConstraintViolationException e) {
                exist = "sim";
//                System.out.println("O semestre " + nome + " já está cadastrado.");
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException("Erro ao criar um novo semestre!!", e);
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            System.out.println(e);
        }
        return exist;
    }
}