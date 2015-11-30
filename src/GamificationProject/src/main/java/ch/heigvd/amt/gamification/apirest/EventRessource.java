package ch.heigvd.amt.gamification.apirest;

import ch.heigvd.amt.gamification.dto.EventDTO;
import ch.heigvd.amt.gamification.services.dao.GamificationDomainEntityNotFoundException;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
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
    private EventsProcessorLocal eventsProcessor;

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
