package View;

import Model.JogadorModel;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class TelaPontu extends Application {
    private static Stage telaPontuStage;
    private static ArrayList<JogadorModel> listaJogador;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("tPontu.fxml"));
        primaryStage.setTitle("FINAL SPACE");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        setTelaPontuStage(primaryStage);
        listaJogador = new ArrayList<>();
    }

    public static Stage getTelaPontuStage() {
        return telaPontuStage;
    }

    public static void setTelaPontuStage(Stage telaPontuStage) {
        TelaPontu.telaPontuStage = telaPontuStage;
    }

    public static ArrayList<JogadorModel> getListaJogador() {
        return listaJogador;
    }

    public static void setListaJogador(ArrayList<JogadorModel> listaJogador) {
        TelaPontu.listaJogador = listaJogador;
    }
}
