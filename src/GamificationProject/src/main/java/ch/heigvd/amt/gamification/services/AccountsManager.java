/* To change this license header, choose License Headers in Project Properties.
 /*
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.amt.gamification.services;

import javax.ejb.Stateless;

import ch.heigvd.amt.gamification.model.Account;
import ch.heigvd.amt.gamification.model.Application;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Raphaël Racine
 */
@Stateless
public class AccountsManager implements AccountsManagerLocal {

    @PersistenceContext
    EntityManager em;

    @Override
    public Account login(String email) {
        List<Account> tmp = em.createQuery(
                "SELECT a FROM Account a WHERE a.email= :email")
                .setParameter("email", email)
                .setMaxResults(1)
                .getResultList();
        
        return tmp.size() > 0 ? tmp.get(0) : null;
    }

    @Override
    public int numbersOfAccount() {
        return em.createQuery("SELECT c FROM Account a")
                .getResultList().size();
    }

    @Override
    public long createAccount(Account newAccount) {
        em.persist(newAccount);
        em.flush();
        return newAccount.getId();
    }

    @Override
    public List<Application> getAccountApps(Account a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void editAccount(Account a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
