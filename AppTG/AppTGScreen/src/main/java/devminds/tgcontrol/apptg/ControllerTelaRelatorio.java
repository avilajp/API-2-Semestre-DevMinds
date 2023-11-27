package devminds.tgcontrol.apptg;

import devminds.tgcontrol.apptg.obj.DTOAptos;
import devminds.tgcontrol.apptg.obj.DTOAptosDefesa;
import devminds.tgcontrol.apptg.obj.DTORelatorioFechamento;
import devminds.tgcontrol.dao.SemestreDao;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class ControllerTelaRelatorio {
    DTORelatorioFechamento data = DTORelatorioFechamento.getInstance();
    DTOAptos dataAptos = DTOAptos.getInstance();

    @FXML
    private ChoiceBox<String> choiceBox;
    @FXML
    private Button btnFechamento;
    @FXML
    private Button btnAlunosApts;
    @FXML
    private Button btnTransporte;


    @FXML
    private void stageTelaFechamento(ActionEvent event) throws IOException {
        data.setSemestre(choiceBox.getSelectionModel().getSelectedItem());
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("TelaFechamentoSemestre.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Fechamento de semestre.");
        stage.setScene(new Scene(root1));
        stage.show();
    }

    @FXML
    private void stageTelaAptosDefesa(ActionEvent event) throws IOException {
        dataAptos.setSemestre(choiceBox.getSelectionModel().getSelectedItem());
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("TelaAptosDefesa.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Alunos aptos para defesa");
        stage.setScene(new Scene(root1));
        stage.show();
    }

    @FXML
    private void initialize() throws SQLException, ClassNotFoundException {
        btnFechamento.disableProperty().bind(choiceBox.valueProperty().isNull());
        btnAlunosApts.disableProperty().bind(choiceBox.valueProperty().isNull());
        btnTransporte.disableProperty().bind(choiceBox.valueProperty().isNull());
        SemestreDao semestreDao = new SemestreDao();
        choiceBox.setItems(semestreDao.getSemestre());
    }

    public void stageTransporteNotas(ActionEvent actionEvent) throws IOException {
        data.setSemestre(choiceBox.getSelectionModel().getSelectedItem());
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("TransporteNotas.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Transporte de Notas.");
        stage.setScene(new Scene(root1));
        stage.show();
    }
}
