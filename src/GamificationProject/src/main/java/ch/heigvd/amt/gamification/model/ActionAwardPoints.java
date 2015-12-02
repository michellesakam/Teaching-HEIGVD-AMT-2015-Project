package ch.heigvd.amt.gamification.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 *
 * @author Raphaël Racine
 */
@Entity
@DiscriminatorValue("nbPoints")
public class ActionAwardPoints extends Action<Integer> {    
    
    private int nbPoints;

    public long getNbPoints() {
        return nbPoints;
    }

    public void setNbPoints(int nbPoints) {
        this.nbPoints = nbPoints;
    } 
    
    @Override
    public String getType() {
        return "AwardPoints";
    }

    @Override
    public Integer getAwardValue() {
        return nbPoints;
    }
    
    
    
}
