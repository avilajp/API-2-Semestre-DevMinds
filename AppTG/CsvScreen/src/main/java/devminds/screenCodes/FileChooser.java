package devminds.screenCodes;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class FileChooser extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        javafx.stage.FileChooser botaocsv = new javafx.stage.FileChooser();
        botaocsv.getExtensionFilters().add(new javafx.stage.FileChooser.ExtensionFilter("Arquivos CSV", "*.csv"));
        Button openButton = new Button("CSV");
        openButton.setFont(Font.font(40));
        openButton.setPrefSize(200, 100);
        openButton.setOnAction(e -> {
            File file = botaocsv.showOpenDialog(stage);
            if (file != null) {
               Testete.csvSender(file.getAbsolutePath());
            }
        });
        AnchorPane root = new AnchorPane(openButton);
        AnchorPane.setTopAnchor(openButton, 5.0);
        AnchorPane.setRightAnchor(openButton, 5.0);
        Scene scene = new Scene(root, 600, 600);
        stage.setTitle("Só quero que o fundo fique preto por favor");
        stage.setFullScreen(true);
        stage.setFullScreenExitHint("");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}


