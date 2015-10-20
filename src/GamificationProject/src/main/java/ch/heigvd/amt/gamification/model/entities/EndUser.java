package ch.heigvd.amt.gamification.model.entities;

import ch.heigvd.amt.gamification.model.entities.AbstractDomainModelEntity;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 
 * @author Raphaël Racine
 */
@Entity

@NamedQueries({
    @NamedQuery(name = "EndUser.findAllCreatedBetweenTwoDates", query = "SELECT e FROM EndUser e WHERE e.regDate BETWEEN :date1 AND :date2")
})

public class EndUser extends AbstractDomainModelEntity<Long> {
   
   @ManyToOne
   private Application application;
    public EndUser() {
    } 
   private String  userID;
   
   @Temporal(TemporalType.TIMESTAMP)
   private Date regDate;
}
