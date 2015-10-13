/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.amt.gamification.dao;

import ch.heigvd.amt.gamification.model.ApiKey;
import ch.heigvd.amt.gamification.model.Application;
import java.util.List;

/**
 *
 * @author parfait
 */
public interface ApiKeyDAOLocal {
    public long create(ApiKey apikey);	
  
public void delete(long id);	
  
boolean update(ApiKey apikey);	
  
public ApiKey findById(long id);	
  
public List<ApiKey> findAll();	
  
public ApiKey findByName(ApiKey k);
}
