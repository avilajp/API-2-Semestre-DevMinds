package devminds.tgcontrol;

import devminds.tgcontrol.objects.DTOFechamento;
import devminds.tgcontrol.objects.ViewObjAlunosAptos;
import devminds.tgcontrol.objects.ViewObjAtividadeXAluno;
import devminds.tgcontrol.objects.ViewObjAtividadeXAvaliacao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
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
    public static ObservableList<ViewObjAtividadeXAvaliacao> converterTelaVisualizar(ResultSet resultSet){
        ObservableList<ViewObjAtividadeXAvaliacao> obsList = FXCollections.observableArrayList();

        try{
            while (resultSet.next()){
                ViewObjAtividadeXAvaliacao obj = new ViewObjAtividadeXAvaliacao();
                obj.setNome(resultSet.getString("nome_aluno"));
                obj.setTipo(resultSet.getString("tipo"));
                obj.setMatriculado(resultSet.getString("matriculado_em"));
                obsList.add(obj);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return obsList;
    }
    public static ObservableList<ViewObjAtividadeXAvaliacao> converterTelaAtividade(ResultSet resultSet){
        ObservableList<ViewObjAtividadeXAvaliacao> obsList = FXCollections.observableArrayList();
        try{
            while (resultSet.next()){
                ViewObjAtividadeXAvaliacao obj = new ViewObjAtividadeXAvaliacao();
                obj.setNome(resultSet.getString("nome_aluno"));
                obsList.add(obj);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return obsList;
    }
    public static ObservableList<ViewObjAtividadeXAluno> converterTelaAvaliar(ResultSet resultSet){
        ObservableList<ViewObjAtividadeXAluno> obsList = FXCollections.observableArrayList();
        try{
            while (resultSet.next()){
                ViewObjAtividadeXAluno obj = new ViewObjAtividadeXAluno();
                obj.setAtividade_nome(resultSet.getString("atividade_nome"));
                obj.setFeedback(resultSet.getString("feedback"));
                obj.setNota(resultSet.getDouble("nota"));
                obj.setNome_aluno(resultSet.getString("nome"));
                obj.setId_avaliacao(resultSet.getInt("id_avaliacao"));
                obsList.add(obj);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return obsList;
    }
    public static ObservableList<DTOFechamento> converterTelaFechamento(ResultSet resultSet){
        ObservableList<DTOFechamento> obsList = FXCollections.observableArrayList();
        try{
            while (resultSet.next()){
                DTOFechamento obj = new DTOFechamento();
                obj.setNomeAluno(resultSet.getString("nome_aluno"));
                obj.setTipo(resultSet.getString("tipo"));
                obj.setNota1(resultSet.getDouble("a1"));
                obj.setNota2(resultSet.getDouble("a2"));
                obj.setNota3(resultSet.getDouble("a3"));
                obj.setNota4(resultSet.getDouble("a4"));
                obj.setNota5(resultSet.getDouble("a5"));
                obj.setNota6(resultSet.getDouble("a6"));
                obj.setNota7(resultSet.getDouble("a7"));
                obj.setNota8(resultSet.getDouble("a8"));

                obsList.add(obj);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return obsList;
    }
    public static ObservableList<String> convertSemestre(ResultSet resultSet){
        ObservableList<String> obsList = FXCollections.observableArrayList();
        try{
            while (resultSet.next()){
                String obj;
                obj = resultSet.getString("nome");
                obsList.add(obj);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return obsList;
    }
    public static ObservableList<ViewObjAlunosAptos> converterTelaAlunosAptosDefesa(ResultSet resultSet){
        ObservableList<ViewObjAlunosAptos> obsList = FXCollections.observableArrayList();
        try{
            while (resultSet.next()){
                ViewObjAlunosAptos obj = new ViewObjAlunosAptos();
                obj.setNomeAluno(resultSet.getString("nome_aluno"));
                obj.setTipo(resultSet.getString("tipo"));
                obj.setOrientador(resultSet.getString("orientador"));
                obj.setNota1(resultSet.getDouble("a1"));
                obj.setNota2(resultSet.getDouble("a2"));
                obj.setNota3(resultSet.getDouble("a3"));
                obj.setNota4(resultSet.getDouble("a4"));
                obj.setNota5(resultSet.getDouble("a5"));
                obj.setNota6(resultSet.getDouble("a6"));
                obj.setNota7(resultSet.getDouble("a7"));
                obj.setNota8(resultSet.getDouble("a8"));

                obsList.add(obj);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return obsList;
    }

}
