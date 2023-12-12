package devminds.tgcontrol.apptg;

import devminds.tgcontrol.apptg.obj.DTORelatorioFechamento;
import devminds.tgcontrol.objects.DTOTransporteNotas;
import devminds.tgcontrol.dao.TransporteNotasDAO;
import devminds.tgcontrol.objects.DTOFechamento;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class ControllerTransporteNotas {
    DTORelatorioFechamento data = DTORelatorioFechamento.getInstance();
    public Button btn_voltar;
    @FXML private TableView<DTOTransporteNotas> tableTransporteNotas;
    @FXML private TableColumn<DTOTransporteNotas,String> col1;
    @FXML private TableColumn<DTOTransporteNotas,String> col2;
    @FXML private TableColumn<DTOTransporteNotas,Double> col3;
    @FXML private TableColumn<DTOTransporteNotas,Double> col4;
    @FXML private TableColumn<DTOTransporteNotas,Double> col5;
    @FXML private TableColumn<DTOTransporteNotas,Double> col6;
    @FXML private TableColumn<DTOTransporteNotas,Double> col7;
    @FXML private TableColumn<DTOTransporteNotas,Double> col8;
    @FXML private TableColumn<DTOTransporteNotas,Double> col9;
    @FXML private TableColumn<DTOTransporteNotas,Double> col10;

    ObservableList<DTOTransporteNotas> listObj = FXCollections.observableArrayList();
    private void setTableItems(ObservableList<DTOTransporteNotas> list){
        for (DTOTransporteNotas obj: list){
            if (obj.getTipo().equals("Relatório Técnico - Estágio") || obj.getTipo().equals("Relatório Técnico - Disciplina") || obj.getTipo().equals("Artigo Tecnológico ou Científico")){
                if(obj.getNota1().equals(0.0)){
                    obj.setNota1(null);
                } if(obj.getNota2().equals(0.0)) {
                    obj.setNota2(null);
                } if(obj.getNota3().equals(0.0)) {
                    obj.setNota3(null);
                } if(obj.getNota4().equals(0.0)) {
                    obj.setNota4(null);
                } if(obj.getNota5().equals(0.0)) {
                    obj.setNota5(null);
                } if(obj.getNota6().equals(0.0)) {
                    obj.setNota6(null);
                } if(obj.getNota7().equals(0.0)) {
                    obj.setNota7(null);
                } if(obj.getNota8().equals(0.0)) {
                    obj.setNota8(null);
                }
                listObj.add(obj);
            }
        }
        tableTransporteNotas.setItems(listObj);
    }

    @FXML
    void voltar() {
    }

    @FXML private void stageToTelaFechamento(ActionEvent event){
        Stage stage = (Stage) btn_voltar.getScene().getWindow();
        stage.close();
    }

    @FXML private void initialize(){
        TransporteNotasDAO dao = new TransporteNotasDAO();
        ObservableList<DTOTransporteNotas> obsList = dao.getTransporteNotas(data.getSemestre());
        setTableItems(obsList);

        col1.setCellValueFactory(new PropertyValueFactory<DTOTransporteNotas, String>("nomeAluno"));
        col2.setCellValueFactory(new PropertyValueFactory<DTOTransporteNotas, String>("tipo"));
        col3.setCellValueFactory(new PropertyValueFactory<DTOTransporteNotas, Double>("nota1"));
        col4.setCellValueFactory(new PropertyValueFactory<DTOTransporteNotas, Double>("nota2"));
        col5.setCellValueFactory(new PropertyValueFactory<DTOTransporteNotas, Double>("nota3"));
        col6.setCellValueFactory(new PropertyValueFactory<DTOTransporteNotas, Double>("nota4"));
        col7.setCellValueFactory(new PropertyValueFactory<DTOTransporteNotas, Double>("nota5"));
        col8.setCellValueFactory(new PropertyValueFactory<DTOTransporteNotas, Double>("nota6"));
        col9.setCellValueFactory(new PropertyValueFactory<DTOTransporteNotas, Double>("nota7"));
        col10.setCellValueFactory(new PropertyValueFactory<DTOTransporteNotas, Double>("nota8"));
    }
}
