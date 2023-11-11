package devminds.tgcontrol.apptg;


import devminds.tgcontrol.apptg.obj.DTOAvaliacao;
import devminds.tgcontrol.apptg.obj.DTOInterTela;
import devminds.tgcontrol.apptg.obj.DTOSemestre;
import devminds.tgcontrol.dao.AvaliacaoXAtividadeDAO;
import devminds.tgcontrol.dao.MateriaDao;
import devminds.tgcontrol.objects.ViewObjAtividadeXAvaliacao;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

public class ControllerTelaVisualizar {
    private String semestreSelecionado;
    private String materiaSelecionada;
    DTOInterTela dtoInterTela = DTOInterTela.getInstance();
    @FXML private ChoiceBox<String> selectlist;
    @FXML private TableView<ViewObjAtividadeXAvaliacao> atividadeTableView;
    @FXML private TableColumn<ViewObjAtividadeXAvaliacao, ViewObjAtividadeXAvaliacao> col1;

    @FXML private TableColumn<ViewObjAtividadeXAvaliacao,String> col2;
    @FXML private TableColumn<ViewObjAtividadeXAvaliacao, String> col3;
    @FXML private TableColumn<ViewObjAtividadeXAvaliacao,String> col4;
    @FXML private TableColumn<ViewObjAtividadeXAvaliacao,Double> col5;
    @FXML private TableColumn<ViewObjAtividadeXAvaliacao,Double> col6;
    @FXML private TableColumn<ViewObjAtividadeXAvaliacao,Double> col7;



    @FXML
    private void selecionaChoiceBox(ActionEvent event) throws SQLException, ClassNotFoundException {
        dtoInterTela.setTextoDaChoice(selectlist.getSelectionModel().getSelectedItem());
        String[] vetString = selectlist.getSelectionModel().getSelectedItem().split("-");
        this.semestreSelecionado = vetString[0].trim();

        if (vetString[1].trim().equals("TG1")) {
            this.materiaSelecionada = "materia_tg1";
        } else {
            this.materiaSelecionada = "materia_tg2";
        }

        col1.setCellFactory(param -> new TableCell<ViewObjAtividadeXAvaliacao, ViewObjAtividadeXAvaliacao>() {
            private final Button button = new Button("Avaliar");

            @Override
            protected void updateItem(ViewObjAtividadeXAvaliacao item, boolean empty) {
                super.updateItem(item, empty);

                if (item == null || empty) {
                    setGraphic(null);
                } else {
                    setGraphic(button);
                    button.setOnAction(event -> {
                        try {
                            createTelaAvaliacao(event,item);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    });
                }
            }
        });
        col1.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue()));
        col2.setCellValueFactory(new PropertyValueFactory<ViewObjAtividadeXAvaliacao, String>("nome"));
        col3.setCellValueFactory(new PropertyValueFactory<ViewObjAtividadeXAvaliacao, String>("tipo"));
        col4.setCellValueFactory(new PropertyValueFactory<ViewObjAtividadeXAvaliacao, String>("matriculado"));
//        col5.setCellValueFactory(new PropertyValueFactory<ViewObjAtividadeXAvaliacao, Double>("nota2"));
//        col6.setCellValueFactory(new PropertyValueFactory<ViewObjAtividadeXAvaliacao, Double>("nota3"));
//        col7.setCellValueFactory(new PropertyValueFactory<ViewObjAtividadeXAvaliacao, Double>("nota4"));


        atividadeTableView.setItems(getAtividade());
    }
    DTOAvaliacao dtoAvaliacao = DTOAvaliacao.getInstance();
    @FXML
    private void createTelaAvaliacao(ActionEvent event, ViewObjAtividadeXAvaliacao data) throws IOException {
        dtoAvaliacao.setNome(data.getNome());
        dtoAvaliacao.setNota1(data.getNota1());
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("TelaAvaliacao.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("ABC");
        stage.setScene(new Scene(root1));
        stage.show();
    }

    public ObservableList<ViewObjAtividadeXAvaliacao> getAtividade() throws SQLException, ClassNotFoundException {
        AvaliacaoXAtividadeDAO avaliacaoXAtividadeDAOiacaoDao = new AvaliacaoXAtividadeDAO();
        return avaliacaoXAtividadeDAOiacaoDao.getAlunosTG(this.materiaSelecionada,this.semestreSelecionado);
    }
    public void setChoiceBox() throws SQLException, ClassNotFoundException,NullPointerException {
    }
    DTOSemestre data = DTOSemestre.getInstance();
    @FXML
    private void stageToTelaAtividade(ActionEvent event) throws IOException, SQLException, ClassNotFoundException {
        data.setSemestre(semestreSelecionado);
        data.setMateria(materiaSelecionada);

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("TelaAtividade.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("ABC");
        stage.setScene(new Scene(root1));
        stage.show();
    }
    @FXML
    private void initialize() throws SQLException, ClassNotFoundException {

        MateriaDao materiaDao  = new MateriaDao();
        List<String> lista = materiaDao.getSemestreEMateria();
        ObservableList<String> obsList = FXCollections.observableList(lista);

        selectlist.setItems(obsList);
    }
}

