import factory.Plataforma;
import java.util.List;
import model.Conteudo;
import model.Credenciais;

public class Main {
    public static void main(String[] args) {
        GerenciadorMidiaSocial gerenciador = new GerenciadorMidiaSocial();

        // 1. Configurar Credenciais
        Credenciais credsTwitter = new Credenciais();
        credsTwitter.set("apiKey", "TW_API_KEY_123");
        credsTwitter.set("apiSecret", "TW_SECRET_456");

        Credenciais credsLinkedIn = new Credenciais();
        credsLinkedIn.set("oauthToken", "LI_OAUTH_TOKEN_789");

        Credenciais credsTikTok = new Credenciais();
        credsTikTok.set("clientId", "TT_CLIENT_ID_ABC");
        credsTikTok.set("clientSecret", "TT_CLIENT_SECRET_DEF");

        // 2. Configurar Plataformas (Demonstração da Factory e Autenticação)
        gerenciador.configurarPlataforma(Plataforma.TWITTER, credsTwitter);
        gerenciador.configurarPlataforma(Plataforma.LINKEDIN, credsLinkedIn);
        gerenciador.configurarPlataforma(Plataforma.TIKTOK, credsTikTok);

        // 3. Criar e Publicar um Conteúdo de TEXTO
        // Deverá funcionar no Twitter e LinkedIn, mas falhar no TikTok.
        Conteudo postTexto = new Conteudo(
            "Olá mundo! Esta é uma postagem de texto unificada.",
            null,
            Conteudo.TipoMidia.TEXTO,
            null
        );
        gerenciador.publicarEmTudo(postTexto);
        
        // 4. Criar e Publicar um Conteúdo de VÍDEO
        // Deverá falhar no Twitter e LinkedIn, mas funcionar no TikTok.
        Conteudo postVideo = new Conteudo(
            "Confira meu novo vídeo de dança!",
            "/videos/danca_legal.mp4",
            Conteudo.TipoMidia.VIDEO,
            List.of("dance", "viral", "java")
        );
        gerenciador.publicarEmTudo(postVideo);

        // 5. Verificar Estatísticas (Demonstração da resposta unificada)
        // IDs fictícios
        gerenciador.verificarEstatisticas(Plataforma.TWITTER, "12345");
        gerenciador.verificarEstatisticas(Plataforma.LINKEDIN, "urn:li:share:67890");
        gerenciador.verificarEstatisticas(Plataforma.TIKTOK, "tt_video_id_999");
    }
}