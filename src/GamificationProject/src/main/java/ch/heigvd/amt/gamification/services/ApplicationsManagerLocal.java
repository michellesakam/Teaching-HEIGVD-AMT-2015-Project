package ch.heigvd.amt.gamification.services;

import ch.heigvd.amt.gamification.model.ApiKey;
import ch.heigvd.amt.gamification.model.Application;
import ch.heigvd.amt.gamification.model.EndUser;
import java.util.List;
import javax.ejb.Local;


/**
 *
 * @author Raphaël Racine
 */
@Local
public interface ApplicationsManagerLocal {
    
    public long numberOfApplicationsManaged();
    public void registerNewApplication(String email, String name, String description, ApiKey apiKey, boolean isEnable);
    public void editApplicationDetails(long id, String newName, String newDescription, ApiKey newApiKey, boolean isEnable);
    public List<EndUser> endUsersOfApplication(long idApplication);
}
