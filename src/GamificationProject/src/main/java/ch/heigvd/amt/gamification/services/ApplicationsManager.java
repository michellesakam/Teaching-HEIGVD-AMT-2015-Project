package ch.heigvd.amt.gamification.services;

import ch.heigvd.amt.gamification.model.Account;
import ch.heigvd.amt.gamification.model.Application;
import ch.heigvd.amt.gamification.model.EndUser;
import ch.heigvd.amt.gamification.services.dao.ApplicationDAOLocal;
import ch.heigvd.amt.gamification.services.dao.GamificationDomainEntityNotFoundException;
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

    @Override
    public Application findById(Long id) throws GamificationDomainEntityNotFoundException {
        return applicationDAO.findById(id);
    }

    @Override
    public long nbEndUsersOfApplication(Application application) {
        return applicationDAO.nbEndUsersOfApplication(application);
    }

    @Override
    public void enableApplication(Application app) throws GamificationDomainEntityNotFoundException {
        applicationDAO.enableApplication(app);
    }

    @Override
    public void disableApplication(Application app) throws GamificationDomainEntityNotFoundException {
        applicationDAO.disableApplication(app);
    }

    @Override
    public List<EndUser> findEndUsersAndPaginate(Application app, int numPage, int nbEndUsersPerPage) throws GamificationDomainEntityNotFoundException {
        return applicationDAO.findEndUsersAndPaginate(app, numPage, nbEndUsersPerPage);
    }

    @Override
    public void updateApplication(Application app) throws GamificationDomainEntityNotFoundException {
        applicationDAO.updateApplication(app);
    }

    @Override
    public boolean checkAccountIsOwnerOfApplication(Account account, Application application) {
        return account.equals(application.getAcount());
    }

    @Override
    public boolean checkEndUserUseAnApplication(Application application, EndUser endUser) {
        // TODO:
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Application retriveApplicationByApikey(String apikey) {
        // TODO:
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    

}
