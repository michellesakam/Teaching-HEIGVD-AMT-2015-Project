package ch.heigvd.amt.gamification.dto;

/**
 *
 * @author Raphaël Racine
 */
public class EventDTO {    
    private String type;
    private String apikey;
    private String noEndUser;

    public void setApikey(String apikey) {
        this.apikey = apikey;
    }

    public void setNoEndUser(String noEndUser) {
        this.noEndUser = noEndUser;
    }

    public String getApikey() {
        return apikey;
    }

    public String getNoEndUser() {
        return noEndUser;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }    
    
}
