/*
 * Cette interface met à disposition toutes les méthodes nécessaires pour 
 * la gestion CRUD des Applications
 */
package ch.heigvd.amt.gamification.services.dao;

import ch.heigvd.amt.gamification.model.entities.Account;
import ch.heigvd.amt.gamification.model.entities.Application;
import ch.heigvd.amt.gamification.model.entities.EndUser;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author parfait
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
}
