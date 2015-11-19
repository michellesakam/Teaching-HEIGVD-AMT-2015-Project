package ch.heigvd.amt.gamification.apirest;

import ch.heigvd.amt.gamification.dto.LevelDTO;
import ch.heigvd.amt.gamification.services.ApplicationsManagerLocal;
import ch.heigvd.amt.gamification.services.LevelsManagerLocal;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;

/**
 *
 * @author Raphaël Racine
 */
@Stateless
@Path("levels")
public class LevelRessource {
    
    @EJB
    private ApplicationsManagerLocal applicationsManager;
    
    @EJB
    private LevelsManagerLocal levelsManager;
    
    @POST
    @Consumes("application/json")
    public void postLevel(LevelDTO levelDTO) {
        // :TODO
    }
    
    @PUT
    @Consumes("application/json")
    public void putLevel(LevelDTO levelDTO) {
        // :TODO
    }
    
    @DELETE
    @Consumes("application/json")
    public void deleteLevel(LevelDTO levelDTO) {
        // :TODO
    }
    
}
