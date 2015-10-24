package ch.heigvd.amt.gamification.services;

import ch.heigvd.amt.gamification.model.entities.Account;
import ch.heigvd.amt.gamification.model.entities.Application;
import ch.heigvd.amt.gamification.model.entities.EndUser;
import ch.heigvd.amt.gamification.services.dao.GamificationDomainEntityNotFoundException;
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
    public Application findById(Long id) throws GamificationDomainEntityNotFoundException;
    public long nbEndUsersOfApplication(Application application);
    public void enableApplication(Application app) throws GamificationDomainEntityNotFoundException;
    public void disableApplication(Application app) throws GamificationDomainEntityNotFoundException;
    public List<EndUser> findEndUsersAndPaginate(Application app, int index, int limit) throws GamificationDomainEntityNotFoundException;
    
}
