package ch.heigvd.amt.gamification.services.dao;

import ch.heigvd.amt.gamification.model.Role;
import javax.ejb.Local;

/**
 *
 * @author parfait
 * But : methods needed only for this entity
 */
@Local
public interface RoleDAOLocal extends IGenericDAO<Role, Long> {

}
