/*
 * Cette interface met à disposition toutes les méthodes nécessaires pour 
 * la gestion CRUD des Applications
 */
package ch.heigvd.amt.gamification.dao;

import ch.heigvd.amt.gamification.model.entities.Account;
import ch.heigvd.amt.gamification.model.entities.Application;
import javax.ejb.Local;

/**
 *
 * @author parfait
 */
@Local
public interface ApplicationDAOLocal extends IGenericDAO<Application, Long> {
    public void assignApplicationToAccount(Application app, Account acc);
    public long numberOfApplicationsManaged();
}
