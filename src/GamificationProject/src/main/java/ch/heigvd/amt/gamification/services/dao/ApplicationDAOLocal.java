package ch.heigvd.amt.gamification.services.dao;

import ch.heigvd.amt.gamification.model.Account;
import ch.heigvd.amt.gamification.model.Application;
import ch.heigvd.amt.gamification.model.EndUser;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author parfait
 * But : defines methods that are only needed in this class
 */
@Local
public interface ApplicationDAOLocal extends IGenericDAO<Application, Long> {
    
    public void assignApplicationToAccount(Application app, Account acc);
    public long numberOfApplicationsManaged();
    public void assignApplicationToEndUser(Application application, EndUser endUser);
    public List<Application> applicationsOfAnAccountWithEndUsersNumber(Account account);
    public long nbEndUsersOfApplication(Application application);
    public void enableApplication(Application app) throws GamificationDomainEntityNotFoundException;
    public void disableApplication(Application app) throws GamificationDomainEntityNotFoundException;
    public List<EndUser> findEndUsersAndPaginate(Application app, int index, int limit) throws GamificationDomainEntityNotFoundException;

    public void updateApplication(Application app) throws GamificationDomainEntityNotFoundException;

    public Application findByApiKey(String apikey);

    public boolean checkEndUserUseApp(Application application, EndUser endUser);
}
