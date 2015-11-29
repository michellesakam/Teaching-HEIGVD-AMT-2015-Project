package ch.heigvd.amt.gamification.services;

import ch.heigvd.amt.gamification.model.Application;
import ch.heigvd.amt.gamification.model.Level;
import ch.heigvd.amt.gamification.services.dao.GamificationDomainEntityNotFoundException;
import ch.heigvd.amt.gamification.services.dao.LevelDAOLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Raphaël Racine
 */
@Stateless
public class LevelsManager implements LevelsManagerLocal {
    
    @EJB
    private LevelDAOLocal levelDAO;

    @Override
    public void editLevel(Level level) throws GamificationDomainEntityNotFoundException {
        levelDAO.update(level);
    }

    @Override
    public void deleteLevel(Level level) throws GamificationDomainEntityNotFoundException {
        levelDAO.delete(level);
    }

    @Override
    public List<Level> findLevelsByApiKey(String apikey) {
        return levelDAO.findLevelsByApiKey(apikey);
    }

    @Override
    public void assignLevelToApplication(Application application, Level level) {
        level.setApplication(application);
        application.getLevels().add(level);
    }

    @Override
    public Level findById(Long id) throws GamificationDomainEntityNotFoundException {
        return levelDAO.findById(id);
    }   
    
}
