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
public class Point extends AbstractDomainModelEntity<Long> {
    @ManyToOne
    private EndUser endUser;   
    
    private String reason;    
    private int score;    
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateReception;

    public EndUser getEndUser() {
        return endUser;
    }

    public void setEndUser(EndUser endUser) {
        this.endUser = endUser;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Date getDateReception() {
        return dateReception;
    }

    public void setDateReception(Date dateReception) {
        this.dateReception = dateReception;
    }
    
    
}
