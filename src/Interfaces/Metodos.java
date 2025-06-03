package Interfaces;

import Classes.Palavras;

public interface Metodos {
    public boolean equalsNormalizado(Palavras palavra);
    public String normalizar();
    public String normalizarSup(String palavra, int tamanho);
}
