package devminds.tgcontrol.apptg;

import devminds.tgcontrol.apptg.obj.DTOSemestre;
import devminds.tgcontrol.dao.AlunoDao;
import devminds.tgcontrol.dao.AtividadeDao;
import devminds.tgcontrol.dao.AvaliacaoDao;
import devminds.tgcontrol.objects.ViewObjAtividadeXAvaliacao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

public class ControllerTelaAtividade {
    DTOSemestre data = DTOSemestre.getInstance();

    @FXML
    private Button btn_voltar;
    @FXML
    private ChoiceBox<String> tipo1;
    @FXML
    private Label showSemestre;
    @FXML
    private TextField nome1;
    @FXML
    private TextField nome2;
    @FXML
    private TextField nome3;
    @FXML
    private TextField nome4;
    @FXML
    private TextArea descricao1;
    @FXML
    private TextArea descricao2;
    @FXML
    private TextArea descricao3;
    @FXML
    private TextArea descricao4;
    @FXML
    private DatePicker dataEntrega1;
    @FXML
    private DatePicker dataEntrega2;
    @FXML
    private DatePicker dataEntrega3;
    @FXML
    private DatePicker dataEntrega4;

    private void disablePreviousDate(DatePicker datePicker) {
        datePicker.setDayCellFactory(picker -> new DateCell() {
            @Override
            public void updateItem(LocalDate date, boolean empty) {
                super.updateItem(date, empty);

                if (date.isBefore(LocalDate.now())) {
                    setDisable(true);
                    setStyle("-fx-background-color: #868686;");
                }
            }
        });
    }
    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Aviso");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private boolean validarAtividade(String nome, String descricao, String tipo) {
        if (nome.isEmpty()) {
            showAlert("Dê um nome para a atividade");
            return false;
        } else if (descricao.isEmpty()) {
            showAlert("É necessário ter uma descrição");
            return false;
        } else if (tipo == null) {
            showAlert("Escolha um tipo de TG");
            return false;
        }
        return true;
    }
    @FXML
    public void sendToDatabase(ActionEvent event) throws SQLException, ClassNotFoundException {
        AtividadeDao atividadeDao = new AtividadeDao();
        AvaliacaoDao avaliacaoDao = new AvaliacaoDao();
        AlunoDao alunoDao = new AlunoDao();
        int counter = 0;

        try {
            if (!nome1.getText().isEmpty() && validarAtividade(nome1.getText(),
                    descricao1.getText(),
                    tipo1.getValue()) && dataEntrega1.getValue() != null) {
                atividadeDao.createAtividade(nome1.getText(), dataEntrega1.getValue().atTime(23, 59, 59), descricao1.getText(), data.getMateria(), tipo1.getValue(), data.getSemestre());
                counter++;
            }

            if (!nome2.getText().isEmpty() && validarAtividade(nome2.getText(),
                    descricao2.getText(),
                    tipo1.getValue()) && dataEntrega2.getValue() != null) {
                atividadeDao.createAtividade(nome2.getText(), dataEntrega2.getValue().atTime(23, 59, 59), descricao2.getText(), data.getMateria(), tipo1.getValue(), data.getSemestre());
                counter++;
            }

            if (!nome3.getText().isEmpty() && validarAtividade(nome3.getText(),
                    descricao3.getText(),
                    tipo1.getValue()) && dataEntrega3.getValue() != null) {
                atividadeDao.createAtividade(nome3.getText(), dataEntrega3.getValue().atTime(23, 59, 59), descricao3.getText(), data.getMateria(), tipo1.getValue(), data.getSemestre());
                counter++;
            }

            if (!nome4.getText().isEmpty() && validarAtividade(nome4.getText(),
                    descricao4.getText(),
                    tipo1.getValue()) && dataEntrega4.getValue() != null) {
                atividadeDao.createAtividade(nome4.getText(), dataEntrega4.getValue().atTime(23, 59, 59), descricao4.getText(), data.getMateria(), tipo1.getValue(), data.getSemestre());
                counter++;
            }

            if (counter > 0) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Sucesso");
                alert.setHeaderText(null);
                alert.setContentText("Feedback salvo com sucesso");
                alert.showAndWait();

                ObservableList<ViewObjAtividadeXAvaliacao> lista = alunoDao.getNomeAluno(data.getMateria(), data.getSemestre(), tipo1.getValue());
                for (int j = 0; j < lista.size(); j++) {
                    for (int i = 0; i < counter; i++) {
                        avaliacaoDao.criarAvaliacaoDaAtividade(lista.get(j).getNome(), i);
                    }
                }
            } else {
                showAlert("Nenhuma atividade válida foi criada.");
            }

        } catch (NullPointerException e) {
            System.out.println("Atividades com campos em branco foram ignoradas..." + e);
        }
        System.out.println(counter);
    }

    @FXML
    private void stageToTelaImportar(ActionEvent event) throws IOException {
        Stage stage = (Stage) btn_voltar.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void initialize() {
        disablePreviousDate(dataEntrega1);
        disablePreviousDate(dataEntrega2);
        disablePreviousDate(dataEntrega3);
        disablePreviousDate(dataEntrega4);
        ObservableList<String> listaChoiceBox = FXCollections.observableArrayList();
        listaChoiceBox.add("Portfólio");
        listaChoiceBox.add("Artigo Tecnológico ou Científico");
        listaChoiceBox.add("Relatório Técnico - Estágio");
        listaChoiceBox.add("Relatório Técnico - Disciplina");
        this.tipo1.setItems(listaChoiceBox);
        showSemestre.setText(data.getSemestre());
    }
}

