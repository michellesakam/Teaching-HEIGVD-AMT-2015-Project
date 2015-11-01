package ch.heigvd.amt.gamification.services.dao;

import ch.heigvd.amt.gamification.model.entities.Account;
import javax.ejb.Local;

/**
 *
 * @author parfait 
 * 
 * But : This methods are available just for Account
 */
@Local
public interface AccountDAOLocal extends IGenericDAO<Account, Long> {
    public Account findByEmail(String email);
    public long numbersOfAccount();
}
