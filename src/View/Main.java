package View;

import Model.JogadorModel;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {
    private static Stage mainStage;
    public static Media media;
    public static MediaPlayer player;

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("tPrincipal.fxml"));
        primaryStage.setTitle("FINAL SPACE");
        if(player == null){
            media = new Media(this.getClass().getResource("/sounds/StarWars8Bit.mp3").toExternalForm());
            player = new MediaPlayer(media);
            player.setVolume(0.8);
            player.setOnEndOfMedia(() -> {
                player.seek(Duration.ZERO);
                System.out.println("Loop");
            });
            //player.play();
        }
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        setMainStage(primaryStage);
    }

    public static Stage getMainStage() {
        return mainStage;
    }

    public static void setMainStage(Stage mainStage) {
        Main.mainStage = mainStage;
    }

}
