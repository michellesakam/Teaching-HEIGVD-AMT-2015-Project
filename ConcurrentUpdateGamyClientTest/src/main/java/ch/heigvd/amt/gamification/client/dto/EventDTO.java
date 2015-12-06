package ch.heigvd.amt.gamification.client.dto;

import java.util.Date;
import java.util.HashMap;

/**
 *
 * @author Raphaël Racine
 */
public class EventDTO { 
    
    private String type;
    private String endUserNumber;
    private HashMap<String, Object> properties = new HashMap<>();
    private Date timestamp;

    public void setEndUserNumber(String endUserNumber) {
        this.endUserNumber = endUserNumber;
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

    public HashMap<String, Object> getProperties() {
        return properties;
    }

    public void setProperties(HashMap<String, Object> properties) {
        this.properties = properties;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
    
    public Object getProperty(String key) {
        return properties.get(key);
    }   
    
}
