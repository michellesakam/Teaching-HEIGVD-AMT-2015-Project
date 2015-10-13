/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.amt.gamification.dao;

import ch.heigvd.amt.gamification.model.Account;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

/**
 *
 * @author parfait
 */
public class AccountDAO implements AccountDAOLocal {

    @PersistenceContext
    EntityManager em;

    @Override
    public long create(Account account) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Account object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Account findById(long id) {
        Object result = null;
        try {
            result = (Account) em.createNamedQuery("Account.findById").setParameter("id", id);
        } catch (NoResultException e) {
            System.out.println("Erreur lors de l'acces à la database ");
        }
        return (Account)result;
    }

    @Override
    public List<Account> findAll() {
        Object result = null;
        try {
            result = (Account) em.createNamedQuery("Account.findByAll");
        } catch (NoResultException e) {
            System.out.println("Erreur lors de l'acces à la database ");
        }
        return (List<Account>)result;
    }

    @Override
    public Account findByName(Account name) {
        Object result = null;
        try {
            result = (Account) em.createNamedQuery("Account.findByName").setParameter("name", name.toString());
        } catch (NoResultException e) {
            System.out.println("Erreur lors de l'acces à la database ");
        }
        return (Account)result;
    }
}
