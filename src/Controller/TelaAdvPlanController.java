package Controller;

import Model.JogadorModel;
import Model.TextosModel;
import View.Main;
import View.TelaAdvPlan;
import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.PathTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
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
    @FXML private ImageView imgErr;
    @FXML private ImageView imgCor;
    @FXML private Label lblPonto;
    @FXML private TextField txfPlanet;
    @FXML private Text txDica;
    @FXML private ImageView imgBalDica;

    private JogoAdvPlanController novoJogo;
    private FadeTransition fd;
    private int c = 0;
    private ArrayList<Integer> num;
    private boolean v, e = false;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        iniciaJogo(TelaNomeController.getJogador());
        txfPlanet.setOnKeyPressed(event -> {
            if(event.getCode() == KeyCode.ENTER){
                if(imgHawking.getOpacity() == 1.0){
                    closeTip();
                }
                if(btVerif.getText().equals("INICIAR") == false){
                    if(c <= 8){
                        v = novoJogo.verificaPlaneta(num.get(c), txfPlanet.getText());
                        if(v == true){
                            mudaPla();
                            icons(1);
                        }else if(e == false){
                            e = true;
                            icons(2);
                            txDica.setText("Você errou o nome desse planeta. Tente mais uma vez com a ajuda de uma dica.");
                            if(imgHawking.getOpacity() == 0.0){
                                loadTip();
                            }
                        }else{
                            icons(2);
                            if(imgHawking.getOpacity() == 1.0){
                                closeTip();
                            }
                            mudaPla();
                        }
                    }
                    if(c == 8){
                        btVerif.setText("FINALIZAR");
                    }
                }
            }
        });
        btVerif.setOnMouseClicked(event -> {
            if(imgHawking.getOpacity() == 1.0){
                closeTip();
            }
            if( c <= 8){
                if(btVerif.getText().equals("INICIAR") == true){
                    btVerif.setText("PRÓXIMO");
                    txfPlanet.setVisible(true);
                    fd = loadPlanet(num.get(c));
                    fd.play();
                }else {
                    v = novoJogo.verificaPlaneta(num.get(c), txfPlanet.getText());
                    if(v == true){
                        icons(1);
                        mudaPla();
                    }else if(e == false){
                        e = true;
                        icons(2);
                        txDica.setText("Você errou o nome desse planeta.Tente mais uma vez com a ajuda de uma dica.");
                        if(imgHawking.getOpacity() == 0.0){
                            loadTip();
                        }
                    }else{
                        icons(2);
                        if(imgHawking.getOpacity() == 1.0){
                            closeTip();
                        }
                        mudaPla();
                    }
                }
            }else if(btVerif.getText().equals("FINALIZAR")){
                this.novoJogo.getJogador().setPontosAdvPla(this.novoJogo.getPontos());
                this.novoJogo.getJogador().setTotal();
            }
        });
        btDica.setOnMouseClicked(event -> {
            if(imgHawking.getOpacity() == 0){
                loadTip();
                loadTipPla(num.get(c));
            }

        });
        btVoltar.setOnMouseClicked(event -> {
            if(novoJogo.getJogador().getPontosSistSol() > 0){
                MainController.getListaJogador().add(novoJogo.getJogador());
            }
            try {
                Transition.abreTelaModoJogo(TelaAdvPlan.getAdvPlanStage());
            } catch (IOException e) {
                    e.printStackTrace();
            }
        });
        imgHawking.setOnMouseClicked(event -> {
            closeTip();
        });
    }

    private void loadTipPla(int pla){
        switch (pla){
            case 9:
                txDica.setText(TextosModel.getTexto2(pla));
                break;
            case 8:
                txDica.setText(TextosModel.getTexto2(pla));
                break;
            case 7:
                txDica.setText(TextosModel.getTexto2(pla));
                break;
            case 6:
                txDica.setText(TextosModel.getTexto2(pla));
                break;
            case 5:
                txDica.setText(TextosModel.getTexto2(pla));
                break;
            case 4:
                txDica.setStyle("-fx-font-size: 18");
                txDica.setText(TextosModel.getTexto2(pla));
                break;
            case 3:
                txDica.setText(TextosModel.getTexto2(pla));
                break;
            case 2:
                txDica.setText(TextosModel.getTexto2(pla));
                break;
            case 1:
                txDica.setStyle("-fx-font-size: 18");
                txDica.setText(TextosModel.getTexto2(pla));
                break;
            default:
                System.out.println("fim");
        }
    }

    private void loadTip(){
        Line li = new Line();
        li.setStartX(0);
        li.setStartY(100);
        li.setEndX(0);
        li.setEndY(50);

        PathTransition tra = new PathTransition();
        tra.setNode(imgHawking);
        tra.setDuration(Duration.seconds(1));
        tra.setPath(li);

        FadeTransition fd = new FadeTransition(Duration.seconds(1), imgHawking);
        fd.setFromValue(0.0);
        fd.setToValue(1.0);
        ParallelTransition p = new ParallelTransition(tra, fd);
        p.play();
        imgBalDica.setOpacity(1.0);
        txDica.setOpacity(1.0);
    }

    private void closeTip(){
        Line li = new Line();
        li.setStartX(0);
        li.setStartY(50);
        li.setEndX(0);
        li.setEndY(100);

        PathTransition tra = new PathTransition();
        tra.setNode(imgHawking);
        tra.setDuration(Duration.seconds(1));
        tra.setPath(li);

        FadeTransition fd = new FadeTransition(Duration.seconds(1), imgHawking);
        fd.setFromValue(1.0);
        fd.setToValue(0.0);
        ParallelTransition p = new ParallelTransition(tra, fd);
        p.play();
        imgBalDica.setOpacity(0.0);
        txDica.setOpacity(0.0);
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

    public void mostraPontos(){
        lblPonto.setText(Integer.toString(novoJogo.getPontos()));
    }

    private void icons(int i){
        FadeTransition fadeIn = new FadeTransition(Duration.seconds(1));
        FadeTransition fadeOut = new FadeTransition(Duration.seconds(1));
        fadeIn.setFromValue(0.0);
        fadeIn.setToValue(1.0);
        fadeOut.setFromValue(1.0);
        fadeOut.setToValue(0.0);
        switch (i){
            case 1:
                fadeIn.setNode(imgCor);
                fadeIn.play();
                setTimeout(() -> {
                    fadeOut.setNode(imgCor);
                    fadeOut.play();
                }, 1000);
                break;
            case 2:
                fadeIn.setNode(imgErr);
                fadeIn.play();
                setTimeout(() -> {
                    fadeOut.setNode(imgErr);
                    fadeOut.play();
                }, 1000);
                break;
        }
    }

    private void iniciaJogo(JogadorModel jog){
        novoJogo = new JogoAdvPlanController(jog);
        txfPlanet.setVisible(false);
        txDica.setText("Olá, digite o nome do planeta que é mostrado na tela, " +
                        "se não souber clique em Dica que eu te ajudo, para as dicas sumirem" +
                        " clique em mim. Boa Sorte!");
        num = new ArrayList();
        for(int i = 1; i <= 9; i++){
            num.add(i);
        }
        Collections.shuffle(num);
        loadTip();
    }

    private void mudaPla(){
        mostraPontos();
        txfPlanet.clear();
        fd = closePlanet(num.get(c));
        fd.play();
        if(c < 8){
            fd = loadPlanet(num.get(c + 1));
            fd.play();
        }else if(c == 8){
            txfPlanet.setVisible(false);
            btDica.setVisible(false);
            btVerif.setText("FINALIZAR");
        }

        c++;
    }


    public static void setTimeout(Runnable runnable, int delay) {
        new Thread(() -> {
            try {
                Thread.sleep(delay);
                runnable.run();
            } catch (InterruptedException exception) {
                System.err.println(exception.getMessage());
            }
        }).start();
    }
}
