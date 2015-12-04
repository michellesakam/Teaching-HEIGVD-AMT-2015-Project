package ch.heigvd.amt.gamification.services.processors;

import ch.heigvd.amt.gamification.dto.EventDTO;
import ch.heigvd.amt.gamification.model.Application;
import ch.heigvd.amt.gamification.model.EndUser;
import ch.heigvd.amt.gamification.model.Rule;
import ch.heigvd.amt.gamification.services.ApplicationsManagerLocal;
import ch.heigvd.amt.gamification.services.EndUsersManagerLocal;
import ch.heigvd.amt.gamification.services.RulesManagerLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @michelle meguep
 */
@Stateless
public class EventsProcessor extends GamificationDTOProcessor<EventDTO, Long>
        implements EventsProcessorLocal {

    @EJB
    private ApplicationsManagerLocal applicationsManager;

    @EJB
    private EndUsersManagerLocal endUserManger;

    @EJB
    private RulesManagerLocal rulesManager;

    @Override
    public void postDTO(String apiKey, EventDTO dto) {
        Application application = super.tryToRetrieveApplication(apiKey);

        EndUser endUser = endUserManger.retrieveEndUser(application, dto.getEndUserNumber());

        if (endUser == null) {
            endUser = new EndUser();
            endUser.setRegDate(dto.getTimestamp());
            endUser.setUserID(dto.getEndUserNumber());
            applicationsManager.assignApplicationToAnEndUser(application, endUser);
        }

        // Find the rules corresponding to the event type and application
        List<Rule> rules = rulesManager.findByEventTypeAndApplication(application, dto.getType());

        for (Rule r : rules) {
            rulesManager.processRuleForAnEvent(dto, r, endUser);
        }
    }

    @Override
    public void putDTO(String apiKey, Long id, EventDTO dto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteDTO(Long id, String apiKey) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
