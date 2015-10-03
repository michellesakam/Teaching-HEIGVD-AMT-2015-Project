package ch.heigvd.amt.gamification.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 * 
 * @author Raphaël Racine
 */
@Entity
public class Role implements Serializable {
   
   private String roleName;
   
   @Id   
   @GeneratedValue(strategy = GenerationType.AUTO)
   private long id;
   
   @ManyToMany
   private List<Account> listAccount;

   public long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }
}
