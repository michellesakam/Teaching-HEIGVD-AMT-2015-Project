package ch.heigvd.amt.gamification.services.dao;

import ch.heigvd.amt.gamification.model.Account;
import ch.heigvd.amt.gamification.model.EndUser;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
/**
 *
 * @author parfait
 */
@Stateless
public class EndUserDAO extends GenericDAO<EndUser, Long> implements EndUserDAOLocal{
    
    @PersistenceContext
    EntityManager em;
    
    @Override
    public long numberOfEndUsersCreatedDuringLastNbDays(int numberOfDay) {        
        
        Calendar today = new GregorianCalendar();
        today.getTime();
        
        Calendar before = new GregorianCalendar();
        before.add(Calendar.DAY_OF_YEAR, -numberOfDay);
        
        // returns numbers of end users created within today and before
        return (long) em.createNamedQuery("EndUser.countEndUsersCreatedBetweenTwoDates")
                .setParameter("date1", before.getTime())
                .setParameter("date2", today.getTime())
                .getSingleResult();
    }

    @Override
    public EndUser findByNo(String noEndUser) {
        List<EndUser> tmp = em.createNamedQuery("EndUser.findByNo")
                .setParameter("no", noEndUser)
                .setMaxResults(1)
                .getResultList();

        return tmp.size() > 0 ? tmp.get(0) : null;
    }
}