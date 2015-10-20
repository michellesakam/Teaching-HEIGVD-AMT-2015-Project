/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.amt.gamification.dao;

import ch.heigvd.amt.gamification.model.entities.Account;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * This SLSB implements the DAO design pattern. This class implements the data
 * access for the Company JPA entity. It extends the GenericDAO and with
 * <Company, Long>, it declares that manages Company entities, which have a Long
 * primary key.
 *
 * @author Olivier Liechti (olivier.liechti@heig-vd.ch)
 */

@Stateless
public class AccountDAO extends GenericDAO<Account, Long> implements AccountDAOLocal {

    @PersistenceContext
    EntityManager em;

    @Override
    public Account login(String email) {
        List<Account> tmp = em.createNamedQuery("Account.findByEmail")
                .setParameter("email", email)
                .setMaxResults(1)
                .getResultList();

        return tmp.size() > 0 ? tmp.get(0) : null;
    }

    @Override
    public long numbersOfAccount() {
        return (long) em.createNamedQuery("Account.numberOfAccounts").getSingleResult();
    }
}
