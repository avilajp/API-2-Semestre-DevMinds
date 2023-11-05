package devminds.tgcontrol.apptg;

import devminds.tgcontrol.apptg.obj.DTOSemestre;
import devminds.tgcontrol.dao.AtividadeDao;
import devminds.tgcontrol.dao.AvaliacaoDao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class ControllerTelaAtividade {
    DTOSemestre data = DTOSemestre.getInstance();

    @FXML private TextField nome1;
    @FXML private TextArea descricao1;
    @FXML private DatePicker dataEntrega1;
    @FXML private ChoiceBox<String> tipo1;
    @FXML private TextField nome2;
    @FXML private TextArea descricao2;
    @FXML private DatePicker dataEntrega2;
    @FXML private Label showSemestre;
    @FXML private TextField nome3;
    @FXML private TextArea descricao3;
    @FXML private DatePicker dataEntrega3;
    @FXML private TextField nome4;
    @FXML private TextArea descricao4;
    @FXML private DatePicker dataEntrega4;

    @FXML
    public void sendToDatabase(ActionEvent event){
        AtividadeDao atividadeDao = new AtividadeDao();

        try {
            if (nome1.getText().isEmpty()){
                System.out.println("O nome da atividade 1 precisa ser preenchido!");
            }if(descricao1.getText().isEmpty()){
                System.out.println("A descrição precisa conter texto");
            }else{
                atividadeDao.createAtividade(nome1.getText(), dataEntrega1.getValue().atTime(23, 59, 59), descricao1.getText(), data.getMateria(), tipo1.getSelectionModel().getSelectedItem(), data.getSemestre());
            }

            atividadeDao.createAtividade(nome2.getText(), dataEntrega2.getValue().atTime(23, 59, 59), descricao2.getText(), data.getMateria(), tipo1.getSelectionModel().getSelectedItem(), data.getSemestre());
            atividadeDao.createAtividade(nome3.getText(), dataEntrega3.getValue().atTime(23, 59, 59), descricao3.getText(), data.getMateria(), tipo1.getSelectionModel().getSelectedItem(), data.getSemestre());
            atividadeDao.createAtividade(nome4.getText(), dataEntrega4.getValue().atTime(23, 59, 59), descricao4.getText(), data.getMateria(), tipo1.getSelectionModel().getSelectedItem(), data.getSemestre());
        }catch (NullPointerException e){
            System.out.println("Atividades com campos em branco foram ignoradas...");
        }
        AvaliacaoDao avaliacaoDao  = new AvaliacaoDao();
//        avaliacaoDao.criarAvaliacaoDaAtividade(); PAROU AQUI



    }
    @FXML
    private void stageToTelaImportar(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("TelaVisualizar.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();
    }

    @FXML
    private void initialize(){
        ObservableList<String> listaChoiceBox = FXCollections.observableArrayList();
        listaChoiceBox.add("Portfólio (Exige participação em todos os 6 APIs)");
        listaChoiceBox.add("Artigo Tecnológico ou Científico");
        listaChoiceBox.add("Relatório Técnico - Estágio (Somente para quem não pode participar de 6 APIs. Autorizado pela empresa)");
        listaChoiceBox.add("Relatório Técnico - Disciplina (Somente para quem não pode participar de 6 APIs)");
        this.tipo1.setItems(listaChoiceBox);


        showSemestre.setText(data.getSemestre());
    }
}

