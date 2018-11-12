package Controller;

import Model.JogadorModel;
import View.Main;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable{
    @FXML private Button btJogar;
    @FXML private Button btOpcao;
    @FXML private ImageView imgAste;



    public void fechaJogo(){
        Transition.fecha(Main.getMainStage());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btJogar.setOnMouseClicked(event -> {
            try {
                Transition.abreTelaJogar(Main.getMainStage());
            } catch (Exception e) {
                System.err.println(e);
            }
        });
        btOpcao.setOnMouseClicked(event -> {
            try {
                Transition.abreTelaOpcao(Main.getMainStage());
            } catch (Exception e) {
                System.err.println(e);
            }
        });
        btOpcao.setOnMouseClicked(event -> {
            try {
                Transition.abreTelaOpcao(Main.getMainStage());
            } catch (Exception e) {
                System.err.println(e);
            }
        });
    }
}
