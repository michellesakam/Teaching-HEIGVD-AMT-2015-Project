package ch.heigvd.amt.gamification.rest.dto;

/**
 *
 * @author parfait
 * But : contient les Roles et les ascenseurs.
 */
public class RoleDTO {
    private String roleName;  

    /**
     * @return the roleName
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * @param roleName the roleName to set
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
