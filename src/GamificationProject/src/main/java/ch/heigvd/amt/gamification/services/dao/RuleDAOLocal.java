package ch.heigvd.amt.gamification.services.dao;

import ch.heigvd.amt.gamification.model.Application;
import ch.heigvd.amt.gamification.model.Rule;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Raphaël Racine
 */
@Local
public interface RuleDAOLocal extends IGenericDAO<Rule, Long> {
    public List<Rule> findByEventTypeAndApplication(Application application, String eventType);
    public List<Rule> findByApiKey(String apiKey);
    public void assignRuleToAnApplication(Application application, Rule rule);
}
