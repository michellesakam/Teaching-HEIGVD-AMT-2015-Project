package ch.heigvd.amt.gamification.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 *
 * @author Raphaël Racine
 */
@Entity

public class Event extends AbstractDomainModelEntity<Long> {

    private String type;
    
    @ManyToOne
    private EndUser endUser;
    
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public EndUser getEndUser() {
        return endUser;
    }

    public void setEndUser(EndUser endUser) {
        this.endUser = endUser;
    }
    
    public 

}
