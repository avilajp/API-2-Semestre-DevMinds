package devminds.tgcontrol.apptg;

import devminds.tgcontrol.dao.AtividadeDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.w3c.dom.Text;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Date;

public class ControllerTelaAtividade {
    @FXML private TextField nome1;
    @FXML private TextField descricao1;
    @FXML private DatePicker dataEntrega1;
    @FXML private TextField nome2;
    @FXML private TextField descricao2;
    @FXML private DatePicker dataEntrega2;

    @FXML
    public void sendToDatabase(ActionEvent event){
        AtividadeDao atividadeDao = new AtividadeDao();
        atividadeDao.createAtividade(nome1.getText(), dataEntrega1.getValue().atTime(23,59,59),descricao1.getText());
        atividadeDao.createAtividade(nome2.getText(), dataEntrega2.getValue().atTime(23,59,59),descricao2.getText());
    }
    @FXML
    private void stageToTelaImportar(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("TelaVisualizar.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();

    }
}

