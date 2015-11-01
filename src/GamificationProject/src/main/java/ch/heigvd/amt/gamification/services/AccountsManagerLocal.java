package ch.heigvd.amt.gamification.services;

import ch.heigvd.amt.gamification.services.passwordvalidation.BadPasswordException;
import ch.heigvd.amt.gamification.model.entities.Account;
import ch.heigvd.amt.gamification.services.dao.GamificationDomainEntityNotFoundException;
import javax.ejb.Local;

/**
 *
 * @author Raphaël Racine
 */
@Local
public interface AccountsManagerLocal {

    /**
     * Update an account
     *
     * @param account (must have an id)
     * @throws GamificationDomainEntityNotFoundException
     * @throws BadPasswordException if the password politic isnt respected
     */
    public void updateAccount(Account account) throws GamificationDomainEntityNotFoundException, BadPasswordException;

    /**
     * Create an new account in data store
     *
     * @param account
     * @throws BadPasswordException if the password politic isnt respected
     */
    public void createAccount(Account account) throws BadPasswordException;

    /**
     * Retrieve an account by his adresse email. If the account exists in the
     * store, it returns an account, in other case it returns null
     *
     * @param email
     * @return Account if founded by email, otherwise null
     */
    public Account retrieveAccount(String email);

    /**
     * Get the numbers of accounts in the store
     *
     * @return The numbers of accounts
     */
    public long numbersOfAccount();
}
