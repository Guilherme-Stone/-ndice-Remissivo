package Classes;

import EDs.LinkedList;
import Interfaces.Metodos;

import java.text.Normalizer;


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


        return this.palavra.toLowerCase().compareToIgnoreCase(palavra.getPalavra());
    }


    @Override
    public boolean equalsNormalizado(Palavras palavra){
        return normalizar(this.palavra).equalsIgnoreCase(normalizar(palavra.getPalavra()));
    }

    // RETIRA S
    @Override
    public String normalizar(String palavra){

        String normalizada = Normalizer.normalize(palavra, Normalizer.Form.NFD);


        normalizada = normalizada.replaceAll("\\p{InCombiningDiacriticalMarks}+", "");

        if (normalizada.endsWith("oes"))
            return normalizarSup(normalizada,3) + "ão";
        if (normalizada.endsWith("aes"))
            return normalizarSup(normalizada, 3) + "ão";
        if (normalizada.endsWith("aos"))
            return normalizarSup(normalizada, 3) + "ão";
        if (normalizada.endsWith("ais"))
            return normalizarSup(normalizada, 3) + "al";
        if (normalizada.endsWith("eis"))
            return normalizarSup(normalizada, 3) + "el";
        if (normalizada.endsWith("ois"))
            return normalizarSup(normalizada, 3) + "ol";
        if (normalizada.endsWith("vam"))
            return normalizarSup(normalizada, 3) + "r";
        if (normalizada.endsWith("is"))
            return normalizarSup(normalizada, 2) + "il";
        if (normalizada.endsWith("es"))
            return normalizarSup(normalizada, 2);
        if (normalizada.endsWith("ns"))
            return normalizarSup(normalizada, 2) + "m";
        if (normalizada.endsWith("s") && normalizada.length() > 3)
            return normalizarSup(normalizada, 1);

        return normalizada;
    }

    @Override
    public String normalizarSup(String palavra, int tamanho){
        return palavra.substring(0, palavra.length() - tamanho);
    }
}
