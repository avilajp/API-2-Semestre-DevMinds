package devminds.tgcontrol;

import devminds.tgcontrol.objects.Atividade;
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
    public static ObservableList<Atividade> convertAtividade(ResultSet resultSet) {
        ObservableList<Atividade> obsList = FXCollections.observableArrayList();
        try {
            while (resultSet.next()) {
                Atividade objeto = new Atividade();
                objeto.setNomeAtividade(resultSet.getString("atividade_nome"));
                objeto.setDescricaoAtividade(resultSet.getString("descricao"));
                objeto.setDataEntrega(resultSet.getObject("atividade_data_entrega", LocalDateTime.class));
                obsList.add(objeto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return obsList;
    }

}
