package ch.heigvd.amt.gamification.services.dao;

import ch.heigvd.amt.gamification.model.Application;
import ch.heigvd.amt.gamification.model.Rule;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Raphaël Racine
 */
@Stateless
public class RuleDAO implements RuleDAOLocal {

    @PersistenceContext
    private EntityManager em;
    
    @Override
    public List<Rule> findByEventTypeAndApplication(Application application, String eventType) {
        return em.createNamedQuery("Rule.findByEventTypeAndApplication")
                .setParameter("application", application)
                .setParameter("eventType", eventType)
                .getResultList();
    }

}
