package ch.heigvd.amt.gamification.services;

import ch.heigvd.amt.gamification.model.Level;
import ch.heigvd.amt.gamification.services.dao.GamificationDomainEntityNotFoundException;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Raphaël Racine
 */
@Local
public interface LevelsManagerLocal {
    public void createLevel(Level level);
    public void editLevel(Level level) throws GamificationDomainEntityNotFoundException;
    public void deleteLevel(Level level) throws GamificationDomainEntityNotFoundException;
    public List<Level> findLevelsByApiKey(String apikey);
}
