package ch.heigvd.amt.gamification.services.dao;

import ch.heigvd.amt.gamification.model.entities.Role;
import javax.ejb.Local;

/**
 *
 * @author parfait
 * Interface generique qui défini les 
 */
@Local
public interface RoleDAOLocal extends IGenericDAO<Role, Long> {

}
