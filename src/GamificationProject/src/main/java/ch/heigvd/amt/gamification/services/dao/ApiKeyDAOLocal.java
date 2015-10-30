package ch.heigvd.amt.gamification.services.dao;

import ch.heigvd.amt.gamification.model.entities.ApiKey;
import javax.ejb.Local;

/**
 *
 * @author parfait
 */
@Local
public interface ApiKeyDAOLocal extends IGenericDAO<ApiKey, Long> {
    public ApiKey getNewApiKey();
    public boolean keyExists(String key);
}
