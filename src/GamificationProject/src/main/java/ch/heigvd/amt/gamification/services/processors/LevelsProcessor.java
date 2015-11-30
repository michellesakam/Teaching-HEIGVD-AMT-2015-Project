package ch.heigvd.amt.gamification.services.processors;

import ch.heigvd.amt.gamification.dto.LevelDTO;
import ch.heigvd.amt.gamification.model.Application;
import ch.heigvd.amt.gamification.model.Level;
import ch.heigvd.amt.gamification.services.ApplicationsManagerLocal;
import ch.heigvd.amt.gamification.services.ApplicationsManagerLocal;
import ch.heigvd.amt.gamification.services.LevelsManagerLocal;
import ch.heigvd.amt.gamification.services.LevelsManagerLocal;
import ch.heigvd.amt.gamification.services.dao.GamificationDomainEntityNotFoundException;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Raphaël Racine
 */
@Stateless
public class LevelsProcessor implements LevelsProcessorLocal {

    @EJB
    private ApplicationsManagerLocal applicationsManager;

    @EJB
    private LevelsManagerLocal levelsManager;

    @Override
    public void processPostLevel(LevelDTO levelDTO) {
        Application application = applicationsManager.retrieveApplicationByApikey(levelDTO.getApikey());

        if (application == null) {
            throw new NullPointerException("This application doesn't exists");
        }

        Level level = new Level();
        level.setName(levelDTO.getName());
        level.setMinimumPoints(levelDTO.getMinimumPoints());

        levelsManager.assignLevelToApplication(application, level);
    }

    @Override
    public void processPutLevel(Long levelID, LevelDTO levelDTO) {
        Application application = applicationsManager.retrieveApplicationByApikey(levelDTO.getApikey());

        if (application == null) {
            throw new NullPointerException("This application doesn't exists");
        }

        try {
            Level level = levelsManager.findById(levelID);

            if (level.getApplication() == application) {
                level.setName(levelDTO.getName());
                level.setMinimumPoints(levelDTO.getMinimumPoints());
            } else {
                throw new Error("This application doens't have level with specified levelID");
            }
        } catch (GamificationDomainEntityNotFoundException ex) {
            throw new NullPointerException("This level doesn't exists");
        }
    }

    @Override
    public void processDeleteLevel(Long levelID, String apiKey) {
        Application application = applicationsManager.retrieveApplicationByApikey(apiKey);

        if (application == null) {
            throw new NullPointerException("This application doesn't exists");
        }

        try {
            Level level = levelsManager.findById(levelID);

            if (level.getApplication() == application) {
                levelsManager.deleteLevel(level);
            } else {
                throw new Error("This application doens't have level with specified levelID");
            }
        } catch (GamificationDomainEntityNotFoundException ex) {
            throw new NullPointerException("This level doesn't exists");
        }
    }

}
