package Jogo.Perguntas;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class PerguntaLeitor {

    private ArrayList<ArrayList<Pergunta>> per= new ArrayList<>();
    private ArrayList<Pergunta> football=new ArrayList<>();
    private ArrayList<Pergunta> ski = new ArrayList<>();
    private ArrayList<Pergunta> natacao=new ArrayList<>();
    private ArrayList<Pergunta> ciencias= new ArrayList<>();
    private ArrayList<Pergunta> artes= new ArrayList<>();

    public ArrayList<ArrayList<Pergunta>> ler() {
        try (Scanner scanner = new Scanner(new File("info.txt"))) {
            while (scanner.hasNextLine()) {
                Pergunta novaper;
                String line = scanner.nextLine();
                String[] parts = line.split(";");
                String tipo = parts[0];
                if (parts.length > 3) {
                    if (tipo.equalsIgnoreCase("Football")) {
                        int par = parts.length - 1;
                        novaper = new Football();
                        for (int i = 1; i < par; i += 2) {
                            ((Football) novaper).par(parts[i], Integer.parseInt(parts[i + 1]));
                        }
                        football.add(novaper);
                    } else if ((tipo.equalsIgnoreCase("ski")) && (parts.length==4)) {
                        String pergunta = parts[1];
                        boolean resposta = false;
                        if (parts[2].equalsIgnoreCase("false")) {
                            resposta = false;
                        } else if (parts[2].equalsIgnoreCase("true")) {
                            resposta = true;

                        }
                        float pontos = Float.parseFloat(parts[3]);
                        novaper = new Ski(pergunta, resposta, pontos);
                        ski.add(novaper);
                    } else if ((tipo.equalsIgnoreCase("natacao"))&& (parts.length == 4)) {
                        String pergunta = parts[1];
                        boolean resposta = false;
                        if (parts[2].equalsIgnoreCase("false")) {
                            resposta = false;
                        } else if (parts[2].equalsIgnoreCase("true")) {
                            resposta = true;

                        }
                        float pontos = Float.parseFloat(parts[3]);
                        novaper = new Natacao(pergunta, resposta, pontos);
                        natacao.add(novaper);

                    } else if ((tipo.equalsIgnoreCase("artes")) && (parts.length>=8)) {
                        String pergunta = parts[1];
                        String respostaCerta = parts[2];
                        ArrayList<String> respostas = new ArrayList<>();
                        for (int i = 3; i < parts.length - 1; i++) {
                            respostas.add(parts[i]);
                        }
                        float pontos = Float.parseFloat(parts[parts.length - 1]);

                        if(respostas.size()>=4){
                            novaper = new Artes(pergunta, respostaCerta, respostas, pontos);
                            artes.add(novaper);
                        }

                    } else if ((tipo.equalsIgnoreCase("ciencias")) &&(parts.length>=13)) {
                        ArrayList<String> facil = new ArrayList<>();
                        ArrayList<String> dificil = new ArrayList<>();
                        String pergunta = parts[1];
                        String respostacerta = parts[2];
                        int i = 4;
                        while (parts[i].compareTo("dificil") != 0) {
                            facil.add(parts[i]);
                            i += 1;
                        }
                        if (parts[i].equalsIgnoreCase("dificil")) {
                            i += 1;
                        }
                        while (i < parts.length - 1) {
                            dificil.add(parts[i]);
                            i += 1;
                        }
                        float pontos = Float.parseFloat(parts[parts.length - 1]);



                        if((facil.size()>=4) && (dificil.size()>=4)){
                            novaper = new Ciencias(pergunta, respostacerta, facil, dificil, pontos);
                            ciencias.add(novaper);
                        }

                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.err.println("File not found. Please check the file path.");
        }
        per.add(ciencias);
        per.add(artes);
        per.add(football);
        per.add(ski);
        per.add(natacao);

        return per;
    }
}
