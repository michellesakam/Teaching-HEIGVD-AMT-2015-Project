package ch.heigvd.amt.gamification.services.processors;

import ch.heigvd.amt.gamification.dto.EventDTO;
import ch.heigvd.amt.gamification.model.Application;
import ch.heigvd.amt.gamification.model.EndUser;
import ch.heigvd.amt.gamification.model.Rule;
import ch.heigvd.amt.gamification.services.ApplicationsManagerLocal;
import ch.heigvd.amt.gamification.services.EndUsersManagerLocal;
import ch.heigvd.amt.gamification.services.RulesManagerLocal;
import ch.heigvd.amt.gamification.services.dao.GamificationDomainEntityNotFoundException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @michelle meguep
 */
@Stateless
public class EventsProcessor extends GamificationDTOProcessor implements EventsProcessorLocal {

    @EJB
    private ApplicationsManagerLocal applicationsManager;

    @EJB
    private EndUsersManagerLocal endUserManger;

    @EJB
    private RulesManagerLocal rulesManager;

    @Override
    public void processEvent(EventDTO event) throws GamificationDomainEntityNotFoundException {

        Application application = super.tryToRetrieveApplication(event.getApiKey());

        EndUser endUser = endUserManger.retrieveEndUser(application, event.getEndUserNumber());

        if (endUser == null) {
            endUser = new EndUser();
            endUser.setRegDate(event.getTimestamp());
            endUser.setUserID(event.getEndUserNumber());
            applicationsManager.assignApplicationToAnEndUser(application, endUser);
        }

        // Find the rules corresponding to the event type and application
        List<Rule> rules = rulesManager.findByEventTypeAndApplication(application, event.getType());

        for (Rule r : rules) {
            rulesManager.processRuleForAnEvent(event, r, endUser);
        }
    }

}
