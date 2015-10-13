package ch.heigvd.amt.gamification.services;

import ch.heigvd.amt.gamification.model.Account;
import ch.heigvd.amt.gamification.model.ApiKey;
import ch.heigvd.amt.gamification.model.Application;
import ch.heigvd.amt.gamification.model.EndUser;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Raphaël Racine
 */
@Stateless
public class ApplicationsManager implements ApplicationsManagerLocal {

    @PersistenceContext
    EntityManager em;
    
    @Override
    public long numberOfApplicationsManaged() {
        return em.createQuery("SELECT a FROM Application a")
                .getResultList().size();
    }

    @Override
    public void assignApplicationToAccount(Application app, Account acc) {       
        app.setAcount(acc);
        acc.getApps().add(app);
        
        ApiKey apikey = new ApiKey();
        apikey.setKey("salutmonami"); // TODO: Generer une clé aléatoire
        app.setApiKey(apikey);
        apikey.setApplication(app);
        
        em.persist(app); 
        em.flush();
    }

    @Override
     public void editApplicationDetails(Application application) {
         throw new UnsupportedOperationException("Not supported yet.");
     }

    @Override
    public List<EndUser> endUsersOfApplication(long idApplication) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
