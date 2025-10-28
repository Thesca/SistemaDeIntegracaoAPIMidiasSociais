package apis;

// API Adaptee 1: Focada em texto
public class TwitterAPI {
    public void login(String apiKey, String apiSecret) {
        System.out.println("Twitter: Autenticado com Chave de API: " + apiKey.substring(0, 5) + "...");
    }

    public long tweet(String text) {
        System.out.println("Twitter: Enviando tweet: " + text);
        return (long) (Math.random() * 1000000); // Retorna um ID de tweet simulado
    }
    
    public String getTweetMetrics(long id) {
        return String.format("{ \"tweet_id\": %d, \"likes\": 150, \"retweets\": 45 }", id);
    }
}