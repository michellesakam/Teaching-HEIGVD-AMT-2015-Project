package ch.heigvd.amt.gamification.services.processors;

import ch.heigvd.amt.gamification.dto.IGamificationDTO;
import ch.heigvd.amt.gamification.model.Application;
import ch.heigvd.amt.gamification.services.ApplicationsManagerLocal;
import javax.ejb.EJB;

/**
 *
 * @author Raphaël Racine
 * @param <T>
 * @param <K>
 */
public abstract class GamificationDTOProcessor<T extends IGamificationDTO, K> implements IGamificationDTOProcessor<T, K> {
    
    @EJB
    private ApplicationsManagerLocal applicationsManager;
    
    protected Application tryToRetrieveApplication(String apiKey) {        
        return applicationsManager.retrieveApplicationByApikey(apiKey);        
    }
    
}
