package ch.heigvd.amt.gamification.services;

import ch.heigvd.amt.gamification.model.Application;
import ch.heigvd.amt.gamification.model.Rule;
import ch.heigvd.amt.gamification.services.dao.RuleDAOLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Raphaël Racine
 */
@Stateless
public class RulesManager implements RulesManagerLocal {

    @EJB
    private RuleDAOLocal ruleDAO;
    
    @Override
    public List<Rule> findByEventTypeAndApplication(Application application, String eventType) {
        return ruleDAO.findByEventTypeAndApplication(application, eventType);
    }
    
}
