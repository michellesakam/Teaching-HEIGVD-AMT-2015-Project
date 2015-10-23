package ch.heigvd.amt.gamification.services;

import ch.heigvd.amt.gamification.model.entities.Account;
import ch.heigvd.amt.gamification.services.dao.AccountDAO;
import ch.heigvd.amt.gamification.services.dao.GamificationDomainEntityNotFoundException;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Raphaël Racine
 */
@Stateless
public class AccountsManager implements AccountsManagerLocal {
    @EJB
    private AccountDAO accountDAO;

    @Override
    public void updateAccount(Account a) throws GamificationDomainEntityNotFoundException {
        accountDAO.update(a);
    }    

    @Override
    public void createAccount(Account a) {
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
