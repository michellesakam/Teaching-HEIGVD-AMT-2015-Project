/*
 * Cette interface met à disposition toutes les méthodes nécessaires pour 
 * la gestion CRUD des Applications
 */
package ch.heigvd.amt.gamification.dao;

import ch.heigvd.amt.gamification.model.Application;
import java.util.List;

/**
 *
 * @author parfait
 */
public interface ApplicationDAOLocal {

public long create(Application application);	
  
public void delete(long id);	
  
boolean update(Application object);	
  
public Application findById(long id);	
  
public List<Application> findAll();	
  
public Application findByName(Application k);	
  
//public findByYYY(Object k);   
}
