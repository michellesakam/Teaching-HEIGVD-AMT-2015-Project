package ch.heigvd.amt.gamification.services.dao;

import ch.heigvd.amt.gamification.model.entities.EndUser;
import javax.ejb.Local;

/**
 *
 * @author parfait
 */
@Local
public interface EndUserDAOLocal extends IGenericDAO<EndUser, Long> {
    public long numberOfEndUsersCreatedDuringLastNbDays(int numberOfDay);
}
