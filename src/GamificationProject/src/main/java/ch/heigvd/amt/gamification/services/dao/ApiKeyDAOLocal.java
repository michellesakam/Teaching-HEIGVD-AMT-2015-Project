package ch.heigvd.amt.gamification.services.dao;

import ch.heigvd.amt.gamification.model.ApiKey;
import javax.ejb.Local;

/**
 *
 * @author parfait
 * But : generate new apiKey
 */
@Local
public interface ApiKeyDAOLocal extends IGenericDAO<ApiKey, Long> {
    public ApiKey getNewApiKey();
    public boolean keyExists(String key);
}
