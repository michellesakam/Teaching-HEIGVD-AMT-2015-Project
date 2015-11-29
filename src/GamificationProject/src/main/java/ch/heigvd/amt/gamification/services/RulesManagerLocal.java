package ch.heigvd.amt.gamification.services;

import ch.heigvd.amt.gamification.dto.EventDTO;
import ch.heigvd.amt.gamification.model.Application;
import ch.heigvd.amt.gamification.model.EndUser;
import ch.heigvd.amt.gamification.model.Rule;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Raphaël Racine
 */
@Local
public interface RulesManagerLocal {
    public List<Rule> findByEventTypeAndApplication(Application application, String eventType);
    public void processRuleForAnEvent(EventDTO eventDTO, Rule r, EndUser endUser);
}
