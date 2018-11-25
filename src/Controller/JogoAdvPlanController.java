package Controller;

import Model.JogadorModel;

public class JogoAdvPlanController {
    private JogadorModel jogador;
    private int pontos;

    public JogoAdvPlanController(JogadorModel jogador) {
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

    public boolean verificaPlaneta(int pla, String nomePla){
        switch (pla){
            case 9:
                if(nomePla.equalsIgnoreCase("mercúrio") == true){
                    this.setPontos(this.getPontos() + 10);
                    return true;
                }
                break;
            case 8:
                if(nomePla.equalsIgnoreCase("vênus") == true){
                    this.setPontos(this.getPontos() + 10);
                    return true;
                }
                break;
            case 7:
                if(nomePla.equalsIgnoreCase("terra") == true){
                    this.setPontos(this.getPontos() + 10);
                    return true;
                }
                break;
            case 6:
                if(nomePla.equalsIgnoreCase("marte") == true){
                    this.setPontos(this.getPontos() + 10);
                    return true;
                }
                break;
            case 5:
                if(nomePla.equalsIgnoreCase("júpter") == true){
                    this.setPontos(this.getPontos() + 10);
                    return true;
                }
                break;
            case 4:
                if(nomePla.equalsIgnoreCase("saturno") == true){
                    this.setPontos(this.getPontos() + 10);
                    return true;
                }
                break;
            case 3:
                if(nomePla.equalsIgnoreCase("urano") == true){
                    this.setPontos(this.getPontos() + 10);
                    return true;
                }
                break;
            case 2:
                if(nomePla.equalsIgnoreCase("netuno") == true){
                    this.setPontos(this.getPontos() + 10);
                    return true;
                }
                break;
            case 1:
                if(nomePla.equalsIgnoreCase("plutão") == true){
                    this.setPontos(this.getPontos() + 20);
                    return true;
                }
                break;
        }
        return false;
    }
}
