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

    /**
     * Process a rule for an event
     * @param eventDTO The eventDTO which contains the informations about the event
     * @param r The rule to apply on the event
     * @param endUser The endUser concerned
     */
    public void processRuleForAnEvent(EventDTO eventDTO, Rule r, EndUser endUser);

    /**
     * 
     * @param apiKey The apikey of the application
     * @return Find all of the rule where the apiKey of application is apiKey
     */
    public List<Rule> findByApiKey(String apiKey);

    /**
     * Assign a rule to an application
     *
     * @param application The concerned application (has to be managed)
     * @param rule The rule
     */
    public void assignRuleToAnApplication(Application application, Rule rule);
}
