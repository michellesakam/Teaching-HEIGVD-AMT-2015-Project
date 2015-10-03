package ch.heigvd.amt.gamification.services;

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
    public void registerNewApplication(String email, String name, String description, ApiKey apiKey, boolean isEnable) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void editApplicationDetails(long id, String newName, String newDescription, ApiKey newApiKey, boolean isEnable) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<EndUser> endUsersOfApplication(long idApplication) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /*@Override
    public List<Application> findAll() {
        // TODO: replace dummy data with real data from DB
        return generateDummyData();
    }

    private List<Application> generateDummyData() {
        Application app1 = new Application("my first app", "enabled", "just for fun", null);
        Application app2 = new Application("my second app", "disable", "just a test", null);
        Application app3 = new Application("my third app", "enabled", "a test, again", null);
        List<Application> result = new LinkedList<>();
        result.add(app1);
        result.add(app2);
        result.add(app3);
        return result;
    }*/

}
