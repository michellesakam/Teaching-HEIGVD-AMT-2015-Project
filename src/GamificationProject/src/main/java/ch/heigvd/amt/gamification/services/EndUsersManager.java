package ch.heigvd.amt.gamification.services;

import ch.heigvd.amt.gamification.model.entities.Application;
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

    @Override
    public long numberOfEndUsersCreatedDuringLastNbDays(int nbDays) {
        return endUserDAO.numberOfEndUsersCreatedDuringLastNbDays(nbDays);
    }
    
}
