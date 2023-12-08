import java.util.ArrayList;
import Jogo.*;


public class Main {
    public static void main(String[] args) {
        Jogo jogo = new Jogo("Player1");
        System.out.println(jogo.lista());

        System.out.println("-----------------------------");

        for (int i = 0; i < 5; i++) {
            Object[] result = jogo.Pergunta();
            String questao = (String) result[0];
            ArrayList<String> res = (ArrayList<String>) result[1];
            String certa = (String) result[2];

            System.out.println("Question: " + questao);
            System.out.println("Answers: " + res);
            System.out.println( "Right answer: " + certa);

            System.out.println("------------------------");
        }
    }
}
//uso de get para so demais atrbs///validacoes , tratar exceptions