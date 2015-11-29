package ch.heigvd.amt.gamification.apirest;

import ch.heigvd.amt.gamification.dto.LevelDTO;
import ch.heigvd.amt.gamification.model.Application;
import ch.heigvd.amt.gamification.model.Level;
import ch.heigvd.amt.gamification.services.ApplicationsManagerLocal;
import ch.heigvd.amt.gamification.services.LevelsManagerLocal;
import ch.heigvd.amt.gamification.services.dao.GamificationDomainEntityNotFoundException;
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
    private ApplicationsManagerLocal applicationsManager;

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

        Application application = applicationsManager.retrieveApplicationByApikey(levelDTO.getApikey());

        if (application == null) {
            throw new NullPointerException("This application doesn't exists");
        }

        Level level = new Level();
        level.setName(levelDTO.getName());
        level.setMinimumPoints(levelDTO.getMinimumPoints());

        levelsManager.assignLevelToApplication(application, level);

    }

    @PUT
    @Consumes("application/json")
    @Path("/{levelID}")
    public void putLevel(@PathParam(value = "levelID") Long levelID, LevelDTO levelDTO) {

        Application application = applicationsManager.retrieveApplicationByApikey(levelDTO.getApikey());

        if (application == null) {
            throw new NullPointerException("This application doesn't exists");
        }

        try {
            Level level = levelsManager.findById(levelID);

            if (level == null) {
                throw new NullPointerException("This level doesn't exists");
            }

            if (level.getApplication() == application) {

                level.setName(levelDTO.getName());
                level.setMinimumPoints(levelDTO.getMinimumPoints());
            } else {
                throw new Error("This application doens't have level with specified levelID");
            }
        } catch (GamificationDomainEntityNotFoundException ex) {
            throw new NullPointerException("This level doesn't exists");
        }

    }

    @DELETE
    @Path("/{levelID}")
    @Consumes("application/json")
    public void deleteLevel(@PathParam(value = "levelID") Long levelID, String apiKey) {

        Application application = applicationsManager.retrieveApplicationByApikey(apiKey);

        if (application == null) {
            throw new NullPointerException("This application doesn't exists");
        }

        try {
            Level level = levelsManager.findById(levelID);

            if (level == null) {
                throw new NullPointerException("This level doesn't exists");
            }

            if (level.getApplication() == application) {
                levelsManager.deleteLevel(level);
            } else {
                throw new Error("This application doens't have level with specified levelID");
            }
        } catch (GamificationDomainEntityNotFoundException ex) {
            throw new NullPointerException("This level doesn't exists");
        }

    }

    public LevelDTO toDTO(Level level) {

        LevelDTO dto = new LevelDTO();
        dto.setName(level.getName());
        dto.setApikey(level.getApplication().getApiKey().getKey());
        dto.setMinimumPoints(level.getMinimumPoints());
        dto.setId(level.getId());

        return dto;

    }

}
