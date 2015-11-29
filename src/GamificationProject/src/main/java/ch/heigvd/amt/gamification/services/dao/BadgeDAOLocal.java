package ch.heigvd.amt.gamification.services.dao;

import ch.heigvd.amt.gamification.model.Badge;
import javax.ejb.Local;

/**
 *
 * @author Samira
 */
@Local
public interface BadgeDAOLocal extends IGenericDAO<Badge, Long> {
    
}
