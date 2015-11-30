package ch.heigvd.amt.gamification.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 *
 * @author michelle meguep
 */

@Entity
@DiscriminatorValue( "score")
public class AwardPoint extends Award{
         
    private int score;      
    
    public AwardPoint(){
 
    }
 
    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
  
}
