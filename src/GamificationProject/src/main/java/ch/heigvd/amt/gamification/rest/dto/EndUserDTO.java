package ch.heigvd.amt.gamification.rest.dto;

import java.util.Date;

/**
 *
 * @author parfait 
 * But : EndUser with getters and setters
 */
public class EndUserDTO {

    
    private String userID;

    private Date regDate;


    public String getUserID() {
        return userID;
    }


    public void setUserID(String userID) {
        this.userID = userID;
    }


    public Date getRegDate() {
        return regDate;
    }


    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }
}
