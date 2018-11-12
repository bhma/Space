package Controller;

import View.TelaModoJogo;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TelaModoJogoController implements Initializable {
    @FXML private Button btVoltar;
    @FXML private Button btSistSolar;
    @FXML private Button btAdvPlaneta;
    @FXML private Button btConst;
    @FXML private Button btCacPlaneta;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btVoltar.setOnMouseClicked(event -> {
            try {
                Transition.abreTelaPrincipal(TelaModoJogo.getTelaModoJogoStage());
            } catch (Exception e) {
                System.err.println(e);
            }
        });
        btSistSolar.setOnMouseClicked(event -> {
            try {
                Transition.abreTelaSistSolar(TelaModoJogo.getTelaModoJogoStage());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
