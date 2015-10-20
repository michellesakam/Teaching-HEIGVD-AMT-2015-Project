/*
 * Cette interface met à disposition toutes les méthodes nécessaires pour 
 * la gestion CRUD des Applications
 */
package ch.heigvd.amt.gamification.dao;

import ch.heigvd.amt.gamification.model.ApiKey;
import ch.heigvd.amt.gamification.model.Application;
import java.util.List;

/**
 *
 * @author parfait
 */
public interface ApplicationDAOLocal extends IGenericDAO<Application, Long> { 
}
