/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.amt.gamification.dao;

import ch.heigvd.amt.gamification.model.EndUser;

/**
 *
 * @author parfait
 */
public interface EndUserDAOLocal {
    public long create(EndUser endUser);	
  
public void delete(long id);	
  
boolean update(EndUser endUser);	
  
public EndUser findById(long id);	
  
public EndUser findAll();	
  
public EndUser findByName(EndUser endUser);
}
