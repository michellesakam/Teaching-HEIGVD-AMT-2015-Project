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
    public Account login(String email, String password);  
    public long numbersOfAccount();
    public void createAccount(String email, String firstName, String lastName, String password);
    public List<Application> getAccountApps(String email); // Voir paramètre avec le prof
    public void editAccount(String email, String newEmail, String newPassword, String newFirstName, String newLastName);
    
    // TODO: Demander au prof pour le paramètre e-mail
    
    /**
     * email est un identificant unique pour l'Account, c'est donc tout à fait possible de l'utiliser comme paramètre
     * pour la méthode getAccountApps. Une alternative serait de donnée l'id (le champs annoté avec @Id dans Account),
     * mais ça serait probablement moins pratique (ça dépend de ce qui est codé dans le serlvet.
     * 
     * Sinon:
     * - getNumberOfAccounts() est un peu mieux que numberOfAccount() (méthod = verb et account au pluriel)
     * - pour create account et edit account, au lieu de passer chaque attribut en paramètre, vous pouvez passer
     *   une instance de Account: createAccount(Account newAccount), updateAccount(Account accountToUpdate).
     */
}
