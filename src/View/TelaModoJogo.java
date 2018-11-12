package View;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class TelaModoJogo extends Application {
    private  static Stage TelaModoJogoStage;

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("tModoJogo.fxml"));
        primaryStage.setTitle("Modo de Jogo");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        setTelaModoJogoStage(primaryStage);

    }

    public static Stage getTelaModoJogoStage() {
        return TelaModoJogoStage;
    }

    public static void setTelaModoJogoStage(Stage telaModoJogoStage) {
        TelaModoJogoStage = telaModoJogoStage;
    }
}
