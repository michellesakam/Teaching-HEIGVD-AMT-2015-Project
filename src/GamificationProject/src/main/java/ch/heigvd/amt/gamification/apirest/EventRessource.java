package ch.heigvd.amt.gamification.apirest;

import ch.heigvd.amt.gamification.dto.EventDTO;
import ch.heigvd.amt.gamification.services.ApplicationsManagerLocal;
import ch.heigvd.amt.gamification.services.EndUsersManagerLocal;
import ch.heigvd.amt.gamification.services.EventsManagerLocal;
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
    private ApplicationsManagerLocal applicationsManager;
    
    @EJB
    private EventsManagerLocal eventsManager;
    
    @POST
    @Consumes("application/json")
    public void postEvent(EventDTO event) {
        
    }

    
}
