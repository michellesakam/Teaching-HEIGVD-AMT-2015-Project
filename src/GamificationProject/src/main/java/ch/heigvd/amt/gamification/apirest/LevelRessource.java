package ch.heigvd.amt.gamification.apirest;

import ch.heigvd.amt.gamification.dto.LevelDTO;
import ch.heigvd.amt.gamification.model.Level;
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
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author Raphaël Racine
 */
@Stateless
@Path("levels")
public class LevelRessource {
    
    @EJB
    private LevelsManagerLocal levelsManager;
    
    @GET
    @Produces("application/json")
    public List<LevelDTO> getLevels(String apiKey) {
        return null;
    } 
    
    @POST
    @Consumes("application/json")
    public void postLevel(LevelDTO levelDTO) {
        // :TODO
    }
    
    @PUT
    @Consumes("application/json")
    @Path("/{levelID}")
    public void putLevel(@PathParam(value="levelID") Long levelID, LevelDTO levelDTO) {

    }
    
    @DELETE
    @Path("/{levelID}")
    @Consumes("application/json")
    public void deleteLevel(@PathParam(value="levelID") Long levelID) {
        // :TODO
    }
    
    public LevelDTO toDTO(Level level) {
        return null;
    }
    
}
