package Controller;

import Model.JogadorModel;
import Model.TextosModel;
import View.TelaSistSolar;
import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.PathTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.shape.*;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TelaSistSolarController implements Initializable {
    @FXML private Button btVoltar;
    @FXML private Button btSub;
    @FXML private Button btPause;
    @FXML private Button btReco;
    @FXML private ImageView imgTerra;
    @FXML private ImageView imgVenus;
    @FXML private ImageView imgMerc;
    @FXML private ImageView imgUrano;
    @FXML private ImageView imgSatur;
    @FXML private ImageView imgJup;
    @FXML private ImageView imgMart;
    @FXML private ImageView imgNetu;
    @FXML private ImageView imgSun;
    @FXML private ImageView imgHawking;
    @FXML private ImageView imgNeil;
    @FXML private ImageView bl2;
    @FXML private ImageView bl1;
    @FXML private Text txtNomePlaneta;
    @FXML private Text txHaw;
    @FXML private Text txNeil;
    @FXML private Text txtAviso;
    @FXML private Label lblPont;
    @FXML private Ellipse eliUra, eliNetu, eliSat, eliJup, eliMart, eliTerra, eliVenus, eliMerc;
    @FXML private Circle p1, p2, p3, p4, p5, p6, p7, p8;


    private JogoSistSolarController novoJogo;
    private PathTransition obMerc, obVenus, obTerra, obMart, obJup, obSat, obUra, obNetu, recMerc;
    private ParallelTransition dHawking, dNeil;// dBalao1, dBalao2;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        iniciaJogo(TelaNomeController.getJogador());
        imgSun.setOnMouseEntered(event -> {
            mostraNome("Sol");
            txtAviso.setText("");
        });
        imgSun.setOnMouseExited(event -> {
            limpaNomePlanet();
        });
        imgTerra.setOnMouseDragged(event -> {
            arrastaImg(imgTerra);
        });
        imgTerra.setOnMouseEntered(event -> {
            mostraNome("Terra");
        });
        imgTerra.setOnMouseExited(event -> {
            limpaNomePlanet();
        });
        imgVenus.setOnMouseDragged(event -> {
            arrastaImg(imgVenus);
        });
        imgVenus.setOnMouseEntered(event -> {
            mostraNome("Vênus");
        });
        imgVenus.setOnMouseExited(event -> {
            limpaNomePlanet();
        });
        imgMerc.setOnMouseDragged(event -> {
            arrastaImg(imgMerc);
        });
        imgMerc.setOnMouseEntered(event -> {
            mostraNome("Mecúrio");
        });
        imgMerc.setOnMouseExited(event -> {
            limpaNomePlanet();
        });
        imgUrano.setOnMouseDragged(event -> {
            arrastaImg(imgUrano);
        });
        imgUrano.setOnMouseEntered(event -> {
            mostraNome("Urano");
        });
        imgUrano.setOnMouseExited(event -> {
            limpaNomePlanet();
        });
        imgSatur.setOnMouseDragged(event -> {
            arrastaImg(imgSatur);
        });
        imgSatur.setOnMouseEntered(event -> {
            mostraNome("Saturno");
        });
        imgSatur.setOnMouseExited(event -> {
            limpaNomePlanet();
        });
        imgJup.setOnMouseDragged(event -> {
            arrastaImg(imgJup);
        });
        imgJup.setOnMouseEntered(event -> {
            mostraNome("Júpter");
        });
        imgJup.setOnMouseExited(event -> {
            limpaNomePlanet();
        });
        imgMart.setOnMouseDragged(event -> {
            arrastaImg(imgMart);
        });
        imgMart.setOnMouseEntered(event -> {
            mostraNome("Marte");
        });
        imgMart.setOnMouseExited(event -> {
            limpaNomePlanet();
        });
        imgNetu.setOnMouseDragged(event -> {
            arrastaImg(imgNetu);
        });
        imgNetu.setOnMouseEntered(event -> {
            mostraNome("Netuno");
        });
        imgNetu.setOnMouseExited(event -> {
            limpaNomePlanet();
        });
        imgMerc.setOnMouseReleased(event -> {
            this.novoJogo.verificaPosicao(imgMerc.getLayoutX(), imgMerc.getLayoutY(), "Merc");
            mostraPontos();
            obMerc = orbitar("Merc");
        });
        imgVenus.setOnMouseReleased(event -> {
            this.novoJogo.verificaPosicao(imgVenus.getLayoutX(), imgVenus.getLayoutY(), "Venus");
            mostraPontos();
            obVenus = orbitar("Venus");
        });
        imgTerra.setOnMouseReleased(event -> {
            this.novoJogo.verificaPosicao(imgTerra.getLayoutX(), imgTerra.getLayoutY(), "Terra");
            mostraPontos();
            obTerra = orbitar("Terra");
        });
        imgMart.setOnMouseReleased(event -> {
            this.novoJogo.verificaPosicao(imgMart.getLayoutX(), imgMart.getLayoutY(), "Mart");
            mostraPontos();
            obMart = orbitar("Mart");
        });
        imgJup.setOnMouseReleased(event -> {
            this.novoJogo.verificaPosicao(imgJup.getLayoutX(), imgJup.getLayoutY(), "Jupt");
            mostraPontos();
            obJup = orbitar("Jup");
        });
        imgSatur.setOnMouseReleased(event -> {
            this.novoJogo.verificaPosicao(imgSatur.getLayoutX(), imgSatur.getLayoutY(), "Satur");
            mostraPontos();
            obSat = orbitar("Sat");
        });
        imgUrano.setOnMouseReleased(event -> {
            this.novoJogo.verificaPosicao(imgUrano.getLayoutX(), imgUrano.getLayoutY(), "Ura");
            mostraPontos();
            obUra = orbitar("Ura");
        });
        imgNetu.setOnMouseReleased(event -> {
            this.novoJogo.verificaPosicao(imgNetu.getLayoutX(), imgNetu.getLayoutY(), "Netu");
            mostraPontos();
            obNetu = orbitar("Netu");
        });
        btVoltar.setOnMouseClicked(event -> {
            try {
                Transition.abreTelaModoJogo(TelaSistSolar.getTelaSistSolarStage());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        final long tm = System.nanoTime();
        btSub.setOnMouseClicked(event -> {
            if(this.novoJogo.verificaSubmit(imgMerc, imgVenus, imgTerra, imgMart, imgJup, imgSatur, imgUrano, imgNetu)){
                limpaPont(false);
                txtNomePlaneta.setText("Parabéns");
                obMerc.play();
                obVenus.play();
                obTerra.play();
                obMart.play();
                obJup.play();
                obSat.play();
                obUra.play();
                obNetu.play();
                this.novoJogo.getJogador().setPontosSistSol(this.novoJogo.getPontos());
                this.novoJogo.getJogador().setTotal();
            }else{
                txtAviso.setText("Algum planeta esta fora de sua órbita!");
            }
        });
        btPause.setOnMouseClicked(event -> {
            if(obMerc != null && obVenus != null && obTerra != null && obMart != null && obJup != null &&
                obSat != null && obUra != null && obNetu != null){
                obMerc.pause();
                obVenus.pause();
                obTerra.pause();
                obMart.pause();
                obJup.pause();
                obSat.pause();
                obUra.pause();
                obNetu.pause();
            }else{
                System.out.println("Uma órbita está vazia!!");
            }
        });
        btReco.setOnMouseClicked(event -> {
            try {
                Transition.abreTelaSistSolar(TelaSistSolar.getTelaSistSolarStage());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        eliMerc.setOnMouseClicked(event -> {
            dNeil = loadTip("neil");
            dNeil.play();
            bl1.setVisible(true);
            txNeil.setOpacity(1);
            txNeil.setText(TextosModel.getTexto1("merc"));
        });
        eliVenus.setOnMouseClicked(event -> {
            dHawking = loadTip("hawking");
            dHawking.play();
            bl2.setVisible(true);
            txHaw.setOpacity(1);
            txHaw.setText(TextosModel.getTexto1("venus"));
        });
        eliTerra.setOnMouseClicked(event -> {
            dNeil = loadTip("neil");
            dNeil.play();
            txNeil.setStyle("-fx-font-size: 19");
            bl1.setVisible(true);
            txNeil.setOpacity(1);
            txNeil.setText(TextosModel.getTexto1("terra"));
        });
        eliMart.setOnMouseClicked(event -> {
            dHawking = loadTip("hawking");
            dHawking.play();
            bl2.setVisible(true);
            txHaw.setOpacity(1);
            txHaw.setText(TextosModel.getTexto1("mart"));
        });
        eliJup.setOnMouseClicked(event -> {
            dNeil = loadTip("neil");
            dNeil.play();
            bl1.setVisible(true);
            txNeil.setOpacity(1);
            txNeil.setText(TextosModel.getTexto1("jup"));
        });
        eliSat.setOnMouseClicked(event -> {
            dHawking = loadTip("hawking");
            dHawking.play();
            bl2.setVisible(true);
            txHaw.setOpacity(1);
            txHaw.setText(TextosModel.getTexto1("sat"));
        });
        eliUra.setOnMouseClicked(event -> {
            dNeil = loadTip("neil");
            dNeil.play();
            bl1.setVisible(true);
            txNeil.setOpacity(1);
            txNeil.setText(TextosModel.getTexto1("ura"));
        });
        eliNetu.setOnMouseClicked(event -> {
            dHawking = loadTip("hawking");
            dHawking.play();
            bl2.setVisible(true);
            txHaw.setOpacity(1);
            txHaw.setText(TextosModel.getTexto1("netu"));
        });
        imgHawking.setOnMouseClicked(event -> {
            if(imgHawking.getOpacity() != 0.0){
                dHawking = closeTip("hawking");
                bl2.setVisible(false);
                //dBalao2 = closeTip("ba2");
                dHawking.play();
//                dBalao2.play();
                txHaw.setOpacity(0);
            }
        });
        imgNeil.setOnMouseClicked(event -> {
            if(imgNeil.getOpacity() != 0.0){
                System.out.println("estou clicando!");
                dNeil = closeTip("neil");
                bl1.setVisible(false);
//                dBalao1 = closeTip("ba1");
                dNeil.play();
//                dBalao1.play();
                txNeil.setOpacity(0);
            }
        });

    }
    private void arrastaImg(ImageView imgV){
        imgV.setOnMouseDragged(event -> {
            imgV.setLayoutX(event.getSceneX() - 35);
            imgV.setLayoutY(event.getSceneY() - 35);
        });
    }

    private Ellipse makeEli(String planet){
        Ellipse el = new Ellipse();
        switch(planet){
            case "Merc":
                el.setCenterX(-90);
                el.setCenterY(30);
                el.setRadiusX(110);
                el.setRadiusY(90);
                break;
            case  "Venus":
                el.setCenterX(-150);
                el.setCenterY(30);
                el.setRadiusX(175);
                el.setRadiusY(155);
                break;
            case "Terra":
                el.setCenterX(-265);
                el.setCenterY(30);
                el.setRadiusX(295);
                el.setRadiusY(235);
                break;
            case "Mart":
                el.setCenterX(-335);
                el.setCenterY(40);
                el.setRadiusX(370);
                el.setRadiusY(315);
                break;
            case "Jup":
                el.setCenterX(-425);
                el.setCenterY(60);
                el.setRadiusX(480);
                el.setRadiusY(400);
                break;
            case "Sat":
                el.setCenterX(-550);
                el.setCenterY(40);
                el.setRadiusX(600);
                el.setRadiusY(470);
                break;
            case "Ura":
                el.setCenterX(-680);
                el.setCenterY(38);
                el.setRadiusX(710);
                el.setRadiusY(510);
                break;
            case "Netu":
                el.setCenterX(-800);
                el.setCenterY(30);
                el.setRadiusX(830);
                el.setRadiusY(520);
                break;
        }
        return el;
    }

    public PathTransition orbitar(String planet){
        PathTransition orb = new PathTransition();
        switch (planet){
            case "Merc":
                orb.setNode(imgMerc);
                orb.setDuration(Duration.millis(3500));
                orb.setPath(makeEli(planet));
                orb.setCycleCount(PathTransition.INDEFINITE);
                break;
            case "Venus":
                orb.setNode(imgVenus);
                orb.setDuration(Duration.millis(4000));
                orb.setPath(makeEli(planet));
                orb.setCycleCount(PathTransition.INDEFINITE);
                break;
            case "Terra":
                orb.setNode(imgTerra);
                orb.setDuration(Duration.millis(5000));
                orb.setPath(makeEli(planet));
                orb.setCycleCount(PathTransition.INDEFINITE);
                break;
            case "Mart":
                orb.setNode(imgMart);
                orb.setDuration(Duration.millis(5400));
                orb.setPath(makeEli(planet));
                orb.setCycleCount(PathTransition.INDEFINITE);
                break;
            case "Jup":
                orb.setNode(imgJup);
                orb.setDuration(Duration.millis(7000));
                orb.setPath(makeEli(planet));
                orb.setCycleCount(PathTransition.INDEFINITE);
                break;
            case "Sat":
                orb.setNode(imgSatur);
                orb.setDuration(Duration.millis(9200));
                orb.setPath(makeEli(planet));
                orb.setCycleCount(PathTransition.INDEFINITE);
                break;
            case "Ura":
                orb.setNode(imgUrano);
                orb.setDuration(Duration.millis(11200));
                orb.setPath(makeEli(planet));
                orb.setCycleCount(PathTransition.INDEFINITE);
                break;
            case "Netu":
                orb.setNode(imgNetu);
                orb.setDuration(Duration.millis(14000));
                orb.setPath(makeEli(planet));
                orb.setCycleCount(PathTransition.INDEFINITE);
                break;
        }
        return orb;
    }

    public void mostraPontos(){
        lblPont.setText(Integer.toString(novoJogo.getPontos()));
    }
    public void limpaPont(boolean s){
        if(s == false){
            p1.setVisible(false);
            p2.setVisible(false);
            p3.setVisible(false);
            p4.setVisible(false);
            p5.setVisible(false);
            p6.setVisible(false);
            p7.setVisible(false);
            p8.setVisible(false);
        }else{
            p1.setVisible(true);
            p2.setVisible(true);
            p3.setVisible(true);
            p4.setVisible(true);
            p5.setVisible(true);
            p6.setVisible(true);
            p7.setVisible(true);
            p8.setVisible(true);
        }

    }

    public ParallelTransition loadTip(String nome){
        ParallelTransition p = null;
        switch (nome){
            case "hawking":
                Line li = new Line();
                li.setStartX(100);
                li.setStartY(100);
                li.setEndX(100);
                li.setEndY(50);

                PathTransition tra = new PathTransition();
                tra.setNode(imgHawking);
                tra.setDuration(Duration.seconds(1));
                tra.setPath(li);

                FadeTransition fd = new FadeTransition(Duration.seconds(1), imgHawking);
                fd.setFromValue(0.0);
                fd.setToValue(1.0);
                p = new ParallelTransition(tra, fd);
                break;
            case "neil":
                Line li1 = new Line();
                li1.setStartX(100);
                li1.setStartY(130);
                li1.setEndX(100);
                li1.setEndY(80);

                PathTransition tra1 = new PathTransition();
                tra1.setNode(imgNeil);
                tra1.setDuration(Duration.seconds(1));
                tra1.setPath(li1);

                FadeTransition fd1 = new FadeTransition(Duration.seconds(1), imgNeil);
                fd1.setFromValue(0.0);
                fd1.setToValue(1.0);
                p = new ParallelTransition(tra1, fd1);
                break;
            case "ba1":
                Line li2 = new Line();
                li2.setStartX(200);
                li2.setStartY(230);
                li2.setEndX(200);
                li2.setEndY(180);

                PathTransition tra2 = new PathTransition();
                tra2.setNode(bl1);
                tra2.setDuration(Duration.seconds(1));
                tra2.setPath(li2);

                FadeTransition fd2 = new FadeTransition(Duration.seconds(1), bl1);
                fd2.setFromValue(0.0);
                fd2.setToValue(1.0);
                p = new ParallelTransition(tra2, fd2);
                break;
            case "ba2":
                Line li3 = new Line();
                li3.setStartX(200);
                li3.setStartY(250);
                li3.setEndX(200);
                li3.setEndY(180);

                PathTransition tra3 = new PathTransition();
                tra3.setNode(bl2);
                tra3.setDuration(Duration.seconds(1));
                tra3.setPath(li3);

                FadeTransition fd3 = new FadeTransition(Duration.seconds(1), bl2);
                fd3.setFromValue(0.0);
                fd3.setToValue(1.0);
                p = new ParallelTransition(tra3, fd3);
                break;
        }

        return p;
    }

    public ParallelTransition closeTip(String nome){
        ParallelTransition p = null;
        switch (nome){
            case "hawking":
                Line li = new Line();
                li.setStartX(100);
                li.setStartY(50);
                li.setEndX(100);
                li.setEndY(100);

                PathTransition tra = new PathTransition();
                tra.setNode(imgHawking);
                tra.setDuration(Duration.seconds(1));
                tra.setPath(li);

                FadeTransition fd = new FadeTransition(Duration.seconds(1), imgHawking);
                fd.setFromValue(1.0);
                fd.setToValue(0.0);
                p = new ParallelTransition(tra, fd);
                break;
            case "neil":
                Line li1 = new Line();
                li1.setStartX(100);
                li1.setStartY(80);
                li1.setEndX(100);
                li1.setEndY(130);

                PathTransition tra1 = new PathTransition();
                tra1.setNode(imgNeil);
                tra1.setDuration(Duration.seconds(1));
                tra1.setPath(li1);

                FadeTransition fd1 = new FadeTransition(Duration.seconds(1), imgNeil);
                fd1.setFromValue(1.0);
                fd1.setToValue(0.0);
                p = new ParallelTransition(tra1, fd1);
                break;
            case "ba1":
                Line li2 = new Line();
                li2.setStartX(200);
                li2.setStartY(180);
                li2.setEndX(200);
                li2.setEndY(230);

                PathTransition tra2 = new PathTransition();
                tra2.setNode(bl1);
                tra2.setDuration(Duration.seconds(1));
                tra2.setPath(li2);

                FadeTransition fd2 = new FadeTransition(Duration.seconds(1), bl1);
                fd2.setFromValue(1.0);
                fd2.setToValue(0.0);
                p = new ParallelTransition(tra2, fd2);
                break;
            case "ba2":
                Line li3 = new Line();
                li3.setStartX(200);
                li3.setStartY(180);
                li3.setEndX(200);
                li3.setEndY(250);

                PathTransition tra3 = new PathTransition();
                tra3.setNode(bl2);
                tra3.setDuration(Duration.seconds(1));
                tra3.setPath(li3);

                FadeTransition fd3 = new FadeTransition(Duration.seconds(1), bl2);
                fd3.setFromValue(1.0);
                fd3.setToValue(0.0);
                p = new ParallelTransition(tra3, fd3);
                break;
        }
        return p;
    }

    public void mostraNome(String planet){ txtNomePlaneta.setText(planet); }

    public void limpaNomePlanet(){
        txtNomePlaneta.setText("");
    }

    private void iniciaJogo(JogadorModel jog){
        novoJogo = new JogoSistSolarController(jog);
        dNeil = loadTip("neil");
        dHawking = loadTip("hawking");
        bl1.setVisible(true);
        bl2.setVisible(true);
// dBalao1 = loadTip("ba1");
//        dBalao2 = loadTip("ba2");
        dNeil.play();
        dHawking.play();
//        dBalao1.play();
//        dBalao2.play();
        txHaw.setText("Olá, eu me chamo Stephen Hawking, para as dicas sumirem basta clicar em mim ou no Neil. Divirta-se!");
        txNeil.setText("Saudações! Pode me chamar de Neil, para conseguir dicas só precisa clicar em uma órbita. Bom jogo!");
        txHaw.setOpacity(1);
        txNeil.setOpacity(1);
    }

    /*public ImageView trocaImg(String planet){
        Image img;
        ImageView bl = new ImageView();
        switch (planet){
            case "merc":
                img = new Image(new File("Images/balao_dica_merc.png").toURI().toString());
                bl.setImage(img);
                break;
        }
        return bl;
    }*/
}