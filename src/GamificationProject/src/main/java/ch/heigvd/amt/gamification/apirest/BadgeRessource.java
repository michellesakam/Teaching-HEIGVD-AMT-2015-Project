package ch.heigvd.amt.gamification.apirest;

import ch.heigvd.amt.gamification.services.processors.BadgesProcessorLocal;
import ch.heigvd.amt.gamification.dto.BadgeDTO;
import ch.heigvd.amt.gamification.model.Application;
import ch.heigvd.amt.gamification.model.Badge;
import ch.heigvd.amt.gamification.services.ApplicationsManagerLocal;
import ch.heigvd.amt.gamification.services.BadgesManagerLocal;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
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
    private BadgesManagerLocal badgesManager;
    
    @EJB
    private BadgesProcessorLocal badgesProcessor;

    @EJB
    private ApplicationsManagerLocal applicationsManager;
    
    @GET
    @Produces("application/json")
    public List<BadgeDTO> getBadges(@HeaderParam("Authorization") String apiKey) {
        
        Application app = applicationsManager.retrieveApplicationByApikey(apiKey);
        
        List<BadgeDTO> dto = new ArrayList<>();
        List<Badge> badges = badgesManager.findByApplication(app);

        for (Badge badge : badges) {
            dto.add(toDTO(badge));
        }
        return dto;
    }

    @POST
    @Consumes("application/json")
    public void postBadge(@HeaderParam("Authorization") String apiKey, BadgeDTO badgeDTO) {
        badgesProcessor.postDTO(apiKey, badgeDTO);
    }

    @PUT
    @Consumes("application/json")
    @Path("{badgeID}")
    public void putBadge(@HeaderParam("Authorization") String apiKey, @PathParam(value = "badgeID") Long badgeID, BadgeDTO badgeDTO) {
        badgesProcessor.putDTO(apiKey, badgeID, badgeDTO);
    }

    @DELETE
    @Consumes("application/json")
    @Path("{badgeID}")
    public void deleteBadge(@HeaderParam("Authorization") String apiKey, @PathParam(value = "badgeID") Long badgeID) {
        badgesProcessor.deleteDTO(badgeID, apiKey);
    }

    public BadgeDTO toDTO(Badge badge) {
        BadgeDTO dto = new BadgeDTO();
        dto.setName(badge.getName());
        dto.setId(badge.getId());

        return dto;
    }

}
