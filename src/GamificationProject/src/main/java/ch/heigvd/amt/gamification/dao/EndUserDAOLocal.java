/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.amt.gamification.dao;

/**
 *
 * @author parfait
 */
public interface EndUserDAOLocal {
    public long create(Object object);	
  
public void delete(long id);	
  
boolean update(Object object);	
  
public Object findById(long id);	
  
public Object findAll();	
  
public Object findByName(Object k);
}
