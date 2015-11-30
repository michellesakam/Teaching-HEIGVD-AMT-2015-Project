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
         
    private long score;      
    
    public AwardPoint(){
 
    }
 
    public long getScore() {
        return score;
    }

    public void setScore(long score) {
        this.score = score;
    }
  
}
