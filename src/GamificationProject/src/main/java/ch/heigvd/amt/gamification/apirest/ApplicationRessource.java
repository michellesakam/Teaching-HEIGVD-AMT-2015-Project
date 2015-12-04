package ch.heigvd.amt.gamification.apirest;

import ch.heigvd.amt.gamification.dto.ApplicationEndUsersDTO;
import ch.heigvd.amt.gamification.dto.EndUserDTO;
import ch.heigvd.amt.gamification.model.Application;
import ch.heigvd.amt.gamification.services.ApplicationsManager;
import ch.heigvd.amt.gamification.services.ApplicationsManagerLocal;
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

    @GET
    @Produces("application/json")
    public List<EndUserDTO> getApplicationDTO(@HeaderParam("Authorization") String apiKey) {

        ApplicationEndUsersDTO dto = new ApplicationEndUsersDTO();
        Application app = applicationsManager.retrieveApplicationByApikey(apiKey);

        if (app == null) {
            throw new NullPointerException("This application doesn't exists");
        }

        dto.setNbEndUsers(applicationsManager.nbEndUsersOfApplication(app));
        return dto.getEndUsers();
    }

}
