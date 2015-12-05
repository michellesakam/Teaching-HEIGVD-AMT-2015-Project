package ch.heigvd.amt.gamification.apirest;

import ch.heigvd.amt.gamification.dto.BadgeDTO;
import ch.heigvd.amt.gamification.dto.EndUserDTO;
import ch.heigvd.amt.gamification.model.Application;
import ch.heigvd.amt.gamification.model.Badge;
import ch.heigvd.amt.gamification.model.EndUser;
import ch.heigvd.amt.gamification.services.ApplicationsManagerLocal;
import ch.heigvd.amt.gamification.services.dao.GamificationDomainEntityNotFoundException;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
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

    @GET
    @Produces("application/json")
    public List<EndUserDTO> getApplicationDTO(@HeaderParam("Authorization") String apiKey) {

        Application app = applicationsManager.retrieveApplicationByApikey(apiKey);

        if (app == null) {
            throw new NullPointerException("This application doesn't exists");
        }
                
        long nbEndUsers = applicationsManager.nbEndUsersOfApplication(app);
        
        List<EndUserDTO> endUsersDTO = new LinkedList<>();
        
        try {
            List<EndUser> endUsers = applicationsManager.findEndUsersAndPaginate(app, 0, (int) nbEndUsers);
            
            for(EndUser e : endUsers) {
                EndUserDTO endUserDTO = new EndUserDTO();
                
                endUserDTO.setApikey(apiKey);
                endUserDTO.setEndUserNumber(e.getUserID());
                endUserDTO.setNbBadges(30); // TODO service to count badges
                endUserDTO.setNbPoints(200);
                               
                List<Badge> badges = new LinkedList(); // TODO services
                
                for(Badge b : badges) {
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

}
