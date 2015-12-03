package ch.heigvd.amt.gamification.client.dto;

/**
 *
 * @author michelle meguep
 */
public class EndUserDTO {
    
    private String endUserNumber;
    private String apikey;
    private int nbBadges;
    private int nbPoints;

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
        return nbBadges;
    }

    public void setNbBadges(int nbBadges) {
        this.nbBadges = nbBadges;
    }

    public int getNbPoints() {
        return nbPoints;
    }

    public void setNbPoints(int nbPoints) {
        this.nbPoints = nbPoints;
    }
    
    
    
}
