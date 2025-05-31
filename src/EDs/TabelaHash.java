package EDs;

import Classes.Palavras;

import java.util.ArrayList;



public class TabelaHash {
    private BST[] tabela;
    private final int capacidade = 26;
    private int numElementos;

    public TabelaHash() {
        this.tabela = new BST[capacidade];
    }

    private int hash(Palavras chave) {
        char primeiraLetra = Character.toLowerCase(chave.getPalavra().charAt(0));
        return primeiraLetra - 'a';
    }

    public Palavras get(Palavras element) {
        int hash = hash(element);


        if  (hash >= 0 && hash< tabela.length && tabela[hash] != null) {
            BST arvoreIndice = this.tabela[hash];
            return arvoreIndice.recursiveSearch(element);

        }
       return null;
    }

    public void put(Palavras element) {
        int hash = hash(element);


        if (this.tabela[hash] == null){
            this.tabela[hash] = new BST();
        }

        BST arvoreIndice = this.tabela[hash];

        Palavras existente = arvoreIndice.recursiveSearch(element);

        if(existente == null){
            arvoreIndice.recursiveAdd(element);
            numElementos++;
        }else {
            if (existente.getOcorrencias() != null || !element.getOcorrencias().isEmpty()) {
                existente.adiconaOcorencia(element.getOcorrencias().getLast());
            }
        }
    }

    public Palavras remove(Palavras element){
        int hash = hash(element);


        if  (hash<0|| hash>= tabela.length|| tabela[hash] == null) return null;

        Palavras palavraRemovida = tabela[hash].remove(element);

        if(palavraRemovida!=null){
            return palavraRemovida;
        }else{
            return null;
        }
}




//Fator de carha -> α = n/m
// n = número de elemento em cada lista e m o tamanho da tabelaa




}

