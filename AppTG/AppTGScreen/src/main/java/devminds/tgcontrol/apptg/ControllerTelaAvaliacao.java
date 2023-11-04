package devminds.tgcontrol.apptg;

import devminds.tgcontrol.apptg.obj.DTOAvaliacao;
import devminds.tgcontrol.apptg.obj.DTOSemestre;
import devminds.tgcontrol.dao.MateriaDao;
import devminds.tgcontrol.objects.Avaliacao;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import java.util.PrimitiveIterator;

public class ControllerTelaAvaliacao {
    private DTOAvaliacao data = DTOAvaliacao.getInstance();
    @FXML private TableView<Avaliacao> avaliacaoTableView;
    @FXML private TableColumn<Avaliacao,String> col1;
    @FXML private TableColumn<Avaliacao,String> col2;
    @FXML private TableColumn<Avaliacao, Double> col3;


    private ObservableList<Avaliacao> getAvaliacao(){
        ObservableList<Avaliacao> obsList = FXCollections.observableArrayList();
        obsList.add(data);
        return obsList;
    }
    @FXML
    private void stageToTelaVisualizar(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("TelaVisualizar.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();

    }
    @FXML
    private void initialize() throws SQLException, ClassNotFoundException {
        col1.setCellValueFactory(new PropertyValueFactory<Avaliacao, String>("nomeAtividade"));
        col2.setCellValueFactory(new PropertyValueFactory<Avaliacao, String>("feedback"));
        col3.setCellValueFactory(new PropertyValueFactory<Avaliacao, Double>("nota"));
        avaliacaoTableView.setItems(getAvaliacao());

    }
}
