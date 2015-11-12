package ch.heigvd.amt.gamification.services;

import ch.heigvd.amt.gamification.services.passwordvalidation.PasswordPoliticValidator;
import ch.heigvd.amt.gamification.model.Account;
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
    public void updateAccount(Account account)
            throws GamificationDomainEntityNotFoundException, BadPasswordException {
        PasswordPoliticValidator.checkPassword(account.getPassword());
        accountDAO.update(account);
    }

    @Override
    public void createAccount(Account account) throws BadPasswordException {
        PasswordPoliticValidator.checkPassword(account.getPassword());
        accountDAO.create(account);
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
