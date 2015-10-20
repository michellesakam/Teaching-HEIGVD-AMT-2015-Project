/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.amt.gamification.dao;

import ch.heigvd.amt.gamification.model.entities.AbstractDomainModelEntity;
import ch.heigvd.amt.gamification.model.entities.EndUser;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author parfait
 */
public class EndUserDAO extends GenericDAO<EndUser, Long> implements EndUserDAOLocal{
    
    @Override
    public long numberOfEndUsers(int numberOfDay) {        
        
        Calendar today = new GregorianCalendar();
        today.getTime();
        
        Calendar before = new GregorianCalendar();
        before.add(Calendar.DAY_OF_YEAR, -numberOfDay);
        
        return em.createNamedQuery("EndUser.findAllCreatedBetweenTwoDates")
                .setParameter("date1", before.getTime())
                .setParameter("date2", today.getTime())
                .getResultList().size();
    }
    
}
