package ch.heigvd.amt.gamification.services.dao;

import ch.heigvd.amt.gamification.model.Award;
import javax.ejb.Stateless;

/**
 *
 * @author Raphaël Racine
 */
@Stateless
public class AwardDAO extends GenericDAO<Award, Long> implements AwardDAOLocal {
    
}
