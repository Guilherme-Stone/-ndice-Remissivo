package EDs;

import Classes.Palavras;

import java.util.ArrayList;
import java.util.Iterator;


public class TabelaHash {
    private ArrayList<BST>[] tabela;
    private int capacidade;

    public TabelaHash(int capacidade) {
        this.tabela = (ArrayList<BST>[]) new ArrayList[capacidade];
        for (int i = 0; i < capacidade; i++) {
            this.tabela[i] = new ArrayList<>();
        }
    }

    private int hash(Palavras chave) {
        char primeiraLetra = Character.toLowerCase(chave.getPalavra().charAt(0));
        return primeiraLetra - 'a';
    }

    public Palavras get(Palavras chave) {
        int hash = hash(chave);
        ArrayList<BST> arvores = this.tabela[hash];

        if (arvores == null) return null;

        for (BST arvore : arvores) {
            Palavras buscada = new Palavras(chave.getPalavra());
            Palavras encontrada = arvore.recursiveSearch(buscada);
            if(encontrada != null) return encontrada;
        }
        return null;
    }

    public void put(Palavras chave, Palavras element) {
        int hash = hash(chave);
        ArrayList<BST> arvores = this.tabela[hash];

        if ( arvores == null){
            arvores = new ArrayList<>();
            this.tabela[hash] = arvores;
        }
        else{
            for(BST arvore: arvores){
                Palavras existentes =  arvore.recursiveSearch(element);
                if(element != null){
                    existentes.adiconaOcorencia(element.getOcorrencias().getLast());
                    return;
                }
            }


        }
    }

    public Palavras remove(Palavras chave){
        int hash = hash(chave);
        ArrayList<BST> arvores = this.tabela[hash];

        if(arvores == null) return null;

       int i = 0;

        while(i<capacidade){
            BST atual = arvores.get(i);
            if(atual.recursiveSearch(chave).getPalavra().charAt(0) == chave.getPalavra().charAt(0)){
                atual.remove(chave);
                return atual.recursiveSearch(chave);
            }
            i++;
        }
        return null;
    }




//Fator de carha -> α = n/m
// n = número de elemento em cada lista e m o tamanho da tabelaa




}

