package ch.heigvd.amt.gamification.rest.dto;

/**
 *
 * @author parfait But : Contient les Applications et les ascenseurs sur les
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

    // nom de l'application
    private String name;

    // description de l'application
    private String description;

    // l'application est-elle toujours disponible ?
    private boolean isEnable;

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     *
     * @return
     */
    public boolean getIsEnable() {
        return isIsEnable();
    }

    /**
     *
     * @param isEnable
     */
    public void setIsEnable(boolean isEnable) {
        this.isEnable = isEnable;
    }

    /**
     * @return the isEnable
     */
    public boolean isIsEnable() {
        return isEnable;
    }

}
