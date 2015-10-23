package ch.heigvd.amt.gamification.services;

import ch.heigvd.amt.gamification.model.entities.Account;
import ch.heigvd.amt.gamification.services.dao.GamificationDomainEntityNotFoundException;
import javax.ejb.Local;

@Local
public interface AccountsManagerLocal {
    public void updateAccount(Account a) throws GamificationDomainEntityNotFoundException;
    public void createAccount(Account a);
    public Account retrieveAccount(String email);
    public long numbersOfAccount();
}
