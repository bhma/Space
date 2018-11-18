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
}
