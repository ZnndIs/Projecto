package Jogo.Perguntas;

import java.util.ArrayList;

public class Ciencias extends Pergunta{
    private String respostaCerta;
    private ArrayList<String> easy;
    private ArrayList<String> hard;

    public Ciencias(String pergunta, String respostaCerta,ArrayList<String> easy, ArrayList<String> hard,float pontos) {
        super(pergunta,pontos);
        this.respostaCerta= respostaCerta;
        this.easy=easy;
        this.hard =hard;
        easy.add(respostaCerta);
        hard.add(respostaCerta);


    }


    @Override
    public String pergunta(int parameter) {
        return pergunta;
    }

    @Override
    public String respostaEscolhida() {
        return null;
    }

    @Override
    public ArrayList<String> respostas(int parameter) {
        if (parameter>3){
        return hard;}else{
            return easy;
        }
    }



    @Override
    public String respostaCerta() {
        return respostaCerta;
    }

    @Override
    public float pontos() {
        return pontos;
    }


}
