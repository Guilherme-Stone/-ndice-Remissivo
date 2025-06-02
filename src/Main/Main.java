package Main;

import Classes.Palavras;
import EDs.BST;
import EDs.TabelaHash;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        TabelaHash hash = new TabelaHash();

        BufferedReader br = null;
        FileWriter fw = null;

        File file = new File("txt1");

        String[] vetor;

        try {

            FileReader fileReader = new FileReader(file);

            br = new BufferedReader(fileReader);

            String linha;


            int i = 1;
            while ((linha = br.readLine()) != null) {
                vetor = linha.split("[,\\s.]+");
                for (String p : vetor) {
                    if (p != null) {
                        Palavras palavras = new Palavras(p);
                        palavras.getOcorrencias().append(i);
                        hash.put(palavras);
                    }
                }
                i++;
            }

            fw = new FileWriter("txt1");

            for (int j = 0; j < hash.getTabela().length; j++) {
                BST arv_aux = hash.getTabela()[j];
                if (arv_aux != null) {
                    arv_aux.WriteWords(fw);
                }
            }

        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("Falha ao achar arquivo");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) br.close();
                if (fw != null) fw.close();
            } catch (IOException e) {
                throw new RuntimeException("Falha ao fechar arquivo");
            }
        }
    }
}