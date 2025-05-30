package Classes;

import EDs.LinkedList;
import Interfaces.Metodos;


public class Palavras implements Comparable<Palavras>, Metodos {
    private String palavra;
    private LinkedList ocorrencias;

    public Palavras(String palavra){
        this.palavra = palavra;
        this.ocorrencias = new LinkedList();
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


        return this.palavra.compareToIgnoreCase(palavra.getPalavra());
    }

    public boolean equalsNormalizado(Palavras palavra){
        return normalizar(this.palavra).equalsIgnoreCase(normalizar(palavra.getPalavra()));
    }

    public String normalizar(String palavra){
        if (palavra.endsWith("ões"))
            return normalizarSup(palavra,3) + "ão";
        if (palavra.endsWith("ães"))
            return normalizarSup(palavra, 3) + "ão";
        if (palavra.endsWith("ãos"))
            return normalizarSup(palavra, 3) + "ão";
        if (palavra.endsWith("ais"))
            return normalizarSup(palavra, 3) + "al";
        if (palavra.endsWith("eis"))
            return normalizarSup(palavra, 3) + "el";
        if (palavra.endsWith("ois"))
            return normalizarSup(palavra, 3) + "ol";
        if (palavra.endsWith("vam"))
            return normalizarSup(palavra, 3) + "r";
        if (palavra.endsWith("is"))
            return normalizarSup(palavra, 2) + "il";
        if (palavra.endsWith("es"))
            return normalizarSup(palavra, 2);
        if (palavra.endsWith("ns"))
            return normalizarSup(palavra, 2) + "m";
        if (palavra.endsWith("s") && palavra.length() > 3)
            return normalizarSup(palavra, 1);

        return palavra;
    }

    public String normalizarSup(String palavra, int tamanho){
        return palavra.substring(0, palavra.length() - tamanho);
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
