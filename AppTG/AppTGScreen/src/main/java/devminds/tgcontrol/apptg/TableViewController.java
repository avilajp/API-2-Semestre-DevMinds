package devminds.tgcontrol.apptg;

import devminds.tgcontrol.importback.csvImport.CsvReader;
import devminds.tgcontrol.importback.jsonObj.Trabalho;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class TableViewController implements Initializable{
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
        ObservableList<Trabalho> trabalho = FXCollections.observableArrayList();
        CsvReader csvReader = new CsvReader();
        Trabalho objTrabalho = csvReader.leitorCsv(filepath);
        trabalho.add(objTrabalho);
        return trabalho;
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
