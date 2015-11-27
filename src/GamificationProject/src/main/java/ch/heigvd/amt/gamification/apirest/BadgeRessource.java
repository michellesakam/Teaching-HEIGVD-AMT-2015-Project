package ch.heigvd.amt.gamification.apirest;

import ch.heigvd.amt.gamification.dto.LevelDTO;
import ch.heigvd.amt.gamification.services.ApplicationsManagerLocal;
import ch.heigvd.amt.gamification.services.LevelsManagerLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 *
 * @author Raphaël Racine
 */
@Stateless
@Path("badges")
public class BadgeRessource {
    
    /*@GET
    @Produces("application/json")
    public List<BadgeDTO> getBadges(String apiKey) {
        return null;
    } */
    
    /*@POST
    @Consumes("application/json")
    public void postBadge(BadgeDTO badgeDTO) {
        // :TODO
    }*/
    
    /*@PUT
    @Consumes("application/json")
    public void putBadge(BadgeDTO badgeDTO) {
        // :TODO
    }*/
    
    /*@DELETE
    @Consumes("application/json")
    public void deleteBadge() {
        // :TODO
    }*/
    
}
