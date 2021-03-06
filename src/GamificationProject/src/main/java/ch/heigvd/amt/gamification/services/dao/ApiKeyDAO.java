package ch.heigvd.amt.gamification.services.dao;

import ch.heigvd.amt.gamification.model.ApiKey;
import java.util.UUID;
import javax.ejb.Stateless;

/**
 *
 * @author parfait
 * 
 */
@Stateless
public class ApiKeyDAO extends GenericDAO<ApiKey, Long> implements ApiKeyDAOLocal {
    
    @Override
    public ApiKey getNewApiKey() {

        String generated = UUID.randomUUID().toString();

        while (keyExists(generated)) {
            generated = UUID.randomUUID().toString();
        }

        ApiKey key = new ApiKey();
        key.setKey(generated);
        return key;
    }

    @Override
    public boolean keyExists(String key) {
        return em.createNamedQuery("ApiKey.findByKey")
                .setParameter("key", key)
                .getResultList().size() > 0;
    }
}
