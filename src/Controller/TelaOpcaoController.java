package Controller;

import View.TelaOpcao;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class TelaOpcaoController implements Initializable {
    @FXML private Button btVoltar;
    @FXML private Button btPont;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btVoltar.setOnMouseClicked(event -> {
            try {
                Transition.abreTelaPrincipal(TelaOpcao.getTelaOpcaoStage());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
