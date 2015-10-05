/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.amt.gamification.services;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Raphaël Racine
 */
@Stateless
public class EndUsersManager implements EndUsersManagerLocal {

    @PersistenceContext
    EntityManager em;
    
    @Override
    public int numberOfEndUsers(int numberOfDay) {        
        
        Calendar today = new GregorianCalendar();
        today.getTime();
        
        Calendar before = new GregorianCalendar();
        before.add(Calendar.DAY_OF_YEAR, -numberOfDay);
        
        return em.createQuery("SELECT a FROM EndUser a WHERE a.regDate BETWEEN :date1 AND :date2")
                .setParameter("date1", before.getTime())
                .setParameter("date2", today.getTime())
                .getResultList().size();
    }
    
}
