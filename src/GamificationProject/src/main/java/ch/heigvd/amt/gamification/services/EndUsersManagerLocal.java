package ch.heigvd.amt.gamification.services;


import ch.heigvd.amt.gamification.model.Application;
import ch.heigvd.amt.gamification.model.EndUser;
import java.util.Map;
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
     * @param application
     * @param noEndUser
     * @return null if enduser doesnt exists, else the found endUSer...
     */
    public EndUser retrieveEndUser(Application application, String noEndUser);

    /**
     * Obtains the number of points the end user winned in this application
     * @param app The managed application
     * @param e The managed endUser
     * @return The number of points of the endUsers in this application
     */
    public long getNumberOfPoints(Application app, EndUser e);

    /**
     * Obtains a HashMap which contains the total of points of an endUser per
     * month (key = month, value = nbPoints during the month) in the specified year
     * @param e The endUser concerned
     * @param app The application concerned
     * @param year The year where you want get the months
     * @return
     */
    public Map<Integer, Long> getPointsPerMonths(EndUser e, Application app, int year);
    
   

}
