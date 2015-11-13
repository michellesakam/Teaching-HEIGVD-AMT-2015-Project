
package ch.heigvd.amt.gamification.services;

import ch.heigvd.amt.gamification.model.EndUser;
import ch.heigvd.amt.gamification.model.Event;
import javax.ejb.Local;

/**
 *
 * @author Raphael
 */
@Local
public interface EventsManagerLocal {
    public void createEvent(Event event, EndUser endUser);
}
