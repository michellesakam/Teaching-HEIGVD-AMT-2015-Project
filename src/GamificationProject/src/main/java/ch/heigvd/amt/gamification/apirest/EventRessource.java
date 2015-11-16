package ch.heigvd.amt.gamification.apirest;

import ch.heigvd.amt.gamification.dto.EventDTO;
import ch.heigvd.amt.gamification.model.Application;
import ch.heigvd.amt.gamification.model.EndUser;
import ch.heigvd.amt.gamification.services.ApplicationsManagerLocal;
import ch.heigvd.amt.gamification.services.EndUsersManager;
import ch.heigvd.amt.gamification.services.EndUsersManagerLocal;
import ch.heigvd.amt.gamification.services.EventsManagerLocal;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

/**
 *
 * @author Raphaël Racine
 */
@Stateless
@Path("events")
public class EventRessource {

    @EJB
    private ApplicationsManagerLocal applicationsManager;

    @EJB
    private EventsManagerLocal eventsManager;

    @EJB
    private EndUsersManagerLocal endUserManger;

    @POST
    @Consumes("application/json")
    public void postEvent(EventDTO event) {
        Application application = applicationsManager.retriveApplicationByApikey(event.getApikey());
        EndUser endUser = endUserManger.retrieveEndUser(event.getNoEndUser());

        if (application == null) {
            throw new NotFoundException("This application does not exist!");
        } else {
            if (endUser != null) {
                if (!applicationsManager.checkEndUserUseAnApplication(application, endUser)) {
                    throw new Error("This user does not use this application!");
                }

            } else {
                applicationsManager.assignApplicationToAnEndUser(application, endUser);
            }

            //appliquer les règles
        }

    }

}
