package ch.heigvd.amt.gamification.services.processors;

import ch.heigvd.amt.gamification.dto.GamificationDTO;
import ch.heigvd.amt.gamification.model.Application;
import ch.heigvd.amt.gamification.services.ApplicationsManagerLocal;
import javax.ejb.EJB;

/**
 *
 * @author Raphaël Racine
 * @param <T>
 * @param <K>
 */
public abstract class GamificationDTOProcessor<T extends GamificationDTO, K> implements IGamificationDTOProcessor<T, K> {
    
    @EJB
    private ApplicationsManagerLocal applicationsManager;
    
    protected Application tryToRetrieveApplication(String apiKey) {
        
        Application app = applicationsManager.retrieveApplicationByApikey(apiKey);
        
        if(app == null)
            throw new NullPointerException("This application doesn't exists");
        
        return app;
        
    }
    
}
