package ch.heigvd.amt.gamification.apirest;

import ch.heigvd.amt.gamification.dto.EventDTO;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 *
 * @author Raphaël Racine
 */

@Stateless
@Path("events")
public class EventRessource {
    
    @POST
    @Consumes("application/json")
    public void receiveEvent(EventDTO event) {
       String str = event.getType();
    }
    
    @GET
    @Produces("application/json")
    public Response test() {
        EventDTO event = new EventDTO();
        event.setType("Salut mon pote");
        return Response.ok(event).build();
    }
    
}
