
package ch.heigvd.amt.gamification.services;

import ch.heigvd.amt.gamification.dto.EventDTO;
import ch.heigvd.amt.gamification.model.AwardPoint;
import ch.heigvd.amt.gamification.model.EndUser;
import ch.heigvd.amt.gamification.model.Event;
import ch.heigvd.amt.gamification.services.dao.EndUserDAOLocal;
import ch.heigvd.amt.gamification.services.dao.EventDAOLocal;
import ch.heigvd.amt.gamification.services.dao.GamificationDomainEntityNotFoundException;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @michelle meguep
 */
@Stateless
public class EventsProcessor implements EventsProcessorLocal{
    
    private static final Logger LOG = Logger.getLogger(EventsProcessor.class.getName());
    @EJB
    private EndUserDAOLocal userDAO;
    @PersistenceContext
    EntityManager em;

    @Override
    public void processEvent(EventDTO event) throws GamificationDomainEntityNotFoundException {
      /*
     * If this is the first event  for this user, we need
     * to create it.
     */
     createAccountIfNotExists(event.getApiKey());  
     EndUser user = userDAO.findById(Long.parseLong(event.getEndUserNumber()));
     int points = user.getPoints().get(0).getScore();
     user.incrementPoints(); // on incremente les points d'un user.
     LOG.info("*** Updating user points: " + user.getId());
    }

    @Override
    public void createAccountIfNotExists(String endUserNumber) {
     EndUser user = userDAO.findByNo(endUserNumber);
    if (user == null) {
      user = new EndUser();
      user.setUserID(endUserNumber);

    }
    }
    
}
