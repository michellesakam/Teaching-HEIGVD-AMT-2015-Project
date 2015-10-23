package ch.heigvd.amt.gamification.services;

import ch.heigvd.amt.gamification.model.entities.Application;
import javax.ejb.Local;

/**
 *
 * @author Raphaël Racine
 */
@Local
public interface EndUsersManagerLocal {

    public long numberOfEndUsersCreatedDuringLastNbDays(int nbDays);
    
}
