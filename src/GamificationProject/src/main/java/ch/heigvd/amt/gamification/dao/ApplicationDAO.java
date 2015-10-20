/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.amt.gamification.dao;

import ch.heigvd.amt.gamification.model.entities.Account;
import ch.heigvd.amt.gamification.model.entities.ApiKey;
import ch.heigvd.amt.gamification.model.entities.Application;
import java.util.UUID;

/**
 *
 * @author parfait
 */
public class ApplicationDAO extends GenericDAO<Application, Long> implements ApplicationDAOLocal {

    @Override
    public void assignApplicationToAccount(Application app, Account acc) {
        ApiKey key = getNewApiKey();

        app.setAcount(acc);
        acc.getApps().add(app);

        app.setApiKey(key);
        key.setApplication(app);

        create(app);
    }
    
        /**
     * Get a new ApiKey which doesnt exists yet
     * @return A new ApiKey
     */
    private ApiKey getNewApiKey() {
        
        String generated = UUID.randomUUID().toString();
        
        while(keyExists(generated)) {
            generated = UUID.randomUUID().toString();
        }
        
        ApiKey key = new ApiKey();
        key.setKey(generated);
        return key;
    }    
        
    private boolean keyExists(String newkey) {
        return em.createNamedQuery("ApiKey.findByKey")
                .setParameter("key", newkey)
                .getResultList().size() > 0;
    }
    
    @Override
    public long numberOfApplicationsManaged() {
        return em.createNamedQuery("Application.findAll")
                .getResultList()
                .size();
    }

}
