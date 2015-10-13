/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.amt.gamification.dao;

import ch.heigvd.amt.gamification.model.Role;

/**
 *
 * @author parfait
 */
public interface RoleDAOLocal {
   public long create(Role role);	
  
public void delete(long id);	
  
boolean update(Role object);	
  
public Role findById(long id);	
  
public Role findAll();	
  
public Role findByName(Role k); 
    
}
