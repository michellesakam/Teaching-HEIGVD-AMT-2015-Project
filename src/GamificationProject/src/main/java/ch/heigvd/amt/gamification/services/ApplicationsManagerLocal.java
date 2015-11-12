package ch.heigvd.amt.gamification.services;

import ch.heigvd.amt.gamification.model.Account;
import ch.heigvd.amt.gamification.model.Application;
import ch.heigvd.amt.gamification.model.EndUser;
import ch.heigvd.amt.gamification.services.dao.GamificationDomainEntityNotFoundException;
import javax.ejb.Local;
import java.util.List;

/**
 *
 * @author Raphaël Racine
 */
@Local
public interface ApplicationsManagerLocal {

    /**
     * Assign an application to an account
     *
     * @param application The application need to be already registred in the
     * store (managed)
     * @param account The account need to be already registred in the store
     * (managed)
     */
    public void assignApplicationToAccount(Application application, Account account);

    /**
     * Get the numbers of applications managed
     *
     * @return The numbers of applications managed
     */
    public long numberOfApplicationsManaged();

    /**
     * Assign and end User in application
     *
     * @param application The application need to be managed
     * @param endUser The endUser doesnt have to be managed
     */
    public void assignApplicationToAnEndUser(Application application, EndUser endUser);

    /**
     * Get all applications of an account, with the numbers of endUsers
     *
     * @param account The account we want know his applications
     * @return The applications of the account and the number of endUsers
     */
    public List<Application> applicationsOfAnAccountWithEndUsersNumber(Account account);

    /**
     * Get a managed application from an id
     *
     * @param id
     * @return Application managed which have the id
     * @throws GamificationDomainEntityNotFoundException
     */
    public Application findById(Long id) throws GamificationDomainEntityNotFoundException;

    /**
     * Get the numbers of endUsers for an application
     *
     * @param application
     * @return The number of endUsers for application
     */
    public long nbEndUsersOfApplication(Application application);

    /**
     * Enable an application
     *
     * @param app
     * @throws GamificationDomainEntityNotFoundException
     */
    public void enableApplication(Application app) throws GamificationDomainEntityNotFoundException;

    /**
     * Disable an application
     *
     * @param app
     * @throws GamificationDomainEntityNotFoundException
     */
    public void disableApplication(Application app) throws GamificationDomainEntityNotFoundException;

    /**
     * Find all and users of an application and paginate the results
     *
     * @param app The application we want to know a part of endUsers
     * @param numPage The number of the page we want (0 is the firstPage, 1 the
     * second page...)
     * @param nbEndUsersPerPage The number of endUsers per page
     * @return The list of endUsers already paginated
     * @throws GamificationDomainEntityNotFoundException
     */
    public List<EndUser> findEndUsersAndPaginate(Application app, int numPage, int nbEndUsersPerPage) throws GamificationDomainEntityNotFoundException;

    /**
     * Update an application
     *
     * @param app (need to have an id)
     * @throws GamificationDomainEntityNotFoundException
     */
    public void updateApplication(Application app) throws GamificationDomainEntityNotFoundException;

    /**
     * Check if an account is the owner of an application
     *
     * @param account The account (need an id)
     * @param application The application (has to be managed)
     * @return true if account is the owner of application, otherwise false
     */
    public boolean checkAccountIsOwnerOfApplication(Account account, Application application);

}
