package ch.heigvd.amt.gamification.apirest;

import ch.heigvd.amt.gamification.dto.BadgeDTO;
import ch.heigvd.amt.gamification.dto.StatsBadgesDTO;
import ch.heigvd.amt.gamification.dto.StatsLevelsDTO;
import ch.heigvd.amt.gamification.dto.StatsPointsDTO;
import ch.heigvd.amt.gamification.model.Application;
import ch.heigvd.amt.gamification.model.Badge;
import ch.heigvd.amt.gamification.model.EndUser;
import ch.heigvd.amt.gamification.model.Level;
import ch.heigvd.amt.gamification.services.ApplicationsManagerLocal;
import ch.heigvd.amt.gamification.services.BadgesManagerLocal;
import ch.heigvd.amt.gamification.services.EndUsersManagerLocal;
import ch.heigvd.amt.gamification.services.LevelsManagerLocal;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
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

    @EJB
    private BadgesManagerLocal badgesManager;

    @GET
    @Produces("application/json")
    @Path("/badges/{endUserNumber}")
    public StatsBadgesDTO getEndUserBadgesStats(@HeaderParam("Authorization") String apiKey,
            @PathParam(value = "endUserNumber") String endUserNumber) {

        Application app = applicationsManager.retrieveApplicationByApikey(apiKey);
        EndUser e = endUsersManager.retrieveEndUser(app, endUserNumber);

        if (e == null) {
            throw new NullPointerException("This endUser isn't in this application");
        }

        StatsBadgesDTO dto = new StatsBadgesDTO();

        List<Badge> badges = badgesManager.findByEndUser(e, app);

        for (Badge b : badges) {
            BadgeDTO badgeDTO = new BadgeDTO();
            badgeDTO.setId(b.getId());
            badgeDTO.setName(b.getName());
            dto.getBadges().add(badgeDTO);
        }

        return dto;

    }

    @GET
    @Produces("application/json")
    @Path("/points/{endUserNumber}")
    public StatsPointsDTO getEndUserPointsStats(@HeaderParam("Authorization") String apiKey,
            @PathParam(value = "endUserNumber") String endUserNumber) {

        StatsPointsDTO dto = new StatsPointsDTO();

        Application app = applicationsManager.retrieveApplicationByApikey(apiKey);
        EndUser e = endUsersManager.retrieveEndUser(app, endUserNumber);

        if (e == null) {
            throw new NullPointerException("This endUser isn't in this application");
        }

        Map<Integer, Long> pointsPerMonth
                = endUsersManager.getPointsPerMonths(e, app, Calendar.getInstance().get(Calendar.YEAR));

        dto.setPointsPerPeriod(pointsPerMonth);
        dto.setTotalPoints(endUsersManager.getNumberOfPoints(app, e));

        return dto;
    }

    @GET
    @Produces("application/json")
    @Path("/levels/{endUserNumber}")
    public StatsLevelsDTO getEndUserLevelsStats(@HeaderParam("Authorization") String apiKey,
            @PathParam(value = "endUserNumber") String endUserNumber) {

        Application app = applicationsManager.retrieveApplicationByApikey(apiKey);

        EndUser e = endUsersManager.retrieveEndUser(app, endUserNumber);

        if (e == null) {
            throw new Error("This user isn't in this application");
        }

        long nbPointsEndUser = endUsersManager.getNumberOfPoints(app, e);

        Level currentLevel = levelsManager.findCurrentLevel(app, nbPointsEndUser);
        Level nextLevel = levelsManager.findNextLevel(app, nbPointsEndUser);

        StatsLevelsDTO dto = new StatsLevelsDTO();

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

}
