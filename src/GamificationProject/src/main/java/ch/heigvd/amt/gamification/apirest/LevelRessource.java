package ch.heigvd.amt.gamification.apirest;

import ch.heigvd.amt.gamification.services.processors.LevelsProcessorLocal;
import ch.heigvd.amt.gamification.dto.LevelDTO;
import ch.heigvd.amt.gamification.model.Level;
import ch.heigvd.amt.gamification.services.LevelsManagerLocal;
import java.util.ArrayList;
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
 * @author Raphaël Racine, Samira
 */
@Stateless
@Path("levels")
public class LevelRessource {

    @EJB
    private LevelsManagerLocal levelsManager;
    
    @EJB
    private LevelsProcessorLocal levelsProcessor;

    @GET
    @Produces("application/json")
    public List<LevelDTO> getLevels(String apiKey) {

        List<LevelDTO> dto = new ArrayList<>();
        List<Level> levels = levelsManager.findLevelsByApiKey(apiKey);

        for (Level level : levels) {
            dto.add(toDTO(level));
        }

        return dto;

    }

    @POST
    @Consumes("application/json")
    public void postLevel(LevelDTO levelDTO) {
        levelsProcessor.processPostLevel(levelDTO);
    }

    @PUT
    @Consumes("application/json")
    @Path("/{levelID}")
    public void putLevel(@PathParam(value = "levelID") Long levelID, LevelDTO levelDTO) {
        levelsProcessor.processPutLevel(levelID, levelDTO);
    }

    @DELETE
    @Path("/{levelID}")
    @Consumes("application/json")
    public void deleteLevel(@PathParam(value = "levelID") Long levelID, String apiKey) {
        levelsProcessor.processDeleteLevel(levelID, apiKey);
    }

    public LevelDTO toDTO(Level level) {

        LevelDTO dto = new LevelDTO();
        dto.setName(level.getName());
        dto.setApiKey(level.getApplication().getApiKey().getKey());
        dto.setMinimumPoints(level.getMinimumPoints());
        dto.setId(level.getId());

        return dto;

    }

}
