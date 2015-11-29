package ch.heigvd.amt.gamification.apirest;

import ch.heigvd.amt.gamification.dto.BadgeDTO;
import ch.heigvd.amt.gamification.model.Badge;
import ch.heigvd.amt.gamification.services.ApplicationsManagerLocal;
import ch.heigvd.amt.gamification.services.BadgesManagerLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author Raphaël Racine
 */
@Stateless
@Path("badges")
public class BadgeRessource {

    @EJB
    private BadgesManagerLocal badgsesManager;
    
    @EJB
    private ApplicationsManagerLocal applicationsManager;
    
    @GET
    @Produces("application/json")
    public List<BadgeDTO> getBadges(String apiKey) {
        return null;
    }

    @POST
    @Consumes("application/json")
    public void postBadge(BadgeDTO badgeDTO) {
        // :TODO
    }

    @PUT
    @Consumes("application/json")
    public void putBadge(@PathParam(value = "badgeID") Long badgeID, BadgeDTO badgeDTO) {
        // :TODO
    }

    @DELETE
    @Consumes("application/json")
    public void deleteBadge(@PathParam(value = "badgeID") Long badgeID, String apiKey) {
        // :TODO
    }

    public BadgeDTO toDTO(Badge badge) {

        /*LevelDTO dto = new LevelDTO();
        dto.setName(level.getName());
        dto.setApikey(level.getApplication().getApiKey().getKey());
        dto.setMinimumPoints(level.getMinimumPoints());
        dto.setId(level.getId());*/

        /*return dto;*/
        return null;
    }

}
