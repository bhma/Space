package Controller;

import Model.JogadorModel;
import javafx.scene.image.ImageView;

public class JogoSistSolarController {
    private JogadorModel jogador;
    private int pontos;

    private boolean vMerc = false, vVenus= false, vTerra= false, vMart= false,
            vJup= false, vSat= false, vUra= false, vNetu= false;
    private boolean eMerc = false, eVenus= false, eTerra= false, eMart= false,
            eJup= false, eSat= false, eUra= false, eNetu= false;

    public JogoSistSolarController(JogadorModel jogador) {
        this.jogador = jogador;
    }

    public JogadorModel getJogador() {
        return jogador;
    }

    public void setJogador(JogadorModel jogador) {
        this.jogador = jogador;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public void verificaPosicao(double x, double y, String planet){
        System.out.println(planet);
        switch (planet){
            case "Merc":
                if(x > 1000 && x <1100 && y > 420 && y < 640){
                    if(vMerc == false){
                        System.out.println("Está certo!!");
                        this.setPontos(this.getPontos() + 10);
                        vMerc = true;
                    }
                }else{
                    if(eMerc == false){
                        eMerc = true;
                        System.out.println("Está Errado!!");
                        if((this.getPontos() - 3) < 0){
                            this.setPontos(0);
                        }else{
                            this.setPontos(this.getPontos() - 3);
                        }
                    }
                }
                break;
            case "Venus":
                if(x > 1100 && x < 1200 && y > 420 && y < 670){
                    if(vVenus == false){
                        vVenus = true;
                        System.out.println("Está certo!!");
                        this.setPontos(this.getPontos() + 10);
                    }
                }else{
                    if(eVenus == false){
                        eVenus = true;
                        System.out.println("Está Errado!!");
                        if((this.getPontos() - 3) < 0){
                            this.setPontos(0);
                        }else{
                            this.setPontos(this.getPontos() - 3);
                        }
                    }
                }
                break;
            case "Terra":
                if(x > 1200 && x < 1300 && y > 400 && y < 680){
                    if(vTerra == false){
                        vTerra = true;
                        System.out.println("Está certo!!");
                        this.setPontos(this.getPontos() + 20);
                    }
                }else{
                    if(eTerra == false) {
                        eTerra = true;
                        System.out.println("Está Errado!!");
                        if ((this.getPontos() - 5) < 0) {
                            this.setPontos(0);
                        } else {
                            this.setPontos(this.getPontos() - 5);
                        }
                    }
                }
                break;
            case "Mart":
                if(x > 1300 && x < 1400 && y > 400 && y < 670){
                    if(vMart == false){
                        vMart = true;
                        System.out.println("Está certo!!");
                        this.setPontos(this.getPontos() + 10);
                    }
                }else{
                    if(eMart == false){
                        eTerra= true;
                        System.out.println("Está Errado!!");
                        if((this.getPontos() - 3) < 0){
                            this.setPontos(0);
                        }else{
                            this.setPontos(this.getPontos() - 3);
                        }
                    }
                }
                break;
            case "Jupt":
                if(x > 1400 && x < 1500 && y > 355 && y < 670){
                    if(vJup == false){
                        vJup = true;
                        System.out.println("Está certo!!");
                        this.setPontos(this.getPontos() + 15);
                    }
                }else{
                    if(eJup == false){
                        eJup = true;
                        System.out.println("Está Errado!!");
                        if((this.getPontos() - 5)< 0){
                            this.setPontos(0);
                        }else{
                            this.setPontos(this.getPontos() - 5);
                        }
                    }
                }
                break;
            case "Satur":
                if(x > 1500 && x < 1600 && y > 350 && y < 670){
                    if(vSat == false){
                        vSat = true;
                        System.out.println("Está certo!!");
                        this.setPontos(this.getPontos() + 15);
                    }
                }else{
                    if(eSat == false) {
                        eJup = true;
                        System.out.println("Está Errado!!");
                        if((this.getPontos() - 5)< 0){
                            this.setPontos(0);
                        }else{
                            this.setPontos(this.getPontos() - 5);
                        }
                    }
                }
                break;
            case "Ura":
                if(x > 1600 && x < 1760 && y > 315 && y < 670){
                    if(vUra == false){
                        vUra = true;
                        System.out.println("Está certo!!");
                        this.setPontos(this.getPontos() + 10);
                    }
                }else{
                    if(eUra == false){
                        eUra = true;
                        System.out.println("Está Errado!!");
                        if((this.getPontos() - 3)< 0){
                            this.setPontos(0);
                        }else{
                            this.setPontos(this.getPontos() - 3);
                        }
                    }
                }
                break;
            case "Netu":
                if(x > 1790 && x < 1900 && y > 315 && y < 670){
                    if(vNetu == false){
                        vNetu = true;
                        System.out.println("Está certo!!");
                        this.setPontos(this.getPontos() + 10);
                    }
                }else{
                    if(eNetu == false){
                        eNetu = true;
                        System.out.println("Está Errado!!");
                        if((this.getPontos() - 3)< 0){
                            this.setPontos(0);
                        }else{
                            this.setPontos(this.getPontos() - 3);
                        }
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
