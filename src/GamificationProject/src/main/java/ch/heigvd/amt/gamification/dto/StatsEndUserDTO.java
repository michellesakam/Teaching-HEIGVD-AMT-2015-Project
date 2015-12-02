
package ch.heigvd.amt.gamification.dto;

/**
 *
 * @author michelle meguep
 */
public class StatsEndUserDTO {
    
    private String endUserNumber;
    private String apiKey;
    private int nbPoints;
    private int nbBadges;
    
    public StatsEndUserDTO(){};
    
    public String getEndUserNumber(){
        return endUserNumber;
    }
    public void setEndUserNumber(String endUserNumber){
        this.endUserNumber = endUserNumber;
    }
    public String getApiKey(){
        return apiKey;
    }
    public void setApikey(String apikey){
        this.apiKey = apikey;
    }
    public int getNbPoints(){
        return nbPoints;
    }
    public void setNbPoints(int nbpoints){
        this.nbPoints = nbpoints;
    }
    public int getNbBadges(){
        return nbBadges;
    }
    public void setNbBadges(int nbbadges){
        this.nbBadges = nbbadges;
    }
}
