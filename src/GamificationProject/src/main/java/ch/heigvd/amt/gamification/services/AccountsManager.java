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

    @Override
    public void updateAccount(Account a) 
            throws GamificationDomainEntityNotFoundException, BadPasswordException
    {
        PasswordPoliticValidator.checkPassword(a.getPassword());
        accountDAO.update(a);
    }    

    @Override
    public void createAccount(Account a) throws BadPasswordException {
        PasswordPoliticValidator.checkPassword(a.getPassword());
        accountDAO.create(a);
    }

    @Override
    public Account retrieveAccount(String email) {
        return accountDAO.findByEmail(email);
    }  

    @Override
    public long numbersOfAccount() {
        return accountDAO.numbersOfAccount();
    }   
    
}
