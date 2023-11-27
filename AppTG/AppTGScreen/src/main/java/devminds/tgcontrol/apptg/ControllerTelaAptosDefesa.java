package devminds.tgcontrol.apptg;

import devminds.tgcontrol.apptg.obj.DTOAptos;
import devminds.tgcontrol.apptg.obj.DTOAptosDefesa;
import devminds.tgcontrol.dao.AptosDefesaDAO;
import devminds.tgcontrol.objects.DTOFechamento;
import devminds.tgcontrol.objects.ViewObjAlunosAptos;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ControllerTelaAptosDefesa {
    ObservableList<ViewObjAlunosAptos> lista = FXCollections.observableArrayList();
    DTOAptos dataApto = DTOAptos.getInstance();
    @FXML private TableView<ViewObjAlunosAptos> tableAptosDefesa;
    @FXML private Label labelSemestreAtivo;
    @FXML private TableColumn<ViewObjAlunosAptos,String> col1;
    @FXML private TableColumn<ViewObjAlunosAptos,String> col2;
    @FXML private TableColumn<ViewObjAlunosAptos,String> col3;
    @FXML private TableColumn<ViewObjAlunosAptos,Double> col4;
    @FXML private TableColumn<ViewObjAlunosAptos,Double> col5;
    @FXML private TableColumn<ViewObjAlunosAptos,Double> col6;
    @FXML private TableColumn<ViewObjAlunosAptos,Double> col7;
    @FXML private TableColumn<ViewObjAlunosAptos,Double> col8;
    @FXML private TableColumn<ViewObjAlunosAptos,Double> col9;
    @FXML private TableColumn<ViewObjAlunosAptos,Double> col10;
    @FXML private TableColumn<ViewObjAlunosAptos,Double> col11;
    @FXML private ChoiceBox<String> choiceMateria;
    @FXML private Button btn_voltar;
    @FXML private void selecionaChoiceBox(ActionEvent event) throws SQLException, ClassNotFoundException {
        AptosDefesaDAO AptosDefesaDAO = new AptosDefesaDAO();
        if (choiceMateria.getSelectionModel().getSelectedItem().equals("TG1")){
            ObservableList<ViewObjAlunosAptos> obsList = AptosDefesaDAO.getAlunosAptos("materia_tg1",dataApto.getSemestre(),"semestre_tg1");
            lista.clear();
            for (ViewObjAlunosAptos objeto : obsList) {
                if (objeto.getTipo().equals("Relatório Técnico - Estágio") || objeto.getTipo().equals("Relatório Técnico - Disciplina") || objeto.getTipo().equals("Artigo Tecnológico ou Científico") ){
                    lista.add(objeto);
                }

            }
        } else {
            ObservableList<ViewObjAlunosAptos> obsList = AptosDefesaDAO.getAlunosAptos("materia_tg2",dataApto.getSemestre(),"semestre_tg2");
            lista.clear();
            for (ViewObjAlunosAptos objeto : obsList) {
                if (objeto.getTipo().equals("Relatório Técnico - Estágio") || objeto.getTipo().equals("Relatório Técnico - Disciplina") || objeto.getTipo().equals("Artigo Tecnológico ou Científico")|| objeto.getTipo().equals("Portfólio")){
                    lista.add(objeto);
                }
            }
        }
        setTableItems(lista);
    }
    private void setTableItems(ObservableList<ViewObjAlunosAptos> list){
        tableAptosDefesa.setItems(list);
    }
    @FXML private void stageToTelaAptosDefesa(ActionEvent event){
        Stage stage = (Stage) btn_voltar.getScene().getWindow();
        stage.close();
    }
    @FXML private void initialize(){
        labelSemestreAtivo.setText(dataApto.getSemestre());
        String texto = "TG1";
        String texto1 = "TG2";
        List<String> lista = new ArrayList<>();
        lista.add(texto);
        lista.add(texto1);
        ObservableList<String> obsList = FXCollections.observableList(lista);
        choiceMateria.setItems(obsList);
        col1.setCellValueFactory(new PropertyValueFactory<ViewObjAlunosAptos, String>("nomeAluno"));
        col2.setCellValueFactory(new PropertyValueFactory<ViewObjAlunosAptos, String>("tipo"));
        col3.setCellValueFactory(new PropertyValueFactory<ViewObjAlunosAptos, String>("orientador"));
        col4.setCellValueFactory(new PropertyValueFactory<ViewObjAlunosAptos, Double>("nota1"));
        col5.setCellValueFactory(new PropertyValueFactory<ViewObjAlunosAptos, Double>("nota2"));
        col6.setCellValueFactory(new PropertyValueFactory<ViewObjAlunosAptos, Double>("nota3"));
        col7.setCellValueFactory(new PropertyValueFactory<ViewObjAlunosAptos, Double>("nota4"));
        col8.setCellValueFactory(new PropertyValueFactory<ViewObjAlunosAptos, Double>("nota5"));
        col9.setCellValueFactory(new PropertyValueFactory<ViewObjAlunosAptos, Double>("nota6"));
        col10.setCellValueFactory(new PropertyValueFactory<ViewObjAlunosAptos, Double>("nota7"));
        col11.setCellValueFactory(new PropertyValueFactory<ViewObjAlunosAptos, Double>("nota8"));
    }
}
