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
    public long numbersOfAccount() {
        // TODO: Implémenter avec la base de données
        return 852;
    }

    @Override
    public long createAccount(Account newAccount) {
        em.persist(newAccount);
        em.flush();
        return newAccount.getId();
    }

    @Override
    public List<Application> getAccountApps(String email) {
        // TODO : Données fake...
        List<Application> apps = new LinkedList<>();
        return apps;
    }

    @Override
    public void editAccount(String email, String newEmail, String newPassword, String newFirstName, String newLastName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
