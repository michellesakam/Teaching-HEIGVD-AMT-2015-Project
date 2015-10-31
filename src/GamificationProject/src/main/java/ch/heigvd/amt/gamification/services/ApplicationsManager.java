package ch.heigvd.amt.gamification.services;

import ch.heigvd.amt.gamification.model.entities.Account;
import ch.heigvd.amt.gamification.model.entities.Application;
import ch.heigvd.amt.gamification.model.entities.EndUser;
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
    
    /**
     * Assign an application to an account
     * @param application The application need to be already registred in the store (managed)
     * @param account The account need to be already registred in the store (managed)
     */
    @Override
    public void assignApplicationToAccount(Application application, Account account) {
        applicationDAO.assignApplicationToAccount(application, account);
    }

    /**
     * Get the numbers of applications managed
     * @return The numbers of applications managed
     */
    @Override
    public long numberOfApplicationsManaged() {
        return applicationDAO.numberOfApplicationsManaged();
    }    

    /**
     * Assign and end User in application
     * @param application The application need to be managed
     * @param endUser The endUser doesnt have to be managed
     */
    @Override
    public void assignApplicationToAnEndUser(Application application, EndUser endUser) {
        applicationDAO.assignApplicationToEndUser(application, endUser);
    }

    /**
     * Get all applications of an account, with the numbers of endUsers
     * @param account The account we want know his applications
     * @return The applications of the account and the number of endUsers
     */
    @Override
    public List<Application> applicationsOfAnAccountWithEndUsersNumber(Account account) {
        return applicationDAO.applicationsOfAnAccountWithEndUsersNumber(account);
    }

    /**
     * Get a managed application from an id
     * @param id
     * @return Application managed which have the id
     * @throws GamificationDomainEntityNotFoundException
     */
    @Override
    public Application findById(Long id) throws GamificationDomainEntityNotFoundException {
        return applicationDAO.findById(id);
    }  

    /**
     * Get the numbers of endUsers for an application
     * @param application
     * @return The number of endUsers for application 
     */
    @Override
    public long nbEndUsersOfApplication(Application application) {
        return applicationDAO.nbEndUsersOfApplication(application);
    }

    /**
     * Enable an application
     * @param app
     * @throws GamificationDomainEntityNotFoundException 
     */
    @Override
    public void enableApplication(Application app) throws GamificationDomainEntityNotFoundException {
        applicationDAO.enableApplication(app);
    }

    /**
     * Disable an application
     * @param app
     * @throws GamificationDomainEntityNotFoundException 
     */
    @Override
    public void disableApplication(Application app) throws GamificationDomainEntityNotFoundException {
        applicationDAO.disableApplication(app);
    }

    /**
     * Find all and users of an application and paginate the results
     * @param app The application we want to know a part of endUsers
     * @param numPage The number of the page we want (0 is the firstPage, 1 the second page...)
     * @param nbEndUsersPerPage The number of endUsers per page
     * @return The list of endUsers already paginated
     * @throws GamificationDomainEntityNotFoundException 
     */
    @Override
    public List<EndUser> findEndUsersAndPaginate(Application app, int numPage, int nbEndUsersPerPage) throws GamificationDomainEntityNotFoundException {
        return applicationDAO.findEndUsersAndPaginate(app, numPage, nbEndUsersPerPage);
    }   

    /**
     * Update an application
     * @param app (need to have an id)
     * @throws GamificationDomainEntityNotFoundException 
     */
    @Override
    public void updateApplication(Application app) throws GamificationDomainEntityNotFoundException {
        applicationDAO.updateApplication(app);
    }
    
    
    
}
