package dao;

import Controller.MainController;
import Model.JogadorModel;
import View.TelaPontu;

import java.io.*;

public class DaoController {
    private static ObjectInputStream input;
    private static ObjectOutputStream output;

    public static void openToRead(String nomeArq){
        File arquivo = new File(nomeArq);
        if(arquivo.exists() == false){
            System.out.println("Arquivo nao existe!");
            return;
        }
        try {
            FileInputStream arq = new FileInputStream(nomeArq);
            input = new ObjectInputStream(arq);
            System.out.println("Arquivo criado com sucesso!");
        } catch (FileNotFoundException e) {
            System.err.println(e);
            System.err.println("Erro ao tentar abrir o arquivo para leitura!");
        } catch (IOException e) {
            System.err.println(e);
            System.err.println("Erro ao tentar abrir o arquivo para leitura!");
        }
    }

    public static void openToWrite(String nomeArq){
        File arquivo = new File(nomeArq);
        if(arquivo.exists() == false){
            try {
                FileOutputStream fOut = new FileOutputStream(nomeArq);
                output = new ObjectOutputStream(fOut);
                System.out.println("Arquivo aberto para escrita!");
            } catch (FileNotFoundException e) {
                System.err.println(e);
                System.err.println("Erro ao tentar abrir o arquivo para escrita!");
            } catch (IOException e) {
                System.err.println(e);
                System.err.println("Erro ao tentar abrir o arquivo para escrita!");
            }
        }else{
            try {
                FileOutputStream fOut = new FileOutputStream(nomeArq);
                output = new ObjectOutputStream(fOut);
                System.out.println("Arquivo aberto com sucesso para escrita!");
            } catch (FileNotFoundException e) {
                System.err.println(e);
                System.err.println("Erro ao tentar abrir o arquivo para escrita!");
            } catch (IOException e) {
                System.err.println(e);
                System.err.println("Erro ao tentar abrir o arquivo para escrita!");
            }

        }
    }

    public static void closeAfterRead(){
        if(input != null){
            try {
                input.close();
                input = null;
                System.out.println("Fechou com sucesso!");
            } catch (IOException e) {
                System.err.println(e);
                System.err.println("Erro ao fechar o arquivo!");
                System.exit(1);
            }
        }
    }

    public static void closeAfterWrite(){
        if(output != null){
            try {
                output.close();
                output = null;
                System.out.println("Fechou com sucesso!");
            } catch (IOException e) {
                System.err.println("ERRO AO FECHAR ARQUIVO!");
                System.exit(1);
            }
        }
    }

    public static void writeJogadores(JogadorModel jog){
        try {
            if(output != null){
                output.writeObject(jog);
                output.flush();
                System.out.println("Gravação efetuada com sucesso!");
            }
        }catch (IOException ioException){
            System.err.println("Error ao gravar jogador!");
            System.exit(1);
        }
    }
    public static void readJogadores(){
        JogadorModel jogador;
        if(input != null){
            try{
                while(true){
                    jogador = (JogadorModel) input.readObject();
                    MainController.getListaJogador().add(jogador);
                }
            } catch (EOFException eofEx){
                System.err.println(eofEx);
                System.out.println("Fim do arquivo na leitura!");
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}