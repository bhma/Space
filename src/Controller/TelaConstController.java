package Controller;

import Model.JogadorModel;
import Model.TextosModel;
import View.TelaConste;
import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.PathTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
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

public class TelaConstController implements Initializable {
    @FXML private Button btVoltar;
    @FXML private Button btVerif;
    @FXML private Button btDica;
    @FXML private ImageView imgNeil;
    @FXML private ImageView imgDica;
    @FXML private ImageView imgCor;
    @FXML private ImageView imgErr;
    @FXML private TextField txfNomeConste;
    @FXML private Text txPont;
    @FXML private Text txDica;
    @FXML private ImageView imgSag;

    private JogoConsteController novoJogo;
    private FadeTransition fd;
    private int c = 0;
    private ArrayList<Integer> num;
    private boolean v, e = false;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        iniciaJogo(TelaNomeController.getJogador());
        txfNomeConste.setOnKeyPressed(event -> {
            if(imgNeil.getOpacity() == 1.0){
                closeTip();
            }
            if(event.getCode() == KeyCode.ENTER){
                if(c <= 10){
                    v = novoJogo.verifConste();
                    if(v == true){
                        mudaConste();
                        icons(1);
                    }else if (e == false){
                        e = true;
                        icons(2);
                        txDica.setText("Você errou o nome dessa constelação. Tente mais uma vez com a ajuda de uma dica.");
                        if(imgNeil.getOpacity() == 0.0){
                            loadTip();
                        }
                    }else{
                        icons(2);
                        if(imgNeil.getOpacity() == 1.0){
                            closeTip();
                        }
                        mudaConste();
                    }
                    if(c == 9){
                        btVerif.setText("FINALIZAR");
                    }
                }
            }
        });
        btVerif.setOnMouseClicked(event -> {
            if(imgNeil.getOpacity() == 1.0){
                closeTip();
            }
            if(c <= 9){
                if(btVerif.getText().equals("INICIAR") == true){
                    btVerif.setText("PRÓXIMO");
                    txfNomeConste.setVisible(true);
                    fd = loadConte(num.get(c));
                    fd.play();
                    imgSag.setVisible(true);
                }else{
                    v = novoJogo.verifConste();
                    if(v == true){
                        icons(1);
                        mudaConste();
                    }else if(e == false){
                        e = true;
                        icons(2);
                        txDica.setText("Você errou o nome dessa constelação.Tente mais uma vez com a ajuda de uma dica.");
                        if(imgNeil.getOpacity() == 0.0){
                            loadTip();
                        }
                    }else {
                        icons(2);
                        if(imgNeil.getOpacity() == 1.0){
                            closeTip();
                        }
                        mudaConste();
                    }
                }
            }else if(btVerif.getText().equals("FINALIZAR")){
                this.novoJogo.getJogador().setPontosConste(this.novoJogo.getPontos());
                this.novoJogo.getJogador().setTotal();
            }
        });

        btDica.setOnMouseClicked(event -> {
            if(imgNeil.getOpacity() == 0){
                loadTip();
                loadTipConste(num.get(c));
            }

        });

        imgNeil.setOnMouseClicked(event -> {
            closeTip();
        });

