package ch.heigvd.amt.gamification.services.dao;

import ch.heigvd.amt.gamification.model.Event;
import javax.ejb.Local;

/**
 *
 * @author parfait 
 * 
 * But : This methods are available just for Event
 */
@Local
public interface EventDAOLocal extends IGenericDAO<Event, Long> {
}
