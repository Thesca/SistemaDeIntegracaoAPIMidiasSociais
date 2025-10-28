package adapter;

import apis.TikTokAPI;
import model.Conteudo;
import model.Credenciais;
import model.RespostaEstatisticas;
import model.RespostaPublicacao;

// Adapter Concreto para o TikTok
public class TikTokAdapter implements ISocialMediaAdapter {
    private TikTokAPI api;

    public TikTokAdapter() {
        this.api = new TikTokAPI();
    }

    @Override
    public void autenticar(Credenciais creds) {
        api.auth(creds.get("clientId"), creds.get("clientSecret"));
    }

    @Override
    public RespostaPublicacao postar(Conteudo content) {
        // Adaptação: TikTok só aceita VÍDEO
        if (content.getTipo() != Conteudo.TipoMidia.VIDEO) {
            return new RespostaPublicacao(false, null, null, "TikTok só aceita publicações de vídeo.");
        }
        
        try {
            String id = api.uploadVideo(content.getMidiaPath(), content.getTexto(), content.getHashtags());
            String url = "https://tiktok.com/@user/video/" + id;
            return new RespostaPublicacao(true, id, url, null);
        } catch (Exception e) {
            return new RespostaPublicacao(false, null, null, e.getMessage());
        }
    }

    @Override
    public RespostaEstatisticas obterEstatisticas(String postId) {
        String json = api.getVideoData(postId);
        // Simulação de parsing
        int plays = 1500000;
        int likes = 300000;
        int comments = 5000;
        return new RespostaEstatisticas(likes, 0, comments, plays, json);
    }
}