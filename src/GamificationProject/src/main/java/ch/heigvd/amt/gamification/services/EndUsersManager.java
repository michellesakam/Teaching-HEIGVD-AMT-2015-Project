package ch.heigvd.amt.gamification.services;


import ch.heigvd.amt.gamification.model.Application;
import ch.heigvd.amt.gamification.model.EndUser;
import ch.heigvd.amt.gamification.services.dao.EndUserDAOLocal;
import java.util.Map;
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
    public EndUser retrieveEndUser(Application application, String noEndUser) {
        return endUserDAO.findByNumberAndApplication(application, noEndUser);
    }

    @Override
    public long getNumberOfPoints(Application app, EndUser e) {
        return endUserDAO.getNumberOfPoints(app, e);
    }

    @Override
    public Map<Integer, Long> getPointsPerMonths(EndUser e, Application app, int year) {
        return endUserDAO.getPointsPerMonths(e, app, year);
    }  

 
}
