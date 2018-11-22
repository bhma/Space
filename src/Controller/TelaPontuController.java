package Controller;

import View.TelaPontu;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TelaPontuController implements Initializable {
    @FXML private Button btVoltar;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btVoltar.setOnMouseClicked(event -> {
            try {
                Transition.abreTelaOpcao(TelaPontu.getTelaPontuStage());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
