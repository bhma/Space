package Controller;

import Model.JogadorModel;
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
        startScore();
        btVoltar.setOnMouseClicked(event -> {
            try {
                Transition.abreTelaOpcao(TelaPontu.getTelaPontuStage());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
    private void startScore(){
        JogadorModel j;
        try{
            j = MainController.getListaJogador().get(0);
            nomeJog1.setText(j.getNome());
            pontJog1.setText(Integer.toString(j.getTotal()));
            j = MainController.getListaJogador().get(1);
            nomeJog2.setText(j.getNome());
            pontJog2.setText(Integer.toString(j.getTotal()));
            j = MainController.getListaJogador().get(2);
            nomeJog3.setText(j.getNome());
            pontJog3.setText(Integer.toString(j.getTotal()));
            j = MainController.getListaJogador().get(3);
            nomeJog4.setText(j.getNome());
            pontJog4.setText(Integer.toString(j.getTotal()));
        }catch (ArrayIndexOutOfBoundsException e){
            System.err.println(e);
            System.out.println("Acesso inválido no array!");
        }

    }
}
