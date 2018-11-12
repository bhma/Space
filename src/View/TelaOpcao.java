package View;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class TelaOpcao extends Application {
    private static Stage telaOpcaoStage;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("tOpcao.fxml"));
        primaryStage.setTitle("JOGAR");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        setTelaOpcaoStage(primaryStage);
    }

    public static Stage getTelaOpcaoStage() {
        return telaOpcaoStage;
    }

    public static void setTelaOpcaoStage(Stage telaOpcaoStage) {
        TelaOpcao.telaOpcaoStage = telaOpcaoStage;
    }
}
