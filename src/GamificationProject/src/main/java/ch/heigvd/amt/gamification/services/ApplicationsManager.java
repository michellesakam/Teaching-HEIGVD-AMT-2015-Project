package ch.heigvd.amt.gamification.services;

import ch.heigvd.amt.gamification.model.entities.Account;
import ch.heigvd.amt.gamification.model.entities.Application;
import ch.heigvd.amt.gamification.model.entities.EndUser;
import ch.heigvd.amt.gamification.services.dao.ApplicationDAOLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Raphaël Racine
 */
@Stateless
public class ApplicationsManager implements ApplicationsManagerLocal {

    @EJB
    private ApplicationDAOLocal applicationDAO;
    
    @Override
    public void assignApplicationToAccount(Application application, Account account) {
        applicationDAO.assignApplicationToAccount(application, account);
    }

    @Override
    public long numberOfApplicationsManaged() {
        return applicationDAO.numberOfApplicationsManaged();
    }    

    @Override
    public void assignApplicationToAnEndUser(Application application, EndUser endUser) {
        applicationDAO.assignApplicationToEndUser(application, endUser);
    }

    @Override
    public List<Application> applicationsOfAnAccountWithEndUsersNumber(Account account) {
        return applicationDAO.applicationsOfAnAccountWithEndUsersNumber(account);
    }
}
