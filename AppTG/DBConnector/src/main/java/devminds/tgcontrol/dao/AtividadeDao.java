package devminds.tgcontrol.dao;

import devminds.tgcontrol.ResultSetToArrayList;
import devminds.tgcontrol.SqlConnection;
import devminds.tgcontrol.objects.Atividade;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class AtividadeDao {
    public void createAtividade(String atividade_nome, LocalDateTime atividade_data_entrega, String descricao) {
        try (Connection con = SqlConnection.getConnection()) {
            String sql_insert = "INSERT INTO sgtg.atividade (atividade_nome, atividade_data_entrega, descricao) VALUES (?, ?, ?)";
            PreparedStatement pst;
            pst = con.prepareStatement(sql_insert);
            pst.setString(1, atividade_nome);
            pst.setObject(2, atividade_data_entrega);
            pst.setString(3, descricao);
            pst.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao gerar nova atividade!!");
        }
    }
    public ObservableList<Atividade> getAtividades() throws SQLException, ClassNotFoundException {
        ObservableList<Atividade> lista  = null;
        try(Connection con = SqlConnection.getConnection()){
            String sql_select = "SELECT atividade_nome, atividade_data_entrega, descricao FROM atividade";
            PreparedStatement pst;
            pst = con.prepareStatement(sql_select);
            ResultSet rs = pst.executeQuery();
            ResultSetToArrayList converter = new ResultSetToArrayList();
            lista = converter.convertAtividade(rs);
        }

        return lista;
    }
}
