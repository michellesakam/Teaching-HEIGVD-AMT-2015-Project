/*
 * Cette interface met à disposition toutes les méthodes nécessaires pour 
 * la gestion CRUD des Applications
 */
package ch.heigvd.amt.gamification.dao;

/**
 *
 * @author parfait
 */
public interface ApplicationDAOLocal {

public long create(Object object);	
  
public void delete(long id);	
  
boolean update(Object object);	
  
public Object findById(long id);	
  
public Object findAll();	
  
public Object findByName(Object k);	
  
//public findByYYY(Object k);   
}
