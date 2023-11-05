package devminds.tgcontrol.apptg;

import devminds.tgcontrol.ResultSetToArrayList;
import devminds.tgcontrol.apptg.obj.DTOAvaliacao;
import devminds.tgcontrol.apptg.obj.DTOSemestre;
import devminds.tgcontrol.dao.AtividadeDao;
import devminds.tgcontrol.dao.MateriaDao;
import devminds.tgcontrol.objects.Avaliacao;
import devminds.tgcontrol.objects.ViewObjAtividadeXAluno;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ControllerTelaAvaliacao {
    private DTOAvaliacao data = DTOAvaliacao.getInstance();
    @FXML private TextField nomeAlunoExibicao;
    @FXML private TableView<ViewObjAtividadeXAluno> avaliacaoTableView;
    @FXML private TableColumn<ViewObjAtividadeXAluno,String> col1;
    @FXML private TableColumn<ViewObjAtividadeXAluno,String> col2;
    @FXML private TableColumn<ViewObjAtividadeXAluno, Double> col3;

    @FXML
    private void stageToTelaVisualizar(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("TelaVisualizar.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();

    }
    ObservableList<ViewObjAtividadeXAluno> lista = FXCollections.observableArrayList();
    private void sincObservableList() throws SQLException, ClassNotFoundException {
        AtividadeDao atividadeDao =  new AtividadeDao();
        ObservableList<ViewObjAtividadeXAluno> rs = atividadeDao.getAtividadeXAluno();
        for (ViewObjAtividadeXAluno objeto : rs) {
            if (data.getNome().equals(objeto.getNome_aluno())) {
                this.lista.add(objeto);
            }
        }

    }
    @FXML
    private void initialize() throws SQLException, ClassNotFoundException {
        sincObservableList();
        nomeAlunoExibicao.setPromptText(data.getNome());

        col1.setCellValueFactory(new PropertyValueFactory<ViewObjAtividadeXAluno, String>("atividade_nome"));
        col2.setCellValueFactory(new PropertyValueFactory<ViewObjAtividadeXAluno, String>("feedback"));
        col3.setCellValueFactory(new PropertyValueFactory<ViewObjAtividadeXAluno, Double>("nota"));
        avaliacaoTableView.setItems(lista);

    }
}
