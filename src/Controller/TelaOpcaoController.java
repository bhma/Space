package Controller;

import View.TelaOpcao;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TelaOpcaoController implements Initializable {
    @FXML private Button btVoltar;
    @FXML private Button btPont;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btPont.setOnMouseClicked(event -> {
            try {
                Transition.abreTelaPontu(TelaOpcao.getTelaOpcaoStage());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        btVoltar.setOnMouseClicked(event -> {
            try {
                Transition.abreTelaPrincipal(TelaOpcao.getTelaOpcaoStage());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
