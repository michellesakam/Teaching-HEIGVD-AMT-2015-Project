package ch.heigvd.amt.gamification.services;

import ch.heigvd.amt.gamification.services.passwordvalidation.PasswordPoliticValidator;
import ch.heigvd.amt.gamification.model.entities.Account;
import ch.heigvd.amt.gamification.services.dao.AccountDAOLocal;
import ch.heigvd.amt.gamification.services.dao.GamificationDomainEntityNotFoundException;
import ch.heigvd.amt.gamification.services.passwordvalidation.BadPasswordException;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Raphaël Racine
 */
@Stateless
public class AccountsManager implements AccountsManagerLocal {
    @EJB
    private AccountDAOLocal accountDAO;

    /**
     * @param account (must have an id)
     * @throws GamificationDomainEntityNotFoundException
     * @throws BadPasswordException if the password politic isnt respected
     */
    @Override
    public void updateAccount(Account account) 
            throws GamificationDomainEntityNotFoundException, BadPasswordException
    {
        PasswordPoliticValidator.checkPassword(account.getPassword());
        accountDAO.update(account);
    }    

    /**
     * Create an new account in data store
     * @param account
     * @throws BadPasswordException if the password politic isnt respected
     */
    @Override
    public void createAccount(Account account) throws BadPasswordException {
        PasswordPoliticValidator.checkPassword(account.getPassword());
        accountDAO.create(account);
    }

    /**
     * Get an account by his adresse email. If the account exists in the store,
     * it returns an account, in other case it returns null
     * @param email
     * @return Account if founded by email, otherwise null
     */
    @Override
    public Account retrieveAccount(String email) {
        return accountDAO.findByEmail(email);
    }  

    /**
     * Get the numbers of accounts in the store
     * @return The numbers of accounts
     */
    @Override
    public long numbersOfAccount() {
        return accountDAO.numbersOfAccount();
    }   
    
}
