package ch.heigvd.amt.gamification.rest.dto;

/**
 *
 * @author parfait
 */
public class ApplicationDTO {

    // id de l'application
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

// nom de l'application
    private String name;
 
    // description de l'application
    private String description;

    // l'application est-elle toujours disponible ?
    private boolean isEnable;

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

    public boolean getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(boolean isEnable) {
        this.isEnable = isEnable;
    }

}
