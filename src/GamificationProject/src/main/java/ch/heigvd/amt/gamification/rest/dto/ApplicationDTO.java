package ch.heigvd.amt.gamification.rest.dto;

/**
 *
 * @author parfait 
 * But : Contient les Applications et les ascenseurs sur les
 * champs.
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

    private String name;

    private String description;

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
        return isIsEnable();
    }


    public void setIsEnable(boolean isEnable) {
        this.isEnable = isEnable;
    }


    public boolean isIsEnable() {
        return isEnable;
    }

}
