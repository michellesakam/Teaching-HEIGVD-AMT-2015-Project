package ch.heigvd.amt.gamification.services.dao;

import ch.heigvd.amt.gamification.model.Level;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author parfait 
 * 
 * But : This methods are available just for Level
 */
@Local
public interface LevelDAOLocal extends IGenericDAO<Level, Long> {
    public List<Level> findLevelsByApiKey(String apikey);
}
