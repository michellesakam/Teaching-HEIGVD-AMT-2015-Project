/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.amt.gamification.dao;

import ch.heigvd.amt.gamification.model.entities.AbstractDomainModelEntity;
import ch.heigvd.amt.gamification.model.entities.ApiKey;
import javax.ejb.Stateless;


/**
 *
 * @author parfait
 */
@Stateless
public class ApiKeyDAO extends GenericDAO<ApiKey, Long> implements ApiKeyDAOLocal{
    
}
