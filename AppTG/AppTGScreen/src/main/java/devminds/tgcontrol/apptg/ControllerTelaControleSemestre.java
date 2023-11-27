package devminds.tgcontrol.apptg;

import devminds.tgcontrol.dao.AlunoDao;
import devminds.tgcontrol.dao.MateriaDao;
import devminds.tgcontrol.dao.ProfessorDao;
import devminds.tgcontrol.dao.SemestreDao;
import devminds.tgcontrol.apptg.obj.csvimport.CsvReader;
import devminds.tgcontrol.apptg.obj.Trabalho;
import javafx.beans.binding.Bindings;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Objects;
import java.util.ResourceBundle;


public class ControllerTelaControleSemestre implements Initializable {
    private String filepath;
    @FXML private TextField semestreInput;
    @FXML private Button btnLoadCsv;
    @FXML private Button btnSendToDataBase;
    @FXML private TableView<Trabalho> tableView;
    @FXML private TableColumn<Trabalho, String> col1;
    @FXML private TableColumn<Trabalho, String> col2;
    @FXML private TableColumn<Trabalho, String> col3;
    @FXML private TableColumn<Trabalho, String> col4;
    @FXML private TableColumn<Trabalho, String> col5;
    @FXML private TableColumn<Trabalho, String> col6;
    @FXML private TableColumn<Trabalho, String> col7;
    @FXML private TableColumn<Trabalho, String> col8;
    @FXML private TableColumn<Trabalho, String> col9;

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Aviso");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    @FXML
    public void btnLoad(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new javafx.stage.FileChooser.ExtensionFilter("Arquivos CSV", "*.csv"));
        File file = fileChooser.showOpenDialog(new Stage());
        if (file != null) {
            filepath = file.getAbsolutePath();
        } else {
            showAlert("Por favor, selecione um arquivo CSV.");
        }
        //Tabela
        col1.setCellValueFactory(new PropertyValueFactory<Trabalho, String>("emailAlunoPessoal"));
        col2.setCellValueFactory(new PropertyValueFactory<Trabalho, String>("nomeCompletoOrientador"));
        col3.setCellValueFactory(new PropertyValueFactory<Trabalho, String>("emailOrientador"));
        col4.setCellValueFactory(new PropertyValueFactory<Trabalho, String>("tipoTG"));
        col5.setCellValueFactory(new PropertyValueFactory<Trabalho, String>("empresa"));
        col6.setCellValueFactory(new PropertyValueFactory<Trabalho, String>("disciplina"));
        col7.setCellValueFactory(new PropertyValueFactory<Trabalho, String>("nomeCompleto"));
        col8.setCellValueFactory(new PropertyValueFactory<Trabalho, String>("emailFatec"));
        col9.setCellValueFactory(new PropertyValueFactory<Trabalho, String>("matriculadoEm"));
        tableView.setItems(getTrabalho());
    }

    public ObservableList<Trabalho> getTrabalho() {
        CsvReader csvReader = new CsvReader();
        Trabalho objTrabalho = csvReader.leitorCsv(filepath);

        return csvReader.getListaDeObjetos();
    }

    @FXML
    public void changeEmailAlunoPessoalCellEvent(TableColumn.CellEditEvent edittedCell) {
        Trabalho trabalhoSelecionado = tableView.getSelectionModel().getSelectedItem();
        trabalhoSelecionado.setEmailAlunoPessoal(edittedCell.getNewValue().toString());

    }

    @FXML
    public void changeNomeOrientadorCellEvent(TableColumn.CellEditEvent edittedCell) {
        Trabalho trabalhoSelecionado = tableView.getSelectionModel().getSelectedItem();
        trabalhoSelecionado.setNomeCompletoOrientador(edittedCell.getNewValue().toString());
    }

    @FXML
    public void changeEmailOrientadorCellEvent(TableColumn.CellEditEvent edittedCell) {
        Trabalho trabalhoSelecionado = tableView.getSelectionModel().getSelectedItem();
        trabalhoSelecionado.setEmailOrientador(edittedCell.getNewValue().toString());
    }

    @FXML
    public void changeTipoTGCellEvent(TableColumn.CellEditEvent edittedCell) {
        Trabalho trabalhoSelecionado = tableView.getSelectionModel().getSelectedItem();
        trabalhoSelecionado.setTipoTG(edittedCell.getNewValue().toString());
    }

    @FXML
    public void changeDisciplinaCellEvent(TableColumn.CellEditEvent edittedCell) {
        Trabalho trabalhoSelecionado = tableView.getSelectionModel().getSelectedItem();
        trabalhoSelecionado.setDisciplina(edittedCell.getNewValue().toString());
    }

    @FXML
    public void changeNomeAlunoCellEvent(TableColumn.CellEditEvent edittedCell) {
        Trabalho trabalhoSelecionado = tableView.getSelectionModel().getSelectedItem();
        trabalhoSelecionado.setNomeCompleto(edittedCell.getNewValue().toString());
    }

    @FXML
    public void changeEmailAlunoCellEvent(TableColumn.CellEditEvent edittedCell) {
        Trabalho trabalhoSelecionado = tableView.getSelectionModel().getSelectedItem();
        trabalhoSelecionado.setEmailFatec(edittedCell.getNewValue().toString());
    }

    @FXML
    public void changeEmpresaCellEvent(TableColumn.CellEditEvent edittedCell) {
        Trabalho trabalhoSelecionado = tableView.getSelectionModel().getSelectedItem();
        trabalhoSelecionado.setEmpresa(edittedCell.getNewValue().toString());
    }

    @FXML
    public void changeMatriculadoEmCellEvent(TableColumn.CellEditEvent edittedCell) {
        Trabalho trabalhoSelecionado = tableView.getSelectionModel().getSelectedItem();
        trabalhoSelecionado.setMatriculadoEm(edittedCell.getNewValue().toString());
    }

    @FXML
    private void stageToMainScree(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("TelaInicial.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();
    }

    @FXML
    private void sendToDataBase(ActionEvent event) throws ParseException, SQLException, ClassNotFoundException {
        SemestreDao semestreDao = new SemestreDao();
        String exist = semestreDao.existSemestre(semestreInput.getText());
        if (!Objects.equals(exist, "sim")) {
            AlunoDao alunoDao = new AlunoDao();
            MateriaDao materiaDao = new MateriaDao();
            ProfessorDao professorDao = new ProfessorDao();
            int aux = getTrabalho().stream().toList().size();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Confirmação");
            alert.setHeaderText(null);
            alert.setContentText("Semestre cadastrado com sucesso!");
            alert.showAndWait();

            for (int i = 0; i < aux; i++) {
                String bufferEmail = null;

                if (tableView.getItems().get(i).getEmailFatec().trim().isEmpty()) {
                    bufferEmail = null;
                } else
                    bufferEmail = tableView.getItems().get(i).getEmailFatec().trim();
                alunoDao.registerAluno(
                        tableView.getItems().get(i).getEmailAlunoPessoal(),
                        bufferEmail,
                        tableView.getItems().get(i).getNomeCompleto()
                );

                professorDao.registerProfessor(
                        tableView.getItems().get(i).getEmailOrientador(),
                        tableView.getItems().get(i).getNomeCompletoOrientador()
                );

                materiaDao.registerMateria(
                        tableView.getItems().get(i).getMatriculadoEm(),
                        semestreInput.getText(),
                        tableView.getItems().get(i).getTipoTG(),
                        tableView.getItems().get(i).getProblema(),
                        tableView.getItems().get(i).getEmpresa(),
                        tableView.getItems().get(i).getDisciplina(),
                        tableView.getItems().get(i).getEmailAlunoPessoal(),
                        tableView.getItems().get(i).getEmailOrientador()
                );
            }
        } else {
            showAlert("Esse semestre já cadastrado");
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btnLoadCsv.disableProperty().bind(
                Bindings.isEmpty(semestreInput.textProperty()));
        btnSendToDataBase.disableProperty().bind(
                Bindings.isEmpty(semestreInput.textProperty()));
        col1.setCellFactory(TextFieldTableCell.forTableColumn());
        col2.setCellFactory(TextFieldTableCell.forTableColumn());
        col3.setCellFactory(TextFieldTableCell.forTableColumn());
        col4.setCellFactory(TextFieldTableCell.forTableColumn());
        col5.setCellFactory(TextFieldTableCell.forTableColumn());
        col6.setCellFactory(TextFieldTableCell.forTableColumn());
        col7.setCellFactory(TextFieldTableCell.forTableColumn());
        col8.setCellFactory(TextFieldTableCell.forTableColumn());
        col9.setCellFactory(TextFieldTableCell.forTableColumn());
    }
}
