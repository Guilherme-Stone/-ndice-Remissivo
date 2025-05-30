import Classes.Palavras;
import EDs.BST;
import EDs.LinkedList;
import EDs.TabelaHash;

public class Main {
    public static void main(String[] args) {

        TabelaHash hash = new TabelaHash(26);
        String[] x = new String[7];

        x[0] = "O gato subiu no telhado quando começou a chover.";
        x[1] = "Mais tarde, os gatos apareceram perto da lareira.";
        x[2] = "A flor desabrochou no jardim ainda pela manhã. ";
        x[3] = "As flores coloridas atraíram muitas borboletas.";
        x[4] = "Ele colocou o livro sobre a mesa antes de sair.";
        x[5] = "Os livros antigos foram doados para a biblioteca.";
        x[6] = "Um pássaro pousou no parapeito da janela.";



        for (int i = 0; i<x.length; i++) {
            String[] palavras = x[i].split("[,\\s.]+");
            for (String palavra : palavras) {

                Palavras novaPalavra = new Palavras(palavra);
                novaPalavra.adiconaOcorencia(i + 1);
                hash.put(novaPalavra);

            }
        }

        hash.print();





    }
}