package ch.heigvd.amt.gamification.services;

import javax.ejb.Local;
import ch.heigvd.amt.gamification.model.Account;
import ch.heigvd.amt.gamification.model.Application;
import java.util.List;

/**
 *
 * @author Raphaël Racine
 */
@Local
public interface AccountsManagerLocal {    
    public Account login(String email);  
    public int numbersOfAccount();
    public long createAccount(Account newAccount);
    public List<Application> getAccountApps(String email); // Voir paramètre avec le prof
    public void editAccount(String email, String newEmail, String newPassword, String newFirstName, String newLastName);
}
