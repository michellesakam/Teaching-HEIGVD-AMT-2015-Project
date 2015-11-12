package ch.heigvd.amt.gamification.apirest;

import ch.heigvd.amt.gamification.dto.EventDTO;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 *
 * @author Raphaël Racine
 */

@Stateless
@Path("events")
public class Events {
    
    @POST
    @Consumes("application/json")
    public void receiveEvent(EventDTO event) {
       String str = event.getType();
    }
    
    @GET
    @Produces("application/json")
    public EventDTO test() {
        EventDTO event = new EventDTO();
        event.setType("Salut mon pote");
        return event;
    }
    
}
