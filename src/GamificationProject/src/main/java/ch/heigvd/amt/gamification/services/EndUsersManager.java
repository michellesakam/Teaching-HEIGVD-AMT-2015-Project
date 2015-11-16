package ch.heigvd.amt.gamification.services;


import ch.heigvd.amt.gamification.model.EndUser;
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

    @Override
    public EndUser retrieveEndUser(String noEndUser) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

 
}
