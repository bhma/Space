package Controller;

import Model.JogadorModel;

public class JogoConsteController {
    private JogadorModel jogador;
    private int pontos;

    public JogoConsteController(JogadorModel jogador) {
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

    public boolean verifConste(int c, String nomeConste){
        switch (c){
            case 9:
                if(nomeConste.equalsIgnoreCase("sargitário") == true){
                    this.setPontos(this.getPontos() + 10);
                    return true;
                }
                break;
            case 8:
                if(nomeConste.equalsIgnoreCase("câncer") == true){
                    this.setPontos(this.getPontos() + 10);
                    return true;
                }
                break;
            case 7:
                if(nomeConste.equalsIgnoreCase("cão menor") == true){
                    this.setPontos(this.getPontos() + 10);
                    return true;
                }
                break;
            case 6:
                if(nomeConste.equalsIgnoreCase("escorpião") == true){
                    this.setPontos(this.getPontos() + 10);
                    return true;
                }
                break;
            case 5:
                if(nomeConste.equalsIgnoreCase("touro") == true){
                    this.setPontos(this.getPontos() + 10);
                    return true;
                }
                break;
            case 4:
                if(nomeConste.equalsIgnoreCase("ursa menor") == true){
                    this.setPontos(this.getPontos() + 10);
                    return true;
                }
                break;
            case 3:
                if(nomeConste.equalsIgnoreCase("libra") == true){
                    this.setPontos(this.getPontos() + 10);
                    return true;
                }
                break;
            case 2:
                if(nomeConste.equalsIgnoreCase("gêmeos") == true){
                    this.setPontos(this.getPontos() + 10);
                    return true;
                }
                break;
            case 1:
                if(nomeConste.equalsIgnoreCase("draco") == true ||
                   nomeConste.equalsIgnoreCase("dragão") == true){
                    this.setPontos(this.getPontos() + 50);
                    return true;
                }
                break;
        }
        return false;
    }
}
