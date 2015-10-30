package ch.heigvd.amt.gamification.services.dao;

import ch.heigvd.amt.gamification.model.entities.Account;
import javax.ejb.Local;

/**
 *
 * @author parfait new : exceptions, changement de la signature des méthodes.
 * But : ici on implémentes les méthodes qui sont à la class Account
 */
@Local
public interface AccountDAOLocal extends IGenericDAO<Account, Long> {
    public Account findByEmail(String email);
    public long numbersOfAccount();
}
