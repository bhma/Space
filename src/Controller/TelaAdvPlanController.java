package Controller;

import Model.JogadorModel;
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
                if(imgHawking.getOpacity() == 1){
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
                            txDica.setText("Você errou o nome desse planeta.Tente mais uma vez com a ajuda de uma dica.");
                            if(imgHawking.getOpacity() == 0){
                                loadTip();
                            }
                        }else{
                            icons(2);
                            if(imgHawking.getOpacity() == 1.0){
                                closeTip();
                            }
                            mudaPla();
                        }
                    }else if(btVerif.getText().equals("FINALIZAR")){
                        //System.out.println("ESTAMOS FINALIZANDO");
                    }
                    if(c == 8){
                        btVerif.setText("FINALIZAR");
                    }
                }
            }
        });
        btVerif.setOnMouseClicked(event -> {
            if(imgHawking.getOpacity() == 1){
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
                        if(imgHawking.getOpacity() == 0){
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
                //System.out.println("ESTAMOS FINALIZANDO");
                this.novoJogo.getJogador().setPontosAdvPla(this.novoJogo.getPontos());
                this.novoJogo.getJogador().setTotal();
                /*System.out.println("O pontos do jogador são: " + this.novoJogo.getJogador().getPontosAdvPla());
                System.out.println("TODOS OS PONTOS COMPUTADOS, FINALIZADO!");*/
            }
            if(c == 8){
                btVerif.setText("FINALIZAR");
            }
        });
        btDica.setOnMouseClicked(event -> {
            if(imgHawking.getOpacity() == 0){
                loadTip();
                loadTipPla(num.get(c));
            }

        });
        btVoltar.setOnMouseClicked(event -> {
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
                txDica.setText("Em função de sua proximidade do Sol, " +
                        "este planeta apresenta temperaturas altíssimas. A temperatura média na " +
                        "superfície é de 126°C, podendo chegar na máxima de 425°C.");
                break;
            case 8:
                txDica.setText("É o planeta mais próximo da Terra." +
                                " A rotação dele ocorre de leste para oeste, " +
                                "contrária a todos os planetas do Sistema Solar.");
                break;
            case 7:
                txDica.setText("O Planeta é composto por camadas que partem desde a " +
                                "superfície terrestre até o núcleo, desse modo são denominadas " +
                                "litosfera, crosta, manto, astenosfera, núcleo externo e núcleo interno.");
                break;
            case 6:
                txDica.setText("Possui duas pequenas luas de formato irregular: Fobos (medo) e Deimos (pânico). " +
                                "Seus nomes derivam da mitologia grega e representam os filhos de Ares e Afrodite.");
                break;
            case 5:
                txDica.setText("Esse planeta foi observado a primeira vez por Galileu Galilei, em 1610, quando também foi possível a" +
                                " identificação de quatro de seus 63 satélites, Io, Europa, Ganimedes e Calisto. A primeira " +
                                "sonda a visita-lo foi a Pioneer 10 em 1973.");
                break;
            case 4:
                txDica.setStyle("-fx-font-size: 18");
                txDica.setText("As observações realizadas indicam que os anéis do planeta são formados por" +
                                " pedaços de cometas, asteroides e luas despedaçadas. Os anéis mais conhecidos são denominados " +
                                "A, B e C, mas há sete no total, todos representam letras do alfabeto à medida em que foram descobertos.");
                break;
            case 3:
                txDica.setText("O planeta possui 27 luas conhecidas que são nomeadas com personagens das obras de William" +
                                " Shakespeare ou Alexander Pope. As primeiras quatro luas, Titania, Oberon, Ariel e " +
                                "Umbriel foram descobertas entre 1787-1851.");
                break;
            case 2:
                txDica.setText("A sua principal lua é Tritão. Desde que foi descoberto, a primeira volta ao Sol dele ocorreu em 2011. " +
                                "O planeta é invisível a olho nu por causa de sua extrema distância da Terra. " +
                                "O campo magnético é cerca de 27 vezes mais potente que o da Terra.");
                break;
            case 1:
                txDica.setStyle("-fx-font-size: 18");
                txDica.setText("Durante 20 anos dos 248 de sua órbita ele fica mais próximo do sol do que " +
                                "netuno devido ao fato de sua órbita ser elíptica. Outro fato interessante é " +
                                "que a órbita de plutão passa pela de netuno em determinado período de seu trajeto, " +
                                "quando ambos percorrem a mesma órbita em torno do sol.");
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
