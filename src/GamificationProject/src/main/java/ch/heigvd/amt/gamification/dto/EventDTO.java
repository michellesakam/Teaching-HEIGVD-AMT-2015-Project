package ch.heigvd.amt.gamification.dto;

import java.util.Date;
import java.util.HashMap;

/**
 *
 * @author Raphaël Racine
 */
public class EventDTO { 
    private String type;
    private String apiKey;
    private String endUserNumber;
    private HashMap<String, Object> additionnalRuleActions;
    private Date timestamp;
    
    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public void setEndUserNumber(String endUserNumber) {
        this.endUserNumber = endUserNumber;
    }

    public String getApiKey() {
        return apiKey;
    }

    public String getEndUserNumber() {
        return endUserNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }    

    public HashMap<String, Object> getAdditionnalRuleActions() {
        return additionnalRuleActions;
    }

    public void setAdditionnalRuleActions(HashMap<String, Object> additionnalRuleActions) {
        this.additionnalRuleActions = additionnalRuleActions;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
    
    public Object getProperty(String key) {
        return additionnalRuleActions.get(key);
    }   
    
}
