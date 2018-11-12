package View;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TelaNome extends Application {
    private static Stage telaJogarStage;

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("tNome.fxml"));
        primaryStage.setTitle("FINAL SPACE");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        setTelaJogarStage(primaryStage);
    }

    public static Stage getTelaJogarStage() {
        return telaJogarStage;
    }

    public static void setTelaJogarStage(Stage telaJogarStage) {
        TelaNome.telaJogarStage = telaJogarStage;
    }
}
