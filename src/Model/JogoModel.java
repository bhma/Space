package Model;

import javafx.scene.image.ImageView;

public class JogoModel {
    private String jogador;
    private int id;
    private int pontos;
    private int qtdDicasUsadas;

    public JogoModel(String jogador) {
        this.jogador = jogador;
    }

    public String getJogador() {
        return jogador;
    }

    public void setJogador(String jogador) {
        this.jogador = jogador;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public int getQtdDicasUsadas() {
        return qtdDicasUsadas;
    }

    public void setQtdDicasUsadas(int qtdDicasUsadas) {
        this.qtdDicasUsadas = qtdDicasUsadas;
    }

    public void verificaPosicao(double x, double y, String planet){
        System.out.println(planet);
        switch (planet){
            case "Merc":
                if(x > 1000 && x <1100 && y > 420 && y < 640){
                    System.out.println("Está certo!!");
                    this.setPontos(this.getPontos() + 10);
                }else{
                    System.out.println("Está Errado!!");
                    if(this.getPontos() > 0){
                        this.setPontos(this.getPontos() - 3);
                    }
                }
                break;
            case "Venus":
                if(x > 1100 && x < 1200 && y > 420 && y < 670){
                    System.out.println("Está certo!!");
                    this.setPontos(this.getPontos() + 10);
                }else{
                    System.out.println("Está Errado!!");
                    if(this.getPontos() > 0){
                        this.setPontos(this.getPontos() - 3);
                    }
                }
                break;
            case "Terra":
                if(x > 1200 && x < 1300 && y > 400 && y < 680){
                    System.out.println("Está certo!!");
                    this.setPontos(this.getPontos() + 20);
                }else{
                    System.out.println("Está Errado!!");
                    if(this.getPontos() > 0){
                        this.setPontos(this.getPontos() - 5);
                    }
                }
                break;
            case "Mart":
                if(x > 1300 && x < 1400 && y > 400 && y < 670){
                    System.out.println("Está certo!!");
                    this.setPontos(this.getPontos() + 10);
                }else{
                    System.out.println("Está Errado!!");
                    if(this.getPontos() > 0){
                        this.setPontos(this.getPontos() - 3);
                    }
                }
                break;
            case "Jupt":
                if(x > 1400 && x < 1500 && y > 355 && y < 670){
                    System.out.println("Está certo!!");
                    this.setPontos(this.getPontos() + 15);
                }else{
                    System.out.println("Está Errado!!");
                    if(this.getPontos() > 0){
                        this.setPontos(this.getPontos() - 5);
                    }
                }
                break;
            case "Satur":
                if(x > 1500 && x < 1600 && y > 350 && y < 670){
                    System.out.println("Está certo!!");
                    this.setPontos(this.getPontos() + 15);
                }else{
                    System.out.println("Está Errado!!");
                    if(this.getPontos() > 0){
                        this.setPontos(this.getPontos() - 5);
                    }
                }
                break;
            case "Ura":
                if(x > 1600 && x < 1760 && y > 315 && y < 670){
                    System.out.println("Está certo!!");
                    this.setPontos(this.getPontos() + 10);
                }else{
                    System.out.println("Está Errado!!");
                    if(this.getPontos() > 0){
                        this.setPontos(this.getPontos() - 3);
                    }
                }
                break;
            case "Netu":
                if(x > 1790 && x < 1900 && y > 315 && y < 670){
                    System.out.println("Está certo!!");
                    this.setPontos(this.getPontos() + 10);
                }else{
                    System.out.println("Está Errado!!");
                    if(this.getPontos() > 0){
                        this.setPontos(this.getPontos() - 3);
                    }
                }
                break;
        }
    }

    public boolean verificaSubmit(ImageView imgMerc, ImageView imgVenus, ImageView imgTerra, ImageView imgMart,
                                  ImageView imgJup, ImageView imgSat, ImageView imgUra, ImageView imgNetu){
        if(imgMerc.getLayoutX() > 1000 && imgMerc.getLayoutX() <1100 && imgMerc.getLayoutY() > 420 && imgMerc.getLayoutY() < 640 &&
           imgVenus.getLayoutX() > 1100 && imgVenus.getLayoutX() < 1200 && imgVenus.getLayoutY() > 420 && imgVenus.getLayoutY() < 670 &&
           imgTerra.getLayoutX() > 1200 && imgTerra.getLayoutX() < 1300 && imgTerra.getLayoutY() > 400 && imgTerra.getLayoutY() < 680 &&
           imgMart.getLayoutX() > 1300 && imgMart.getLayoutX() < 1400 && imgMart.getLayoutY() > 400 && imgMart.getLayoutY() < 670 &&
           imgJup.getLayoutX() > 1400 && imgJup.getLayoutX() < 1500 && imgJup.getLayoutY() > 355 && imgJup.getLayoutY() < 670 &&
           imgSat.getLayoutX() > 1500 && imgSat.getLayoutX() < 1600 && imgSat.getLayoutY() > 350 && imgSat.getLayoutY() < 670 &&
           imgUra.getLayoutX() > 1600 && imgUra.getLayoutX() < 1760 && imgUra.getLayoutY() > 315 && imgUra.getLayoutY() < 670 &&
           imgNetu.getLayoutX() > 1790 && imgNetu.getLayoutX() < 1900 && imgNetu.getLayoutY() > 315 && imgNetu.getLayoutY() < 670){
            return true;
        }else{
            return false;
        }
    }
}
