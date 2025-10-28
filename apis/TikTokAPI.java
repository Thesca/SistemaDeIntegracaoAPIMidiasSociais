package apis;

import java.util.List;

// API Adaptee 3: Focada em vídeo
public class TikTokAPI {
    public boolean auth(String clientId, String clientSecret) {
        System.out.println("TikTok: Autenticado com Client ID: " + clientId.substring(0, 5) + "...");
        return true;
    }
    
    public String uploadVideo(String videoPath, String description, List<String> hashtags) {
        System.out.printf("TikTok: Fazendo upload do vídeo '%s'. Descrição: %s. Hashtags: %s%n", 
            videoPath, description, hashtags);
        return "tt_video_id_" + (long) (Math.random() * 1000000);
    }

    public String getVideoData(String videoId) {
        return String.format("{ \"id\": \"%s\", \"plays\": 1500000, \"likes\": 300000, \"comments\": 5000 }", videoId);
    }
}