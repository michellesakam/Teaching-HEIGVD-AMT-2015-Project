package ch.heigvd.amt.gamification.apirest;

import ch.heigvd.amt.gamification.dto.EventDTO;
import ch.heigvd.amt.gamification.model.Application;
import ch.heigvd.amt.gamification.model.EndUser;
import ch.heigvd.amt.gamification.services.ApplicationsManagerLocal;
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
    public void postEvent(EventDTO eventDTO) {

        Application application = 
                applicationsManager.retrieveApplicationByApikey(eventDTO.getApiKey());

        if (application == null) {
            throw new NotFoundException("This application does not exist!");
        }

        EndUser endUser = endUserManger.retrieveEndUser(eventDTO.getEndUserNumber());

        if (endUser != null) {
            if (!applicationsManager.checkEndUserUseAnApplication(application, endUser)) {
                throw new Error("This user does not use this application!");
            }
        } else {            
            endUser = new EndUser();
            endUser.setRegDate(eventDTO.getTimestamp());
            endUser.setUserID(eventDTO.getEndUserNumber());
            applicationsManager.assignApplicationToAnEndUser(application, endUser);
        }

        //appliquer les règles*/
        System.out.println("Application des règles");
        
    }

}
