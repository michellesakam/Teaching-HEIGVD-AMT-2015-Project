package ch.heigvd.amt.gamification.services;

import ch.heigvd.amt.gamification.model.Account;
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
    public void assignApplicationToAccount(Application app, Account acc, ApiKey apikey);
    public void editApplicationDetails(Application application);
    public List<EndUser> endUsersOfApplication(long idApplication);
}
