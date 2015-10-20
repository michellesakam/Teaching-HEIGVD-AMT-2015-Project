/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.amt.gamification.dao;

import ch.heigvd.amt.gamification.model.entities.Account;
import ch.heigvd.amt.gamification.model.entities.ApiKey;
import ch.heigvd.amt.gamification.model.entities.Application;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author parfait
 */
@Stateless
public class ApplicationDAO extends GenericDAO<Application, Long> implements ApplicationDAOLocal {

    @EJB
    private ApiKeyDAOLocal apikeyDAO;
    
    @Override
    public void assignApplicationToAccount(Application app, Account acc) {
        ApiKey key = apikeyDAO.getNewApiKey();

        app.setAcount(acc);
        acc.getApps().add(app);

        app.setApiKey(key);
        key.setApplication(app);

        create(app);
    }

    @Override
    public long numberOfApplicationsManaged() {
        return em.createNamedQuery("Application.findAll")
                .getResultList()
                .size();
    }

}
