package ch.heigvd.amt.gamification.services.dao;

import ch.heigvd.amt.gamification.model.Badge;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Samira
 */
@Local
public interface BadgeDAOLocal extends IGenericDAO<Badge, Long> {
    public List<Badge> findByApiKey(String apiKey);
}
