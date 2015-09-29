package ch.heigvd.amt.gamification.model;

import java.util.List;

/**
 *
 * @author Raphaël Racine
 */
public class Application {

    private String name;
    private String state;
    private String description;
    private ApiKey apiKey;
    private long numberOfUsers;
    private Account acount;
    private boolean isAnable;
    private List <EndUser> user;
    
    

    public Application(String name, String state, String description, ApiKey apiKey) {
        this.name = name;
        this.state = state;
        this.description = description;
        this.apiKey = apiKey;
    }

    public String getName() {
        return name;
    }

    public String getState() {
        return state;
    }

    public String getDescription() {
        return description;
    }

    public ApiKey getApiKey() {
        return apiKey;
    }

    public long getNumberOfUsers() {
        return numberOfUsers;
    }

}
