package ch.heigvd.amt.gamification.dto;

/**
 *
 * @author Samira
 */
public class BadgeDTO {
    
    private Long id;
    private String name;
    private String apiKey; 

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

   
    
    
}
