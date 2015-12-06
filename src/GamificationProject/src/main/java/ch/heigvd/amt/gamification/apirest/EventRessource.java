package ch.heigvd.amt.gamification.apirest;

import ch.heigvd.amt.gamification.services.processors.EventsProcessorLocal;
import ch.heigvd.amt.gamification.dto.EventDTO;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.HeaderParam;
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
    public void postEvent(@HeaderParam("Authorization") String apiKey, EventDTO eventDTO) {
        System.out.println("Received apikey : " + apiKey);
        eventsProcessor.postDTO(apiKey, eventDTO);
    }

}
