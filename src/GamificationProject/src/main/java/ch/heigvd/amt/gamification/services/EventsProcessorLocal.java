
package ch.heigvd.amt.gamification.services;

import ch.heigvd.amt.gamification.dto.EventDTO;
import ch.heigvd.amt.gamification.services.dao.GamificationDomainEntityNotFoundException;
import javax.ejb.Local;

/**
 *
 * @author michelle meguep
 */
@Local
public interface EventsProcessorLocal {
    /**
     * Process an event 
     * @param event The event to be process
     * @throws GamificationDomainEntityNotFoundException 
     */
    public void processEvent(EventDTO event) throws GamificationDomainEntityNotFoundException;

    public void createAccountIfNotExists(String endUserNumber);
}
