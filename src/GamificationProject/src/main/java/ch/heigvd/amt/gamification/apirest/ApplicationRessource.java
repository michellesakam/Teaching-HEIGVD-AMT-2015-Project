package ch.heigvd.amt.gamification.apirest;

import ch.heigvd.amt.gamification.dto.BadgeDTO;
import ch.heigvd.amt.gamification.dto.EndUserDTO;
import ch.heigvd.amt.gamification.model.Application;
import ch.heigvd.amt.gamification.model.Badge;
import ch.heigvd.amt.gamification.model.EndUser;
import ch.heigvd.amt.gamification.services.ApplicationsManagerLocal;
import ch.heigvd.amt.gamification.services.BadgesManagerLocal;
import ch.heigvd.amt.gamification.services.EndUsersManagerLocal;
import ch.heigvd.amt.gamification.services.dao.GamificationDomainEntityNotFoundException;
import java.util.LinkedList;
import java.util.List;
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
/**
 * Used to tests transactions in client test
 */
@Stateless
@Path("applicationsEndUsers")
public class ApplicationRessource {

    @EJB
    private ApplicationsManagerLocal applicationsManager;

    @EJB
    private BadgesManagerLocal badgesManager;

    @EJB
    private EndUsersManagerLocal endUsersManager;

    @GET
    @Produces("application/json")
    public List<EndUserDTO> getEndUsers(@HeaderParam("Authorization") String apiKey) {

        Application app = applicationsManager.retrieveApplicationByApikey(apiKey);
        long nbEndUsers = applicationsManager.nbEndUsersOfApplication(app);

        List<EndUserDTO> endUsersDTO = new LinkedList<>();

        try {
            List<EndUser> endUsers = applicationsManager.findEndUsersAndPaginate(app, 0, (int) nbEndUsers);

            for (EndUser e : endUsers) {
                EndUserDTO endUserDTO = new EndUserDTO();

                List<Badge> badges = badgesManager.findByEndUser(e, app);

                endUserDTO.setApikey(apiKey);
                endUserDTO.setEndUserNumber(e.getUserID());
                endUserDTO.setNbPoints(endUsersManager.getNumberOfPoints(app, e));

                for (Badge b : badges) {
                    BadgeDTO badgeDTO = new BadgeDTO();
                    badgeDTO.setId(b.getId());
                    badgeDTO.setName(b.getName());
                    endUserDTO.getBadges().add(badgeDTO);
                }

                endUsersDTO.add(endUserDTO);
            }

        } catch (GamificationDomainEntityNotFoundException ex) {
            throw new Error(ex.getMessage());
        }

        return endUsersDTO;
    }

    @GET
    @Path("{endUserNumber}")
    @Produces("application/json")
    public EndUserDTO getAnEndUser(@HeaderParam("Authorization") String apiKey,
            @PathParam(value = "endUserNumber") String endUserNumber) {

        Application app = applicationsManager.retrieveApplicationByApikey(apiKey);

        EndUser e = endUsersManager.retrieveEndUser(app, endUserNumber);

        if (e == null) {
            throw new NullPointerException("This user doesn't exists in this application");
        }

        EndUserDTO endUserDTO = new EndUserDTO();

        List<Badge> badges = badgesManager.findByEndUser(e, app);

        endUserDTO.setApikey(apiKey);
        endUserDTO.setEndUserNumber(e.getUserID());
        endUserDTO.setNbPoints(endUsersManager.getNumberOfPoints(app, e));

        for (Badge b : badges) {
            BadgeDTO badgeDTO = new BadgeDTO();
            badgeDTO.setId(b.getId());
            badgeDTO.setName(b.getName());
            endUserDTO.getBadges().add(badgeDTO);
        }

        return endUserDTO;
    }

}
