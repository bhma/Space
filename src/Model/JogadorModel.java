package Model;

import java.io.Serializable;

public class JogadorModel implements Serializable, Comparable<JogadorModel>{
    private String nome;
    private int pontosSistSol;
    private int pontosAdvPla;
    private int pontosConste;
    private int pontosCaPla;
    private int total;

    public JogadorModel(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPontosSistSol() {
        return pontosSistSol;
    }

    public void setPontosSistSol(int pontosSistSol) {
        this.pontosSistSol = pontosSistSol;
    }

    public int getPontosAdvPla() {
        return pontosAdvPla;
    }

    public void setPontosAdvPla(int pontosAdvPla) {
        this.pontosAdvPla = pontosAdvPla;
    }

    public int getPontosConste() {
        return pontosConste;
    }

    public void setPontosConste(int pontosConste) {
        this.pontosConste = pontosConste;
    }

    public int getPontosCaPla() {
        return pontosCaPla;
    }

    public void setPontosCaPla(int pontosCaPla) {
        this.pontosCaPla = pontosCaPla;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal() {
        this.total = this.getPontosAdvPla() + this.getPontosCaPla() + this.getPontosConste() + this.getPontosSistSol();
    }

    @Override
    public String toString() {
        return "JogadorModel{" +
                "Nome = '" + nome + '\'' +
                ", pontosSistSol = " + pontosSistSol +
                ", pontosAdvPla = " + pontosAdvPla +
                ", pontosConste = " + pontosConste +
                ", pontosCaPla = " + pontosCaPla +
                ", total = " + total +
                '}';
    }
    @Override
    public int compareTo(JogadorModel o) {
        if(this.total < o.getTotal()){
            return 1;
        }else if(this.total > o.getTotal()){
            return -1;
        }
        return 0;
    }
}
