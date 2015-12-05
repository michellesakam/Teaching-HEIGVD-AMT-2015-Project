package ch.heigvd.amt.gamification.services.dao;

import ch.heigvd.amt.gamification.model.Application;
import ch.heigvd.amt.gamification.model.AwardPoint;
import ch.heigvd.amt.gamification.model.EndUser;
import java.util.List;
import java.util.Map;
import javax.ejb.Local;

/**
 *
 * @author parfait
 * But : methods available just for this class
 */
@Local
public interface EndUserDAOLocal extends IGenericDAO<EndUser, Long> {
    public long numberOfEndUsersCreatedDuringLastNbDays(int numberOfDay);

    public EndUser findByNumberAndApplication(Application application, String noEndUser);

    public long getNumberOfPoints(Application app, EndUser e);

    public Map<Integer, Long> getPointsPerMonths(EndUser e, Application app, int year);
}
