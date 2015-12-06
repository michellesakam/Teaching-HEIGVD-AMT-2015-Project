package ch.heigvd.amt.gamification.services.dao;

import ch.heigvd.amt.gamification.model.Application;
import ch.heigvd.amt.gamification.model.Badge;
import ch.heigvd.amt.gamification.model.EndUser;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Samira
 */
@Local
public interface BadgeDAOLocal extends IGenericDAO<Badge, Long> {
    
    /**
     * 
     * @param application (Application have to be managed)
     * @return The list of badges of the application
     */
    public List<Badge> findByApplication(Application application);
    
    /**
     * 
     * @param endUser endUser (which have to be managed)
     * @param application application (have to be managed)
     * @return All of the badges of an endUser in an application
     */
    public List<Badge> findByEndUser(EndUser endUser, Application application);
}
