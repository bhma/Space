package Controller;

import Model.JogadorModel;
import View.Main;
import dao.DaoController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;

public class MainController implements Initializable{
    @FXML private Button btJogar;
    @FXML private Button btOpcao;
    @FXML private ImageView imgAste;
    @FXML private Button btSair;
    private static ArrayList<JogadorModel> listaJogador;
    private String arqJog = "jogadores.dat";
    private static boolean lido = false;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        startArq();
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
        btSair.setOnMouseClicked(event -> {
            closeArq();
            Transition.fecha(Main.getMainStage());
        });
    }

    private void startArq(){
        if(listaJogador == null){
            listaJogador = new ArrayList<>();
        }
        if(lido == false){
            DaoController.openToRead(arqJog);
            DaoController.readJogadores();
            DaoController.closeAfterRead();
            lido = true;
        }
    }

    private void closeArq(){
        DaoController.openToWrite(arqJog);
        Collections.sort(listaJogador);
        for(JogadorModel j : listaJogador){
            System.out.println(j);
            DaoController.writeJogadores(j);
        }
        DaoController.closeAfterWrite();
    }


    public static ArrayList<JogadorModel> getListaJogador() {
        return listaJogador;
    }

    public static void setListaJogador(ArrayList<JogadorModel> listaJogador) {
        MainController.listaJogador = listaJogador;
    }
}
