package ch.heigvd.amt.gamification.services.dao;

import ch.heigvd.amt.gamification.model.entities.Role;
import javax.ejb.Stateless;

/**
 *
 * @author parfait
 * But : here are methods needed only for this entity
 */
@Stateless
public class RoleDAO extends GenericDAO<Role, Long> implements RoleDAOLocal{   

}
