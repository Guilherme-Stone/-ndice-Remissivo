package Classes;

import EDs.LinkedList;
import Interfaces.Metodos;


public class Palavras implements Comparable<Palavras>, Metodos {
    private String palavra;
    private LinkedList ocorrencias;

    public Palavras(String palavra){
        this.palavra = palavra;
    }

    public String getPalavra() {
        return palavra;
    }

    public LinkedList getOcorrencias() {
        return ocorrencias;
    }

    public void adiconaOcorencia(int linha){
        ocorrencias.append(linha);
    }

    @Override
    public int compareTo(Palavras palavra) {
        return this.palavra.compareTo(palavra.getPalavra());
    }

    @Override
    public String ignoraS(String palavra) {
        return "";
    }

    @Override
    public String ignoraAcento(String palavra) {
        return "";
    }
}
