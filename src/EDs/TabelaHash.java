package EDs;

import Classes.Palavras;

import java.util.ArrayList;
import java.util.Iterator;


public class TabelaHash {
    private BST tabela[];
    private int nElementos;

    public TabelaHash(int capacidade) {
        this.tabela = (BST[]) new BST[capacidade];
        this.nElementos = 0;
    }

    private int hash(Palavras chave) {
        char primeiraLetra = Character.toLowerCase(chave.getPalavra().charAt(0));
        return primeiraLetra - 'a';
    }

    public BST get(Palavras chave) {
        int hash = hash(chave);
        return this.tabela[hash];
    }

    public void put(Palavras palavra) {
        int hash = hash(palavra);
        BST arvore = this.tabela[hash];

        if ( arvore == null){
            arvore = new BST();
            this.tabela[hash] = arvore;
            arvore.recursiveAdd(palavra);
            nElementos++;
        }
        else{

                Palavras existente =  arvore.recursiveSearch(palavra);
                if(existente == null){
                    arvore.recursiveAdd(palavra);
                }
                else{
                    existente.getOcorrencias().append(palavra.getOcorrencias().head.linha);

                }


        }
    }

    public void print(){
        for (BST bst : tabela) {
            if (bst != null) {
                bst.printBFS();
            }


        }
    }

    /*public Palavras remove(Palavras chave){
        int hash = hash(chave);
        BST arvores = this.tabela[hash];

        if(arvores == null) return null;

       int i = 0;

        while(i<nElementos){
            BST atual = arvores.get(i);
            if(atual.recursiveSearch(chave).getPalavra().charAt(0) == chave.getPalavra().charAt(0)){
                atual.remove(chave);
                return atual.recursiveSearch(chave);
            }
            i++;
        }
        return null;
    }
     */




//Fator de carha -> α = n/m
// n = número de elemento em cada lista e m o tamanho da tabelaa




}

