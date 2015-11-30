package ch.heigvd.amt.gamification.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 *
 * @author Raphaël Racine
 */
@Entity
@DiscriminatorValue("nbPoints")
public class ActionAwardPoints extends Action {    
    
    private long nbPoints;

    public long getNbPoints() {
        return nbPoints;
    }

    public void setNbPoints(long nbPoints) {
        this.nbPoints = nbPoints;
    } 
    
    @Override
    public String getType() {
        return "AwardPoints";
    }

    @Override
    public Object getValue() {
        return nbPoints;
    }
    
}
