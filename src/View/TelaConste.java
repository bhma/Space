package View;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class TelaConste extends Application {
    private static Stage telaConsteStage;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("tConste.fxml"));
        primaryStage.setTitle("Constelações");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        setTelaConsteStage(primaryStage);
    }

    public static Stage getTelaConsteStage() {
        return telaConsteStage;
    }

    public static void setTelaConsteStage(Stage telaConsteStage) {
        TelaConste.telaConsteStage = telaConsteStage;
    }
}
