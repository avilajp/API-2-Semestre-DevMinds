package devminds.tgcontrol.apptg;

import devminds.tgcontrol.apptg.obj.DTOInicial;
import devminds.tgcontrol.dao.SemestreDao;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;


import java.io.IOException;
import java.sql.SQLException;

public class ControllerTelaInicial {
    @FXML private Button btnClose;
    @FXML private Label turmaAtual;
    @FXML private Label exibeSemestre;
    @FXML private Button btn_tg1;
    @FXML private Button btn_tg2;

    DTOInicial data = DTOInicial.getInstance();
    String semestreAtual;
    @FXML private void handleCloseAction(ActionEvent event){
        Stage stage = (Stage) btnClose.getScene().getWindow();
        stage.close();
    }
    @FXML private void stageTelaVisualizarTG1(ActionEvent event) throws IOException {
        data.setSemestreMateria(semestreAtual.concat(" - TG1"));
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("TelaVisualizar.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();
    }
    @FXML private void stageTelaVisualizarTG2(ActionEvent event) throws IOException {
        data.setSemestreMateria(semestreAtual.concat(" - TG2"));
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("TelaVisualizar.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();
    }

    @FXML private void initialize() throws SQLException, ClassNotFoundException {
        SemestreDao semestreDao = new SemestreDao();
        String semestre = semestreDao.getSemestreAtual();
        if (semestre != null) {
            exibeSemestre.setText(semestre);
            semestreAtual = semestre;
            btn_tg1.setText(semestre.concat(" - TG1"));
            btn_tg2.setText(semestre.concat(" - TG2"));
        } else {
            turmaAtual.setVisible(false);
            exibeSemestre.setVisible(false);
            btn_tg1.setVisible(false);
            btn_tg2.setVisible(false);
        }
    }



}
