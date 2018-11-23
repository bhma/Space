package Controller;

import View.Main;
import View.TelaOpcao;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;

import java.io.IOException;
import java.net.URL;
import java.util.Observable;
import java.util.ResourceBundle;

public class TelaOpcaoController implements Initializable {
    @FXML private Button btVoltar;
    @FXML private Button btPont;
    @FXML private Slider volBar;


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
        volBar.setValue(Main.player.getVolume() * 100);
        volBar.valueProperty().addListener(observable -> {
            Main.player.setVolume(volBar.getValue() / 100);
        });

    }
}
