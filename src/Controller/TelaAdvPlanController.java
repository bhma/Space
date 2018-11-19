package Controller;

import Model.JogadorModel;
import View.TelaAdvPlan;
import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.util.Duration;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;

public class TelaAdvPlanController implements Initializable {

    @FXML private Button btVoltar;
    @FXML private Button btDica;
    @FXML private Button btVerif;
    @FXML private ImageView imgTerra;
    @FXML private ImageView imgMerc;
    @FXML private ImageView imgVenus;
    @FXML private ImageView imgmart;
    @FXML private ImageView imgJup;
    @FXML private ImageView imgSat;
    @FXML private ImageView imgUra;
    @FXML private ImageView imgNetu;
    @FXML private ImageView imgPlut;
    @FXML private ImageView imgHawking;
    @FXML private Label lblPonto;
    @FXML private Label lblDicas;
    @FXML private TextField txfPlanet;

    private JogoAdvPlanController novoJogo;
    private FadeTransition fd;
    private int c = 1;
    private ArrayList<Integer> num;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        iniciaJogo(TelaNomeController.getJogador());

        txfPlanet.setOnKeyPressed(event -> {
            if(event.getCode() == KeyCode.ENTER){
                System.out.println(txfPlanet.getText());
            }
        });
        btVerif.setOnMouseClicked(event -> {
            if( c <= 9){
                if(btVerif.getText().equals("INICIAR") == true){
                    btVerif.setText("PRÓXIMO");
                    //v = n.nextInt(8) + 1;
                    fd = loadPlanet(num.get(c - 1));
                    fd.play();
                }else {
                    fd = closePlanet(num.get(c - 1));
                    fd.play();
                    //v = n.nextInt(8) + 1;
                    if(c == 9){
                        fd = loadPlanet(num.get(8));
                        fd.play();
                    }else{
                        fd = loadPlanet(num.get(c));
                        fd.play();
                    }
                    System.out.println(num.get(c - 1));
                    c++;
                }
            }else{
                System.out.println("voce ja viu todos os planetas do nosso sistema solar!");
            }
        });
        btVoltar.setOnMouseClicked(event -> {
            try {
                Transition.abreTelaModoJogo(TelaAdvPlan.getAdvPlanStage());
            } catch (IOException e) {
                    e.printStackTrace();
            }
        });
    }

    private FadeTransition loadPlanet(int pla){
        FadeTransition fd = new FadeTransition(Duration.seconds(1));
        fd.setFromValue(0.0);
        fd.setToValue(1.0);
        switch (pla){
            case 9:
                fd.setNode(imgMerc);
                break;
            case 8:
                fd.setNode(imgVenus);
                break;
            case 7:
                fd.setNode(imgTerra);
                break;
            case 6:
                fd.setNode(imgmart);
                break;
            case 5:
                fd.setNode(imgJup);
                break;
            case 4:
                fd.setNode(imgSat);
                break;
            case 3:
                fd.setNode(imgUra);
                break;
            case 2:
                fd.setNode(imgNetu);
                break;
            case 1:
                fd.setNode(imgPlut);
                break;
        }
        return fd;
    }

    private FadeTransition closePlanet(int pla){
        FadeTransition fd = new FadeTransition(Duration.seconds(1));
        fd.setFromValue(1.0);
        fd.setToValue(0.0);
        switch (pla){
            case 9:
                fd.setNode(imgMerc);
                break;
            case 8:
                fd.setNode(imgVenus);
                break;
            case 7:
                fd.setNode(imgTerra);
                break;
            case 6:
                fd.setNode(imgmart);
                break;
            case 5:
                fd.setNode(imgJup);
                break;
            case 4:
                fd.setNode(imgSat);
                break;
            case 3:
                fd.setNode(imgUra);
                break;
            case 2:
                fd.setNode(imgNetu);
                break;
            case 1:
                fd.setNode(imgPlut);
                break;
        }
        return fd;
    }

    private void iniciaJogo(JogadorModel jog){
        novoJogo = new JogoAdvPlanController(jog);
        num = new ArrayList();
        for(int i = 1; i <= 9; i++){
            num.add(i);
        }
        Collections.shuffle(num);
    }
}