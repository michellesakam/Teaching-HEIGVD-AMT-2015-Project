package ch.heigvd.amt.gamification.services;

import ch.heigvd.amt.gamification.model.Application;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Raphaël Racine
 */
@Local
public interface ApplicationsManagerLocal {
    
    public List<Application> findAll();
    
}
