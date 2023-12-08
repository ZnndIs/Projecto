package Jogo.Perguntas;

import java.util.ArrayList;
import java.util.Random;

public class Football extends Desporto{
    private static ArrayList<String> camisolas;
    private static ArrayList<String> nomeDeJogador;

    private  int ind ;
    private String nome;
    private int camisola;
    private int perguntaType;
    private String respostacerta;

    public void par(String nome, int camisola) {
        this.nome = nome;
        this.camisola=camisola;
        camisolas.add(String.valueOf(camisola));
        nomeDeJogador.add(nome);
        parCerto.add(new ParJogadorCamisola(nome,camisola));
    }


    private static class ParJogadorCamisola{
        private String nome;
        private int numero;

        public ParJogadorCamisola(String nome, int camisola) {
            this.nome=nome;
            this.numero = camisola;
        }


    }

    private static ArrayList<ParJogadorCamisola> parCerto;

    static {

        camisolas = new ArrayList<>();
        nomeDeJogador = new ArrayList<>();
        parCerto = new ArrayList<>();

    }



    public Football() {
        super("Match the Player and Shirt number",5);
    }





    public String getCamisola(){
        return String.valueOf(camisola);
    }

    public String getNome(){
        return nome;
    }

    @Override
    public String pergunta(int parameter) {
        this.perguntaType = parameter;
        Random random = new Random();
        this.ind = random.nextInt(camisolas.size());//ind é indice

        if (perguntaType < 3) {
            this.respostacerta = nomeDeJogador.get(ind);
            return "Qual é o jogador que usa a camisola " + camisolas.get(ind) + " ?";
        } else {
            this.respostacerta = camisolas.get(ind);
            return "Qual é o numero da camisola do " + nomeDeJogador.get(ind) + " ?";
        }
    }

    @Override
    public String respostaEscolhida() {
        return "";
    }



    @Override
    public ArrayList<String> respostas(int Parameter) {
        ArrayList<String> resp = new ArrayList<>();
        ArrayList<String>aux = new ArrayList<>();
        resp.add(respostaCerta());
        Random random = new Random();
        if(perguntaType<3){
            aux = new ArrayList<>(nomeDeJogador);
            aux.remove(respostaCerta());
            int rand = random.nextInt(aux.size());
            resp.add(aux.get(rand));
        }
        else {
            aux = new ArrayList<>(camisolas);
            aux.remove(respostaCerta());
            int rand = random.nextInt(aux.size());
            resp.add(aux.get(rand));

        }
        return resp;
    }

    @Override
    public String respostaCerta() {
        return respostacerta;
    }


    @Override
    public float pontos() {
        return pontos;
    }
}
