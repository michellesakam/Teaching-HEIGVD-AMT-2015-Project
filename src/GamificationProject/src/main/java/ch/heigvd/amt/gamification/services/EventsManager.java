package ch.heigvd.amt.gamification.services;

import ch.heigvd.amt.gamification.model.EndUser;
import ch.heigvd.amt.gamification.model.Event;
import javax.ejb.Stateless;

/**
 *
 * @author Raphael
 */
@Stateless
public class EventsManager implements EventsManagerLocal {

    @Override
    public void createEvent(Event event, EndUser endUser) {
        // TODO:
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }   
    
    
}
