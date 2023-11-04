package devminds.tgcontrol;

import devminds.tgcontrol.dao.AvaliacaoXAtividadeDAO;
import devminds.tgcontrol.objects.Atividade;
import devminds.tgcontrol.objects.Avaliacao;
import devminds.tgcontrol.objects.ViewObjAtividadeXAvaliacao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ResultSetToArrayList {
    public ArrayList convert(ResultSet rs) throws SQLException {
        ResultSetMetaData rsmd = rs.getMetaData();
        int columns = rsmd.getColumnCount();
        ArrayList<String> lista = new ArrayList<>();
        while (rs.next()) {
            Map<String, String> row = new HashMap<>();
            for (int i = 1; i <= columns; i++) {
                row.put(rsmd.getColumnName(i), rs.getString(i));
                lista.add(row.get("semestre"));
            }

        }
        return lista;
    }
    public static ObservableList<ViewObjAtividadeXAvaliacao> convertAtividade(ResultSet resultSet) {
        ObservableList<ViewObjAtividadeXAvaliacao> obsList = FXCollections.observableArrayList();
        try {
            while (resultSet.next()) {
                ViewObjAtividadeXAvaliacao objeto = new ViewObjAtividadeXAvaliacao();
                objeto.setId_atividade(resultSet.getInt("id_atividade"));
                obsList.add(objeto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return obsList;
    }
    public static ObservableList<ViewObjAtividadeXAvaliacao> converterTelaVisualizar(ResultSet resultSet){
        ObservableList<ViewObjAtividadeXAvaliacao> obsList = FXCollections.observableArrayList();

        try{
            while (resultSet.next()){
                ViewObjAtividadeXAvaliacao obj = new ViewObjAtividadeXAvaliacao();
                obj.setNome(resultSet.getString("nome_aluno"));
                obj.setTipo(resultSet.getString("tipo"));
                obj.setNota1(resultSet.getDouble("A1"));
                obj.setNota2(resultSet.getDouble("A2"));
                obj.setNota3(resultSet.getDouble("A3"));
                obj.setNota4(resultSet.getDouble("A4"));
                obsList.add(obj);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return obsList;
    }
}
