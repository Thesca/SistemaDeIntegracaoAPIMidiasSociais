package adapter;

import apis.TwitterAPI;
import model.Conteudo;
import model.Credenciais;
import model.RespostaEstatisticas;
import model.RespostaPublicacao;

// Adapter Concreto para o Twitter
public class TwitterAdapter implements ISocialMediaAdapter {
    private TwitterAPI api;

    public TwitterAdapter() {
        this.api = new TwitterAPI(); // Instancia o "Adaptee"
    }

    @Override
    public void autenticar(Credenciais creds) {
        api.login(creds.get("apiKey"), creds.get("apiSecret"));
    }

    @Override
    public RespostaPublicacao postar(Conteudo content) {
        // Adaptação: Twitter só aceita TEXTO
        if (content.getTipo() != Conteudo.TipoMidia.TEXTO) {
            return new RespostaPublicacao(false, null, null, "Twitter só aceita publicações de texto.");
        }
        
        try {
            long id = api.tweet(content.getTexto());
            String url = "https://twitter.com/user/status/" + id;
            return new RespostaPublicacao(true, String.valueOf(id), url, null);
        } catch (Exception e) {
            return new RespostaPublicacao(false, null, null, e.getMessage());
        }
    }

    @Override
    public RespostaEstatisticas obterEstatisticas(String postId) {
        String json = api.getTweetMetrics(Long.parseLong(postId));
        // Simulação de parsing de JSON
        int likes = 150;
        int retweets = 45;
        return new RespostaEstatisticas(likes, retweets, 0, 0, json);
    }
}