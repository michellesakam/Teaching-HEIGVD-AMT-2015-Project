package ch.heigvd.amt.gamification.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 
 * @author Raphaël Racine
 */
@Entity
public class EndUser extends AbstractDomainModelEntity<Long>  implements Serializable {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Long id;
   
   @ManyToOne
   private Application application;
    public EndUser() {
    } 
   private String  userID;
   
   @Temporal(TemporalType.TIMESTAMP)
   private Date regDate;

   public Long getId() {
      return id;
   }
   public void setId(Long id) {
      this.id = id;
   }
}
