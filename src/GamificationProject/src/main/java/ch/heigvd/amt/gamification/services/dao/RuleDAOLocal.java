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
public interface RuleDAOLocal {
    public List<Rule> findByEventTypeAndApplication(Application application, String eventType);
}
