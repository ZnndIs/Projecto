package Jogo.Perguntas;

import java.util.ArrayList;

public abstract class Pergunta implements metodos {

    protected String pergunta;

    protected  float pontos;

    public Pergunta(String pergunta,float pontos) {
        this.pergunta = pergunta;
        this.pontos=pontos;

    }


}
