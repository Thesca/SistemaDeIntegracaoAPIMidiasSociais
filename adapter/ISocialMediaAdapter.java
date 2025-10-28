package adapter;

import model.Conteudo;
import model.Credenciais;
import model.RespostaEstatisticas;
import model.RespostaPublicacao;

/**
 * Interface Alvo (Target)
 * Define a interface unificada que o cliente (GerenciadorMidiaSocial) usará.
 * Todas as APIs, por mais diferentes que sejam, serão "adaptadas" para esta interface.
 */
public interface ISocialMediaAdapter {
    void autenticar(Credenciais creds);
    RespostaPublicacao postar(Conteudo content);
    RespostaEstatisticas obterEstatisticas(String postId);
}