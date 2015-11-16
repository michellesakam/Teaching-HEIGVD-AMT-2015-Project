package ch.heigvd.amt.gamification.services;


import ch.heigvd.amt.gamification.model.EndUser;
import javax.ejb.Local;

/**
 *
 * @author Raphaël Racine
 */
@Local
public interface EndUsersManagerLocal {

    /**
     * Get the number of endUsers created during the last nbDays days
     *
     * @param nbDays
     * @return The number of endUsers created during the last nbDays days
     */
    public long numberOfEndUsersCreatedDuringLastNbDays(int nbDays);
    
    /**
     * Retrieve an EndUSer by his number
     * @param noEndUser
     * @return null if enduser doesnt exists, else the found endUSer...
     */
    public EndUser retrieveEndUser(String noEndUser);
    
   

}
