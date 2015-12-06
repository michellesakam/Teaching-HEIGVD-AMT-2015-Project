package ch.heigvd.amt.gamification.services.dao;

import ch.heigvd.amt.gamification.model.Account;
import java.util.List;
import javax.ejb.Stateless;

/**
 * This SLSB implements the DAO design pattern. This class implements the data
 * access for the Company JPA entity. It extends the GenericDAO and with
 * <Company, Long>, it declares that manages Company entities, which have a Long
 * primary key.
 *
 * @author Olivier Liechti (olivier.liechti@heig-vd.ch)
 * Edit : Parfait Noubissi (parfait.noubissi@heig-vd.ch)
 */

@Stateless
public class AccountDAO extends GenericDAO<Account, Long> implements AccountDAOLocal {

    @Override
    public Account findByEmail(String email) {
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
