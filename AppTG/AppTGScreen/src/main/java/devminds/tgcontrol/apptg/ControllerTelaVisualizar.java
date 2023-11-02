package devminds.tgcontrol.apptg;

import devminds.tgcontrol.apptg.obj.DTOSemestre;
import devminds.tgcontrol.dao.MateriaDao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

public class ControllerTelaVisualizar {
    private String semestreSelecionado;
    private String materiaSelecionada;
    @FXML private ChoiceBox<String> selectlist;
    @FXML
    private void selecionaChoiceBox(ActionEvent event){
        String[] vetString = selectlist.getSelectionModel().getSelectedItem().split("-");
        this.semestreSelecionado = vetString[0];
        if (vetString[1].trim().equals("TG1")) {
            this.materiaSelecionada = "materia_tg1";
        } else {
            this.materiaSelecionada = "materia_tg2";
        }
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

