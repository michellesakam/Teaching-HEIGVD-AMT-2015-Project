package ch.heigvd.amt.gamification.model;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Raphaël Racine
 */
public class Application implements Serializable {

    private String name;
    private String description;
    private ApiKey apiKey;
    private Account acount;
    private boolean isAnable;
    private List <EndUser> user;   

    public Application(String name, String description, ApiKey apiKey, Account acount, boolean isAnable) {
        this.name = name;
        this.description = description;
        this.apiKey = apiKey;
        this.acount = acount;
        this.isAnable = isAnable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ApiKey getApiKey() {
        return apiKey;
    }

    public void setApiKey(ApiKey apiKey) {
        this.apiKey = apiKey;
    }

    public Account getAcount() {
        return acount;
    }

    public void setAcount(Account acount) {
        this.acount = acount;
    }

    public boolean isIsAnable() {
        return isAnable;
    }

    public void setIsAnable(boolean isAnable) {
        this.isAnable = isAnable;
    }

    public List<EndUser> getUser() {
        return user;
    }

    public void setUser(List<EndUser> user) {
        this.user = user;
    }
    
    

}
