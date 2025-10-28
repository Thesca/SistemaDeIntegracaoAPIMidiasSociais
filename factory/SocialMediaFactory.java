package factory;

import adapter.ISocialMediaAdapter;
import adapter.LinkedInAdapter;
import adapter.TikTokAdapter;
import adapter.TwitterAdapter;

/**
 * Padrão Simple Factory
 * Encapsula a lógica de criação dos adapters.
 * O Gerenciador (cliente) não precisa saber as classes concretas dos adapters.
 */
public class SocialMediaFactory {
    
    public static ISocialMediaAdapter createAdapter(Plataforma plataforma) {
        switch (plataforma) {
            case TWITTER:
                return new TwitterAdapter();
            case LINKEDIN:
                return new LinkedInAdapter();
            case TIKTOK:
                return new TikTokAdapter();
            default:
                throw new IllegalArgumentException("Plataforma não suportada: " + plataforma);
        }
    }
}