package ch.heigvd.amt.gamification.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 *
 * @author Raphaël Racine
 */
@Entity
@DiscriminatorValue("badge")
public class ActionAwardBadge extends Action {    
    
    @ManyToOne
    private Badge badge;

    public Badge getBadge() {
        return badge;
    }

    public void setBadge(Badge badge) {
        this.badge = badge;
    }

    @Override
    public String getType() {
        return "AwardBadge";
    }

    @Override
    public Object getValue() {
        return badge.getId();
    }
    
}