        btVoltar.setOnMouseClicked(event -> {
            try {
                Transition.abreTelaModoJogo(TelaConste.getTelaConsteStage());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    private void loadTip(){
        Line li = new Line();
        li.setStartX(0);
        li.setStartY(100);
        li.setEndX(0);
        li.setEndY(50);

        PathTransition tra = new PathTransition();
        tra.setNode(imgNeil);
        tra.setDuration(Duration.seconds(1));
        tra.setPath(li);

        FadeTransition fd = new FadeTransition(Duration.seconds(1), imgNeil);
        fd.setFromValue(0.0);
        fd.setToValue(1.0);
        ParallelTransition p = new ParallelTransition(tra, fd);
        p.play();
        imgDica.setVisible(true);
        txDica.setVisible(true);
    }

    private void closeTip(){
        Line li = new Line();
        li.setStartX(0);
        li.setStartY(50);
        li.setEndX(0);
        li.setEndY(100);

        PathTransition tra = new PathTransition();
        tra.setNode(imgNeil);
        tra.setDuration(Duration.seconds(1));
        tra.setPath(li);

        FadeTransition fd = new FadeTransition(Duration.seconds(1), imgNeil);
        fd.setFromValue(1.0);
        fd.setToValue(0.0);
        ParallelTransition p = new ParallelTransition(tra, fd);
        p.play();
        imgDica.setVisible(false);
        txDica.setVisible(false);
    }

    private FadeTransition loadConte(int pla){
        FadeTransition fd = new FadeTransition(Duration.seconds(1));
        fd.setFromValue(0.0);
        fd.setToValue(1.0);
        switch (pla){
            case 9:
//                fd.setNode(imgMerc);
                break;
            case 8:
//                fd.setNode(imgVenus);
                break;
            case 7:
//                fd.setNode(imgTerra);
                break;
            case 6:
//                fd.setNode(imgmart);
                break;
            case 5:
//                fd.setNode(imgJup);
                break;
            case 4:
//                fd.setNode(imgSat);
                break;
            case 3:
//                fd.setNode(imgUra);
                break;
            case 2:
//                fd.setNode(imgNetu);
                break;
            case 1:
//                fd.setNode(imgPlut);
                break;
            case 0:

                break;
        }
        return fd;
    }

    private FadeTransition closeConste(int pla){
        FadeTransition fd = new FadeTransition(Duration.seconds(1));
        fd.setFromValue(1.0);
        fd.setToValue(0.0);
        switch (pla){
            case 9:
//                fd.setNode(imgMerc);
                break;
            case 8:
//                fd.setNode(imgVenus);
                break;
            case 7:
//                fd.setNode(imgTerra);
                break;
            case 6:
//                fd.setNode(imgmart);
                break;
            case 5:
//                fd.setNode(imgJup);
                break;
            case 4:
//                fd.setNode(imgSat);
                break;
            case 3:
//                fd.setNode(imgUra);
                break;
            case 2:
//                fd.setNode(imgNetu);
                break;
            case 1:
//                fd.setNode(imgPlut);
                break;
            case 0:

                break;
        }
        return fd;
    }

    private void loadTipConste(int pla){
        switch (pla){
            case 9:
                txDica.setText(TextosModel.getTexto3(pla));
                break;
            case 8:
                txDica.setText(TextosModel.getTexto3(pla));
                break;
            case 7:
                txDica.setText(TextosModel.getTexto3(pla));
                break;
            case 6:
                txDica.setText(TextosModel.getTexto3(pla));
                break;
            case 5:
                txDica.setText(TextosModel.getTexto3(pla));
                break;
            case 4:
                txDica.setStyle("-fx-font-size: 18");
                txDica.setText(TextosModel.getTexto3(pla));
                break;
            case 3:
                txDica.setText(TextosModel.getTexto3(pla));
                break;
            case 2:
                txDica.setText(TextosModel.getTexto3(pla));
                break;
            case 1:
                txDica.setStyle("-fx-font-size: 18");
                txDica.setText(TextosModel.getTexto3(pla));
                break;
            default:
                System.out.println("fim");
        }
    }

    public void mostraPontos(){
        txPont.setText(Integer.toString(novoJogo.getPontos()));
    }

    private void mudaConste(){
        mostraPontos();
        txfNomeConste.clear();
        fd = closeConste(num.get(c));
        fd.play();
        if(c < 9){
            fd = loadConte(num.get(c + 1));
            fd.play();
        }else if(c == 9){
            txfNomeConste.setVisible(false);
            btVerif.setText("FINALIZAR");
        }
        c++;
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

    private void iniciaJogo(JogadorModel jog){
        novoJogo = new JogoConsteController(jog);
        txDica.setText("Olá, digite o nome da constelação que é mostrada na tela, " +
                        "se não souber clique em Dica que eu te ajudo. Bom jogo!");
        num = new ArrayList();
        for(int i = 1; i <= 9; i++){
            num.add(i);
        }
        Collections.shuffle(num);
        loadTip();
    }
}
