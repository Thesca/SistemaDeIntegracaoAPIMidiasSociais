package model;

import java.util.List;

public class Conteudo {
    private String texto;
    private String midiaPath; // Caminho para imagem ou vídeo
    private TipoMidia tipo;
    private List<String> hashtags;

    public enum TipoMidia { TEXTO, IMAGEM, VIDEO, ARTIGO }

    public Conteudo(String texto, String midiaPath, TipoMidia tipo, List<String> hashtags) {
        this.texto = texto;
        this.midiaPath = midiaPath;
        this.tipo = tipo;
        this.hashtags = hashtags;
    }
    
    // Getters
    public String getTexto() { return texto; }
    public String getMidiaPath() { return midiaPath; }
    public TipoMidia getTipo() { return tipo; }
    public List<String> getHashtags() { return hashtags; }
}