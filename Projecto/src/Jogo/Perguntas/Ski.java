package Jogo.Perguntas;

import java.util.ArrayList;

public class Ski extends Desporto{
    private boolean respostaCerta;
    public Ski(String pergunta,boolean respostaCerta,float pontos) {
        super(pergunta,pontos);
        this.respostaCerta = respostaCerta;
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
        ArrayList<String> respostas = new ArrayList<>();
        respostas.add("Verdadeiro");
        respostas.add("Falso");
        return respostas;
    }

    @Override
    public String respostaCerta() {
        return Boolean.toString(respostaCerta);
    }

    @Override
    public float pontos() {
        return pontos;
    }



}
