package Jogo.Perguntas;

import java.util.ArrayList;
import java.util.Random;

public class Artes extends Pergunta{

    private ArrayList<String>respostas;
    private String respostaCerta;
    public Artes(String pergunta,String respostaCerta,ArrayList<String> respostas,float pontos) {
        super(pergunta,pontos);
        this.respostas = respostas;
        this.respostaCerta = respostaCerta;
        respostas.add(respostaCerta);
    }


    @Override
    public String pergunta( int parametro) {
        return pergunta;
    }

    @Override
    public String respostaEscolhida() {
        return null;
    }

    @Override
    public ArrayList<String> respostas(int parameter) {
        ArrayList<String> sub = new ArrayList<>();
        ArrayList<String> aux = new ArrayList<>();
        Random random = new Random();
        if (parameter<3){
            sub.add(respostaCerta());
            aux = new ArrayList<>(respostas);
            aux.remove(respostaCerta());
            for(int i= 0 ; i<2 ; i++){
                int index = random.nextInt(aux.size());
                sub.add(aux.get(index));
                aux.remove(aux.get(index));
            }
            return sub;


        }else {return respostas;}



    }


    @Override
    public String respostaCerta() {
        return respostaCerta ;
    }

    @Override
    public float pontos() {
        return pontos;
    }
}
