package devminds.tgcontrol.apptg;

import devminds.tgcontrol.apptg.obj.DTOInterTela;
import devminds.tgcontrol.objects.DTOFechamento;
import devminds.tgcontrol.apptg.obj.DTORelatorioFechamento;
import devminds.tgcontrol.dao.FechamentoDAO;
import devminds.tgcontrol.objects.ViewObjAtividadeXAluno;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.w3c.dom.ranges.Range;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ControllerTelaFechamentoSemestre {
    DTORelatorioFechamento data = DTORelatorioFechamento.getInstance();
    @FXML private Label labelSemestreAtivo;
    @FXML private ChoiceBox<String> choiceMateria;
    @FXML private TableView<DTOFechamento> tableFechamento;
    @FXML private TableColumn<DTOFechamento,String> col1;
    @FXML private TableColumn<DTOFechamento,String> col2;
    @FXML private TableColumn<DTOFechamento,Double> col3;
    @FXML private TableColumn<DTOFechamento,Double> col4;
    @FXML private TableColumn<DTOFechamento,Double> col5;
    @FXML private TableColumn<DTOFechamento,Double> col6;
    @FXML private TableColumn<DTOFechamento,Double> col7;
    @FXML private TableColumn<DTOFechamento,Double> col8;
    @FXML private TableColumn<DTOFechamento,Double> col9;
    @FXML private TableColumn<DTOFechamento,Double> col10;
    @FXML private Button btn_voltar;


    ObservableList<DTOFechamento> lista = FXCollections.observableArrayList();
    @FXML private void selecionaChoiceBox(ActionEvent event) throws SQLException, ClassNotFoundException {
        FechamentoDAO fechamentoDAO = new FechamentoDAO();
        if (choiceMateria.getSelectionModel().getSelectedItem().equals("TG1")){
            ObservableList<DTOFechamento> obsList = fechamentoDAO.getAllSemestre("materia_tg1",data.getSemestre(),"semestre_tg1");
            lista.clear();
            for (DTOFechamento objeto : obsList) {
                    lista.add(objeto);
           }
        } else {
            ObservableList<DTOFechamento> obsList = fechamentoDAO.getAllSemestre("materia_tg2",data.getSemestre(),"semestre_tg2");
            lista.clear();
            for (DTOFechamento objeto : obsList) {
                    lista.add(objeto);
            }
        }
        setTableItems(lista);

    }
    private void setTableItems(ObservableList<DTOFechamento> list){
       tableFechamento.setItems(list);
    }


    @FXML private void stageToTelaFechamento(ActionEvent event){
        Stage stage = (Stage) btn_voltar.getScene().getWindow();
        stage.close();
    }

    @FXML private void initialize(){
        labelSemestreAtivo.setText(data.getSemestre());
        String texto = "TG1";
        String texto1 = "TG2";
        List<String> lista = new ArrayList<>();
        lista.add(texto);
        lista.add(texto1);
        ObservableList<String> obsList = FXCollections.observableList(lista);
        choiceMateria.setItems(obsList);
        col1.setCellValueFactory(new PropertyValueFactory<DTOFechamento, String>("nomeAluno"));
        col2.setCellValueFactory(new PropertyValueFactory<DTOFechamento, String>("tipo"));
        col3.setCellValueFactory(new PropertyValueFactory<DTOFechamento, Double>("nota1"));
        col4.setCellValueFactory(new PropertyValueFactory<DTOFechamento, Double>("nota2"));
        col5.setCellValueFactory(new PropertyValueFactory<DTOFechamento, Double>("nota3"));
        col6.setCellValueFactory(new PropertyValueFactory<DTOFechamento, Double>("nota4"));
        col7.setCellValueFactory(new PropertyValueFactory<DTOFechamento, Double>("nota5"));
        col8.setCellValueFactory(new PropertyValueFactory<DTOFechamento, Double>("nota6"));
        col9.setCellValueFactory(new PropertyValueFactory<DTOFechamento, Double>("nota7"));
        col10.setCellValueFactory(new PropertyValueFactory<DTOFechamento, Double>("nota8"));
    }
}
