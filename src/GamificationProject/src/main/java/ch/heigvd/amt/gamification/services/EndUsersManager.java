package ch.heigvd.amt.gamification.services;

import ch.heigvd.amt.gamification.services.dao.EndUserDAOLocal;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Raphaël Racine
 */
@Stateless
public class EndUsersManager implements EndUsersManagerLocal {
    
    @EJB
    private EndUserDAOLocal endUserDAO;

    /**
     * Get the number of endUsers created during the last nbDays days
     * @param nbDays
     * @return The number of endUsers created during the last nbDays days
     */
    @Override
    public long numberOfEndUsersCreatedDuringLastNbDays(int nbDays) {
        return endUserDAO.numberOfEndUsersCreatedDuringLastNbDays(nbDays);
    }
    
}
