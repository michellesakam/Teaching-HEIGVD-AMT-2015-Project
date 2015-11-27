package ch.heigvd.amt.gamification.services;

import ch.heigvd.amt.gamification.dto.EventDTO;
import ch.heigvd.amt.gamification.model.Application;
import ch.heigvd.amt.gamification.model.EndUser;
import ch.heigvd.amt.gamification.services.dao.GamificationDomainEntityNotFoundException;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;

/**
 *
 * @michelle meguep
 */
@Stateless
public class EventsProcessor implements EventsProcessorLocal {

    @EJB
    private ApplicationsManagerLocal applicationsManager;

    @EJB
    private EndUsersManagerLocal endUserManger;

    @POST
    @Consumes("application/json")

    @Override
    public void processEvent(EventDTO event) throws GamificationDomainEntityNotFoundException {

        Application application
                = applicationsManager.retrieveApplicationByApikey(event.getApiKey());

        if (application == null) {
            throw new NotFoundException("This application does not exist!");
        }

        EndUser endUser = endUserManger.retrieveEndUser(application, event.getEndUserNumber());

        if (endUser == null) {
            endUser = new EndUser();
            endUser.setRegDate(event.getTimestamp());
            endUser.setUserID(event.getEndUserNumber());
            applicationsManager.assignApplicationToAnEndUser(application, endUser);
        }

        //appliquer les règles*/
        System.out.println("Application des règles");
    }

}
