package ch.heigvd.amt.gamification.services;

import ch.heigvd.amt.gamification.model.EndUser;
import ch.heigvd.amt.gamification.model.Event;
import ch.heigvd.amt.gamification.services.dao.EndUserDAOLocal;
import ch.heigvd.amt.gamification.services.dao.EventDAOLocal;
import ch.heigvd.amt.gamification.services.dao.GamificationDomainEntityNotFoundException;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Raphael
 */
@Stateless
public class EventsManager implements EventsManagerLocal {

    @EJB
    private EventDAOLocal eventDAO;
    
    @EJB
    private EndUserDAOLocal endUserDAO;
    
    @Override
    public void createEvent(Event event, EndUser endUser) throws GamificationDomainEntityNotFoundException {
        
        // We need to attach the two entities
        event.setEndUser(endUser);
        endUser.getEvents().add(event);
        
        eventDAO.create(event);
        endUserDAO.update(endUser);
        
    }   
    
    
}
