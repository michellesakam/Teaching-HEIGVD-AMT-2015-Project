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
    
    private int nbPoints;

    public int getNbPoints() {
        return nbPoints;
    }

    public void setNbPoints(int nbPoints) {
        this.nbPoints = nbPoints;
    }   
    
}
