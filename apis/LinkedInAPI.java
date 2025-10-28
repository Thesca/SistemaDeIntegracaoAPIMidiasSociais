package apis;

// API Adaptee 2: Focada em "Artigos" (objetos complexos)
public class LinkedInAPI {
    // Classe interna específica do LinkedIn
    public static class LinkedInArticle {
        String title;
        String content;
        public LinkedInArticle(String title, String content) {
            this.title = title;
            this.content = content;
        }
    }

    public void authorize(String oauthToken) {
        System.out.println("LinkedIn: Autorizado com Token OAuth2: " + oauthToken.substring(0, 5) + "...");
    }

    public String sharePost(LinkedInArticle article) {
        System.out.println("LinkedIn: Publicando artigo: " + article.title);
        return "urn:li:share:" + (long) (Math.random() * 1000000); // Retorna um "URN" simulado
    }

    public String getPostAnalytics(String postUrn) {
        return String.format("{ \"urn\": \"%s\", \"views\": 1200, \"shares\": 15 }", postUrn);
    }
}