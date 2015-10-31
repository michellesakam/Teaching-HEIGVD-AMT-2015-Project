package ch.heigvd.amt.gamification.services;

import javax.ejb.Local;

/**
 *
 * @author Raphaël Racine
 */
@Local
public interface EndUsersManagerLocal {

    /**
     * Get the number of endUsers created during the last nbDays days
     *
     * @param nbDays
     * @return The number of endUsers created during the last nbDays days
     */
    public long numberOfEndUsersCreatedDuringLastNbDays(int nbDays);

}
