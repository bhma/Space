package Controller;

import View.TelaPontu;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TelaPontuController implements Initializable {
    @FXML private Button btVoltar;
    @FXML private Text nomeJog1;
    @FXML private Text nomeJog2;
    @FXML private Text nomeJog3;
    @FXML private Text nomeJog4;
    @FXML private Text pontJog1;
    @FXML private Text pontJog2;
    @FXML private Text pontJog3;
    @FXML private Text pontJog4;

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
