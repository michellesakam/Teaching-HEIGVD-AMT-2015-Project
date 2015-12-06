package ch.heigvd.amt.gamification.services.dao;

import ch.heigvd.amt.gamification.model.Application;
import ch.heigvd.amt.gamification.model.EndUser;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;

/**
 *
 * @author parfait
 */
@Stateless
public class EndUserDAO extends GenericDAO<EndUser, Long> implements EndUserDAOLocal {

    @Override
    public long numberOfEndUsersCreatedDuringLastNbDays(int numberOfDay) {

        Calendar today = new GregorianCalendar();

        Calendar before = new GregorianCalendar();
        before.add(Calendar.DAY_OF_YEAR, -numberOfDay);

        // returns numbers of end users created within today and before
        return (long) em.createNamedQuery("EndUser.countEndUsersCreatedBetweenTwoDates")
                .setParameter("date1", before.getTime())
                .setParameter("date2", today.getTime())
                .getSingleResult();
    }

    @Override
    public EndUser findByNumberAndApplication(Application application, String noEndUser) {
        List<EndUser> tmp = em.createNamedQuery("EndUser.findByNo")
                .setParameter("no", noEndUser)
                .setParameter("application", application)
                .setMaxResults(1)
                .getResultList();

        return tmp.size() > 0 ? tmp.get(0) : null;
    }

    @Override
    public long getNumberOfPoints(Application app, EndUser e) {
        try {
            return (long) em.createNamedQuery("AwardPoint.getNumberOfPoints")
                    .setParameter("application", app)
                    .setParameter("endUser", e)
                    .getSingleResult();
        }
        catch(Exception ex) {
            return 0;
        }
    }

    @Override
    public Map<Integer, Long> getPointsPerMonths(EndUser e, Application app, int year) {
        List<Object[]> list = em.createNamedQuery("AwardPoint.getPointsPerMonthInAYear")
                .setParameter("application", app)
                .setParameter("endUser", e)
                .setParameter("year", year)
                .getResultList();
        
        Map<Integer, Long> pointsPerMonths = new HashMap<>();
        
        for(Object[] o : list)
            pointsPerMonths.put((int) o[0], (long) o[1]);
        
        return pointsPerMonths;
    }   
    
}
