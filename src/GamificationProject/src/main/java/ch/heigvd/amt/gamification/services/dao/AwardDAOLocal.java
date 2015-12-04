package ch.heigvd.amt.gamification.services.dao;

import ch.heigvd.amt.gamification.model.Award;
import javax.ejb.Local;

/**
 *
 * @author Raphaël Racine
 */
@Local
public interface AwardDAOLocal extends IGenericDAO<Award, Long> {
    
}
