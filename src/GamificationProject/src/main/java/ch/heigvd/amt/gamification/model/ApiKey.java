package ch.heigvd.amt.gamification.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * 
 * @author Raphaël Racine
 */
@Entity
public class ApiKey implements Serializable {
   
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Long id;
   
   @OneToOne
    private Application appl;
   
    private String key;

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }
   
   public Long getUsers(){
       return 0l;
   }
}
