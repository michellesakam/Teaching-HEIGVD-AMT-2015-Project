package ch.heigvd.amt.gamification.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 *
 * @author parfait
 */
@Entity
@DiscriminatorValue( "badge")
public class AwardBadge extends Award{  
    // contient le lien vers l'image qui contient le badge
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
