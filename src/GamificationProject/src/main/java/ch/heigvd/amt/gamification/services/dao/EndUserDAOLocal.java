package ch.heigvd.amt.gamification.services.dao;

import ch.heigvd.amt.gamification.model.EndUser;
import javax.ejb.Local;

/**
 *
 * @author parfait
 * But : methods available just for this class
 */
@Local
public interface EndUserDAOLocal extends IGenericDAO<EndUser, Long> {
    public long numberOfEndUsersCreatedDuringLastNbDays(int numberOfDay);
}
