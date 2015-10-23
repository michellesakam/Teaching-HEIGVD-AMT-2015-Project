/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.amt.gamification.services.dao;

import ch.heigvd.amt.gamification.model.entities.EndUser;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
/**
 *
 * @author parfait
 */
@Stateless
public class EndUserDAO extends GenericDAO<EndUser, Long> implements EndUserDAOLocal{
    
    @PersistenceContext
    EntityManager em;
    
    @Override
    public long numberOfEndUsers(int numberOfDay) {        
        
        Calendar today = new GregorianCalendar();
        today.getTime();
        
        Calendar before = new GregorianCalendar();
        before.add(Calendar.DAY_OF_YEAR, -numberOfDay);
        
        return (long) em.createNamedQuery("EndUser.countEndUsersCreatedBetweenTwoDates")
                .setParameter("date1", before.getTime())
                .setParameter("date2", today.getTime())
                .getSingleResult();
    }
}