package ch.heigvd.amt.gamification.services;

import javax.ejb.Local;

/**
 *
 * @author Raphaël Racine
 */
@Local
public interface EndUsersManagerLocal {

    public long numberOfEndUsersCreatedDuringLastNbDays(int nbDays);
    
}
