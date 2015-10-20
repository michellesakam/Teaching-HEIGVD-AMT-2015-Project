package ch.heigvd.amt.gamification.model.entities;

import ch.heigvd.amt.gamification.model.entities.AbstractDomainModelEntity;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

/**
 * 
 * @author Raphaël Racine
 */
@Entity
public class Role extends AbstractDomainModelEntity<Long> {   
   
    private String roleName;

    public Role() {
    }

   @ManyToMany
   private List<Account> listAccount;
}
