package devminds.tgcontrol.dao;

import devminds.tgcontrol.SqlConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.SQLIntegrityConstraintViolationException;

public class SemestreDao {

    public void createSemestre(String nome) {
        try (Connection con = SqlConnection.getConnection()) {
            try {
                String sql_insert = "INSERT INTO sgtg.semestre (nome) VALUES (?)";
                PreparedStatement pst;
                pst = con.prepareStatement(sql_insert);
                pst.setString(1, nome);
                pst.executeUpdate();
            } catch (SQLIntegrityConstraintViolationException e) {
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
    }
    public String existSemestre(String semestre){
        String existe = null;
        try (Connection con = SqlConnection.getConnection()) {
            try {
                String sql_insert = "INSERT INTO sgtg.semestre (nome) VALUES (?)";
                PreparedStatement pst;
                pst = con.prepareStatement(sql_insert);
                pst.setString(1, semestre);
                pst.executeUpdate();
            } catch (SQLIntegrityConstraintViolationException e) {
                existe = "sim";
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
        return existe;
    }
}