package devminds.tgcontrol.apptg;

<<<<<<< Updated upstream:AppTG/AppTGScreen/src/main/java/devminds/tgcontrol/apptg/TableViewController.java
=======
import devminds.tgcontrol.dao.AlunoDao;
>>>>>>> Stashed changes:AppTG/AppTGScreen/src/main/java/devminds/tgcontrol/apptg/ControllerTelaControleSemestre.java
import devminds.tgcontrol.importback.csvImport.CsvReader;
import devminds.tgcontrol.importback.jsonObj.Trabalho;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
<<<<<<< Updated upstream:AppTG/AppTGScreen/src/main/java/devminds/tgcontrol/apptg/TableViewController.java
=======
import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.Date;
>>>>>>> Stashed changes:AppTG/AppTGScreen/src/main/java/devminds/tgcontrol/apptg/ControllerTelaControleSemestre.java
import java.util.ResourceBundle;

public class ControllerTelaControleSemestre implements Initializable{
    private String filepath;

    @FXML
    private Label welcomeText;
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
    @FXML private TableColumn<Trabalho, String> col10;
    @FXML
    public void btnLoad(ActionEvent event){
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new javafx.stage.FileChooser.ExtensionFilter("Arquivos CSV", "*.csv"));
        File file = fileChooser.showOpenDialog(new Stage());
        if (file != null) {
            filepath = file.getAbsolutePath();
        }
        //Tabela
        col1.setCellValueFactory(new PropertyValueFactory<Trabalho, String>("timestamp"));
        col2.setCellValueFactory(new PropertyValueFactory<Trabalho, String>("nomeCompletoOrientador"));
        col3.setCellValueFactory(new PropertyValueFactory<Trabalho, String>("emailOrientador"));
        col4.setCellValueFactory(new PropertyValueFactory<Trabalho, String>("tipoTG"));
        col5.setCellValueFactory(new PropertyValueFactory<Trabalho, String>("empresa"));
        col6.setCellValueFactory(new PropertyValueFactory<Trabalho, String>("disciplina"));
        col8.setCellValueFactory(new PropertyValueFactory<Trabalho, String>("emailFatec"));
        col7.setCellValueFactory(new PropertyValueFactory<Trabalho, String>("nomeCompleto"));



            tableView.setItems(getTrabalho());



    }
    public ObservableList<Trabalho> getTrabalho(){
        CsvReader csvReader = new CsvReader();
        Trabalho objTrabalho = csvReader.leitorCsv(filepath);

    return csvReader.getListaDeObjetos();
    }
    @FXML
    public void changeTimestampCellEvent(TableColumn.CellEditEvent edittedCell){
        Trabalho trabalhoSelecionado = tableView.getSelectionModel().getSelectedItem();
        trabalhoSelecionado.setTimestamp(edittedCell.getNewValue().toString());
    }
    @FXML
    public void changeNomeOrientadorCellEvent(TableColumn.CellEditEvent edittedCell){
        Trabalho trabalhoSelecionado = tableView.getSelectionModel().getSelectedItem();
        trabalhoSelecionado.setNomeCompletoOrientador(edittedCell.getNewValue().toString());
    }
    @FXML
    public void changeEmailOrientadorCellEvent(TableColumn.CellEditEvent edittedCell){
        Trabalho trabalhoSelecionado = tableView.getSelectionModel().getSelectedItem();
        trabalhoSelecionado.setEmailOrientador(edittedCell.getNewValue().toString());
    }
    @FXML
    public void changeTipoTGCellEvent(TableColumn.CellEditEvent edittedCell){
        Trabalho trabalhoSelecionado = tableView.getSelectionModel().getSelectedItem();
        trabalhoSelecionado.setTipoTG(edittedCell.getNewValue().toString());
    }
    @FXML
    public void changeDisciplinaCellEvent(TableColumn.CellEditEvent edittedCell){
        Trabalho trabalhoSelecionado = tableView.getSelectionModel().getSelectedItem();
        trabalhoSelecionado.setDisciplina(edittedCell.getNewValue().toString());
    }
    @FXML
    public void changeNomeAlunoCellEvent(TableColumn.CellEditEvent edittedCell){
        Trabalho trabalhoSelecionado = tableView.getSelectionModel().getSelectedItem();
        trabalhoSelecionado.setNomeCompleto(edittedCell.getNewValue().toString());
    }
    @FXML
    public void changeEmailAlunoCellEvent(TableColumn.CellEditEvent edittedCell){
        Trabalho trabalhoSelecionado = tableView.getSelectionModel().getSelectedItem();
        trabalhoSelecionado.setEmailFatec(edittedCell.getNewValue().toString());
    }
    @FXML
    public void changeEmpresaCellEvent(TableColumn.CellEditEvent edittedCell){
        Trabalho trabalhoSelecionado = tableView.getSelectionModel().getSelectedItem();
        trabalhoSelecionado.setEmpresa(edittedCell.getNewValue().toString());
    }
    @FXML
    private void stageToMainScree(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("TelaInicial.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();

    }
<<<<<<< Updated upstream:AppTG/AppTGScreen/src/main/java/devminds/tgcontrol/apptg/TableViewController.java
=======
    public LocalDateTime convertToLocalDateTimeViaSqlTimestamp(Date dateToConvert) {
        return new java.sql.Timestamp(
                dateToConvert.getTime()).toLocalDateTime();
    }
    @FXML
    private void sendToDataBase(ActionEvent event) {
        AlunoDao alunoDao = new AlunoDao();


//        SemestreDao semestreDao = new SemestreDao();
//
//        AtividadeDao atividadeDao = new AtividadeDao();
//        DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
//
       int aux  = getTrabalho().stream().toList().size();
      for (int i = 0; i <aux ; i++) {
          if (tableView.getItems().get(i).getEmailFatec().isEmpty()){
              alunoDao.registerAluno(tableView.getItems().get(i).getEmailPessoal(),tableView.getItems().get(i).getNomeCompleto());
          } else {
              alunoDao.registerAluno(tableView.getItems().get(i).getEmailFatec(),tableView.getItems().get(i).getNomeCompleto());
          }



//                semestreDao.createSemestre(tableView.getItems().get(i).getNomeCompleto());
//            LocalDateTime dateTime = convertToLocalDateTimeViaSqlTimestamp(formatter.parse(getTrabalho().get(i).getTimestamp()));
//            atividadeDao.createAtividade(tableView.getItems().get(i).getTimestamp(),dateTime,tableView.getItems().get(i).getNomeCompleto());
       }

    }
>>>>>>> Stashed changes:AppTG/AppTGScreen/src/main/java/devminds/tgcontrol/apptg/ControllerTelaControleSemestre.java




    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tableView.setEditable(true);
        col1.setCellFactory(TextFieldTableCell.forTableColumn());
        col2.setCellFactory(TextFieldTableCell.forTableColumn());
        col3.setCellFactory(TextFieldTableCell.forTableColumn());
        col4.setCellFactory(TextFieldTableCell.forTableColumn());
        col5.setCellFactory(TextFieldTableCell.forTableColumn());
        col6.setCellFactory(TextFieldTableCell.forTableColumn());
        col7.setCellFactory(TextFieldTableCell.forTableColumn());
        col8.setCellFactory(TextFieldTableCell.forTableColumn());

    }

}
