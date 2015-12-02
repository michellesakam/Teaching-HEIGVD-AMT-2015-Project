
package ch.heigvd.amt.gamification.client.dto;

/**
 *
 * @author michelle meguep
 */
public class LevelDTO {
    
    private String name;
    private String apikey;
    private int minimumPoints;
    
    public LevelDTO() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getApikey() {
        return apikey;
    }

    public void setApikey(String apikey) {
        this.apikey = apikey;
    }

    public int getMinimumPoints() {
        return minimumPoints;
    }

    public void setMinimumPoints(int minimumPoints) {
        this.minimumPoints = minimumPoints;
    }
    
    
    
}
