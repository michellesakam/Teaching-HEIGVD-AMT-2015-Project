
package ch.heigvd.amt.gamification.services;

import ch.heigvd.amt.gamification.model.EndUser;
import ch.heigvd.amt.gamification.model.Event;
import ch.heigvd.amt.gamification.services.dao.GamificationDomainEntityNotFoundException;
import javax.ejb.Local;

/**
 *
 * @author Raphael
 */
@Local
public interface EventsManagerLocal {
    
    /**
     * Create an event for an endUser
     * @param event The event to create
     * @param endUser The endUser concerned (this object has to be managed)
     * @throws GamificationDomainEntityNotFoundException 
     */
    public void createEvent(Event event, EndUser endUser) throws GamificationDomainEntityNotFoundException;
}
