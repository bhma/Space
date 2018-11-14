package Controller;

import View.TelaSistSolar;
import javafx.animation.PathTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Ellipse;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TelaSistSolarController implements Initializable {
    @FXML private Button btVoltar;
    @FXML private Button btSub;
    @FXML private ImageView imgTerra;
    @FXML private ImageView imgVenus;
    @FXML private ImageView imgMerc;
    @FXML private ImageView imgUrano;
    @FXML private ImageView imgSatur;
    @FXML private ImageView imgJup;
    @FXML private ImageView imgMart;
    @FXML private ImageView imgNetu;
    @FXML private Text txtNomePlaneta;
    @FXML private Text txtAviso;
    @FXML private Text txtPont;
    @FXML private ImageView imgSun;
    @FXML private Ellipse eliUra;

    private JogoController novoJogol;

    private boolean vMerc = false, vVenus= false, vTerra= false, vMart= false,
                    vJup= false, vSat= false, vUra= false, vNetu= false;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        iniciaJogo(TelaNomeController.getNomeJogador());
        imgSun.setOnMouseEntered(event -> {
            txtAviso.setText("");
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
            mostraNome("Venus");
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
            this.novoJogol.verificaPosicao(imgMerc.getLayoutX(), imgMerc.getLayoutY(), "Merc");
            mostraPontos();
        });
        imgVenus.setOnMouseReleased(event -> {
            this.novoJogol.verificaPosicao(imgVenus.getLayoutX(), imgVenus.getLayoutY(), "Venus");
            mostraPontos();
        });
        imgTerra.setOnMouseReleased(event -> {
            this.novoJogol.verificaPosicao(imgTerra.getLayoutX(), imgTerra.getLayoutY(), "Terra");
            mostraPontos();
        });
        imgMart.setOnMouseReleased(event -> {
            this.novoJogol.verificaPosicao(imgMart.getLayoutX(), imgMart.getLayoutY(), "Mart");
            mostraPontos();
        });
        imgJup.setOnMouseReleased(event -> {
            this.novoJogol.verificaPosicao(imgJup.getLayoutX(), imgJup.getLayoutY(), "Jupt");
            mostraPontos();
        });
        imgSatur.setOnMouseReleased(event -> {
            this.novoJogol.verificaPosicao(imgSatur.getLayoutX(), imgSatur.getLayoutY(), "Satur");
            mostraPontos();
        });
        imgUrano.setOnMouseReleased(event -> {
            this.novoJogol.verificaPosicao(imgUrano.getLayoutX(), imgUrano.getLayoutY(), "Ura");
            mostraPontos();
        });
        imgNetu.setOnMouseReleased(event -> {
            this.novoJogol.verificaPosicao(imgNetu.getLayoutX(), imgNetu.getLayoutY(), "Netu");
            mostraPontos();
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
            if(this.novoJogol.verificaSubmit(imgMerc, imgVenus, imgTerra, imgMart,
                                             imgJup, imgSatur, imgUrano, imgNetu))
            {
                txtNomePlaneta.setText("Parabéns");
                orbitar("Merc").play();
                orbitar("Venus").play();
                orbitar("Terra").play();
                orbitar("Mart").play();
                orbitar("Jup").play();
                orbitar("Sat").play();
                orbitar("Ura").play();
                orbitar("Netu").play();
            }else{
                txtAviso.setText("Algum planeta esta fora de sua órbita!");
            }
        });
        eliUra.setOnMouseClicked(event -> {
            System.out.println("Cliquei na órbita de Urano!");
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
        txtPont.setText(Integer.toString(novoJogol.getPontos()));
    }

    public void mostraNome(String planet){ txtNomePlaneta.setText(planet); }

    public void limpaNomePlanet(){
        txtNomePlaneta.setText("");
    }

    private void iniciaJogo(String nome){
        novoJogol = new JogoController(nome);
    }
}
