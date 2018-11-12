package View;

import com.sun.deploy.util.FXLoader;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class TelaSistSolar extends Application {
    private static Stage TelaSistSolarStage;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("tSistSolar.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.setTitle("Sitema Solar");
        primaryStage.show();
        setTelaSistSolarStage(primaryStage);
    }

    public static Stage getTelaSistSolarStage() {
        return TelaSistSolarStage;
    }

    public static void setTelaSistSolarStage(Stage telaSistSolarStage) {
        TelaSistSolarStage = telaSistSolarStage;
    }
}
