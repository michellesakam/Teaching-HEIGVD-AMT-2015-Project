package ch.heigvd.amt.gamification.services.dao;

import ch.heigvd.amt.gamification.model.Application;
import ch.heigvd.amt.gamification.model.Badge;
import ch.heigvd.amt.gamification.model.EndUser;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Samira
 */
@Local
public interface BadgeDAOLocal extends IGenericDAO<Badge, Long> {
    public List<Badge> findByApiKey(String apiKey);

    public List<Badge> findByEndUser(EndUser endUser, Application application);
}
