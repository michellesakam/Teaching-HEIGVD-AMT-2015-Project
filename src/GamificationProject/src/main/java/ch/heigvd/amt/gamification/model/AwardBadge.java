package ch.heigvd.amt.gamification.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 *
 * @author parfait
 */
@Entity
@DiscriminatorValue( "badge")
public class AwardBadge extends Award{  


    @ManyToOne
    private Badge badge; 

    /**
     * @return the badge
     */
    public Badge getBadge() {
        return badge;
    }

    /**
     * @param badge the badge to set
     */
    public void setBadge(Badge badge) {
        this.badge = badge;
    }
}
