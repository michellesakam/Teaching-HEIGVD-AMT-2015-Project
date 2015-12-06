package ch.heigvd.amt.gamification.dto;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Raphaël Racine
 */
public class EndUserDTO {
    
    private String endUserNumber;
    private String apikey;
    private long nbPoints;
    private List<BadgeDTO> badges = new LinkedList<>();

    public String getEndUserNumber() {
        return endUserNumber;
    }

    public void setEndUserNumber(String endUserNumber) {
        this.endUserNumber = endUserNumber;
    }

    public String getApikey() {
        return apikey;
    }

    public void setApikey(String apikey) {
        this.apikey = apikey;
    }

    public int getNbBadges() {
        return badges.size();
    }

    public long getNbPoints() {
        return nbPoints;
    }

    public void setNbPoints(long nbPoints) {
        this.nbPoints = nbPoints;
    }
    
    public List<BadgeDTO> getBadges(){
        return badges;
    }
    
}
