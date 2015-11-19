package ch.heigvd.amt.gamification.services;

import ch.heigvd.amt.gamification.model.Level;
import ch.heigvd.amt.gamification.services.dao.GamificationDomainEntityNotFoundException;
import ch.heigvd.amt.gamification.services.dao.LevelDAOLocal;
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
    public void createLevel(Level level) {
        levelDAO.create(level);
    }

    @Override
    public void editLevel(Level level) throws GamificationDomainEntityNotFoundException {
        levelDAO.update(level);
    }

    @Override
    public void deleteLevel(Level level) throws GamificationDomainEntityNotFoundException {
        levelDAO.delete(level);
    }
    
}
