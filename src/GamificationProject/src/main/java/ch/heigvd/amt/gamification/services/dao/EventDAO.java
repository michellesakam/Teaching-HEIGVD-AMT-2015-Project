package ch.heigvd.amt.gamification.services.dao;

import ch.heigvd.amt.gamification.model.Account;
import ch.heigvd.amt.gamification.model.Event;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * This SLSB implements the DAO design pattern. This class implements the data
 * access for the Company JPA entity. It extends the GenericDAO and with
 * <Company, Long>, it declares that manages Company entities, which have a Long
 * primary key.
 *
 * @author Olivier Liechti (olivier.liechti@heig-vd.ch)
 * Edit : Parfait Noubissi (parfait.noubissi@heig-vd.ch)
 */

@Stateless
public class EventDAO extends GenericDAO<Event, Long> implements EventDAOLocal {

    @PersistenceContext
    EntityManager em;
    
}