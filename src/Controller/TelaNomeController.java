package Controller;

import Model.JogadorModel;
import View.TelaNome;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TelaNomeController implements Initializable {
    @FXML private TextField txfDigNome;
    @FXML private Button btContinua;
    @FXML private Button btVoltar;
    @FXML private Text txtErro;
     private static JogadorModel jogador;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btContinua.setOnMouseClicked(event -> {
            if(txfDigNome.getText().length() < 3){
                txtErro.setText("Digite mais letras.");
            }else{
                try {
                    jogador = new JogadorModel(txfDigNome.getText());
                    Transition.abreTelaModoJogo(TelaNome.getTelaJogarStage());
                } catch (IOException e) {
                    System.err.println(e);
                }
            }
        });
        btVoltar.setOnMouseClicked(event -> {
            try {
                Transition.abreTelaPrincipal(TelaNome.getTelaJogarStage());
            } catch (Exception e) {
                System.err.println(e);
            }
        });
    }

    public static JogadorModel getJogador() {
        return jogador;
    }

    public static void setJogador(JogadorModel jogador) {
        TelaNomeController.jogador = jogador;
    }
}
