package ch.heigvd.amt.gamification.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Raphaël Racine
 */

@Entity
public class AwardPoint extends Award{
  
     
    private int score;    
    
 
    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

  
    
}
