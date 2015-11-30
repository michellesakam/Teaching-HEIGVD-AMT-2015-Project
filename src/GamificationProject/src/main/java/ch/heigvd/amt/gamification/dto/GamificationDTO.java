package ch.heigvd.amt.gamification.dto;

/**
 *
 * @author Raphaël Racine
 */
public abstract class GamificationDTO {
    
    private String apiKey;

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }   
    
}
