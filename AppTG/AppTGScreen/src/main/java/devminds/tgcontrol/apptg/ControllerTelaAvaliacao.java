package devminds.tgcontrol.apptg;

import devminds.tgcontrol.apptg.obj.DTOAvaliacao;
import devminds.tgcontrol.dao.AtividadeDao;
import devminds.tgcontrol.dao.AvaliacaoDao;
import devminds.tgcontrol.objects.ViewObjAtividadeXAluno;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;


public class ControllerTelaAvaliacao {
    private DTOAvaliacao data = DTOAvaliacao.getInstance();
    @FXML private TextField nomeAlunoExibicao;
    @FXML private TableView<ViewObjAtividadeXAluno> avaliacaoTableView;
    @FXML private TableColumn<ViewObjAtividadeXAluno,String> col1;
    @FXML private TableColumn<ViewObjAtividadeXAluno,String> col2;
    @FXML private TableColumn<ViewObjAtividadeXAluno,String> col3;
    @FXML private Button btn_voltar;


    @FXML
    public void setFeedBackCellEvent(TableColumn.CellEditEvent edittedCell){
        ViewObjAtividadeXAluno objSelecionado = avaliacaoTableView.getSelectionModel().getSelectedItem();
        objSelecionado.setFeedback(edittedCell.getNewValue().toString());

    }
    @FXML
    public void setNotaCellEvent(TableColumn.CellEditEvent edittedCell){
        ViewObjAtividadeXAluno objSelecionado = avaliacaoTableView.getSelectionModel().getSelectedItem();
        objSelecionado.setNota(Double.parseDouble(edittedCell.getNewValue().toString()));
    }
    @FXML
    private void stageToTelaVisualizar(ActionEvent event) throws IOException {
        Stage stage = (Stage) btn_voltar.getScene().getWindow();
        stage.close();
    }
    ObservableList<ViewObjAtividadeXAluno> lista = FXCollections.observableArrayList();
    private void sincObservableList() throws SQLException, ClassNotFoundException {
        AtividadeDao atividadeDao =  new AtividadeDao();
        if(!data.getTipo().equals("Portfólio")){
            ObservableList<ViewObjAtividadeXAluno> rs = atividadeDao.getAtividadeXAluno();
            for (ViewObjAtividadeXAluno objeto : rs) {
                if (data.getNome().equals(objeto.getNome_aluno())) {
                    this.lista.add(objeto);
                }
            }
        } else {
            if(data.getMateria().equals("materia_tg1")){
                ObservableList<ViewObjAtividadeXAluno> rs = atividadeDao.getAtividadeXAlunoPortfolio("semestre_tg1",data.getSemestre());
                for (ViewObjAtividadeXAluno obj: rs) {
                    if(data.getNome().equals(obj.getNome_aluno())){
                        this.lista.add(obj);
                    }
                }
            } else {
                ObservableList<ViewObjAtividadeXAluno> rs = atividadeDao.getAtividadeXAlunoPortfolio("semestre_tg2",data.getSemestre());
                for (ViewObjAtividadeXAluno obj: rs) {
                    if(data.getNome().equals(obj.getNome_aluno())){
                        this.lista.add(obj);
                    }
                }
            }

        }


    }
    @FXML
    private void sendToDatabase(ActionEvent event) throws SQLException, ClassNotFoundException {
        AvaliacaoDao avaliacaoDao = new AvaliacaoDao();

        int aux = lista.size();
        for (int i = 0; i < aux; i++) {
            avaliacaoDao.updateAvaliacao(avaliacaoTableView.getItems().get(i).getFeedback(), Double.valueOf(avaliacaoTableView.getItems().get(i).getNota()),avaliacaoTableView.getItems().get(i).getId_avaliacao());
        }

    }
    @FXML
    private void initialize() throws SQLException, ClassNotFoundException {
        sincObservableList();
        nomeAlunoExibicao.setPromptText(data.getNome());
        avaliacaoTableView.setEditable(true);

        col1.setCellValueFactory(new PropertyValueFactory<ViewObjAtividadeXAluno, String>("atividade_nome"));
        col2.setCellValueFactory(new PropertyValueFactory<ViewObjAtividadeXAluno, String>("feedback"));
        col3.setCellValueFactory(new PropertyValueFactory<ViewObjAtividadeXAluno, String>("nota"));


        col2.setCellFactory(TextFieldTableCell.forTableColumn());
        col3.setCellFactory(TextFieldTableCell.forTableColumn());

        avaliacaoTableView.setItems(lista);

    }
}
