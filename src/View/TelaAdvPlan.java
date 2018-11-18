package View;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import static View.Main.setMainStage;

public class TelaAdvPlan extends Application {
    private static Stage advPlanStage;

    public static void main(String[] args) { launch(args); }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("tAdvPlan.fxml"));
        primaryStage.setTitle("Advinhe o Planeta");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        setAdvPlanStage(primaryStage);
    }

    public static Stage getAdvPlanStage() { return advPlanStage; }

    public static void setAdvPlanStage(Stage advPlanStage) { TelaAdvPlan.advPlanStage = advPlanStage; }
}
