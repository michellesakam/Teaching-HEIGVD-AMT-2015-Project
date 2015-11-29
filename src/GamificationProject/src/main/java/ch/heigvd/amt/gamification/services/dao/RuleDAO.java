package ch.heigvd.amt.gamification.services.dao;

import ch.heigvd.amt.gamification.model.Application;
import ch.heigvd.amt.gamification.model.Rule;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author Raphaël Racine
 */
@Stateless
public class RuleDAO extends GenericDAO<Rule, Long> implements RuleDAOLocal {
    
    @Override
    public List<Rule> findByEventTypeAndApplication(Application application, String eventType) {
        return em.createNamedQuery("Rule.findByEventTypeAndApplication")
                .setParameter("application", application)
                .setParameter("eventType", eventType)
                .getResultList();
    }

}
