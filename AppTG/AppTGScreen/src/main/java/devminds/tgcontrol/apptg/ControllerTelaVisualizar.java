package devminds.tgcontrol.apptg;


import devminds.tgcontrol.apptg.obj.DTOSemestre;
import devminds.tgcontrol.dao.AtividadeDao;
import devminds.tgcontrol.dao.MateriaDao;
import devminds.tgcontrol.importback.csvImport.CsvReader;
import devminds.tgcontrol.importback.jsonObj.Trabalho;
import devminds.tgcontrol.objects.Atividade;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.*;

public class ControllerTelaVisualizar {
    private String semestreSelecionado;
    private String materiaSelecionada;
    @FXML private ChoiceBox<String> selectlist;
    @FXML private TableView<Atividade> atividadeTableView;
    @FXML private TableColumn<Atividade,String> col1;
    @FXML private TableColumn<Atividade, LocalDateTime> col2;
    @FXML private TableColumn<Atividade,String> col3;

    @FXML
    private void selecionaChoiceBox(ActionEvent event) throws SQLException, ClassNotFoundException {
        String[] vetString = selectlist.getSelectionModel().getSelectedItem().split("-");
        this.semestreSelecionado = vetString[0];
        if (vetString[1].trim().equals("TG1")) {
            this.materiaSelecionada = "materia_tg1";
        } else {
            this.materiaSelecionada = "materia_tg2";
        }

        col1.setCellValueFactory(new PropertyValueFactory<Atividade, String>("nomeAtividade"));
        col2.setCellValueFactory(new PropertyValueFactory<Atividade, LocalDateTime>("dataEntrega"));
        col3.setCellValueFactory(new PropertyValueFactory<Atividade, String>("descricaoAtividade"));
        atividadeTableView.setItems(getAtividade());
    }
    public ObservableList<Atividade> getAtividade() throws SQLException, ClassNotFoundException {
        AtividadeDao atividadeDao = new AtividadeDao();
        ObservableList<Atividade> objAtividade = atividadeDao.getAtividades();

        return atividadeDao.getAtividades();
    }
    public void setChoiceBox() throws SQLException, ClassNotFoundException,NullPointerException {

    }
    DTOSemestre data = DTOSemestre.getInstance();
    @FXML
    private void stageToTelaAtividade(ActionEvent event) throws IOException, SQLException, ClassNotFoundException {
        data.setSemestre(semestreSelecionado);
        data.setMateria(materiaSelecionada);


        Parent tableViewParent = FXMLLoader.load(getClass().getResource("TelaAtividade.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();
    }
    @FXML
    private void initialize() throws SQLException, ClassNotFoundException {
        MateriaDao materiaDao  = new MateriaDao();
        List<String> lista = materiaDao.getSemestreEMateria();
        ObservableList<String> obsList = FXCollections.observableList(lista);
        selectlist.setItems(obsList);
    }
}

