package ch.heigvd.amt.gamification.rest.dto;

import java.util.Date;

/**
 *
 * @author parfait But : Contient les EndUser et les ascenseurs sur les champs.
 */
public class EndUserDTO {

    
    private String userID;

    private Date regDate;

    /**
     * 
     * @return 
     */
    public String getUserID() {
        return userID;
    }

    /**
     * 
     * @param userID 
     */
    public void setUserID(String userID) {
        this.userID = userID;
    }

    /**
     * 
     * @return 
     */
    public Date getRegDate() {
        return regDate;
    }

    /**
     * 
     * @param regDate 
     */
    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }
}
