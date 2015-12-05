package ch.heigvd.amt.gamification.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author michelle meguep
 */

@Entity
@DiscriminatorValue( "score")

@NamedQueries({
    @NamedQuery(name = "AwardPoint.getNumberOfPoints", 
            query = "SELECT SUM(aw.score) FROM AwardPoint aw "
                    + "WHERE aw.endUser = :endUser AND aw.endUser.application = :application")
})
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
