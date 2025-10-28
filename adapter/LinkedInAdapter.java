package adapter;

import apis.LinkedInAPI;
import model.Conteudo;
import model.Credenciais;
import model.RespostaEstatisticas;
import model.RespostaPublicacao;

// Adapter Concreto para o LinkedIn
public class LinkedInAdapter implements ISocialMediaAdapter {
    private LinkedInAPI api;

    public LinkedInAdapter() {
        this.api = new LinkedInAPI();
    }

    @Override
    public void autenticar(Credenciais creds) {
        api.authorize(creds.get("oauthToken"));
    }

    @Override
    public RespostaPublicacao postar(Conteudo content) {
        // Adaptação: Converte Conteudo em LinkedInArticle
        if (content.getTipo() != Conteudo.TipoMidia.ARTIGO && content.getTipo() != Conteudo.TipoMidia.TEXTO) {
            return new RespostaPublicacao(false, null, null, "LinkedIn (nesta simulação) só aceita Artigos ou Texto.");
        }
        
        try {
            // Adaptação de dados
            LinkedInAPI.LinkedInArticle article = new LinkedInAPI.LinkedInArticle("Post via Agendador", content.getTexto());
            
            String urn = api.sharePost(article);
            String url = "https://linkedin.com/feed/update/" + urn;
            return new RespostaPublicacao(true, urn, url, null);
        } catch (Exception e) {
            return new RespostaPublicacao(false, null, null, e.getMessage());
        }
    }

    @Override
    public RespostaEstatisticas obterEstatisticas(String postId) {
        String json = api.getPostAnalytics(postId);
        // Simulação de parsing
        int views = 1200;
        int shares = 15;
        return new RespostaEstatisticas(0, shares, 0, views, json);
    }
}