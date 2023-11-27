package devminds.tgcontrol.dao;

import devminds.tgcontrol.ResultSetToArrayList;
import devminds.tgcontrol.SqlConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

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
    public ObservableList<String> getSemestre(){
        ObservableList<String> lista = FXCollections.observableArrayList();
        try(Connection con = SqlConnection.getConnection()) {
            String sql_insert = "SELECT * from semestre";
            PreparedStatement pst;
            pst = con.prepareStatement(sql_insert);
            ResultSet rs = pst.executeQuery();
            lista = ResultSetToArrayList.convertSemestre(rs);
        } catch (SQLIntegrityConstraintViolationException e) {
//                System.out.println("O semestre " + nome + " já está cadastrado.");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao criar um novo semestre!!", e);
        }
        return lista;

    }
    public String getSemestreAtual() throws SQLException, ClassNotFoundException {
        ObservableList<String> lista = FXCollections.observableArrayList();
        String semestreAtual = null;
        try(Connection con = SqlConnection.getConnection()) {
            String sql_insert = "SELECT * from semestre order by nome desc limit 0,1";
            PreparedStatement pst;
            pst = con.prepareStatement(sql_insert);
            ResultSet rs = pst.executeQuery();
            lista = ResultSetToArrayList.convertSemestre(rs);
            semestreAtual = lista.get(0);

        }
        return semestreAtual;

    }
}