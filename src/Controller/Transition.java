package Controller;

import View.*;
import javafx.stage.Stage;

import java.io.IOException;

public class Transition {
    public static void abreTelaJogar(Stage stage) throws Exception {
        TelaNome telaJogar = new TelaNome();
        fecha(stage);
        telaJogar.start(new Stage());
    }
    public static void abreTelaPrincipal(Stage stage) throws Exception {
        Main main = new Main();
        fecha(stage);
        main.start(new Stage());
    }
    public static void abreTelaOpcao(Stage stage) throws IOException {
        TelaOpcao telaOpcao = new TelaOpcao();
        fecha(stage);
        telaOpcao.start(new Stage());
    }
    public static void abreTelaModoJogo(Stage stage) throws IOException {
        TelaModoJogo tModoJogo = new TelaModoJogo();
        fecha(stage);
        tModoJogo.start(new Stage());
    }
    public static void abreTelaSistSolar(Stage stage) throws IOException {
        TelaSistSolar tSisSolar = new TelaSistSolar();
        stage.close();
        tSisSolar.start(new Stage());
    }

    public static void abreTelaAdvPlan(Stage stage) throws IOException {
        TelaAdvPlan telaAdvPlan = new TelaAdvPlan();
        fecha(stage);
        telaAdvPlan.start(new Stage());
    }
    public static void abreTelaPontu(Stage stage) throws IOException {
        TelaPontu telaPontu = new TelaPontu();
        telaPontu.start(new Stage());
        fecha(stage);
    }
    public static void abreTelaConste(Stage stage) throws IOException {
        TelaConste telaConste = new TelaConste();
        telaConste.start(new Stage());
        fecha(stage);
    }

    public static void fecha(Stage stage){
        stage.close();
    }
}
