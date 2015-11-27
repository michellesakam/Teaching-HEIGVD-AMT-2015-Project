package ch.heigvd.amt.gamification.apirest;

import ch.heigvd.amt.gamification.dto.EventDTO;
import ch.heigvd.amt.gamification.model.Application;
import ch.heigvd.amt.gamification.model.EndUser;
import ch.heigvd.amt.gamification.services.ApplicationsManagerLocal;
import ch.heigvd.amt.gamification.services.EndUsersManagerLocal;
import ch.heigvd.amt.gamification.services.EventsProcessor;
import ch.heigvd.amt.gamification.services.dao.GamificationDomainEntityNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    private EventsProcessor eventsProcessor;

    @POST
    @Consumes("application/json")
    public void postEvent(EventDTO eventDTO) {
        try {
            eventsProcessor.processEvent(eventDTO);
        } catch (GamificationDomainEntityNotFoundException ex) {
            throw new Error("Application doesnt exists");
        }
    }

}
