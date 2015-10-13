/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.amt.gamification.dao;

import ch.heigvd.amt.gamification.model.Account;
import java.util.List;

/**
 *
 * @author parfait
 */
public interface AccountDAOLocal {
    public long create(Account account);	
  
public void delete(long id);	
  
boolean update(Account account);	
  
public Account findById(long id);	
  
public List<Account>  findAll();	
  
public Account findByName(Account account);
}
