package ch.heigvd.amt.gamification.apirest;

import ch.heigvd.amt.gamification.dto.WidgetLevelDTO;
import ch.heigvd.amt.gamification.model.Application;
import ch.heigvd.amt.gamification.model.EndUser;
import ch.heigvd.amt.gamification.model.Level;
import ch.heigvd.amt.gamification.services.ApplicationsManagerLocal;
import ch.heigvd.amt.gamification.services.EndUsersManagerLocal;
import ch.heigvd.amt.gamification.services.LevelsManagerLocal;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author Raphaël Racine
 */
@Stateless
@Path("statsEndUser")
public class StatsEndUserRessource {

    @EJB
    private ApplicationsManagerLocal applicationsManager;

    @EJB
    private EndUsersManagerLocal endUsersManager;

    @EJB
    private LevelsManagerLocal levelsManager;

    @GET
    @Produces("application/json")
    @Path("/widgetBadges/{endUserNumber}")
    public void getEndUserBadgesStats(@HeaderParam("Authorization") String apiKey,
            @PathParam(value = "endUserNumber") String endUserNumber) {
        // TODO        
    }

    @GET
    @Produces("application/json")
    @Path("/widgetPoints/{endUserNumber}")
    public void getEndUserPointsStats(@HeaderParam("Authorization") String apiKey,
            @PathParam(value = "endUserNumber") String endUserNumber) {
        // TODO        
    }

    @GET
    @Produces("application/json")
    @Path("/widgetLevels/{endUserNumber}")
    public WidgetLevelDTO getEndUserLevelsStats(@HeaderParam("Authorization") String apiKey,
            @PathParam(value = "endUserNumber") String endUserNumber) {

        Application app = applicationsManager.retrieveApplicationByApikey(apiKey);

        EndUser e = endUsersManager.retrieveEndUser(app, endUserNumber);

        if (e == null) {
            throw new Error("This user isn't in this application");
        }

        long nbPointsEndUser = endUsersManager.getNumberOfPoints(app, e);

        Level currentLevel = levelsManager.findCurrentLevel(app, nbPointsEndUser);
        Level nextLevel = levelsManager.findNextLevel(app, nbPointsEndUser);

        WidgetLevelDTO dto = new WidgetLevelDTO();

        if (currentLevel != null) {
            dto.setCurrentLevelName(currentLevel.getName());
        }

        if (nextLevel != null) {
            dto.setNextLevelName(nextLevel.getName());
            dto.setPointsForNextLevel(nextLevel.getMinimumPoints());
        }

        dto.setCurrentPoints(nbPointsEndUser);
        
        return dto;
    }

    @GET
    @Produces("application/json")
    @Path("/badges/{endUserNumber}")
    public void getEndUserBadgesNb(@HeaderParam("Authorization") String apiKey,
            @PathParam(value = "endUserNumber") String endUserNumber) {
        // TODO

    }

    @GET
    @Produces("application/json")
    @Path("/points/{endUserNumber}")
    public void getEndUserPointsNb(@HeaderParam("Authorization") String apiKey,
            @PathParam(value = "endUserNumber") String endUserNumber) {
        // TODO    

    }
}
