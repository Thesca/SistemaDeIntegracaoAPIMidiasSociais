package model;

// Resposta unificada para qualquer publicação
public class RespostaPublicacao {
    private boolean sucesso;
    private String postId;
    private String url;
    private String mensagemErro;

    public RespostaPublicacao(boolean sucesso, String postId, String url, String mensagemErro) {
        this.sucesso = sucesso;
        this.postId = postId;
        this.url = url;
        this.mensagemErro = mensagemErro;
    }

    public boolean isSucesso() { return sucesso; }

    @Override
    public String toString() {
        if (sucesso) {
            return String.format("[SUCESSO] ID: %s | URL: %s", postId, url);
        } else {
            return String.format("[FALHA] Erro: %s", mensagemErro);
        }
    }
}