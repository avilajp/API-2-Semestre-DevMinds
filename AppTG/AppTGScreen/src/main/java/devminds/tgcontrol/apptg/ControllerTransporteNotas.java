package devminds.tgcontrol.apptg;

import devminds.tgcontrol.apptg.obj.DTOTransporteNotas;
import devminds.tgcontrol.dao.TransporteNotasDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.sql.SQLException;

public class ControllerTransporteNotas {
    public Button btn_voltar;
    @FXML
    private TableView<DTOTransporteNotas> tableTransporteNotas;
    @FXML
    private TableColumn<DTOTransporteNotas, String> colNomeAluno;
    @FXML
    private TableColumn<DTOTransporteNotas, String> colTipoTg;
    @FXML
    private TableColumn<DTOTransporteNotas, Double> colA1;
    @FXML
    private TableColumn<DTOTransporteNotas, Double> colA2;
    @FXML
    private TableColumn<DTOTransporteNotas, Double> colA3;
    @FXML
    private TableColumn<DTOTransporteNotas, Double> colA4;
    @FXML
    private TableColumn<DTOTransporteNotas, Double> colA5;
    @FXML
    private TableColumn<DTOTransporteNotas, Double> colA6;
    @FXML
    private TableColumn<DTOTransporteNotas, Double> colA7;
    @FXML
    private TableColumn<DTOTransporteNotas, Double> colA8;
    @FXML
    private ComboBox<String> comboTipoTg;

    @FXML
    private Button btnVoltar;

    @FXML
    void carregarNotas() {
        String tipoTg = comboTipoTg.getValue();
        String semestre = "";

        TransporteNotasDAO transporteNotasDAO = new TransporteNotasDAO();
        ObservableList<DTOTransporteNotas> lista = FXCollections.observableArrayList((DTOTransporteNotas) transporteNotasDAO.getTransporteNotas(tipoTg, semestre));
        tableTransporteNotas.setItems(lista);
    }

    @FXML
    void voltar() {
    }

    @FXML private void stageToTelaFechamento(ActionEvent event){
        Stage stage = (Stage) btn_voltar.getScene().getWindow();
        stage.close();
    }
}
