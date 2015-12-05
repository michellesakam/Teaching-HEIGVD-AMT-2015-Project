package ch.heigvd.amt.gamification.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author parfait
 */
@Entity
@DiscriminatorValue( "badge")

@NamedQueries({
    @NamedQuery(name = "AwardBadge.findByEndUserAndApplication", 
            query = "SELECT ab FROM AwardBadge ab WHERE ab.endUser = :endUser AND ab.endUser.application = :application "),
})
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
