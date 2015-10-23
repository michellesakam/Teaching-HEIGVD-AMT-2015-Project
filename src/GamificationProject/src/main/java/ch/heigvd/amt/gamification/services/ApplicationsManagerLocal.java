package ch.heigvd.amt.gamification.services;

import ch.heigvd.amt.gamification.model.entities.Account;
import ch.heigvd.amt.gamification.model.entities.Application;
import ch.heigvd.amt.gamification.model.entities.EndUser;
import javax.ejb.Local;
import java.util.List;

/**
 *
 * @author Raphaël Racine
 */
@Local
public interface ApplicationsManagerLocal {

    public void assignApplicationToAccount(Application application, Account account);
    public long numberOfApplicationsManaged();    
    public void assignApplicationToAnEndUser(Application application, EndUser endUser);
    public List<Application> applicationsOfAnAccountWithEndUsersNumber(Account account);
}
