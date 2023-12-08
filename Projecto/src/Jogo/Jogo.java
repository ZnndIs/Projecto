package Jogo;

import Jogo.Perguntas.*;
import Jogo.Perguntas.PerguntaLeitor;

import java.util.ArrayList;

import java.util.*;


public class Jogo {


    private String jogador;

    private int perguntaNumero;
    private int pontuacao;


    private ArrayList<ArrayList<Pergunta>> perguntas ;
    private int cat;


    public Jogo(String player){
        this.jogador=player;
        this.perguntaNumero = 0;
        this.pontuacao = 0 ;
        this.perguntas = new PerguntaLeitor().ler();


    }



    public String start(){
        return " Vamos jogar ao POO Trivia";
    }

    public Object[] Pergunta(){

        Random random = new Random();
        int rand = random.nextInt(3);
        String questao;
        String respCerta;
        Pergunta per;
        ArrayList<String> res;
        int rand2;
        int rand3;
        ArrayList <Pergunta> categoria;
        if (rand == 0){ // perguntas de ciencias
             categoria = perguntas.get(rand);
             rand2 = random.nextInt(categoria.size());
             per = categoria.get(rand2);
             questao = per.pergunta(perguntaNumero);
             res = per.respostas(perguntaNumero);
             respCerta = per.respostaCerta();
             categoria.remove(per);
             this.cat=rand;
        } else if (rand == 1){ // peruntas de Artes
             categoria = perguntas.get(rand);
             rand2 = random.nextInt(categoria.size());
            per = categoria.get(rand2);
             questao = per.pergunta(perguntaNumero);
             res = per.respostas(perguntaNumero);
             respCerta = categoria.get(rand2).respostaCerta();
             categoria.remove(per);
             this.cat=rand;
        } else{
            rand2 = random.nextInt(3);
            categoria = perguntas.get(rand + rand2); // 2 para pares , 3 para ski , 4 para swimming;
            this.cat = (rand+rand2);
            rand3 = random.nextInt(categoria.size());
            questao = categoria.get(rand3).pergunta(perguntaNumero);
            res = categoria.get(rand3).respostas(perguntaNumero);
            respCerta = categoria.get(rand3).respostaCerta();
            if(rand + rand2 != 2){
                per = categoria.get(rand3); // football tem indice 2 e a remocao é feita na chamada do metodo resposta
            }

        }
        perguntaNumero +=1;
        return new Object[]{questao,res,respCerta,};
    }

    public void aumentaPontos(float pont){ // pont sera tirado da funcao da pergunta
        if(cat ==0){ //para ciencias
            pontuacao += (pont+5);
        } else if (cat ==1){ // para artes

             pontuacao+= (pont+ 10);
        } else if (cat == 2) { // football
            pontuacao += pont+1 +3;

        } else if (cat ==3) {
            pontuacao += pont +10 + 3;
        } else if (cat==4) {
            pontuacao += (3+pont)*2;

        }
    }



    public String lista() {
        StringBuilder result = new StringBuilder();

        for (ArrayList<Pergunta> category : perguntas) {
            result.append("Category Size: ").append(category.size()).append("\n");
        }

        return result.toString();

    }





}
