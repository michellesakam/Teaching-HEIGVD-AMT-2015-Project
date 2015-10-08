package ch.heigvd.amt.gamification.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 * 
 * @author Raphaël Racine
 */
@Entity
@NamedQueries({
  // Selectionner un Role si on connait son ID
  @NamedQuery(name = "Role.findById", query = "SELECT r FROM Role r WHERE r.id = :id"),

  // Selectionner tous les roles de la database. 
  @NamedQuery(name = "Role.findAllRoles", query = "SELECT r FROM Role")  
})

public class Role implements Serializable {   
   private String roleName;   
   @Id   
   @GeneratedValue(strategy = GenerationType.AUTO)
   private long id;

    public Role() {
    }

   @ManyToMany
   private List<Account> listAccount;

   public long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }
}
