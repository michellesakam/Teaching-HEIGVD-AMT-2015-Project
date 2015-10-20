package ch.heigvd.amt.gamification.services;

import ch.heigvd.amt.gamification.model.entities.Account;
import ch.heigvd.amt.gamification.model.entities.ApiKey;
import ch.heigvd.amt.gamification.model.entities.Application;
import ch.heigvd.amt.gamification.model.entities.EndUser;
import java.util.List;
import javax.ejb.Local;


/**
 *
 * @author Raphaël Racine
 */
@Local
public interface ApplicationsManagerLocal {
    
    public long numberOfApplicationsManaged();
    public void assignApplicationToAccount(Application app, Account acc);
    public void editApplicationDetails(Application application);
    public List<EndUser> endUsersOfApplication(long idApplication);
}
