package devminds.tgcontrol.apptg;

import devminds.tgcontrol.dao.MateriaDao;
import javafx.beans.InvalidationListener;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

public class ControllerTelaVisualizar {
    @FXML private ChoiceBox<String> selectlist;

    public void setChoiceBox() throws SQLException, ClassNotFoundException,NullPointerException {

    }


    @FXML
    private void stageToTelaAtividade(ActionEvent event) throws IOException, SQLException, ClassNotFoundException {
        ControllerTelaVisualizar ctrl = new ControllerTelaVisualizar();
        ctrl.setChoiceBox();










        Parent tableViewParent = FXMLLoader.load(getClass().getResource("TelaAtividade.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();
    }
    @FXML
    private void initialize() throws SQLException, ClassNotFoundException {
        MateriaDao materiaDao  = new MateriaDao();
        List<String> lista = materiaDao.getSemestreEMateria();
        ObservableList<String> obsList = FXCollections.observableList(lista);
        selectlist.setItems(obsList);
    }
}

