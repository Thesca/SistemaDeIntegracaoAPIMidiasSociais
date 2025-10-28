package model;

// Resposta unificada para estatísticas
public class RespostaEstatisticas {
    private int curtidas;
    private int compartilhamentos;
    private int comentarios;
    private int visualizacoes;
    private String rawData; // Para dados brutos

    public RespostaEstatisticas(int c, int s, int k, int v, String raw) {
        this.curtidas = c;
        this.compartilhamentos = s;
        this.comentarios = k;
        this.visualizacoes = v;
        this.rawData = raw;
    }

    @Override
    public String toString() {
        return String.format("Estatísticas: [Curtidas %d] [Compartilhamentos %d] [Comentarios %d] [Visualizacoes %d]%n\tDados Brutos: %s",
            curtidas, compartilhamentos, comentarios, visualizacoes, rawData);
    }
}